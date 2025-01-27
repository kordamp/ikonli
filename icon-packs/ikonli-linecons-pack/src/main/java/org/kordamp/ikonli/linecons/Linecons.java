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
package org.kordamp.ikonli.linecons;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum Linecons implements Ikon {
    BANKNOTE("li-banknote", '\ue020'),
    BUBBLE("li-bubble", '\ue014'),
    BULB("li-bulb", '\ue00e'),
    CALENDAR("li-calendar", '\ue02b'),
    CAMERA("li-camera", '\ue00b'),
    CLIP("li-clip", '\ue029'),
    CLOCK("li-clock", '\ue01d'),
    CLOUD("li-cloud", '\ue001'),
    CUP("li-cup", '\ue016'),
    DATA("li-data", '\ue021'),
    DIAMOND("li-diamond", '\ue010'),
    DISPLAY("li-display", '\ue011'),
    EYE("li-eye", '\ue013'),
    FIRE("li-fire", '\ue028'),
    FOOD("li-food", '\ue026'),
    HEART("li-heart", '\ue000'),
    KEY("li-key", '\ue008'),
    LAB("li-lab", '\ue025'),
    LIKE("li-like", '\ue01a'),
    LOCATION("li-location", '\ue012'),
    LOCK("li-lock", '\ue00d'),
    MAIL("li-mail", '\ue019'),
    MEGAPHONE("li-megaphone", '\ue023'),
    MUSIC("li-music", '\ue022'),
    NEWS("li-news", '\ue018'),
    NOTE("li-note", '\ue01c'),
    PAPERPLANE("li-paperplane", '\ue01e'),
    PARAMS("li-params", '\ue01f'),
    PEN("li-pen", '\ue00f'),
    PHONE("li-phone", '\ue017'),
    PHOTO("li-photo", '\ue01b'),
    SEARCH("li-search", '\ue009'),
    SETTINGS("li-settings", '\ue00a'),
    SHOP("li-shop", '\ue02a'),
    SOUND("li-sound", '\ue004'),
    STACK("li-stack", '\ue015'),
    STAR("li-star", '\ue002'),
    STUDY("li-study", '\ue024'),
    T_SHIRT("li-t-shirt", '\ue027'),
    TAG("li-tag", '\ue00c'),
    TRASH("li-trash", '\ue006'),
    TRUCK("li-truck", '\ue02e'),
    TV("li-tv", '\ue003'),
    USER("li-user", '\ue007'),
    VALLET("li-vallet", '\ue02c'),
    VIDEO("li-video", '\ue005'),
    VYNIL("li-vynil", '\ue02d'),
    WORLD("li-world", '\ue02f');

    private String description;
    private int code;

    Linecons(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public static Linecons findByDescription(String description) {
        for (Linecons font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
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