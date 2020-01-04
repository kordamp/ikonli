/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2020 Andres Almiray
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
package org.kordamp.ikonli.javafx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.kordamp.ikonli.Ikon;

import static java.util.Objects.requireNonNull;

public class FontIconTableCell<S, T> extends TableCell<S, T> {
    private static final String ERROR_CONVERTER_NULL = "Argument 'converter' must not be null";

    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn() {
        return param -> new FontIconTableCell<S, T>();
    }

    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(StringConverter<T> converter) {
        return param -> new FontIconTableCell<S, T>(converter);
    }

    private Subscription subscription;
    private final FontIcon icon;
    private final ObjectProperty<StringConverter<T>> converter = new SimpleObjectProperty<StringConverter<T>>(this, "converter");

    @SuppressWarnings("unchecked")
    public FontIconTableCell() {
        this(new StringConverter<T>() {
            @Override
            public String toString(T object) {
                return object != null ? String.valueOf(object) : "";
            }

            @Override
            public T fromString(String string) {
                // leave it as is for now
                return null;
            }
        });
    }

    public FontIconTableCell(StringConverter<T> converter) {
        this.getStyleClass().add("font-icon-table-cell");
        this.icon = new FontIcon();
        setConverter(requireNonNull(converter, ERROR_CONVERTER_NULL));
    }

    public final ObjectProperty<StringConverter<T>> converterProperty() {
        return converter;
    }

    public final void setConverter(StringConverter<T> converter) {
        converterProperty().set(requireNonNull(converter, ERROR_CONVERTER_NULL));
    }

    public final StringConverter<T> getConverter() {
        return converterProperty().get();
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            if (subscription != null) {
                subscription.unsubscribe();
                subscription = null;
            }

            final TableColumn<S, T> column = getTableColumn();
            ObservableValue<T> observable = column == null ? null : column.getCellObservableValue(getIndex());

            if (observable != null) {
                ChangeListener<T> listener = (v, o, n) -> setIconCode(n);
                observable.addListener(listener);
                subscription = () -> observable.removeListener(listener);
                setIconCode(observable.getValue());
            } else if (item != null) {
                setIconCode(item);
            }

            setGraphic(icon);
            setAlignment(Pos.CENTER);
        }
    }

    private void setIconCode(T value) {
        if (value instanceof Ikon) {
            icon.setIconCode((Ikon) value);
        } else {
            icon.setIconLiteral(getConverter().toString(value));
        }
    }

    private interface Subscription {
        void unsubscribe();
    }
}
