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
package org.kordamp.ikonli.maki;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum Maki implements Ikon {
    ABOVEGROUND_RAIL("maki-aboveground-rail", '\ue800'),
    AIRFIELD("maki-airfield", '\ue801'),
    AIRPORT("maki-airport", '\ue802'),
    ART_GALLERY("maki-art-gallery", '\ue803'),
    BAR("maki-bar", '\ue804'),
    BASEBALL("maki-baseball", '\ue806'),
    BASKETBALL("maki-basketball", '\ue807'),
    BEER("maki-beer", '\ue808'),
    BELOWGROUND_RAIL("maki-belowground-rail", '\ue809'),
    BICYCLE("maki-bicycle", '\ue80a'),
    BUS("maki-bus", '\ue80b'),
    CAFE("maki-cafe", '\ue80c'),
    CAMPSITE("maki-campsite", '\ue80d'),
    CEMETERY("maki-cemetery", '\ue80e'),
    CINEMA("maki-cinema", '\ue80f'),
    COLLEGE("maki-college", '\ue810'),
    COMMERICAL_BUILDING("maki-commerical-building", '\ue811'),
    CREDIT_CARD("maki-credit-card", '\ue812'),
    CRICKET("maki-cricket", '\ue813'),
    EMBASSY("maki-embassy", '\ue814'),
    FAST_FOOD("maki-fast-food", '\ue815'),
    FERRY("maki-ferry", '\ue816'),
    FIRE_STATION("maki-fire-station", '\ue817'),
    FOOTBALL("maki-football", '\ue818'),
    FUEL("maki-fuel", '\ue819'),
    GARDEN("maki-garden", '\ue81a'),
    GIRAFFE("maki-giraffe", '\ue81b'),
    GOLF("maki-golf", '\ue81c'),
    GROCERY_STORE("maki-grocery-store", '\ue81e'),
    HARBOR("maki-harbor", '\ue81f'),
    HELIPORT("maki-heliport", '\ue820'),
    HOSPITAL("maki-hospital", '\ue821'),
    INDUSTRIAL_BUILDING("maki-industrial-building", '\ue822'),
    LIBRARY("maki-library", '\ue823'),
    LODGING("maki-lodging", '\ue824'),
    LONDON_UNDERGROUND("maki-london-underground", '\ue825'),
    MINEFIELD("maki-minefield", '\ue826'),
    MONUMENT("maki-monument", '\ue827'),
    MUSEUM("maki-museum", '\ue828'),
    PHARMACY("maki-pharmacy", '\ue829'),
    PITCH("maki-pitch", '\ue82a'),
    POLICE("maki-police", '\ue82b'),
    POST("maki-post", '\ue82c'),
    PRISON("maki-prison", '\ue82d'),
    RAIL("maki-rail", '\ue82e'),
    RELIGIOUS_CHRISTIAN("maki-religious-christian", '\ue82f'),
    RELIGIOUS_ISLAM("maki-religious-islam", '\ue830'),
    RELIGIOUS_JEWISH("maki-religious-jewish", '\ue831'),
    RESTAURANT("maki-restaurant", '\ue832'),
    ROADBLOCK("maki-roadblock", '\ue833'),
    SCHOOL("maki-school", '\ue834'),
    SHOP("maki-shop", '\ue835'),
    SKIING("maki-skiing", '\ue836'),
    SOCCER("maki-soccer", '\ue837'),
    SWIMMING("maki-swimming", '\ue838'),
    TENNIS("maki-tennis", '\ue839'),
    THEATRE("maki-theatre", '\ue83a'),
    TOILET("maki-toilet", '\ue83b'),
    TOWN_HALL("maki-town-hall", '\ue83c'),
    TRASH("maki-trash", '\ue83d'),
    TREE_1("maki-tree-1", '\ue83e'),
    TREE_2("maki-tree-2", '\ue83f'),
    WAREHOUSE("maki-warehouse", '\ue840');

    public static Maki findByDescription(String description) {
        for (Maki font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private char code;

    Maki(String description, char code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public char getCode() {
        return code;
    }
}