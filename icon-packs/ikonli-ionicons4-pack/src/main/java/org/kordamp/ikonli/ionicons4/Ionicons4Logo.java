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
package org.kordamp.ikonli.ionicons4;

import org.kordamp.ikonli.Ikon;

/**
 * @author Loïc Sculier aka typhon0
 */
public enum Ionicons4Logo implements Ikon {
    ANDROID("ion4-logo-android",'\uf225'),
    ANGULAR("ion4-logo-angular",'\uf227'),
    APPLE("ion4-logo-apple",'\uf229'),
    BITBUCKET("ion4-logo-bitbucket",'\uf193'),
    BITCOIN("ion4-logo-bitcoin",'\uf22b'),
    BUFFER("ion4-logo-buffer",'\uf22d'),
    CHROME("ion4-logo-chrome",'\uf22f'),
    CLOSED_CAPTIONING("ion4-logo-closed-captioning",'\uf105'),
    CODEPEN("ion4-logo-codepen",'\uf230'),
    CSS3("ion4-logo-css3",'\uf231'),
    DESIGNERNEWS("ion4-logo-designernews",'\uf232'),
    DRIBBBLE("ion4-logo-dribbble",'\uf233'),
    DROPBOX("ion4-logo-dropbox",'\uf234'),
    EURO("ion4-logo-euro",'\uf235'),
    FACEBOOK("ion4-logo-facebook",'\uf236'),
    FLICKR("ion4-logo-flickr",'\uf107'),
    FOURSQUARE("ion4-logo-foursquare",'\uf237'),
    FREEBSD_DEVIL("ion4-logo-freebsd-devil",'\uf238'),
    GAME_CONTROLLER_A("ion4-logo-game-controller-a",'\uf13b'),
    GAME_CONTROLLER_B("ion4-logo-game-controller-b",'\uf181'),
    GITHUB("ion4-logo-github",'\uf239'),
    GOOGLE("ion4-logo-google",'\uf23a'),
    GOOGLEPLUS("ion4-logo-googleplus",'\uf23b'),
    HACKERNEWS("ion4-logo-hackernews",'\uf23c'),
    HTML5("ion4-logo-html5",'\uf23d'),
    INSTAGRAM("ion4-logo-instagram",'\uf23e'),
    IONIC("ion4-logo-ionic",'\uf150'),
    IONITRON("ion4-logo-ionitron",'\uf151'),
    JAVASCRIPT("ion4-logo-javascript",'\uf23f'),
    LINKEDIN("ion4-logo-linkedin",'\uf240'),
    MARKDOWN("ion4-logo-markdown",'\uf241'),
    MODEL_S("ion4-logo-model-s",'\uf153'),
    NO_SMOKING("ion4-logo-no-smoking",'\uf109'),
    NODEJS("ion4-logo-nodejs",'\uf242'),
    NPM("ion4-logo-npm",'\uf195'),
    OCTOCAT("ion4-logo-octocat",'\uf243'),
    PINTEREST("ion4-logo-pinterest",'\uf244'),
    PLAYSTATION("ion4-logo-playstation",'\uf245'),
    POLYMER("ion4-logo-polymer",'\uf15e'),
    PYTHON("ion4-logo-python",'\uf246'),
    REDDIT("ion4-logo-reddit",'\uf247'),
    RSS("ion4-logo-rss",'\uf248'),
    SASS("ion4-logo-sass",'\uf249'),
    SKYPE("ion4-logo-skype",'\uf24a'),
    SLACK("ion4-logo-slack",'\uf10b'),
    SNAPCHAT("ion4-logo-snapchat",'\uf24b'),
    STEAM("ion4-logo-steam",'\uf24c'),
    TUMBLR("ion4-logo-tumblr",'\uf24d'),
    TUX("ion4-logo-tux",'\uf2ae'),
    TWITCH("ion4-logo-twitch",'\uf2af'),
    TWITTER("ion4-logo-twitter",'\uf2b0'),
    USD("ion4-logo-usd",'\uf2b1'),
    VIMEO("ion4-logo-vimeo",'\uf2c4'),
    VK("ion4-logo-vk",'\uf10d'),
    WHATSAPP("ion4-logo-whatsapp",'\uf2c5'),
    WINDOWS("ion4-logo-windows",'\uf32f'),
    WORDPRESS("ion4-logo-wordpress",'\uf330'),
    XBOX("ion4-logo-xbox",'\uf34c'),
    XING("ion4-logo-xing",'\uf10f'),
    YAHOO("ion4-logo-yahoo",'\uf34d'),
    YEN("ion4-logo-yen",'\uf34e'),
    YOUTUBE("ion4-logo-youtube",'\uf34f');

    public static Ionicons4Logo findByDescription(String description) {
        for (Ionicons4Logo font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    private String description;
    private char code;

    Ionicons4Logo(String description, char code) {
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