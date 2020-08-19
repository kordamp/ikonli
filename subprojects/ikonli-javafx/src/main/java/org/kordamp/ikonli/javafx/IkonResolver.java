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

import javafx.scene.text.Font;
import org.kordamp.ikonli.IkonHandler;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.ServiceLoader;
import java.util.Set;

import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class IkonResolver {
    private static final IkonResolver INSTANCE;
    private static final Set<IkonHandler> HANDLERS = new LinkedHashSet<>();

    static {
        INSTANCE = new IkonResolver();

        ClassLoader classLoader = IkonResolver.class.getClassLoader();
        ServiceLoader<IkonHandler> loader = ServiceLoader.load(IkonHandler.class, classLoader);
        for (IkonHandler handler : loader) {
            HANDLERS.add(handler);
            handler.setFont(Font.loadFont(classLoader.getResource(handler.getFontResourcePath()).toExternalForm(), 16));
        }
    }

    private IkonResolver() {

    }

    private final Set<IkonHandler> customHandlers = new LinkedHashSet<>();

    private boolean isLoadedViaClasspath(IkonHandler handler) {
        String fontFamily = handler.getFontFamily();
        for (IkonHandler classpathHandler : HANDLERS)
            if (classpathHandler.getFontFamily().equals(fontFamily))
                return true;
        return false;
    }

    private static boolean strictChecksEnabled() {
        return Boolean.parseBoolean(System.getProperty("org.kordamp.ikonli.strict", Boolean.TRUE.toString()));
    }

    private void throwOrWarn(String errMessage) {
        if (strictChecksEnabled())
            throw new IllegalArgumentException(errMessage);
        else
            System.err.println("WARNING:" + errMessage);
    }

    /**
     * @return {@code true} if the specified handler was not already registered
     * @throws IllegalArgumentException if the specified handler was already registered via classpath and property
     *                                  "-Dorg.kordamp.ikonli.strict" is set to {@code true}
     */
    public boolean registerHandler(IkonHandler handler) {
        // check whether handler for this font is already loaded via classpath
        String fontFamily = handler.getFontFamily();
        if (isLoadedViaClasspath(handler)) {
            throwOrWarn(String.format("IkonHandler for %s is already loaded via classpath", fontFamily));
            return false;
        }
        return customHandlers.add(handler);
    }

    /**
     * @return {@code true} if the specified handler was removed from the set of handlers
     * @throws IllegalArgumentException if the specified handler was registered via classpath and property
     *                                  "-Dorg.kordamp.ikonli.strict" is set to {@code true}
     */
    public boolean unregisterHandler(IkonHandler handler) {
        // check whether handler for this font is loaded via classpath
        String fontFamily = handler.getFontFamily();
        if (isLoadedViaClasspath(handler)) {
            throwOrWarn(String.format("IkonHandler for %s was loaded via classpath and can't be unregistered", fontFamily));
            return false;
        }
        return customHandlers.remove(handler);
    }

    public static IkonResolver getInstance() {
        return INSTANCE;
    }

    public IkonHandler resolveIkonHandler(String value) {
        requireNonNull(value, "Ikon description must not be null");
        for (Set<IkonHandler> handlers : Arrays.asList(HANDLERS, customHandlers))
            for (IkonHandler handler : handlers) {
                if (handler.supports(value)) {
                    return handler;
                }
            }
        throw new UnsupportedOperationException("Cannot resolve '" + value + "'");
    }
}
