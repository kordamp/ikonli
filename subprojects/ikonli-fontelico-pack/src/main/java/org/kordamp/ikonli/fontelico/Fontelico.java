/*
 * Copyright 2015-2016 Andres Almiray. <aalmiray@yahoo.com>
 *
 * This file is part of Ikonli
 *
 * Ikonli is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Ikonli is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Ikonli. If not, see <http://www.gnu.org/licenses/>.
 *
 * ========================================================================
 *
 * This library is distributed under the terms of the GNU General Public
 * License with the following clarification and special exception:
 *
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole
 * combination.
 *
 * As an special exception, the copyright holders of this library give
 * you permission to use this library under the terms of the Apache
 * Software License v2 and forego the licensing terms of the GNU General
 * Public License if and only if the library is used as part of an
 * executable and/or application that makes use of the APIs of either the
 * Griffon Framework (https://github.com/griffon/griffon) or the
 * Basilisk Framework (https://github.com/basilisk-fw/basilisk).
 *
 * ========================================================================
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
package org.kordamp.ikonli.fontelico;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum Fontelico implements Ikon {
    EMO_HAPPY("ftl-emo-happy", '\ue800'),
    EMO_WINK("ftl-emo-wink", '\ue801'),
    EMO_WINK2("ftl-emo-wink2", '\ue813'),
    EMO_UNHAPPY("ftl-emo-unhappy", '\ue802'),
    EMO_SLEEP("ftl-emo-sleep", '\ue803'),
    EMO_THUMBSUP("ftl-emo-thumbsup", '\ue804'),
    EMO_DEVIL("ftl-emo-devil", '\ue805'),
    EMO_SURPRISED("ftl-emo-surprised", '\ue806'),
    EMO_TONGUE("ftl-emo-tongue", '\ue807'),
    EMO_COFFEE("ftl-emo-coffee", '\ue808'),
    EMO_SUNGLASSES("ftl-emo-sunglasses", '\ue809'),
    EMO_DISPLEASED("ftl-emo-displeased", '\ue80a'),
    EMO_BEER("ftl-emo-beer", '\ue80b'),
    EMO_GRIN("ftl-emo-grin", '\ue80c'),
    EMO_ANGRY("ftl-emo-angry", '\ue80d'),
    EMO_SAINT("ftl-emo-saint", '\ue80e'),
    EMO_CRY("ftl-emo-cry", '\ue80f'),
    EMO_SHOOT("ftl-emo-shoot", '\ue810'),
    EMO_SQUINT("ftl-emo-squint", '\ue811'),
    EMO_LAUGH("ftl-emo-laugh", '\ue812'),
    SPIN1("ftl-spin1", '\ue830'),
    SPIN2("ftl-spin2", '\ue831'),
    SPIN3("ftl-spin3", '\ue832'),
    SPIN4("ftl-spin4", '\ue834'),
    SPIN5("ftl-spin5", '\ue838'),
    SPIN6("ftl-spin6", '\ue839'),
    FIREFOX("ftl-firefox", '\ue840'),
    CHROME("ftl-chrome", '\ue841'),
    OPERA("ftl-opera", '\ue842'),
    IE("ftl-ie", '\ue843'),
    CROWN("ftl-crown", '\ue844'),
    CROWN_PLUS("ftl-crown-plus", '\ue845'),
    CROWN_MINUS("ftl-crown-minus", '\ue846'),
    MARQUEE("ftl-marquee", '\ue847');

    public static Fontelico findByDescription(String description) {
        for (Fontelico font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private char code;

    Fontelico(String description, char code) {
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