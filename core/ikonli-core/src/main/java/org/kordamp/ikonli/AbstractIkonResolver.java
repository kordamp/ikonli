/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2024 Andres Almiray
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

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/**
 * @author Andres Almiray
 */
public class AbstractIkonResolver implements IkonResolver {
    private static final String ORG_KORDAMP_IKONLI_STRICT = "org.kordamp.ikonli.strict";
    private final static Logger LOGGER = Logger.getLogger(AbstractIkonResolver.class.getName());

    protected final Set<IkonHandler> handlers = new CopyOnWriteArraySet<>();
    protected final Set<IkonHandler> customHandlers = new CopyOnWriteArraySet<>();

    @Override
    public boolean registerHandler(IkonHandler handler) {
    	requireNonNull(handler, "Handler must not be null");
        if (isHandlerLoadedViaClasspath(handler)) {
            throwOrWarn(String.format("IkonHandler for %s is already loaded via classpath", handler.getFontFamily()));
            return false;
        }
        return customHandlers.add(handler);
    }

    @Override
    public boolean unregisterHandler(IkonHandler handler) {
    	requireNonNull(handler, "Handler must not be null");
        if (isHandlerLoadedViaClasspath(handler)) {
            throwOrWarn(String.format("IkonHandler for %s was loaded via classpath and can't be unregistered", handler.getFontFamily()));
            return false;
        }
        return customHandlers.remove(handler);
    }

    @Override
    public IkonHandler resolve(String value) {
        requireNonNull(value, "Ikon description must not be null");
        return findHandler(value)
            .orElseThrow(() -> new UnsupportedOperationException("Cannot resolve '" + value + "'"));
    }

    protected java.util.Optional<IkonHandler> findHandler(String value) {
        return Arrays.asList(handlers, customHandlers).stream()
            .flatMap(Set::stream)
            .filter(handler -> handler.supports(value))
            .findFirst();
    }

    private boolean isHandlerLoadedViaClasspath(IkonHandler handler) {
        return handlers.stream()
            .anyMatch(h -> h.getFontFamily().equals(handler.getFontFamily()));
    }

    private void throwOrWarn(String message) {
        if (Boolean.getBoolean(ORG_KORDAMP_IKONLI_STRICT)) {
            throw new IllegalArgumentException(message);
        }
        LOGGER.warning(message);
    }

    public static ServiceLoader<IkonHandler> resolveServiceLoader() {
        // Check if handlers must be loaded from a ModuleLayer
    	if (IkonHandler.class.getModule().getLayer() != null) {
            ServiceLoader<IkonHandler> ikonHandlerServiceLoaders = ServiceLoader.load(
                IkonHandler.class.getModule().getLayer(), 
                IkonHandler.class
            );
            if (ikonHandlerServiceLoaders.findFirst().isPresent()) {
                return ikonHandlerServiceLoaders;
            }
        }

    	ServiceLoader<IkonHandler> handlers = ServiceLoader.load(
                IkonHandler.class, 
                IkonHandler.class.getClassLoader()
            );
    	// Return if the IkonHandler.class.classLoader works or if *nothing* else works
        return handlers.findFirst().isPresent() ? handlers : ServiceLoader.load(IkonHandler.class);
    }
}
