/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2025 Andres Almiray
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
