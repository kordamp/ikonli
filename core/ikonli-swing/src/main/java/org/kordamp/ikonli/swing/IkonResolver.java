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
package org.kordamp.ikonli.swing;

import org.kordamp.ikonli.AbstractIkonResolver;
import org.kordamp.ikonli.IkonHandler;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * @author Andres Almiray
 */
public class IkonResolver extends AbstractIkonResolver {
    private static final IkonResolver INSTANCE;
    private static final Set<IkonHandler> HANDLERS = new LinkedHashSet<>();
    private static final Set<IkonHandler> CUSTOM_HANDLERS = new LinkedHashSet<>();

    static {
        INSTANCE = new IkonResolver();

        ServiceLoader<IkonHandler> loader = resolveServiceLoader();
        for (IkonHandler handler : loader) {
            HANDLERS.add(handler);

            try {
                InputStream stream = handler.getFontResourceAsStream();
                Font font = Font.createFont(Font.TRUETYPE_FONT, stream);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
                stream.close();
                handler.setFont(font);
            } catch (FontFormatException | IOException ffe) {
                throw new IllegalStateException(ffe);
            }
        }
    }

    private IkonResolver() {

    }

    /**
     * @return {@code true} if the specified handler was not already registered
     * @throws IllegalArgumentException if the specified handler was already registered via classpath and property
     *                                  "-Dorg.kordamp.ikonli.strict" is set to {@code true} or {@code null}.
     */
    public boolean registerHandler(IkonHandler handler) {
        return registerHandler(handler, HANDLERS, CUSTOM_HANDLERS);
    }

    /**
     * @return {@code true} if the specified handler was removed from the set of handlers
     * @throws IllegalArgumentException if the specified handler was registered via classpath and property
     *                                  "-Dorg.kordamp.ikonli.strict" is set to {@code true} or {@code null}.
     */
    public boolean unregisterHandler(IkonHandler handler) {
        return unregisterHandler(handler, HANDLERS, CUSTOM_HANDLERS);
    }

    public IkonHandler resolve(String value) {
        return resolve(value, HANDLERS, CUSTOM_HANDLERS);
    }

    public static IkonResolver getInstance() {
        return INSTANCE;
    }
}
