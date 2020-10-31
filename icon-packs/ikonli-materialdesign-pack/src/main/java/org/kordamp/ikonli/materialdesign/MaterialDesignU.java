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
public enum MaterialDesignU implements Ikon {
    UBISOFT("mdiu-ubisoft", "F0BDA"),
    UBUNTU("mdiu-ubuntu", "F0548"),
    UFO("mdiu-ufo", "F10C4"),
    UFO_OUTLINE("mdiu-ufo-outline", "F10C5"),
    ULTRA_HIGH_DEFINITION("mdiu-ultra-high-definition", "F07F9"),
    UMBRACO("mdiu-umbraco", "F0549"),
    UMBRELLA("mdiu-umbrella", "F054A"),
    UMBRELLA_CLOSED("mdiu-umbrella-closed", "F09B0"),
    UMBRELLA_CLOSED_OUTLINE("mdiu-umbrella-closed-outline", "F13E2"),
    UMBRELLA_CLOSED_VARIANT("mdiu-umbrella-closed-variant", "F13E1"),
    UMBRELLA_OUTLINE("mdiu-umbrella-outline", "F054B"),
    UNDO("mdiu-undo", "F054C"),
    UNDO_VARIANT("mdiu-undo-variant", "F054D"),
    UNFOLD_LESS_HORIZONTAL("mdiu-unfold-less-horizontal", "F054E"),
    UNFOLD_LESS_VERTICAL("mdiu-unfold-less-vertical", "F0760"),
    UNFOLD_MORE_HORIZONTAL("mdiu-unfold-more-horizontal", "F054F"),
    UNFOLD_MORE_VERTICAL("mdiu-unfold-more-vertical", "F0761"),
    UNGROUP("mdiu-ungroup", "F0550"),
    UNICODE("mdiu-unicode", "F0ED0"),
    UNICORN("mdiu-unicorn", "F15C2"),
    UNICORN_VARIANT("mdiu-unicorn-variant", "F15C3"),
    UNICYCLE("mdiu-unicycle", "F15E5"),
    UNITY("mdiu-unity", "F06AF"),
    UNREAL("mdiu-unreal", "F09B1"),
    UNTAPPD("mdiu-untappd", "F0551"),
    UPDATE("mdiu-update", "F06B0"),
    UPLOAD("mdiu-upload", "F0552"),
    UPLOAD_LOCK("mdiu-upload-lock", "F1373"),
    UPLOAD_LOCK_OUTLINE("mdiu-upload-lock-outline", "F1374"),
    UPLOAD_MULTIPLE("mdiu-upload-multiple", "F083D"),
    UPLOAD_NETWORK("mdiu-upload-network", "F06F6"),
    UPLOAD_NETWORK_OUTLINE("mdiu-upload-network-outline", "F0CD8"),
    UPLOAD_OFF("mdiu-upload-off", "F10C6"),
    UPLOAD_OFF_OUTLINE("mdiu-upload-off-outline", "F10C7"),
    UPLOAD_OUTLINE("mdiu-upload-outline", "F0E07"),
    USB("mdiu-usb", "F0553"),
    USB_FLASH_DRIVE("mdiu-usb-flash-drive", "F129E"),
    USB_FLASH_DRIVE_OUTLINE("mdiu-usb-flash-drive-outline", "F129F"),
    USB_PORT("mdiu-usb-port", "F11F0");

    public static MaterialDesignU findByDescription(String description) {
        for (MaterialDesignU font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

    MaterialDesignU(String description, String code) {
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
