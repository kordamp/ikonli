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
package org.kordamp.ikonli.javafx;

import javafx.scene.text.Font;
import org.kordamp.ikonli.FontLoader;
import org.kordamp.ikonli.IkonHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@org.osgi.service.component.annotations.Component(service = FontLoader.class)
public class JavaFXFontLoader implements FontLoader {
    private static final Map<String, Font> FONTS = new ConcurrentHashMap<>();

    @Override
    public void loadFont(IkonHandler handler) {
        String fontResource = handler.getFontResource().toExternalForm();
        Font font = FONTS.computeIfAbsent(fontResource, key -> Font.loadFont(key, 16));
        handler.setFont(font);
    }

    public static FontLoader getInstance() {
        return new JavaFXFontLoader();
    }
}
