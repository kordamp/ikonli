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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.SVGPath;
import org.kordamp.ikonli.Ikon;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class SVGIcon extends Region implements Icon {
    protected StyleableIntegerProperty iconSize;
    protected StyleableObjectProperty<Paint> iconColor;
    private StyleableObjectProperty<Ikon> iconCode;
    private final SVGPath path = new SVGPath();

    private ChangeListener<Number> iconSizeChangeListener = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> v, Number o, Number n) {
            //SVGIcon.this.setStyle(getStyle() + "-fx-font-size: " + n + "px;");
        }
    };
    private ChangeListener<Paint> iconColorChangeListener = new ChangeListener<Paint>() {
        @Override
        public void changed(ObservableValue<? extends Paint> v, Paint o, Paint n) {
            path.setFill(n);
        }
    };
    private ChangeListener<Ikon> iconFontChangeListener = new ChangeListener<Ikon>() {
        @Override
        public void changed(ObservableValue<? extends Ikon> v, Ikon o, Ikon n) {
            SVGIcon.this.setIconCode(n);
        }
    };

    public SVGIcon() {
        getChildren().add(path);
        path.setScaleX(0.1);
        path.setScaleY(0.1);
        getStyleClass().setAll("ikonli-svg-icon");
        setIconSize(16);
        setIconColor(Color.BLACK);
    }

    public SVGIcon(String iconCode) {
        this();
        setIconLiteral(iconCode);
    }

    public SVGIcon(Ikon iconCode) {
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
                    return SVGIcon.this;
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
                    return SVGIcon.this;
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
                    return SVGIcon.this;
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
        path.setContent(SVGGlyphRegistry.getInstance().getSVGContent(iconCode));
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
        private static final CssMetaData<SVGIcon, Number> ICON_SIZE =
            new CssMetaData<SVGIcon, Number>("-fx-icon-size",
                SizeConverter.getInstance(), 16.0) {

                @Override
                public boolean isSettable(SVGIcon icon) {
                    return true;
                }

                @Override
                public StyleableProperty<Number> getStyleableProperty(SVGIcon icon) {
                    return (StyleableProperty<Number>) icon.iconSizeProperty();
                }
            };

        private static final CssMetaData<SVGIcon, Paint> ICON_COLOR =
            new CssMetaData<SVGIcon, Paint>("-fx-icon-color",
                PaintConverter.getInstance(), Color.BLACK) {

                @Override
                public boolean isSettable(SVGIcon node) {
                    return true;
                }

                @Override
                public StyleableProperty<Paint> getStyleableProperty(SVGIcon icon) {
                    return (StyleableProperty<Paint>) icon.iconColorProperty();
                }
            };

        private static final CssMetaData<SVGIcon, Ikon> ICON_CODE =
            new CssMetaData<SVGIcon, Ikon>("-fx-icon-code",
                SVGIconConverter.getInstance(), null) {

                @Override
                public boolean isSettable(SVGIcon node) {
                    return true;
                }

                @Override
                public StyleableProperty<Ikon> getStyleableProperty(SVGIcon icon) {
                    return (StyleableProperty<Ikon>) icon.iconCodeProperty();
                }
            };

        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables =
                new ArrayList<CssMetaData<? extends Styleable, ?>>(Region.getClassCssMetaData());
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
        return SVGIcon.getClassCssMetaData();
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
        try {
            return Color.valueOf(value);
        } catch (IllegalArgumentException e1) {
            try {
                return LinearGradient.valueOf(value);
            } catch (IllegalArgumentException e2) {
                try {
                    return RadialGradient.valueOf(value);
                } catch (IllegalArgumentException e3) {
                    throw invalidDescription(iconCode, e3);
                }
            }
        }
    }

    public static IllegalArgumentException invalidDescription(String description, Exception e) {
        throw new IllegalArgumentException("Description " + description + " is not a valid icon description", e);
    }
}
