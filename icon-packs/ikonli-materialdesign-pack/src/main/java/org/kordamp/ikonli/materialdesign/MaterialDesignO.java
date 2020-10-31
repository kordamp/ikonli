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
public enum MaterialDesignO implements Ikon {
    OAR("mdio-oar", "F067C"),
    OCARINA("mdio-ocarina", "F0DE0"),
    OCI("mdio-oci", "F12E9"),
    OCR("mdio-ocr", "F113A"),
    OCTAGON("mdio-octagon", "F03C3"),
    OCTAGON_OUTLINE("mdio-octagon-outline", "F03C4"),
    OCTAGRAM("mdio-octagram", "F06F9"),
    OCTAGRAM_OUTLINE("mdio-octagram-outline", "F0775"),
    ODNOKLASSNIKI("mdio-odnoklassniki", "F03C5"),
    OFFER("mdio-offer", "F121B"),
    OFFICE_BUILDING("mdio-office-building", "F0991"),
    OFFICE_BUILDING_MARKER("mdio-office-building-marker", "F1520"),
    OFFICE_BUILDING_MARKER_OUTLINE("mdio-office-building-marker-outline", "F1521"),
    OFFICE_BUILDING_OUTLINE("mdio-office-building-outline", "F151F"),
    OIL("mdio-oil", "F03C7"),
    OIL_LAMP("mdio-oil-lamp", "F0F19"),
    OIL_LEVEL("mdio-oil-level", "F1053"),
    OIL_TEMPERATURE("mdio-oil-temperature", "F0FF8"),
    OMEGA("mdio-omega", "F03C9"),
    ONE_UP("mdio-one-up", "F0BAD"),
    ONEPASSWORD("mdio-onepassword", "F0881"),
    OPACITY("mdio-opacity", "F05CC"),
    OPEN_IN_APP("mdio-open-in-app", "F03CB"),
    OPEN_IN_NEW("mdio-open-in-new", "F03CC"),
    OPEN_SOURCE_INITIATIVE("mdio-open-source-initiative", "F0BAE"),
    OPENID("mdio-openid", "F03CD"),
    OPERA("mdio-opera", "F03CE"),
    ORBIT("mdio-orbit", "F0018"),
    ORBIT_VARIANT("mdio-orbit-variant", "F15DB"),
    ORDER_ALPHABETICAL_ASCENDING("mdio-order-alphabetical-ascending", "F020D"),
    ORDER_ALPHABETICAL_DESCENDING("mdio-order-alphabetical-descending", "F0D07"),
    ORDER_BOOL_ASCENDING("mdio-order-bool-ascending", "F02BE"),
    ORDER_BOOL_ASCENDING_VARIANT("mdio-order-bool-ascending-variant", "F098F"),
    ORDER_BOOL_DESCENDING("mdio-order-bool-descending", "F1384"),
    ORDER_BOOL_DESCENDING_VARIANT("mdio-order-bool-descending-variant", "F0990"),
    ORDER_NUMERIC_ASCENDING("mdio-order-numeric-ascending", "F0545"),
    ORDER_NUMERIC_DESCENDING("mdio-order-numeric-descending", "F0546"),
    ORIGIN("mdio-origin", "F0B43"),
    ORNAMENT("mdio-ornament", "F03CF"),
    ORNAMENT_VARIANT("mdio-ornament-variant", "F03D0"),
    OUTDOOR_LAMP("mdio-outdoor-lamp", "F1054"),
    OVERSCAN("mdio-overscan", "F1005"),
    OWL("mdio-owl", "F03D2");

    public static MaterialDesignO findByDescription(String description) {
        for (MaterialDesignO font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

    MaterialDesignO(String description, String code) {
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
