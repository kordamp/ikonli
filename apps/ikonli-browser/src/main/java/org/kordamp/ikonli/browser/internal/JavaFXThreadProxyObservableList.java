/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2024 Andres Almiray
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
package org.kordamp.ikonli.browser.internal;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.TransformationList;

/**
 * @author Andres Almiray
 */
public class JavaFXThreadProxyObservableList<E> extends TransformationList<E, E> {
    public JavaFXThreadProxyObservableList(ObservableList<E> source) {
        super(source);
    }

    @Override
    protected void sourceChanged(ListChangeListener.Change<? extends E> c) {
        if (Platform.isFxApplicationThread()) {
            fireChange(c);
        } else {
            Platform.runLater(() -> fireChange(c));
        }
    }

    @Override
    public int getSourceIndex(int index) {
        return index;
    }

    @Override
    public E get(int index) {
        return getSource().get(index);
    }

    @Override
    public int size() {
        return getSource().size();
    }

    @Override
    public int getViewIndex(int index) {
        return index;
    }
}