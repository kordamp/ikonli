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
package org.kordamp.ikonli.fontawesome5;

import org.kordamp.ikonli.AbstractIkonHandler;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;
import org.kordamp.jipsy.ServiceProviderFor;

/**
 * @author Andres Almiray
 */
@ServiceProviderFor(IkonHandler.class)
public class FontAwesomeSolidIkonHandler extends AbstractIkonHandler {
    @Override
    public boolean supports(String description) {
        return description != null && description.startsWith("fas-");
    }

    @Override
    public Ikon resolve(String description) {
        return FontAwesomeSolid.findByDescription(description);
    }

    @Override
    public String getFontResourcePath() {
        return "META-INF/resources/fontawesome5/5.8.1/fonts/fa-solid-900.ttf";
    }

    @Override
    public String getFontFamily() {
        return "Font Awesome 5 Free Solid";
    }
}
