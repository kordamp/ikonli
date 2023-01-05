/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2023 Andres Almiray
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
import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class AbstractIkonResolver {
    private static final String ORG_KORDAMP_IKONLI_STRICT = "org.kordamp.ikonli.strict";
    private final static Logger LOGGER = Logger.getLogger(AbstractIkonResolver.class.getName());

    protected boolean registerHandler(IkonHandler handler, Set<IkonHandler> handlers, Set<IkonHandler> customHandlers) {
        // check whether handler for this font is already loaded via classpath
        if (isLoadedViaClasspath(handler, handlers)) {
            throwOrWarn(String.format("IkonHandler for %s is already loaded via classpath", handler.getFontFamily()));
            return false;
        }
        return customHandlers.add(handler);
    }

    protected boolean unregisterHandler(IkonHandler handler, Set<IkonHandler> handlers, Set<IkonHandler> customHandlers) {
        // check whether handler for this font is loaded via classpath
        if (isLoadedViaClasspath(handler, handlers)) {
            throwOrWarn(String.format("IkonHandler for %s was loaded via classpath and can't be unregistered", handler.getFontFamily()));
            return false;
        }
        return customHandlers.remove(handler);
    }

    protected IkonHandler resolve(String value, Set<IkonHandler> handlers, Set<IkonHandler> customHandlers) {
        requireNonNull(value, "Ikon description must not be null");
        for (Set<IkonHandler> hs : Arrays.asList(handlers, customHandlers)) {
            for (IkonHandler handler : hs) {
                if (handler.supports(value)) {
                    return handler;
                }
            }
        }
        throw new UnsupportedOperationException("Cannot resolve '" + value + "'");
    }

    private boolean isLoadedViaClasspath(IkonHandler handler, Set<IkonHandler> handlers) {
        String fontFamily = handler.getFontFamily();
        for (IkonHandler classpathHandler : handlers) {
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

    public static ServiceLoader<IkonHandler> resolveServiceLoader() {
        // Check if handlers must be loaded from a ModuleLayer
        if (null != IkonHandler.class.getModule().getLayer()) {
            ServiceLoader<IkonHandler> handlers = ServiceLoader.load(IkonHandler.class.getModule().getLayer(), IkonHandler.class);
            if (handlers.stream().count() > 0) {
                return handlers;
            }
        }

        // Check if the IkonHandler.class.classLoader works
        ServiceLoader<IkonHandler> handlers = ServiceLoader.load(IkonHandler.class, IkonHandler.class.getClassLoader());
        if (handlers.stream().count() > 0) {
            return handlers;
        }

        // If *nothing* else works
        return ServiceLoader.load(IkonHandler.class);
    }
}
