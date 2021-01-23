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
package org.kordamp.ikonli.materialdesign2;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum MaterialDesignZ implements Ikon {
    Z_WAVE("mdi2z-z-wave", "F0AEA"),
    ZEND("mdi2z-zend", "F0AEB"),
    ZIGBEE("mdi2z-zigbee", "F0D41"),
    ZIP_BOX("mdi2z-zip-box", "F05C4"),
    ZIP_BOX_OUTLINE("mdi2z-zip-box-outline", "F0FFA"),
    ZIP_DISK("mdi2z-zip-disk", "F0A23"),
    ZODIAC_AQUARIUS("mdi2z-zodiac-aquarius", "F0A7D"),
    ZODIAC_ARIES("mdi2z-zodiac-aries", "F0A7E"),
    ZODIAC_CANCER("mdi2z-zodiac-cancer", "F0A7F"),
    ZODIAC_CAPRICORN("mdi2z-zodiac-capricorn", "F0A80"),
    ZODIAC_GEMINI("mdi2z-zodiac-gemini", "F0A81"),
    ZODIAC_LEO("mdi2z-zodiac-leo", "F0A82"),
    ZODIAC_LIBRA("mdi2z-zodiac-libra", "F0A83"),
    ZODIAC_PISCES("mdi2z-zodiac-pisces", "F0A84"),
    ZODIAC_SAGITTARIUS("mdi2z-zodiac-sagittarius", "F0A85"),
    ZODIAC_SCORPIO("mdi2z-zodiac-scorpio", "F0A86"),
    ZODIAC_TAURUS("mdi2z-zodiac-taurus", "F0A87"),
    ZODIAC_VIRGO("mdi2z-zodiac-virgo", "F0A88");

    public static MaterialDesignZ findByDescription(String description) {
        for (MaterialDesignZ font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

    MaterialDesignZ(String description, String code) {
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
