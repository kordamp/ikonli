package org.kordamp.ikonli.swing;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.kordamp.ikonli.FontLoader;
import org.kordamp.ikonli.IkonHandler;
import org.osgi.service.component.annotations.Component;

@Component(service = FontLoader.class)
public class SwingFontLoader implements FontLoader {
	private static final Map<String, Font> FONTS = new ConcurrentHashMap<>();

	@Override
	public void loadFont(IkonHandler handler) {
		String fontResource = handler.getFontResource().toExternalForm();
		Font font = FONTS.computeIfAbsent(fontResource, key -> {
			try (InputStream stream = handler.getFontResourceAsStream()) {
				if (stream == null) {
					throw new IllegalStateException("Font resource not found: " + fontResource);
				}
				Font newFont = Font.createFont(Font.TRUETYPE_FONT, stream);
				GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(newFont);
				return newFont;
			} catch (FontFormatException | IOException e) {
				throw new IllegalStateException("Failed to load font from " + fontResource, e);
			}
		});
		handler.setFont(font);
	}

	public static FontLoader getInstance() {
		return new SwingFontLoader();
	}
}
