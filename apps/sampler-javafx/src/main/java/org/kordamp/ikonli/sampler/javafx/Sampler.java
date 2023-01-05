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
package org.kordamp.ikonli.sampler.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonProvider;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.EnumSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.TreeMap;

import static java.util.EnumSet.allOf;

/**
 * @author Andres Almiray
 */
public class Sampler extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL location = getClass().getResource("sampler.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        TabPane tabPane = fxmlLoader.load();

        Map<String, IkonProvider> ikons = new TreeMap<>();
        ServiceLoader<IkonProvider> providers = ServiceLoader.load(IkonProvider.class);
        for (IkonProvider provider : providers) {
            ikons.put(provider.getIkon().getSimpleName(), provider);
        }
        for (IkonProvider provider : ikons.values()) {
            tabPane.getTabs().add(new DemoTab(provider.getIkon(), allOf(provider.getIkon())));
        }

        Scene scene = new Scene(tabPane);
        scene.getStylesheets().add("org/kordamp/ikonli/sampler/javafx/sampler.css");

        primaryStage.setTitle("Ikonli Sampler");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(1024);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Sampler.class);
    }

    private static class DemoTab extends Tab {
        private DemoTab(Class<? extends Ikon> iconFontClass, EnumSet<? extends Ikon> enumSet) throws Exception {
            super(iconFontClass.getSimpleName());
            setClosable(false);

            GridPane pane = new GridPane();
            ScrollPane scrollPane = new ScrollPane(pane);
            setContent(scrollPane);

            int column = 0;
            int row = 0;
            int index = 0;
            for (Ikon value : enumSet) {
                FontIcon icon = FontIcon.of(value);
                icon.getStyleClass().setAll("font-icon");
                pane.add(icon, column++, row);
                GridPane.setMargin(icon, new Insets(10, 10, 10, 10));
                if (++index % 10 == 0) {
                    column = 0;
                    row++;
                }
            }
        }
    }
}
