package org.kordamp.ikonli;

public interface IkonResolver {

	IkonHandler resolve(String value);

    boolean registerHandler(IkonHandler handler);

    boolean unregisterHandler(IkonHandler handler);
}
