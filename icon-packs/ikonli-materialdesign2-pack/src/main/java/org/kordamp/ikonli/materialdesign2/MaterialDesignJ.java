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
package org.kordamp.ikonli.materialdesign2;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum MaterialDesignJ implements Ikon {
    JABBER("mdi2j-jabber", "F0DD5"),
    JEEPNEY("mdi2j-jeepney", "F0302"),
    JELLYFISH("mdi2j-jellyfish", "F0F01"),
    JELLYFISH_OUTLINE("mdi2j-jellyfish-outline", "F0F02"),
    JIRA("mdi2j-jira", "F0303"),
    JQUERY("mdi2j-jquery", "F087D"),
    JSFIDDLE("mdi2j-jsfiddle", "F0304"),
    JUDAISM("mdi2j-judaism", "F097A"),
    JUMP_ROPE("mdi2j-jump-rope", "F12FF");

    public static MaterialDesignJ findByDescription(String description) {
        for (MaterialDesignJ font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

    MaterialDesignJ(String description, String code) {
        this.description = description;
        this.code = Integer.parseInt(code, 16);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCode() {
        return code;
    }
}
