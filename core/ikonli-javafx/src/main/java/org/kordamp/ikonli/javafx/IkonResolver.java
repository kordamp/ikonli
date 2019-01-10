/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2019 Andres Almiray
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

    public static IkonResolver getInstance() {
        return INSTANCE;
    }

    public IkonHandler resolveIkonHandler(String value) {
        requireNonNull(value, "Ikon description must not be null");
        for (IkonHandler handler : HANDLERS) {
            if (handler.supports(value)) {
                return handler;
            }
        }
        throw new UnsupportedOperationException("Cannot resolve '" + value + "'");
    }
}
