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

import eu.hansolo.tilesfx.tools.FlowGridPane;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import org.kordamp.desktoppanefx.scene.layout.DesktopPane;
import org.kordamp.desktoppanefx.scene.layout.InternalWindow;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonProvider;
import org.kordamp.ikonli.boxicons.BoxiconsRegular;
import org.kordamp.ikonli.browser.internal.JavaFXThreadProxyObservableList;
import org.kordamp.ikonli.javafx.FontIcon;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.EnumSet.allOf;
import static java.util.Objects.requireNonNull;
import static javafx.collections.FXCollections.observableArrayList;

/**
 * @author Andres Almiray
 */
public class SearchInternalWindow extends InternalWindow {
    private static final String SEARCH_WINDOW_ID = "__SEARCH__";

    private final Model model = new Model();
    private final Controller controller = new Controller(model);

    public SearchInternalWindow(Node icon, MigPane migPane) {
        super(SEARCH_WINDOW_ID, icon, "Search", migPane);

        Label label = new Label("Search:");
        TextField searchItem = new TextField();
        model.termProperty().bind(searchItem.textProperty());
        Button searchButton = new Button();
        searchButton.setGraphic(FontIcon.of(BoxiconsRegular.SEARCH_ALT_2, Color.WHITE));
        searchButton.getStyleClass().addAll("btn", "btm-sm", "btn-primary");
        migPane.add(label);
        migPane.add(searchItem, "grow");
        migPane.add(searchButton);

        Button cancelButton = new Button();
        cancelButton.setGraphic(FontIcon.of(BoxiconsRegular.X, Color.WHITE));
        cancelButton.getStyleClass().addAll("btn", "btm-sm", "btn-danger");
        ProgressBar progress = new ProgressBar();
        migPane.add(progress, "span 2, grow");
        migPane.add(cancelButton);

        label = new Label("Selection:");
        TextField selection = new TextField();
        selection.setEditable(false);
        selection.textProperty().bind(model.selectionProperty());
        Button copy = new Button();
        copy.setGraphic(FontIcon.of(BoxiconsRegular.COPY, Color.WHITE));
        copy.getStyleClass().addAll("btn", "btm-sm", "btn-primary");
        migPane.add(label);
        migPane.add(selection, "grow");
        migPane.add(copy);

        copy.disableProperty().bind(selection.textProperty().isEmpty());
        copy.setOnAction(e -> {
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(model.getSelection());
            clipboard.setContent(content);
        });

        final FlowGridPane grid = new FlowGridPane(10, 20);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        grid.setCenterShape(true);
        grid.setPadding(new Insets(5));
        grid.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        migPane.add(new ScrollPane(grid), "span 3, grow");

        searchButton.setOnAction(e -> searchIcons());

        BooleanProperty enabled = new SimpleBooleanProperty(this, "enabled", true);
        BooleanProperty running = new SimpleBooleanProperty(this, "running", false);

        searchItem.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setState(null == newValue || newValue.isEmpty() ? State.DISABLED : State.READY);
        });
        running.addListener((observable, oldValue, newValue) -> {
            if (null != newValue && newValue) grid.getChildren().clear();
        });

        model.stateProperty().addListener((observable, oldValue, newValue) ->
            Platform.runLater(() -> {
                switch (newValue) {
                    case DISABLED:
                        enabled.setValue(false);
                        running.setValue(false);
                        break;
                    case READY:
                        enabled.setValue(true);
                        running.setValue(false);
                        break;
                    case RUNNING:
                        enabled.setValue(false);
                        running.setValue(true);
                        break;
                }
            }));

        searchButton.disableProperty().bind(Bindings.not(enabled));
        cancelButton.visibleProperty().bind(running);
        cancelButton.managedProperty().bind(running);
        progress.visibleProperty().bind(running);
        progress.managedProperty().bind(running);

        model.getIkons().addListener(new ListChangeListener<>() {
            private final FontIcon[] previousIcon = new FontIcon[1];

            @Override
            public void onChanged(Change<? extends Ikon> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        addIcons(new ArrayList<>(c.getAddedSubList()), grid);
                    } else if (c.wasRemoved()) {
                        // can only happen when we clear the list
                        if (Platform.isFxApplicationThread()) {
                            grid.getChildren().clear();
                        } else {
                            Platform.runLater(() -> grid.getChildren().clear());
                        }
                    }
                }
            }

            private void addIcons(List<? extends Ikon> list, FlowGridPane grid) {
                if (Platform.isFxApplicationThread()) {
                    doAddIcons(list, grid);
                } else {
                    Platform.runLater(() -> doAddIcons(list, grid));
                }
            }

            private void doAddIcons(List<? extends Ikon> list, FlowGridPane grid) {
                list.forEach(ikon -> grid.getChildren().add(createIcon(ikon)));
            }

            private FontIcon createIcon(Ikon ikon) {
                FontIcon icon = FontIcon.of(ikon);
                icon.getStyleClass().setAll("font-icon");
                icon.setOnMouseClicked(me -> {
                    if (previousIcon[0] != null) {
                        previousIcon[0].getStyleClass().remove("active-icon");
                    }
                    FontIcon nextIcon = (FontIcon) me.getSource();
                    model.setSelection(nextIcon.getIconCode().getDescription());
                    nextIcon.getStyleClass().add("active-icon");
                    previousIcon[0] = nextIcon;
                });
                return icon;
            }
        });

        setOnHidden(e -> controller.cancel());
    }

    @Override
    public void closeWindow() {
        controller.shutdown();
        super.closeWindow();
    }

    private void searchIcons() {
        controller.cancel();
        controller.search();
    }

    public static void show(DesktopPane desktopPane) {
        desktopPane.findInternalWindow(SEARCH_WINDOW_ID)
            .or(() -> Optional.of(createInternalWindow()))
            .ifPresent(desktopPane::addInternalWindow);
    }

    private static SearchInternalWindow createInternalWindow() {
        SearchInternalWindow internalWindow = new SearchInternalWindow(
            FontIcon.of(BoxiconsRegular.GRID_SMALL, Color.WHITE),
            new MigPane("fill, wrap 3",
                "[left, p!][80%][center]",
                "[p][p][p][80%]"));
        internalWindow.setPrefSize(800, 600);
        internalWindow.getStylesheets().addAll(
            IkonBrowser.class.getResource("common.css").toExternalForm(),
            IkonBrowser.class.getResource("ikon-window.css").toExternalForm());
        return internalWindow;
    }

    private static <E> ObservableList<E> createJavaFXThreadProxyList(ObservableList<E> source) {
        requireNonNull(source, "Argument 'source' must not be null");
        return new JavaFXThreadProxyObservableList<>(source);
    }

    public enum State {
        DISABLED,
        READY,
        RUNNING
    }

    private static class Model {
        private final ObservableList<Ikon> ikons = observableArrayList();
        private StringProperty term;
        private StringProperty selection;
        private ObjectProperty<State> state;
        private Task<Void> task;

        public Model() {
            stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == State.RUNNING) {
                    ikons.clear();
                }
            });
        }

        public ObservableList<Ikon> getIkons() {
            return ikons;
        }

        public Task<Void> getTask() {
            return task;
        }

        public void setTask(Task<Void> task) {
            this.task = task;
        }

        public StringProperty termProperty() {
            if (term == null) {
                term = new SimpleStringProperty(this, "term");
            }
            return term;
        }

        public String getTerm() {
            return termProperty().get();
        }

        public void setTerm(String term) {
            termProperty().set(term);
        }

        public StringProperty selectionProperty() {
            if (selection == null) {
                selection = new SimpleStringProperty(this, "selection");
            }
            return selection;
        }

        public String getSelection() {
            return selectionProperty().get();
        }

        public void setSelection(String selection) {
            this.selectionProperty().set(selection);
        }

        public State getState() {
            return stateProperty().get();
        }

        public void setState(State state) {
            stateProperty().set(state);
        }

        public ObjectProperty<State> stateProperty() {
            if (state == null) {
                state = new SimpleObjectProperty<>(this, "state", State.READY);
            }
            return state;
        }
    }

    private static class Controller {
        private final Model model;
        private final List<Ikon> ikons = new ArrayList<>();
        private ExecutorService executor;

        public Controller(Model model) {
            this.model = model;
        }

        public void search() {
            model.getIkons().clear();

            if (executor == null) {
                executor = Executors.newSingleThreadExecutor();
            }

            if (ikons.isEmpty()) {
                loadIcons();
            }

            Task<Void> task = createTask();
            model.setTask(task);
            executor.execute(task);
        }

        private Task<Void> createTask() {
            return new Task<>() {
                @Override
                protected Void call() throws Exception {
                    String term = model.getTerm().toLowerCase();
                    ikons.stream()
                        .filter(ikon -> ikon.getDescription().contains(term))
                        .peek(model.getIkons()::add)
                        .forEach(Controller::noop);

                    return null;
                }
            };
        }

        public void cancel() {
            model.setSelection("");
            if (model.getTask() != null) {
                model.getTask().cancel(true);
                model.setState(State.READY);
            }
        }

        public void shutdown() {
            executor.shutdownNow();
            executor = null;
        }

        private void loadIcons() {
            if (null != IkonProvider.class.getModule().getLayer()) {
                for (IkonProvider provider : ServiceLoader.load(IkonProvider.class.getModule().getLayer(), IkonProvider.class)) {
                    add(allOf(provider.getIkon()), ikons);
                }
            } else {
                for (IkonProvider provider : ServiceLoader.load(IkonProvider.class)) {
                    add(allOf(provider.getIkon()), ikons);
                }
            }
        }

        private void add(EnumSet<? extends Ikon> set, List<Ikon> ikons) {
            ikons.addAll(set);
        }

        private static void noop(Ikon ikon) {
        }
    }
}
