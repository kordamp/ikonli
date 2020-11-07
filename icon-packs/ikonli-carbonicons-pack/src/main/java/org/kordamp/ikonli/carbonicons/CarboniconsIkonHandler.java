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
package org.kordamp.ikonli.carbonicons;

/**
 * @author Andres Almiray
 */
@org.kordamp.jipsy.ServiceProviderFor(org.kordamp.ikonli.IkonHandler.class)
public class CarboniconsIkonHandler extends org.kordamp.ikonli.AbstractIkonHandler {
    @Override
    public boolean supports(String description) {
        return description != null && description.startsWith("ci-");
    }

    @Override
    public org.kordamp.ikonli.Ikon resolve(String description) {
        return CarbonIcons.findByDescription(description);
    }

    @Override
    public String getFontResourcePath() {
        return "META-INF/resources/carbonicons/10.23.2/fonts/Carbon-Icons.ttf";
    }

    @Override
    public String getFontFamily() {
        return "Carbon-Icons";
    }
}