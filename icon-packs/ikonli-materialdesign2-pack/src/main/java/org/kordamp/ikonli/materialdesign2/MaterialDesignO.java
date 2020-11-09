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
package org.kordamp.ikonli.materialdesign2;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum MaterialDesignO implements Ikon {
    OAR("mdi2o-oar", "F067C"),
    OCARINA("mdi2o-ocarina", "F0DE0"),
    OCI("mdi2o-oci", "F12E9"),
    OCR("mdi2o-ocr", "F113A"),
    OCTAGON("mdi2o-octagon", "F03C3"),
    OCTAGON_OUTLINE("mdi2o-octagon-outline", "F03C4"),
    OCTAGRAM("mdi2o-octagram", "F06F9"),
    OCTAGRAM_OUTLINE("mdi2o-octagram-outline", "F0775"),
    ODNOKLASSNIKI("mdi2o-odnoklassniki", "F03C5"),
    OFFER("mdi2o-offer", "F121B"),
    OFFICE_BUILDING("mdi2o-office-building", "F0991"),
    OFFICE_BUILDING_MARKER("mdi2o-office-building-marker", "F1520"),
    OFFICE_BUILDING_MARKER_OUTLINE("mdi2o-office-building-marker-outline", "F1521"),
    OFFICE_BUILDING_OUTLINE("mdi2o-office-building-outline", "F151F"),
    OIL("mdi2o-oil", "F03C7"),
    OIL_LAMP("mdi2o-oil-lamp", "F0F19"),
    OIL_LEVEL("mdi2o-oil-level", "F1053"),
    OIL_TEMPERATURE("mdi2o-oil-temperature", "F0FF8"),
    OMEGA("mdi2o-omega", "F03C9"),
    ONE_UP("mdi2o-one-up", "F0BAD"),
    ONEPASSWORD("mdi2o-onepassword", "F0881"),
    OPACITY("mdi2o-opacity", "F05CC"),
    OPEN_IN_APP("mdi2o-open-in-app", "F03CB"),
    OPEN_IN_NEW("mdi2o-open-in-new", "F03CC"),
    OPEN_SOURCE_INITIATIVE("mdi2o-open-source-initiative", "F0BAE"),
    OPENID("mdi2o-openid", "F03CD"),
    OPERA("mdi2o-opera", "F03CE"),
    ORBIT("mdi2o-orbit", "F0018"),
    ORBIT_VARIANT("mdi2o-orbit-variant", "F15DB"),
    ORDER_ALPHABETICAL_ASCENDING("mdi2o-order-alphabetical-ascending", "F020D"),
    ORDER_ALPHABETICAL_DESCENDING("mdi2o-order-alphabetical-descending", "F0D07"),
    ORDER_BOOL_ASCENDING("mdi2o-order-bool-ascending", "F02BE"),
    ORDER_BOOL_ASCENDING_VARIANT("mdi2o-order-bool-ascending-variant", "F098F"),
    ORDER_BOOL_DESCENDING("mdi2o-order-bool-descending", "F1384"),
    ORDER_BOOL_DESCENDING_VARIANT("mdi2o-order-bool-descending-variant", "F0990"),
    ORDER_NUMERIC_ASCENDING("mdi2o-order-numeric-ascending", "F0545"),
    ORDER_NUMERIC_DESCENDING("mdi2o-order-numeric-descending", "F0546"),
    ORIGIN("mdi2o-origin", "F0B43"),
    ORNAMENT("mdi2o-ornament", "F03CF"),
    ORNAMENT_VARIANT("mdi2o-ornament-variant", "F03D0"),
    OUTDOOR_LAMP("mdi2o-outdoor-lamp", "F1054"),
    OVERSCAN("mdi2o-overscan", "F1005"),
    OWL("mdi2o-owl", "F03D2");

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
