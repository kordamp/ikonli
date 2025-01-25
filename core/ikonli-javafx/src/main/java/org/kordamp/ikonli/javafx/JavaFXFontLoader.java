package org.kordamp.ikonli.javafx;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.kordamp.ikonli.FontLoader;
import org.kordamp.ikonli.IkonHandler;
import org.osgi.service.component.annotations.Component;

import javafx.scene.text.Font;

@Component(service = FontLoader.class)
public class JavaFXFontLoader implements FontLoader {
	private static final Map<String, Font> FONTS = new ConcurrentHashMap<>();

	@Override
	public void loadFont(IkonHandler handler) {
		String fontResource = handler.getFontResource().toExternalForm();
		Font font = FONTS.computeIfAbsent(fontResource, key -> Font.loadFont(key, 16));
		handler.setFont(font);
	}

	public static FontLoader getInstance() {
		return new JavaFXFontLoader();
	}
}
