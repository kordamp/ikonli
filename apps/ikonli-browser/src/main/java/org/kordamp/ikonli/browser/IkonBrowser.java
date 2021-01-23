/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2021 Andres Almiray
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

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.desktoppanefx.scene.layout.DesktopPane;
import org.kordamp.desktoppanefx.scene.layout.IncubatingFeatures;
import org.kordamp.desktoppanefx.scene.layout.TaskBar;
import org.kordamp.desktoppanefx.scene.layout.TaskBarIcon;
import org.kordamp.ikonli.boxicons.BoxiconsRegular;
import org.kordamp.ikonli.javafx.FontIcon;

import static javafx.beans.binding.Bindings.createBooleanBinding;

/**
 * @author Andres Almiray
 */
public class IkonBrowser extends Application {
    private DesktopPane desktopPane;

    @Override
    public void start(Stage stage) throws Exception {
        desktopPane = new DesktopPane();
        desktopPane.getStylesheets().add(IkonBrowser.class.getResource("browser.css").toExternalForm());
        desktopPane.getTaskBar().setPosition(TaskBar.Position.BOTTOM);

        ObservableList<TaskBarIcon> icons = desktopPane.getTaskBar().getTaskBarIcons();
        desktopPane.getTaskBar().visibleProperty().bind(createBooleanBinding(() -> icons.size() > 0, icons));

        System.setProperty(IncubatingFeatures.DETACHABLE_WINDOWS, "true");

        BorderPane mainPane = new BorderPane();
        mainPane.setPrefSize(1024, 768);

        MenuBar menuBar = createMenuBar();

        mainPane.setTop(menuBar);
        mainPane.setCenter(desktopPane);

        Scene scene = new Scene(mainPane);
        scene.getStylesheets().addAll(
            IkonBrowser.class.getResource("browser.css").toExternalForm(),
            BootstrapFX.bootstrapFXStylesheet());

        stage.setScene(scene);
        stage.setTitle("Ikonli - https://kordamp.org/ikonli");
        stage.show();
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().addAll(
            createActionsMenu(),
            createWindowsMenu(),
            createHelpMenu());

        return menuBar;
    }

    private Menu createActionsMenu() {
        Menu actionsMenu = new Menu("Actions");

        MenuItem browse = new MenuItem("Browse");
        browse.setGraphic(FontIcon.of(BoxiconsRegular.GRID_SMALL));
        browse.setOnAction(e -> IkonPickerDialog.show(desktopPane));
        MenuItem search = new MenuItem("Search");
        search.setGraphic(FontIcon.of(BoxiconsRegular.SEARCH));
        search.setOnAction(e -> SearchInternalWindow.show(desktopPane));
        actionsMenu.getItems().addAll(browse, search);

        return actionsMenu;
    }

    private Menu createWindowsMenu() {
        Menu windowsMenu = new Menu("Windows");

        Menu tileMenu = new Menu("Tile");
        tileMenu.setGraphic(FontIcon.of(BoxiconsRegular.WINDOWS));
        Menu minimizeMenu = new Menu("Minimize");
        minimizeMenu.setGraphic(FontIcon.of(BoxiconsRegular.COLLAPSE));
        Menu maximizeMenu = new Menu("Maximize");
        maximizeMenu.setGraphic(FontIcon.of(BoxiconsRegular.EXPAND));
        Menu closeMenu = new Menu("Close");
        closeMenu.setGraphic(FontIcon.of(BoxiconsRegular.WINDOW_CLOSE));
        Menu restoreMenu = new Menu("Restore");
        restoreMenu.setGraphic(FontIcon.of(BoxiconsRegular.WINDOW_OPEN));
        windowsMenu.getItems().addAll(tileMenu, minimizeMenu, maximizeMenu, closeMenu, restoreMenu);

        MenuItem minimizeAll = new MenuItem("Minimize All");
        minimizeAll.setOnAction(e -> desktopPane.minimizeAllWindows());
        MenuItem minimizeOthers = new MenuItem("Minimize Others");
        minimizeOthers.setOnAction(e -> desktopPane.minimizeOtherWindows());
        minimizeMenu.getItems().addAll(minimizeAll, minimizeOthers);

        MenuItem maximizeAll = new MenuItem("Maximize All");
        maximizeAll.setOnAction(e -> desktopPane.maximizeAllWindows());
        MenuItem maximizeVisible = new MenuItem("Maximize Visible");
        maximizeVisible.setOnAction(e -> desktopPane.maximizeVisibleWindows());
        maximizeMenu.getItems().addAll(maximizeAll, maximizeVisible);

        MenuItem closeAll = new MenuItem("Close All");
        closeAll.setOnAction(e -> desktopPane.closeAllWindows());
        MenuItem closeOthers = new MenuItem("Close Others");
        closeOthers.setOnAction(e -> desktopPane.closeOtherWindows());
        closeMenu.getItems().addAll(closeAll, closeOthers);

        MenuItem restoreMinimized = new MenuItem("Restore Minimized");
        restoreMinimized.setOnAction(e -> desktopPane.restoreMinimizedWindows());
        MenuItem restoreVisible = new MenuItem("Restore Visible");
        restoreVisible.setOnAction(e -> desktopPane.restoreVisibleWindows());
        restoreMenu.getItems().addAll(restoreMinimized, restoreVisible);

        MenuItem tileAll = new MenuItem("Tile All");
        tileAll.setOnAction(e -> desktopPane.tileAllWindows());
        MenuItem tileVisible = new MenuItem("Tile Visible");
        tileVisible.setOnAction(e -> desktopPane.tileVisibleWindows());
        MenuItem tileHorizontally = new MenuItem("Tile Horizontally");
        tileHorizontally.setOnAction(e -> desktopPane.tileHorizontally());
        MenuItem tileVertically = new MenuItem("Tile Vertically");
        tileVertically.setOnAction(e -> desktopPane.tileVertically());
        tileMenu.getItems().addAll(tileAll, tileVisible, tileHorizontally, tileVertically);

        return windowsMenu;
    }

    private Menu createHelpMenu() {
        Menu helpMenu = new Menu("Help");

        MenuItem about = new MenuItem("About");
        about.setGraphic(FontIcon.of(BoxiconsRegular.COPYRIGHT));
        about.setOnAction(e -> AboutDialog.show());
        helpMenu.getItems().addAll(about);

        return helpMenu;
    }
}
