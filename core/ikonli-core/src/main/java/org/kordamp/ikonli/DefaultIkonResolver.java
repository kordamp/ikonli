package org.kordamp.ikonli;

public class DefaultIkonResolver extends AbstractIkonResolver implements IkonResolver {
	private final FontLoader fontLoader;
	private static volatile DefaultIkonResolver instance;

	protected DefaultIkonResolver(FontLoader fontLoader) {
		this.fontLoader = fontLoader;
		resolveServiceLoader().forEach(handler -> {
			handlers.add(handler);
			fontLoader.loadFont(handler);
		});
	}

	@Override
	public boolean registerHandler(IkonHandler handler) {
		boolean result = super.registerHandler(handler);
		if (result) {
			fontLoader.loadFont(handler);
		}
		return result;
	}

	public static IkonResolver getInstance(FontLoader fontLoader) {
		if (instance == null) {
			synchronized (DefaultIkonResolver.class) {
				if (instance == null) {
					instance = new DefaultIkonResolver(fontLoader);
				}
			}
		}
		return instance;
	}
}
