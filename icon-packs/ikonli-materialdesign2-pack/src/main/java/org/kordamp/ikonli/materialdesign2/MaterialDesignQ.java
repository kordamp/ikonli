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
public enum MaterialDesignQ implements Ikon {
    QI("mdi2q-qi", "F0999"),
    QQCHAT("mdi2q-qqchat", "F0605"),
    QRCODE("mdi2q-qrcode", "F0432"),
    QRCODE_EDIT("mdi2q-qrcode-edit", "F08B8"),
    QRCODE_MINUS("mdi2q-qrcode-minus", "F118C"),
    QRCODE_PLUS("mdi2q-qrcode-plus", "F118B"),
    QRCODE_REMOVE("mdi2q-qrcode-remove", "F118D"),
    QRCODE_SCAN("mdi2q-qrcode-scan", "F0433"),
    QUADCOPTER("mdi2q-quadcopter", "F0434"),
    QUALITY_HIGH("mdi2q-quality-high", "F0435"),
    QUALITY_LOW("mdi2q-quality-low", "F0A0C"),
    QUALITY_MEDIUM("mdi2q-quality-medium", "F0A0D"),
    QUEUE_FIRST_IN_LAST_OUT("mdi2q-queue-first-in-last-out", "F1CAF"),
    QUORA("mdi2q-quora", "F0D29");

    public static MaterialDesignQ findByDescription(String description) {
        for (MaterialDesignQ font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private final String description;
    private final int code;

    MaterialDesignQ(String description, String code) {
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