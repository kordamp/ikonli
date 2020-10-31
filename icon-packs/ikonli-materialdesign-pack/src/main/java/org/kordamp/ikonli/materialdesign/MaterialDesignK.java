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

package org.kordamp.ikonli.materialdesign;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum MaterialDesignK implements Ikon {
    KABADDI("mdik-kabaddi", "F0D87"),
    KANGAROO("mdik-kangaroo", "F1558"),
    KARATE("mdik-karate", "F082C"),
    KEG("mdik-keg", "F0305"),
    KETTLE("mdik-kettle", "F05FA"),
    KETTLE_ALERT("mdik-kettle-alert", "F1317"),
    KETTLE_ALERT_OUTLINE("mdik-kettle-alert-outline", "F1318"),
    KETTLE_OFF("mdik-kettle-off", "F131B"),
    KETTLE_OFF_OUTLINE("mdik-kettle-off-outline", "F131C"),
    KETTLE_OUTLINE("mdik-kettle-outline", "F0F56"),
    KETTLE_STEAM("mdik-kettle-steam", "F1319"),
    KETTLE_STEAM_OUTLINE("mdik-kettle-steam-outline", "F131A"),
    KETTLEBELL("mdik-kettlebell", "F1300"),
    KEY("mdik-key", "F0306"),
    KEY_ARROW_RIGHT("mdik-key-arrow-right", "F1312"),
    KEY_CHAIN("mdik-key-chain", "F1574"),
    KEY_CHAIN_VARIANT("mdik-key-chain-variant", "F1575"),
    KEY_CHANGE("mdik-key-change", "F0307"),
    KEY_LINK("mdik-key-link", "F119F"),
    KEY_MINUS("mdik-key-minus", "F0308"),
    KEY_OUTLINE("mdik-key-outline", "F0DD6"),
    KEY_PLUS("mdik-key-plus", "F0309"),
    KEY_REMOVE("mdik-key-remove", "F030A"),
    KEY_STAR("mdik-key-star", "F119E"),
    KEY_VARIANT("mdik-key-variant", "F030B"),
    KEY_WIRELESS("mdik-key-wireless", "F0FC2"),
    KEYBOARD("mdik-keyboard", "F030C"),
    KEYBOARD_BACKSPACE("mdik-keyboard-backspace", "F030D"),
    KEYBOARD_CAPS("mdik-keyboard-caps", "F030E"),
    KEYBOARD_CLOSE("mdik-keyboard-close", "F030F"),
    KEYBOARD_ESC("mdik-keyboard-esc", "F12B7"),
    KEYBOARD_F1("mdik-keyboard-f1", "F12AB"),
    KEYBOARD_F10("mdik-keyboard-f10", "F12B4"),
    KEYBOARD_F11("mdik-keyboard-f11", "F12B5"),
    KEYBOARD_F12("mdik-keyboard-f12", "F12B6"),
    KEYBOARD_F2("mdik-keyboard-f2", "F12AC"),
    KEYBOARD_F3("mdik-keyboard-f3", "F12AD"),
    KEYBOARD_F4("mdik-keyboard-f4", "F12AE"),
    KEYBOARD_F5("mdik-keyboard-f5", "F12AF"),
    KEYBOARD_F6("mdik-keyboard-f6", "F12B0"),
    KEYBOARD_F7("mdik-keyboard-f7", "F12B1"),
    KEYBOARD_F8("mdik-keyboard-f8", "F12B2"),
    KEYBOARD_F9("mdik-keyboard-f9", "F12B3"),
    KEYBOARD_OFF("mdik-keyboard-off", "F0310"),
    KEYBOARD_OFF_OUTLINE("mdik-keyboard-off-outline", "F0E4B"),
    KEYBOARD_OUTLINE("mdik-keyboard-outline", "F097B"),
    KEYBOARD_RETURN("mdik-keyboard-return", "F0311"),
    KEYBOARD_SETTINGS("mdik-keyboard-settings", "F09F9"),
    KEYBOARD_SETTINGS_OUTLINE("mdik-keyboard-settings-outline", "F09FA"),
    KEYBOARD_SPACE("mdik-keyboard-space", "F1050"),
    KEYBOARD_TAB("mdik-keyboard-tab", "F0312"),
    KEYBOARD_VARIANT("mdik-keyboard-variant", "F0313"),
    KHANDA("mdik-khanda", "F10FD"),
    KICKSTARTER("mdik-kickstarter", "F0745"),
    KLINGON("mdik-klingon", "F135B"),
    KNIFE("mdik-knife", "F09FB"),
    KNIFE_MILITARY("mdik-knife-military", "F09FC"),
    KODI("mdik-kodi", "F0314"),
    KUBERNETES("mdik-kubernetes", "F10FE");

    public static MaterialDesignK findByDescription(String description) {
        for (MaterialDesignK font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

    MaterialDesignK(String description, String code) {
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
