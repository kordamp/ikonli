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
public enum MaterialDesignQ implements Ikon {
    QI("mdiq-qi", "F0999"),
    QQCHAT("mdiq-qqchat", "F0605"),
    QRCODE("mdiq-qrcode", "F0432"),
    QRCODE_EDIT("mdiq-qrcode-edit", "F08B8"),
    QRCODE_MINUS("mdiq-qrcode-minus", "F118C"),
    QRCODE_PLUS("mdiq-qrcode-plus", "F118B"),
    QRCODE_REMOVE("mdiq-qrcode-remove", "F118D"),
    QRCODE_SCAN("mdiq-qrcode-scan", "F0433"),
    QUADCOPTER("mdiq-quadcopter", "F0434"),
    QUALITY_HIGH("mdiq-quality-high", "F0435"),
    QUALITY_LOW("mdiq-quality-low", "F0A0C"),
    QUALITY_MEDIUM("mdiq-quality-medium", "F0A0D"),
    QUORA("mdiq-quora", "F0D29");

    public static MaterialDesignQ findByDescription(String description) {
        for (MaterialDesignQ font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

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
