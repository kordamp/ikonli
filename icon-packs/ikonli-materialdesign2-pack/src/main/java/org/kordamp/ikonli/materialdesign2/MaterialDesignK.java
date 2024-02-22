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
package org.kordamp.ikonli.materialdesign2;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum MaterialDesignK implements Ikon {
    KABADDI("mdi2k-kabaddi", "F0D87"),
    KANGAROO("mdi2k-kangaroo", "F1558"),
    KARATE("mdi2k-karate", "F082C"),
    KEG("mdi2k-keg", "F0305"),
    KETTLE("mdi2k-kettle", "F05FA"),
    KETTLE_ALERT("mdi2k-kettle-alert", "F1317"),
    KETTLE_ALERT_OUTLINE("mdi2k-kettle-alert-outline", "F1318"),
    KETTLE_OFF("mdi2k-kettle-off", "F131B"),
    KETTLE_OFF_OUTLINE("mdi2k-kettle-off-outline", "F131C"),
    KETTLE_OUTLINE("mdi2k-kettle-outline", "F0F56"),
    KETTLE_STEAM("mdi2k-kettle-steam", "F1319"),
    KETTLE_STEAM_OUTLINE("mdi2k-kettle-steam-outline", "F131A"),
    KETTLEBELL("mdi2k-kettlebell", "F1300"),
    KEY("mdi2k-key", "F0306"),
    KEY_ARROW_RIGHT("mdi2k-key-arrow-right", "F1312"),
    KEY_CHAIN("mdi2k-key-chain", "F1574"),
    KEY_CHAIN_VARIANT("mdi2k-key-chain-variant", "F1575"),
    KEY_CHANGE("mdi2k-key-change", "F0307"),
    KEY_LINK("mdi2k-key-link", "F119F"),
    KEY_MINUS("mdi2k-key-minus", "F0308"),
    KEY_OUTLINE("mdi2k-key-outline", "F0DD6"),
    KEY_PLUS("mdi2k-key-plus", "F0309"),
    KEY_REMOVE("mdi2k-key-remove", "F030A"),
    KEY_STAR("mdi2k-key-star", "F119E"),
    KEY_VARIANT("mdi2k-key-variant", "F030B"),
    KEY_WIRELESS("mdi2k-key-wireless", "F0FC2"),
    KEYBOARD("mdi2k-keyboard", "F030C"),
    KEYBOARD_BACKSPACE("mdi2k-keyboard-backspace", "F030D"),
    KEYBOARD_CAPS("mdi2k-keyboard-caps", "F030E"),
    KEYBOARD_CLOSE("mdi2k-keyboard-close", "F030F"),
    KEYBOARD_ESC("mdi2k-keyboard-esc", "F12B7"),
    KEYBOARD_F1("mdi2k-keyboard-f1", "F12AB"),
    KEYBOARD_F10("mdi2k-keyboard-f10", "F12B4"),
    KEYBOARD_F11("mdi2k-keyboard-f11", "F12B5"),
    KEYBOARD_F12("mdi2k-keyboard-f12", "F12B6"),
    KEYBOARD_F2("mdi2k-keyboard-f2", "F12AC"),
    KEYBOARD_F3("mdi2k-keyboard-f3", "F12AD"),
    KEYBOARD_F4("mdi2k-keyboard-f4", "F12AE"),
    KEYBOARD_F5("mdi2k-keyboard-f5", "F12AF"),
    KEYBOARD_F6("mdi2k-keyboard-f6", "F12B0"),
    KEYBOARD_F7("mdi2k-keyboard-f7", "F12B1"),
    KEYBOARD_F8("mdi2k-keyboard-f8", "F12B2"),
    KEYBOARD_F9("mdi2k-keyboard-f9", "F12B3"),
    KEYBOARD_OFF("mdi2k-keyboard-off", "F0310"),
    KEYBOARD_OFF_OUTLINE("mdi2k-keyboard-off-outline", "F0E4B"),
    KEYBOARD_OUTLINE("mdi2k-keyboard-outline", "F097B"),
    KEYBOARD_RETURN("mdi2k-keyboard-return", "F0311"),
    KEYBOARD_SETTINGS("mdi2k-keyboard-settings", "F09F9"),
    KEYBOARD_SETTINGS_OUTLINE("mdi2k-keyboard-settings-outline", "F09FA"),
    KEYBOARD_SPACE("mdi2k-keyboard-space", "F1050"),
    KEYBOARD_TAB("mdi2k-keyboard-tab", "F0312"),
    KEYBOARD_VARIANT("mdi2k-keyboard-variant", "F0313"),
    KHANDA("mdi2k-khanda", "F10FD"),
    KICKSTARTER("mdi2k-kickstarter", "F0745"),
    KLINGON("mdi2k-klingon", "F135B"),
    KNIFE("mdi2k-knife", "F09FB"),
    KNIFE_MILITARY("mdi2k-knife-military", "F09FC"),
    KODI("mdi2k-kodi", "F0314"),
    KUBERNETES("mdi2k-kubernetes", "F10FE");

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
