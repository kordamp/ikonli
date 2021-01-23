/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2021 Andres Almiray
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
package org.kordamp.ikonli.ionicons4;

import org.kordamp.ikonli.AbstractIkonHandler;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;
import org.kordamp.jipsy.ServiceProviderFor;

import java.io.InputStream;
import java.net.URL;

/**
 * @author Loïc Sculier aka typhon0
 */
@ServiceProviderFor(IkonHandler.class)
public class Ionicons4IOSIkonHandler extends AbstractIkonHandler {
    private static final String FONT_RESOURCE = "/META-INF/resources/ionicons4/4.1.2/fonts/ionicons.ttf";

    @Override
    public boolean supports(String description) {
        return description != null && description.startsWith("ion4-ios-");
    }

    @Override
    public Ikon resolve(String description) {
        return Ionicons4IOS.findByDescription(description);
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
        return "Ionicons4";
    }
}