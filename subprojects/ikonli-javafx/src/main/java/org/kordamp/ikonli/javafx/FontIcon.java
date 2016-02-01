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
package org.kordamp.ikonli.javafx;

import com.sun.javafx.css.converters.PaintConverter;
import com.sun.javafx.css.converters.SizeConverter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableIntegerProperty;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.text.Text;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class FontIcon extends Text implements Icon {
    protected StyleableIntegerProperty iconSize;
    protected StyleableObjectProperty<Paint> iconColor;
    private StyleableObjectProperty<Ikon> iconCode;

    private ChangeListener<Number> iconSizeChangeListener = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> v, Number o, Number n) {
            FontIcon.this.setStyle(getStyle() + "-fx-font-size: " + n + "px;");
        }
    };
    private ChangeListener<Paint> iconColorChangeListener = new ChangeListener<Paint>() {
        @Override
        public void changed(ObservableValue<? extends Paint> v, Paint o, Paint n) {
            FontIcon.this.setFill(n);
        }
    };
    private ChangeListener<Ikon> iconFontChangeListener = new ChangeListener<Ikon>() {
        @Override
        public void changed(ObservableValue<? extends Ikon> v, Ikon o, Ikon n) {
            FontIcon.this.setIconCode(n);
        }
    };

    public FontIcon() {
        getStyleClass().setAll("ikonli-font-icon");
        setIconSize(16);
        setIconColor(Color.BLACK);
    }

    public FontIcon(String iconCode) {
        this();
        setIconLiteral(iconCode);
    }

    public FontIcon(Ikon iconCode) {
        this();
        setIconCode(iconCode);
    }

    public String toString() {
        return getIconCode().getDescription() + ":" + getIconSize() + ":" + getIconColor();
    }

    @Override
    public IntegerProperty iconSizeProperty() {
        if (iconSize == null) {
            iconSize = new StyleableIntegerProperty(16) {
                @Override
                public CssMetaData getCssMetaData() {
                    return StyleableProperties.ICON_SIZE;
                }

                @Override
                public Object getBean() {
                    return FontIcon.this;
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

    @Override
    public ObjectProperty<Paint> iconColorProperty() {
        if (iconColor == null) {
            iconColor = new StyleableObjectProperty<Paint>(Color.BLACK) {
                @Override
                public CssMetaData getCssMetaData() {
                    return StyleableProperties.ICON_COLOR;
                }

                @Override
                public Object getBean() {
                    return FontIcon.this;
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

    public ObjectProperty<Ikon> iconCodeProperty() {
        if (iconCode == null) {
            iconCode = new StyleableObjectProperty<Ikon>() {
                @Override
                public CssMetaData getCssMetaData() {
                    return StyleableProperties.ICON_CODE;
                }

                @Override
                public Object getBean() {
                    return FontIcon.this;
                }

                @Override
                public String getName() {
                    return "iconCode";
                }
            };
            iconCode.addListener(iconFontChangeListener);
        }
        return iconCode;
    }

    public ObjectProperty<Ikon> getIconCodeProperty() {
        return iconCodeProperty();
    }

    @Override
    public void setIconSize(int size) {
        if (size <= 0) {
            throw new IllegalStateException("Argument 'size' must be greater than zero.");
        }
        iconSizeProperty().set(size);
    }

    @Override
    public int getIconSize() {
        return iconSizeProperty().get();
    }

    @Override
    public void setIconColor(Paint paint) {
        requireNonNull(paint, "Argument 'paint' must not be null");
        iconColorProperty().set(paint);
    }

    @Override
    public Paint getIconColor() {
        return iconColorProperty().get();
    }

    public Ikon getIconCode() {
        return iconCodeProperty().get();
    }

    public void setIconCode(Ikon iconCode) {
        iconCodeProperty().set(requireNonNull(iconCode, "Argument 'code' must not be null"));
        IkonHandler ikonHandler = IkonResolver.getInstance().resolveIkonHandler(iconCode.getDescription());
        setStyle(getStyle() + "-fx-font-family: '" + ikonHandler.getFontFamily() + "';");
        setText(String.valueOf(iconCode.getCode()));
    }

    public void setIconLiteral(String iconCode) {
        String[] parts = iconCode.split(":");
        setIconCode(IkonResolver.getInstance().resolveIkonHandler(parts[0]).resolve(parts[0]));
        resolveSize(iconCode, parts);
        resolvePaint(iconCode, parts);
    }

    public String getIconLiteral() {
        Ikon ikon = iconCodeProperty().get();
        return ikon != null ? ikon.getDescription() : null;
    }

    private static class StyleableProperties {
        private static final CssMetaData<FontIcon, Number> ICON_SIZE =
            new CssMetaData<FontIcon, Number>("-fx-icon-size",
                SizeConverter.getInstance(), 16.0) {

                @Override
                public boolean isSettable(FontIcon icon) {
                    return true;
                }

                @Override
                public StyleableProperty<Number> getStyleableProperty(FontIcon icon) {
                    return (StyleableProperty<Number>) icon.iconSizeProperty();
                }
            };

        private static final CssMetaData<FontIcon, Paint> ICON_COLOR =
            new CssMetaData<FontIcon, Paint>("-fx-icon-color",
                PaintConverter.getInstance(), Color.BLACK) {

                @Override
                public boolean isSettable(FontIcon node) {
                    return true;
                }

                @Override
                public StyleableProperty<Paint> getStyleableProperty(FontIcon icon) {
                    return (StyleableProperty<Paint>) icon.iconColorProperty();
                }
            };

        private static final CssMetaData<FontIcon, Ikon> ICON_CODE =
            new CssMetaData<FontIcon, Ikon>("-fx-icon-code",
                IconFontConverter.getInstance(), null) {

                @Override
                public boolean isSettable(FontIcon node) {
                    return true;
                }

                @Override
                public StyleableProperty<Ikon> getStyleableProperty(FontIcon icon) {
                    return (StyleableProperty<Ikon>) icon.iconCodeProperty();
                }
            };

        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables =
                new ArrayList<CssMetaData<? extends Styleable, ?>>(Text.getClassCssMetaData());
            styleables.add(ICON_SIZE);
            styleables.add(ICON_COLOR);
            styleables.add(ICON_CODE);
            STYLEABLES = unmodifiableList(styleables);
        }
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return FontIcon.getClassCssMetaData();
    }

    private void resolveSize(String iconCode, String[] parts) {
        if (parts.length > 1) {
            try {
                setIconSize(Integer.parseInt(parts[1]));
            } catch (NumberFormatException e) {
                throw invalidDescription(iconCode, e);
            }
        } else {
            setIconSize(16);
        }
    }

    private void resolvePaint(String iconCode, String[] parts) {
        if (parts.length > 2) {
            Paint paint = resolvePaintValue(iconCode, parts[2]);
            if (paint != null) {
                setIconColor(paint);
            }
        }
    }

    private static Paint resolvePaintValue(String iconCode, String value) {
        try { return Color.valueOf(value); } catch (IllegalArgumentException e1) {
            try { return LinearGradient.valueOf(value); } catch (IllegalArgumentException e2) {
                try { return RadialGradient.valueOf(value); } catch (IllegalArgumentException e3) {
                    throw invalidDescription(iconCode, e3);
                }
            }
        }
    }

    public static IllegalArgumentException invalidDescription(String description, Exception e) {
        throw new IllegalArgumentException("Description " + description + " is not a valid icon description", e);
    }
}