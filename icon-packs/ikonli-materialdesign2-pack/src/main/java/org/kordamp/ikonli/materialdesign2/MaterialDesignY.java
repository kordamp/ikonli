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
public enum MaterialDesignY implements Ikon {
    YAHOO("mdi2y-yahoo", "F0B4F"),
    YEAST("mdi2y-yeast", "F05C1"),
    YIN_YANG("mdi2y-yin-yang", "F0680"),
    YOGA("mdi2y-yoga", "F117C"),
    YOUTUBE("mdi2y-youtube", "F05C3"),
    YOUTUBE_GAMING("mdi2y-youtube-gaming", "F0848"),
    YOUTUBE_STUDIO("mdi2y-youtube-studio", "F0847"),
    YOUTUBE_SUBSCRIPTION("mdi2y-youtube-subscription", "F0D40"),
    YOUTUBE_TV("mdi2y-youtube-tv", "F0448"),
    YURT("mdi2y-yurt", "F1516");

    public static MaterialDesignY findByDescription(String description) {
        for (MaterialDesignY font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private final String description;
    private final int code;

    MaterialDesignY(String description, String code) {
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