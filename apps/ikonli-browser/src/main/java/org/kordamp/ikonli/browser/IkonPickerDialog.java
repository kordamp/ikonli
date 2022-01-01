/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2022 Andres Almiray
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kordamp.ikonli.browser;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.desktoppanefx.scene.layout.DesktopPane;
import org.kordamp.ikonli.IkonProvider;

import java.util.ServiceLoader;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Andres Almiray
 */
public class IkonPickerDialog extends Dialog<IkonProvider> {
    private final ObservableList<IkonData> data;
    private final Set<IkonData> ikons;

    private IkonPickerDialog() {
        this.ikons = resolveIkonData();
        DialogPane dialogPane = getDialogPane();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setMaxWidth(Double.MAX_VALUE);
        grid.setAlignment(Pos.CENTER_LEFT);

        Label label = createContentLabel(dialogPane.getContentText());
        label.setPrefWidth(Region.USE_COMPUTED_SIZE);

        setTitle("Ikon Picker");
        dialogPane.setHeaderText("Select an Ikon provider (" + ikons.size() + " in total)");
        dialogPane.getStyleClass().add("ikon-picker");
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialogPane.getScene().getStylesheets().addAll(
            IkonBrowser.class.getResource("common.css").toExternalForm(),
            BootstrapFX.bootstrapFXStylesheet());
        dialogPane.getStyleClass().add("dialog-content");
        dialogPane.lookupButton(ButtonType.OK)
            .getStyleClass().addAll("btn", "btn-primary");
        dialogPane.lookupButton(ButtonType.CANCEL)
            .getStyleClass().addAll("btn", "btn-danger");

        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);

        data = FXCollections.observableArrayList(ikons);

        ListView<IkonData> listView = new ListView<>();
        listView.setItems(data);
        listView.setMinWidth(400);
        listView.setMaxHeight(400);
        listView.setMaxWidth(400);
        listView.setMaxHeight(400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        listView.setOnMouseClicked(me -> {
            if (me.getClickCount() > 1) {
                okButton.fire();
            }
        });
        okButton.disableProperty().bind(
            listView.getSelectionModel()
                .selectedItemProperty()
                .isNull());

        setResultConverter((dialogButton) -> {
            ButtonBar.ButtonData data = dialogButton == null ? null : dialogButton.getButtonData();
            return data == ButtonBar.ButtonData.OK_DONE ? getSelectedItem(listView) : null;
        });

        GridPane.setHgrow(listView, Priority.ALWAYS);
        GridPane.setFillWidth(listView, true);
        grid.add(label, 0, 0);
        grid.add(listView, 1, 0);
        getDialogPane().setContent(grid);

        Platform.runLater(listView::requestFocus);
    }

    private Set<IkonData> resolveIkonData() {
        Set<IkonData> ikons = new TreeSet<>();
        if (null != IkonProvider.class.getModule().getLayer()) {
            for (IkonProvider provider : ServiceLoader.load(IkonProvider.class.getModule().getLayer(), IkonProvider.class)) {
                ikons.add(IkonData.of(provider));
            }
        } else {
            for (IkonProvider provider : ServiceLoader.load(IkonProvider.class)) {
                ikons.add(IkonData.of(provider));
            }
        }

        return ikons;
    }

    private IkonProvider getSelectedItem(ListView<IkonData> listView) {
        IkonData selectedItem = listView.getSelectionModel().getSelectedItem();
        return selectedItem != null ? selectedItem.ikonProvider : null;
    }

    private Label createContentLabel(String text) {
        Label label = new Label(text);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setMaxHeight(Double.MAX_VALUE);
        label.getStyleClass().add("content");
        label.setWrapText(true);
        label.setPrefWidth(360);
        return label;
    }

    public static void show(DesktopPane desktopPane) {
        new IkonPickerDialog()
            .showAndWait()
            .ifPresent(ikonProvider -> IkonInternalWindow.show(ikonProvider, desktopPane));
    }

    private static class IkonData implements Comparable<IkonData> {
        private String name;
        private IkonProvider ikonProvider;

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(IkonData o) {
            return name.compareTo(o.name);
        }

        static IkonData of(IkonProvider ikonProvider) {
            IkonData ikonData = new IkonData();
            ikonData.ikonProvider = ikonProvider;
            ikonData.name = ikonProvider.getIkon().getSimpleName();
            return ikonData;
        }
    }
}
