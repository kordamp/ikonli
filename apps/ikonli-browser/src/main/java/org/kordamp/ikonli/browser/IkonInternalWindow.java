/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2023 Andres Almiray
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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import org.kordamp.desktoppanefx.scene.layout.DesktopPane;
import org.kordamp.desktoppanefx.scene.layout.InternalWindow;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonProvider;
import org.kordamp.ikonli.boxicons.BoxiconsRegular;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.EnumSet;
import java.util.Optional;

import static java.util.EnumSet.allOf;

/**
 * @author Andres Almiray
 */
public class IkonInternalWindow extends InternalWindow {
    public IkonInternalWindow(String mdiWindowID, Node icon, String title, Node content) {
        super(mdiWindowID, icon, title, content);
    }

    public static void show(IkonProvider ikonProvider, DesktopPane desktopPane) {
        String windowId = ikonProvider.getIkon().getName().toLowerCase();

        desktopPane.findInternalWindow(windowId)
            .or(() -> Optional.of(createInternalWindow(ikonProvider, windowId)))
            .ifPresent(desktopPane::addInternalWindow);
    }

    private static IkonInternalWindow createInternalWindow(IkonProvider ikonProvider, String windowId) {
        IkonInternalWindow internalWindow = new IkonInternalWindow(windowId,
            FontIcon.of(BoxiconsRegular.GRID_SMALL, Color.WHITE),
            ikonProvider.getIkon().getSimpleName(),
            createIkonGrid(allOf(ikonProvider.getIkon())));
        internalWindow.setPrefSize(800, 600);
        internalWindow.getStylesheets().addAll(
            IkonBrowser.class.getResource("common.css").toExternalForm(),
            IkonBrowser.class.getResource("ikon-window.css").toExternalForm());
        return internalWindow;
    }

    private static Node createIkonGrid(EnumSet<? extends Ikon> enumSet) {
        BorderPane borderPane = new BorderPane();

        Label label = new Label("Selection:");
        TextField selection = new TextField();
        selection.setEditable(false);
        Button copy = new Button();
        copy.setGraphic(FontIcon.of(BoxiconsRegular.COPY, Color.WHITE));
        copy.getStyleClass().addAll("btn", "btm-sm", "btn-primary");
        HBox.setMargin(label, new Insets(10, 5, 10, 10));
        HBox.setMargin(selection, new Insets(10, 5, 10, 5));
        HBox.setMargin(copy, new Insets(10, 10, 10, 5));
        HBox.setHgrow(selection, Priority.ALWAYS);
        HBox hbox = new HBox(label, selection, copy);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        borderPane.setTop(hbox);

        copy.disableProperty().bind(selection.textProperty().isEmpty());
        copy.setOnAction(e -> {
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(selection.getText());
            clipboard.setContent(content);
        });

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setCenterShape(true);
        pane.setPadding(new Insets(5));
        pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        borderPane.setCenter(new ScrollPane(pane));

        int column = 0;
        int row = 0;
        int index = 0;

        FontIcon[] previousIcon = new FontIcon[1];

        for (Ikon value : enumSet) {
            FontIcon icon = FontIcon.of(value);
            icon.getStyleClass().setAll("font-icon");
            icon.setOnMouseClicked(me -> {
                if (previousIcon[0] != null) {
                    previousIcon[0].getStyleClass().remove("active-icon");
                }
                FontIcon nextIcon = (FontIcon) me.getSource();
                selection.setText(nextIcon.getIconCode().getDescription());
                nextIcon.getStyleClass().add("active-icon");
                previousIcon[0] = nextIcon;
            });
            pane.add(icon, column++, row);
            GridPane.setMargin(icon, new Insets(10, 10, 10, 10));
            if (++index % 10 == 0) {
                column = 0;
                row++;
            }
        }

        return borderPane;
    }
}
