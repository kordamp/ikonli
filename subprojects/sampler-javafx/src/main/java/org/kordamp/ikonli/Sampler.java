/*
 * Copyright 2015-2016 Andres Almiray. <aalmiray@yahoo.com>
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
package org.kordamp.ikonli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.kordamp.ikonli.devicons.Devicons;
import org.kordamp.ikonli.elusive.Elusive;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.fontelico.Fontelico;
import org.kordamp.ikonli.foundation.Foundation;
import org.kordamp.ikonli.hawcons.HawconsFilled;
import org.kordamp.ikonli.hawcons.HawconsStroke;
import org.kordamp.ikonli.icomoon.Icomoon;
import org.kordamp.ikonli.ionicons.Ionicons;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.maki.Maki;
import org.kordamp.ikonli.material.Material;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.metrizeicons.MetrizeIcons;
import org.kordamp.ikonli.octicons.Octicons;
import org.kordamp.ikonli.openiconic.Openiconic;
import org.kordamp.ikonli.typicons.Typicons;
import org.kordamp.ikonli.weathericons.WeatherIcons;
import org.kordamp.ikonli.websymbols.Websymbols;

import java.net.URL;
import java.util.EnumSet;

import static java.util.EnumSet.allOf;

/**
 * @author Andres Almiray
 */
public class Sampler extends Application {
    public static void main(String[] args) {
        launch(Sampler.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL location = getClass().getResource("sampler.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        TabPane tabPane = fxmlLoader.load();

        tabPane.getTabs().add(new DemoTab(Devicons.class, allOf(Devicons.class)));
        tabPane.getTabs().add(new DemoTab(Elusive.class, allOf(Elusive.class)));
        tabPane.getTabs().add(new DemoTab(Feather.class, allOf(Feather.class)));
        tabPane.getTabs().add(new DemoTab(FontAwesome.class, allOf(FontAwesome.class)));
        tabPane.getTabs().add(new DemoTab(Fontelico.class, allOf(Fontelico.class)));
        tabPane.getTabs().add(new DemoTab(Foundation.class, allOf(Foundation.class)));
        tabPane.getTabs().add(new DemoTab(HawconsFilled.class, allOf(HawconsFilled.class)));
        tabPane.getTabs().add(new DemoTab(HawconsStroke.class, allOf(HawconsStroke.class)));
        tabPane.getTabs().add(new DemoTab(Icomoon.class, allOf(Icomoon.class)));
        tabPane.getTabs().add(new DemoTab(Ionicons.class, allOf(Ionicons.class)));
        tabPane.getTabs().add(new DemoTab(Maki.class, allOf(Maki.class)));
        tabPane.getTabs().add(new DemoTab(Material.class, allOf(Material.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesign.class, allOf(MaterialDesign.class)));
        tabPane.getTabs().add(new DemoTab(MetrizeIcons.class, allOf(MetrizeIcons.class)));
        tabPane.getTabs().add(new DemoTab(Octicons.class, allOf(Octicons.class)));
        tabPane.getTabs().add(new DemoTab(Openiconic.class, allOf(Openiconic.class)));
        tabPane.getTabs().add(new DemoTab(Typicons.class, allOf(Typicons.class)));
        tabPane.getTabs().add(new DemoTab(WeatherIcons.class, allOf(WeatherIcons.class)));
        tabPane.getTabs().add(new DemoTab(Websymbols.class, allOf(Websymbols.class)));

        Scene scene = new Scene(tabPane);
        scene.getStylesheets().add("org/kordamp/ikonli/sampler.css");

        primaryStage.setTitle("Ikonli Sampler");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(1024);
        primaryStage.show();
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
                FontIcon icon = new FontIcon(value);
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