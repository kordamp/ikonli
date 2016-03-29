/*
 * Copyright 2015-2016 Andres Almiray. <aalmiray@yahoo.com>
 *
 * This file is part of Ikonli
 *
 * Ikonli is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Ikonli is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Ikonli. If not, see <http://www.gnu.org/licenses/>.
 *
 * ========================================================================
 *
 * This library is distributed under the terms of the GNU General Public
 * License with the following clarification and special exception:
 *
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole
 * combination.
 *
 * As an special exception, the copyright holders of this library give
 * you permission to use this library under the terms of the Apache
 * Software License v2 and forego the licensing terms of the GNU General
 * Public License if and only if the library is used as part of an
 * executable and/or application that makes use of the APIs of either the
 * Griffon Framework (https://github.com/griffon/griffon) or the
 * Basilisk Framework (https://github.com/basilisk-fw/basilisk).
 *
 * ========================================================================
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
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.fontelico.Fontelico;
import org.kordamp.ikonli.foundation.Foundation;
import org.kordamp.ikonli.ionicons.Ionicons;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.maki.Maki;
import org.kordamp.ikonli.material.Material;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.octicons.Octicons;
import org.kordamp.ikonli.openiconic.Openiconic;
import org.kordamp.ikonli.typicons.Typicons;
import org.kordamp.ikonli.weathericons.WeatherIcons;

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
        tabPane.getTabs().add(new DemoTab(FontAwesome.class, allOf(FontAwesome.class)));
        tabPane.getTabs().add(new DemoTab(Fontelico.class, allOf(Fontelico.class)));
        tabPane.getTabs().add(new DemoTab(Foundation.class, allOf(Foundation.class)));
        tabPane.getTabs().add(new DemoTab(Ionicons.class, allOf(Ionicons.class)));
        tabPane.getTabs().add(new DemoTab(Maki.class, allOf(Maki.class)));
        tabPane.getTabs().add(new DemoTab(Material.class, allOf(Material.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesign.class, allOf(MaterialDesign.class)));
        tabPane.getTabs().add(new DemoTab(Octicons.class, allOf(Octicons.class)));
        tabPane.getTabs().add(new DemoTab(Openiconic.class, allOf(Openiconic.class)));
        tabPane.getTabs().add(new DemoTab(Typicons.class, allOf(Typicons.class)));
        tabPane.getTabs().add(new DemoTab(WeatherIcons.class, allOf(WeatherIcons.class)));

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