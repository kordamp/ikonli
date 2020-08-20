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
package org.kordamp.ikonli;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class AbstractIkonResolver {
    protected static final Set<IkonHandler> HANDLERS = new LinkedHashSet<>();
    protected static final Set<IkonHandler> CUSTOM_HANDLERS = new LinkedHashSet<>();
    private static final String ORG_KORDAMP_IKONLI_STRICT = "org.kordamp.ikonli.strict";
    private final static Logger LOGGER = Logger.getLogger(AbstractIkonResolver.class.getName());

    /**
     * @return {@code true} if the specified handler was not already registered
     * @throws IllegalArgumentException if the specified handler was already registered via classpath and property
     *                                  "-Dorg.kordamp.ikonli.strict" is set to {@code true} or {@code null}.
     */
    public boolean registerHandler(IkonHandler handler) {
        // check whether handler for this font is already loaded via classpath
        if (isLoadedViaClasspath(handler)) {
            throwOrWarn(String.format("IkonHandler for %s is already loaded via classpath", handler.getFontFamily()));
            return false;
        }
        return CUSTOM_HANDLERS.add(handler);
    }

    /**
     * @return {@code true} if the specified handler was removed from the set of handlers
     * @throws IllegalArgumentException if the specified handler was registered via classpath and property
     *                                  "-Dorg.kordamp.ikonli.strict" is set to {@code true} or {@code null}.
     */
    public boolean unregisterHandler(IkonHandler handler) {
        // check whether handler for this font is loaded via classpath
        if (isLoadedViaClasspath(handler)) {
            throwOrWarn(String.format("IkonHandler for %s was loaded via classpath and can't be unregistered", handler.getFontFamily()));
            return false;
        }
        return CUSTOM_HANDLERS.remove(handler);
    }

    public IkonHandler resolve(String value) {
        requireNonNull(value, "Ikon description must not be null");
        for (Set<IkonHandler> handlers : Arrays.asList(HANDLERS, CUSTOM_HANDLERS)) {
            for (IkonHandler handler : handlers) {
                if (handler.supports(value)) {
                    return handler;
                }
            }
        }
        throw new UnsupportedOperationException("Cannot resolve '" + value + "'");
    }

    private boolean isLoadedViaClasspath(IkonHandler handler) {
        String fontFamily = handler.getFontFamily();
        for (IkonHandler classpathHandler : HANDLERS) {
            if (classpathHandler.getFontFamily().equals(fontFamily)) {
                return true;
            }
        }
        return false;
    }

    private void throwOrWarn(String message) {
        if (strictChecksEnabled()) {
            throw new IllegalArgumentException(message);
        } else {
            LOGGER.warning(message);
        }
    }

    private boolean strictChecksEnabled() {
        return System.getProperty(ORG_KORDAMP_IKONLI_STRICT) == null || Boolean.getBoolean(ORG_KORDAMP_IKONLI_STRICT);
    }
}
