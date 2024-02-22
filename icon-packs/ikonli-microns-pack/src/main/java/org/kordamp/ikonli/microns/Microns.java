/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2024 Andres Almiray
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
package org.kordamp.ikonli.microns;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum Microns implements Ikon {
    ALIGN_CENTER("mu-align-center", '\ue765'),
    ALIGN_LEFT("mu-align-left", '\ue764'),
    ALIGN_RIGHT("mu-align-right", '\ue766'),
    ARROW_DOWN("mu-arrow-down", '\ue703'),
    ARROW_LEFT("mu-arrow-left", '\ue700'),
    ARROW_RIGHT("mu-arrow-right", '\ue701'),
    ARROW_UP("mu-arrow-up", '\ue702'),
    AUDIO("mu-audio", '\ue73d'),
    AUDIO_DESCRIPTION("mu-audio-description", '\ue725'),
    BARS("mu-bars", '\ue740'),
    BOLD("mu-bold", '\ue75e'),
    BOOKMARK("mu-bookmark", '\ue72f'),
    BOX("mu-box", '\ue750'),
    BOX_CROSS("mu-box-cross", '\ue755'),
    BOX_FULL("mu-box-full", '\ue751'),
    BOX_MINUS("mu-box-minus", '\ue753'),
    BOX_PLUS("mu-box-plus", '\ue752'),
    BOX_TICK("mu-box-tick", '\ue754'),
    CALENDAR("mu-calendar", '\ue72a'),
    CANCEL("mu-cancel", '\ue741'),
    CAPTIONS("mu-captions", '\ue723'),
    CARET("mu-caret", '\ue70f'),
    CARET_DOWN("mu-caret-down", '\ue711'),
    CARET_UP("mu-caret-up", '\ue710'),
    CHAPTERS("mu-chapters", '\ue74b'),
    CHART_BAR("mu-chart-bar", '\ue727'),
    CHART_LINE("mu-chart-line", '\ue726'),
    CHART_PIE("mu-chart-pie", '\ue729'),
    CHART_SCATTER("mu-chart-scatter", '\ue728'),
    CHAT("mu-chat", '\ue730'),
    CLOCK("mu-clock", '\ue72b'),
    CLOUD("mu-cloud", '\ue769'),
    CODE("mu-code", '\ue74f'),
    COG("mu-cog", '\ue736'),
    CONTRACT("mu-contract", '\ue747'),
    DELETE("mu-delete", '\ue732'),
    DOWN("mu-down", '\ue707'),
    DOWNLOAD("mu-download", '\ue709'),
    EDIT("mu-edit", '\ue731'),
    EXPAND("mu-expand", '\ue748'),
    FAIL("mu-fail", '\ue75c'),
    FILE("mu-file", '\ue73a'),
    FLAG("mu-flag", '\ue72e'),
    GRID("mu-grid", '\ue749'),
    GROUP("mu-group", '\ue739'),
    HD("mu-hd", '\ue724'),
    HEART("mu-heart", '\ue72d'),
    HIDE("mu-hide", '\ue734'),
    IMAGE("mu-image", '\ue73b'),
    INDENT("mu-indent", '\ue767'),
    INFO("mu-info", '\ue759'),
    ITALIC("mu-italic", '\ue75f'),
    I_ASTERISK("mu-i-asterisk", '\ue71b'),
    I_BULLET("mu-i-bullet", '\ue71a'),
    I_CROSS("mu-i-cross", '\ue719'),
    I_DOWN("mu-i-down", '\ue715'),
    I_LEFT("mu-i-left", '\ue712'),
    I_MINUS("mu-i-minus", '\ue717'),
    I_PLUS("mu-i-plus", '\ue716'),
    I_RIGHT("mu-i-right", '\ue713'),
    I_TICK("mu-i-tick", '\ue718'),
    I_UP("mu-i-up", '\ue714'),
    LEFT("mu-left", '\ue704'),
    LINK("mu-link", '\ue737'),
    LOCK("mu-lock", '\ue735'),
    MAIL("mu-mail", '\ue74e'),
    MATRIX("mu-matrix", '\ue74a'),
    MENU("mu-menu", '\ue73f'),
    MINUS("mu-minus", '\ue70e'),
    OPTS_H("mu-opts-h", '\ue742'),
    OPTS_V("mu-opts-v", '\ue743'),
    OUTDENT("mu-outdent", '\ue768'),
    PASS("mu-pass", '\ue75b'),
    PAUSE("mu-pause", '\ue71d'),
    PLAY("mu-play", '\ue71c'),
    PLUS("mu-plus", '\ue70d'),
    PRINT("mu-print", '\ue73e'),
    RADIO_FULL("mu-radio-full", '\ue758'),
    RADIO_OFF("mu-radio-off", '\ue756'),
    RADIO_ON("mu-radio-on", '\ue757'),
    REDO("mu-redo", '\ue70b'),
    REPLAY("mu-replay", '\ue70c'),
    RIGHT("mu-right", '\ue705'),
    RSS("mu-rss", '\ue74c'),
    SEARCH("mu-search", '\ue744'),
    SHARE("mu-share", '\ue74d'),
    SHOW("mu-show", '\ue733'),
    STAR("mu-star", '\ue72c'),
    STRIKEOUT("mu-strikeout", '\ue761'),
    SUBTITLES("mu-subtitles", '\ue71e'),
    TEXT("mu-text", '\ue75d'),
    TEXT_SIZE("mu-text-size", '\ue762'),
    TEXT_UNSTYLE("mu-text-unstyle", '\ue763'),
    UNDERLINE("mu-underline", '\ue760'),
    UNDO("mu-undo", '\ue70a'),
    UP("mu-up", '\ue706'),
    UPLOAD("mu-upload", '\ue708'),
    USER("mu-user", '\ue738'),
    VIDEO("mu-video", '\ue73c'),
    VOL_HIGH("mu-vol-high", '\ue721'),
    VOL_LOW("mu-vol-low", '\ue71f'),
    VOL_MID("mu-vol-mid", '\ue720'),
    VOL_MUTE("mu-vol-mute", '\ue722'),
    WARN("mu-warn", '\ue75a'),
    WEB("mu-web", '\ue76a'),
    WIFI("mu-wifi", '\ue76b'),
    ZOOM_IN("mu-zoom-in", '\ue745'),
    ZOOM_OUT("mu-zoom-out", '\ue746');

    public static Microns findByDescription(String description) {
        for (Microns font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private int code;

    Microns(String description, int code) {
        this.description = description;
        this.code = code;
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