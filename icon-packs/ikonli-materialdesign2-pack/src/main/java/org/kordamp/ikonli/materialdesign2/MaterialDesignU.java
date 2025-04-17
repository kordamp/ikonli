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
public enum MaterialDesignU implements Ikon {
    UBISOFT("mdi2u-ubisoft", "F0BDA"),
    UBUNTU("mdi2u-ubuntu", "F0548"),
    UFO("mdi2u-ufo", "F10C4"),
    UFO_OUTLINE("mdi2u-ufo-outline", "F10C5"),
    ULTRA_HIGH_DEFINITION("mdi2u-ultra-high-definition", "F07F9"),
    UMBRACO("mdi2u-umbraco", "F0549"),
    UMBRELLA("mdi2u-umbrella", "F054A"),
    UMBRELLA_BEACH("mdi2u-umbrella-beach", "F188A"),
    UMBRELLA_BEACH_OUTLINE("mdi2u-umbrella-beach-outline", "F188B"),
    UMBRELLA_CLOSED("mdi2u-umbrella-closed", "F09B0"),
    UMBRELLA_CLOSED_OUTLINE("mdi2u-umbrella-closed-outline", "F13E2"),
    UMBRELLA_CLOSED_VARIANT("mdi2u-umbrella-closed-variant", "F13E1"),
    UMBRELLA_OUTLINE("mdi2u-umbrella-outline", "F054B"),
    UNDERWEAR_OUTLINE("mdi2u-underwear-outline", "F1D0F"),
    UNDO("mdi2u-undo", "F054C"),
    UNDO_VARIANT("mdi2u-undo-variant", "F054D"),
    UNFOLD_LESS_HORIZONTAL("mdi2u-unfold-less-horizontal", "F054E"),
    UNFOLD_LESS_VERTICAL("mdi2u-unfold-less-vertical", "F0760"),
    UNFOLD_MORE_HORIZONTAL("mdi2u-unfold-more-horizontal", "F054F"),
    UNFOLD_MORE_VERTICAL("mdi2u-unfold-more-vertical", "F0761"),
    UNGROUP("mdi2u-ungroup", "F0550"),
    UNICODE("mdi2u-unicode", "F0ED0"),
    UNICORN("mdi2u-unicorn", "F15C2"),
    UNICORN_VARIANT("mdi2u-unicorn-variant", "F15C3"),
    UNICYCLE("mdi2u-unicycle", "F15E5"),
    UNITY("mdi2u-unity", "F06AF"),
    UNREAL("mdi2u-unreal", "F09B1"),
    UPDATE("mdi2u-update", "F06B0"),
    UPLOAD("mdi2u-upload", "F0552"),
    UPLOAD_BOX("mdi2u-upload-box", "F1D10"),
    UPLOAD_BOX_OUTLINE("mdi2u-upload-box-outline", "F1D11"),
    UPLOAD_CIRCLE("mdi2u-upload-circle", "F1D12"),
    UPLOAD_CIRCLE_OUTLINE("mdi2u-upload-circle-outline", "F1D13"),
    UPLOAD_LOCK("mdi2u-upload-lock", "F1373"),
    UPLOAD_LOCK_OUTLINE("mdi2u-upload-lock-outline", "F1374"),
    UPLOAD_MULTIPLE("mdi2u-upload-multiple", "F083D"),
    UPLOAD_MULTIPLE_OUTLINE("mdi2u-upload-multiple-outline", "F1D14"),
    UPLOAD_NETWORK("mdi2u-upload-network", "F06F6"),
    UPLOAD_NETWORK_OUTLINE("mdi2u-upload-network-outline", "F0CD8"),
    UPLOAD_OFF("mdi2u-upload-off", "F10C6"),
    UPLOAD_OFF_OUTLINE("mdi2u-upload-off-outline", "F10C7"),
    UPLOAD_OUTLINE("mdi2u-upload-outline", "F0E07"),
    USB("mdi2u-usb", "F0553"),
    USB_C_PORT("mdi2u-usb-c-port", "F1CBF"),
    USB_FLASH_DRIVE("mdi2u-usb-flash-drive", "F129E"),
    USB_FLASH_DRIVE_OUTLINE("mdi2u-usb-flash-drive-outline", "F129F"),
    USB_PORT("mdi2u-usb-port", "F11F0");

    public static MaterialDesignU findByDescription(String description) {
        for (MaterialDesignU font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private final String description;
    private final int code;

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