package org.kordamp.ikonli.javafx.converters;

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.lang.reflect.Method;

/**
 * @author Andres Almiray
 */
public class PaintConverter extends StyleConverter<ParsedValue<?, Paint>, Paint> {
    private final StyleConverter<ParsedValue<?, Paint>, Paint> delegate;

    public static PaintConverter getInstance() {

        ClassLoader classLoader = PaintConverter.class.getClassLoader();
        Class<?> converterClass = null;

        String JDK9_CLASS = "javafx.css.converter.PaintConverter";
        String JDK8_CLASS = "com.sun.javafx.css.converters.PaintConverter";
        try {
            converterClass = classLoader.loadClass(JDK9_CLASS);
        } catch (ClassNotFoundException e) {
            try {
                converterClass = classLoader.loadClass(JDK8_CLASS);
            } catch (ClassNotFoundException e1) {
                throw new IllegalStateException("Can't locate either " + JDK9_CLASS + " or " + JDK8_CLASS);
            }
        }

        try {
            Method getInstance = converterClass.getDeclaredMethod("getInstance");
            return new PaintConverter((StyleConverter<ParsedValue<?, Paint>, Paint>) getInstance.invoke(null));
        } catch (Exception e) {
            throw new IllegalStateException("Unnexpected error while grabbing instance from " + converterClass.getName(), e);
        }
    }

    private PaintConverter(StyleConverter<ParsedValue<?, Paint>, Paint> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Paint convert(ParsedValue<ParsedValue<?, Paint>, Paint> value, Font font) {
        return delegate.convert(value, font);
    }
}
