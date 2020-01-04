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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableIntegerProperty;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.css.converter.PaintConverter;
import javafx.css.converter.SizeConverter;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.kordamp.ikonli.Ikon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class StackedFontIcon extends StackPane implements Icon {
    private static final String KEY_STACKED_FONT_ICON_SIZE = StackedFontIcon.class.getName() + ".iconSize";

    private StyleableIntegerProperty iconSize;
    private StyleableObjectProperty<Paint> iconColor;
    private double[] iconSizes = new double[0];

    private ChangeListener<Number> iconSizeChangeListener = (v, o, n) -> setIconSizeOnChildren(n.intValue());
    private ChangeListener<Paint> iconColorChangeListener = (v, o, n) -> setIconColorOnChildren(n);

    public static void setIconSize(Node icon, double size) {
        if (icon != null && size >= 0d && size <= 1.0d) {
            icon.getProperties().put(KEY_STACKED_FONT_ICON_SIZE, size);
        }
    }

    public static double getIconSize(Node icon) {
        if (icon != null) {
            Object value = icon.getProperties().get(KEY_STACKED_FONT_ICON_SIZE);
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            }
        }
        return 1.0d;
    }

    private class NodeSizeListener implements MapChangeListener<Object, Object> {
        private Node node;

        private NodeSizeListener(Node node) {
            this.node = node;
        }

        @Override
        public void onChanged(Change<?, ?> change) {
            if (KEY_STACKED_FONT_ICON_SIZE.equals(String.valueOf(change.getKey()))) {
                int size = getChildren().size();
                for (int i = 0; i < size; i++) {
                    if (node == getChildren().get(i)) {
                        double value = 0;
                        Object valueAdded = change.getValueAdded();
                        if (valueAdded instanceof Number) {
                            value = ((Number) valueAdded).doubleValue();
                        } else {
                            value = Double.parseDouble(String.valueOf(valueAdded));
                        }
                        iconSizes[i] = value;
                        return;
                    }
                }
            }
        }
    }

    public StackedFontIcon() {
        getStyleClass().setAll("stacked-ikonli-font-icon");

        final String propertiesListenerKey = StackedFontIcon.class.getName() + "-" + System.identityHashCode(this);

        getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        int size = c.getTo() - c.getFrom();
                        // grow iconSizes by size
                        iconSizes = Arrays.copyOf(iconSizes, iconSizes.length + size);
                        // apply 1.0 [from..to]
                        for (int i = c.getFrom(); i < c.getTo(); i++) {
                            iconSizes[i] = getIconSize(c.getList().get(i));
                        }
                        for (Node node : c.getAddedSubList()) {
                            node.getProperties().put(propertiesListenerKey, new NodeSizeListener(node));
                        }
                    } else if (c.wasRemoved()) {
                        int size = c.getTo() - c.getFrom();
                        // shrink iconSizes by size
                        double[] newIconSizes = new double[iconSizes.length - size];
                        // copy [0..from]
                        int index = 0;
                        for (int i = 0; i < c.getFrom(); i++) {
                            newIconSizes[index++] = iconSizes[i];
                        }
                        // copy [to..-1]
                        for (int i = c.getTo(); i < iconSizes.length; i++) {
                            newIconSizes[index++] = iconSizes[i];
                        }
                        iconSizes = newIconSizes;
                        for (Node node : c.getRemoved()) {
                            node.getProperties().remove(propertiesListenerKey);
                        }
                    } else if (c.wasPermutated()) {
                        double[] newIconSizes = Arrays.copyOf(iconSizes, iconSizes.length);
                        for (int i = c.getFrom(); i <= c.getTo(); i++) {
                            newIconSizes[i] = c.getPermutation(i);
                        }
                        iconSizes = newIconSizes;
                    }
                }
            }
        });
    }

    public IntegerProperty iconSizeProperty() {
        if (iconSize == null) {
            iconSize = new StyleableIntegerProperty(16) {
                @Override
                public CssMetaData getCssMetaData() {
                    return StyleableProperties.ICON_SIZE;
                }

                @Override
                public Object getBean() {
                    return StackedFontIcon.this;
                }

                @Override
                public String getName() {
                    return "iconSize";
                }
            };
            iconSize.addListener(iconSizeChangeListener);
        }
        return iconSize;
    }

    public ObjectProperty<Paint> iconColorProperty() {
        if (iconColor == null) {
            iconColor = new StyleableObjectProperty<Paint>(Color.BLACK) {
                @Override
                public CssMetaData getCssMetaData() {
                    return StyleableProperties.ICON_COLOR;
                }

                @Override
                public Object getBean() {
                    return StackedFontIcon.this;
                }

                @Override
                public String getName() {
                    return "iconColor";
                }
            };
            iconColor.addListener(iconColorChangeListener);
        }
        return iconColor;
    }

    public void setIconSize(int size) {
        if (size <= 0) {
            throw new IllegalStateException("Argument 'size' must be greater than zero.");
        }
        iconSizeProperty().set(size);
    }

    public int getIconSize() {
        return iconSizeProperty().get();
    }

    public void setIconColor(Paint paint) {
        requireNonNull(paint, "Argument 'paint' must not be null");
        iconColorProperty().set(paint);
    }

    public Paint getIconColor() {
        return iconColorProperty().get();
    }

    public void setIconCodes(Ikon... iconCodes) {
        getChildren().clear();
        initializeSizesIfNeeded(iconCodes);
        updateIconCodes(iconCodes);
    }

    public void setIconCodeLiterals(String... iconCodes) {
        getChildren().clear();
        Ikon[] codes = new Ikon[iconCodes.length];
        for (int i = 0; i < iconCodes.length; i++) {
            codes[i] = IkonResolver.getInstance().resolveIkonHandler(iconCodes[i]).resolve(iconCodes[i]);
        }
        initializeSizesIfNeeded(iconCodes);
        updateIconCodes(codes);
    }

    /**
     * Sets the size for each child icon relative to this icon's size.
     *
     * @param iconSizes values must be within the range [0..1]
     */
    public void setIconSizes(double... iconSizes) {
        this.iconSizes = iconSizes;
        setIconSizeOnChildren(getIconSize());
    }

    public void setColors(Paint... iconColors) {
        int i = 0;
        for (Node node : getChildren()) {
            if (node instanceof Icon) {
                ((Icon) node).setIconColor(iconColors[i++]);
            }
        }
    }

    private void initializeSizesIfNeeded(Object[] array) {
        if (iconSizes.length == 0 || iconSizes.length != array.length) {
            iconSizes = new double[array.length];
            Arrays.fill(iconSizes, 1d);
        }
    }

    private void updateIconCodes(Ikon[] iconCodes) {
        for (int index = 0; index < iconCodes.length; index++) {
            getChildren().add(createFontIcon(iconCodes[index], index));
        }
    }

    private FontIcon createFontIcon(Ikon iconCode, int index) {
        FontIcon icon = new FontIcon(iconCode);
        icon.setIconSize(getIconSize());
        icon.setIconColor(getIconColor());
        int size = icon.getIconSize();
        applySizeToIcon(size, icon, index);
        return icon;
    }

    private static class StyleableProperties {
        private static final CssMetaData<StackedFontIcon, Number> ICON_SIZE =
            new CssMetaData<StackedFontIcon, Number>("-fx-icon-size",
                SizeConverter.getInstance(), 16.0) {

                @Override
                public boolean isSettable(StackedFontIcon fontIcon) {
                    return true;
                }

                @Override
                public StyleableProperty<Number> getStyleableProperty(StackedFontIcon icon) {
                    return (StyleableProperty<Number>) icon.iconSizeProperty();
                }
            };

        private static final CssMetaData<StackedFontIcon, Paint> ICON_COLOR =
            new CssMetaData<StackedFontIcon, Paint>("-fx-icon-color",
                PaintConverter.getInstance(), Color.BLACK) {

                @Override
                public boolean isSettable(StackedFontIcon node) {
                    return true;
                }

                @Override
                public StyleableProperty<Paint> getStyleableProperty(StackedFontIcon icon) {
                    return (StyleableProperty<Paint>) icon.iconColorProperty();
                }
            };

        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables =
                new ArrayList<CssMetaData<? extends Styleable, ?>>(StackPane.getClassCssMetaData());
            styleables.add(ICON_SIZE);
            styleables.add(ICON_COLOR);
            STYLEABLES = unmodifiableList(styleables);
        }
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return StackedFontIcon.getClassCssMetaData();
    }

    private void setIconSizeOnChildren(int size) {
        int i = 0;
        for (Node node : getChildren()) {
            if (node instanceof Icon) {
                applySizeToIcon(size, (Icon) node, i++);
            }
        }
    }

    private void applySizeToIcon(int size, Icon icon, int index) {
        double childPercentageSize = iconSizes[index];
        double newSize = size * childPercentageSize;
        icon.setIconSize((int) newSize);
    }

    private void setIconColorOnChildren(Paint color) {
        for (Node node : getChildren()) {
            if (node instanceof Icon) {
                ((Icon) node).setIconColor(color);
            }
        }
    }
}
