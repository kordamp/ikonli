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
package org.kordamp.ikonli.bytedance;

import org.kordamp.ikonli.AbstractIkonHandler;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;
import org.kordamp.jipsy.annotations.ServiceProviderFor;

import java.io.InputStream;
import java.net.URL;

/**
 * @author LeeWyatt
 */
@ServiceProviderFor(IkonHandler.class)
public class BytedanceIconsExtraBoldMZIkonHandler extends AbstractIkonHandler {
    private static final String FONT_RESOURCE = "/META-INF/resources/bytedance/1.3.0/fonts/Bytedance-IconPack-ExtraBold.ttf";

    @Override
    public boolean supports(String description) {
        return description != null && description.startsWith("bd4-");
    }

    @Override
    public Ikon resolve(String description) {
        return BytedanceIconsExtraBoldMZ.findByDescription(description);
    }

    @Override
    public URL getFontResource() {
        return getClass().getResource(FONT_RESOURCE);
    }

    @Override
    public InputStream getFontResourceAsStream() {
        return getClass().getResourceAsStream(FONT_RESOURCE);
    }

    @Override
    public String getFontFamily() {
        return "Bytedance-IconPack-ExtraBold";
    }
}