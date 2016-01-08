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
package org.kordamp.ikonli.octicons;

import javafx.scene.text.Font;
import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum Octicons implements Ikon {
    ALERT("oct-alert", '\uf02d'),
    ARROW_DOWN("oct-arrow-down", '\uf03f'),
    ARROW_LEFT("oct-arrow-left", '\uf040'),
    ARROW_RIGHT("oct-arrow-right", '\uf03e'),
    ARROW_SMALL_DOWN("oct-arrow-small-down", '\uf0a0'),
    ARROW_SMALL_LEFT("oct-arrow-small-left", '\uf0a1'),
    ARROW_SMALL_RIGHT("oct-arrow-small-right", '\uf071'),
    ARROW_SMALL_UP("oct-arrow-small-up", '\uf09f'),
    ARROW_UP("oct-arrow-up", '\uf03d'),
    BEAKER("oct-beaker", '\uf0dd'),
    BELL("oct-bell", '\uf0de'),
    BOLD("oct-bold", '\uf0e2'),
    BOOK("oct-book", '\uf007'),
    BOOKMARK("oct-bookmark", '\uf07b'),
    BRIEFCASE("oct-briefcase", '\uf0d3'),
    BROADCAST("oct-broadcast", '\uf048'),
    BROWSER("oct-browser", '\uf0c5'),
    BUG("oct-bug", '\uf091'),
    CALENDAR("oct-calendar", '\uf068'),
    CHECK("oct-check", '\uf03a'),
    CHECKLIST("oct-checklist", '\uf076'),
    CHEVRON_DOWN("oct-chevron-down", '\uf0a3'),
    CHEVRON_LEFT("oct-chevron-left", '\uf0a4'),
    CHEVRON_RIGHT("oct-chevron-right", '\uf078'),
    CHEVRON_UP("oct-chevron-up", '\uf0a2'),
    CIRCLE_SLASH("oct-circle-slash", '\uf084'),
    CIRCUIT_BOARD("oct-circuit-board", '\uf0d6'),
    CLIPPY("oct-clippy", '\uf035'),
    CLOCK("oct-clock", '\uf046'),
    CLONE("oct-clone", '\uf0dc'),
    CLOUD_DOWNLOAD("oct-cloud-download", '\uf00b'),
    CLOUD_UPLOAD("oct-cloud-upload", '\uf00c'),
    CODE("oct-code", '\uf05f'),
    COLOR_MODE("oct-color-mode", '\uf065'),
    COMMENT("oct-comment", '\uf02b'),
    COMMENT_ADD("oct-comment-add", '\uf02b'),
    COMMENT_DISCUSSION("oct-comment-discussion", '\uf04f'),
    CREDIT_CARD("oct-credit-card", '\uf045'),
    DASH("oct-dash", '\uf0ca'),
    DASHBOARD("oct-dashboard", '\uf07d'),
    DATABASE("oct-database", '\uf096'),
    DESKTOP_DOWNLOAD("oct-desktop-download", '\uf0dc'),
    DEVICE_CAMERA("oct-device-camera", '\uf056'),
    DEVICE_CAMERA_VIDEO("oct-device-camera-video", '\uf057'),
    DEVICE_DESKTOP("oct-device-desktop", '\uf27c'),
    DEVICE_MOBILE("oct-device-mobile", '\uf038'),
    DIFF("oct-diff", '\uf04d'),
    DIFF_ADDED("oct-diff-added", '\uf06b'),
    DIFF_IGNORED("oct-diff-ignored", '\uf099'),
    DIFF_MODIFIED("oct-diff-modified", '\uf06d'),
    DIFF_REMOVED("oct-diff-removed", '\uf06c'),
    DIFF_RENAMED("oct-diff-renamed", '\uf06e'),
    ELLIPSIS("oct-ellipsis", '\uf09a'),
    EYE("oct-eye", '\uf04e'),
    EYE_UNWATCH("oct-eye-unwatch", '\uf04e'),
    EYE_WATCH("oct-eye-watch", '\uf04e'),
    FILE_ADD("oct-file-add", '\uf05d'),
    FILE_BINARY("oct-file-binary", '\uf094'),
    FILE_CODE("oct-file-code", '\uf010'),
    FILE_DIRECTORY("oct-file-directory", '\uf016'),
    FILE_DIRECTORY_CREATE("oct-file-directory-create", '\uf05d'),
    FILE_MEDIA("oct-file-media", '\uf012'),
    FILE_PDF("oct-file-pdf", '\uf014'),
    FILE_SUBMODULE("oct-file-submodule", '\uf017'),
    FILE_SYMLINK_DIRECTORY("oct-file-symlink-directory", '\uf0b1'),
    FILE_SYMLINK_FILE("oct-file-symlink-file", '\uf0b0'),
    FILE_TEXT("oct-file-text", '\uf011'),
    FILE_ZIP("oct-file-zip", '\uf013'),
    FLAME("oct-flame", '\uf0d2'),
    FOLD("oct-fold", '\uf0cc'),
    GEAR("oct-gear", '\uf02f'),
    GIFT("oct-gift", '\uf042'),
    GIST("oct-gist", '\uf00e'),
    GIST_FORK("oct-gist-fork", '\uf002'),
    GIST_NEW("oct-gist-new", '\uf05d'),
    GIST_PRIVATE("oct-gist-private", '\uf06a'),
    GIST_SECRET("oct-gist-secret", '\uf08c'),
    GIT_BRANCH("oct-git-branch", '\uf020'),
    GIT_BRANCH_CREATE("oct-git-branch-create", '\uf020'),
    GIT_BRANCH_DELETE("oct-git-branch-delete", '\uf020'),
    GIT_COMMIT("oct-git-commit", '\uf01f'),
    GIT_COMPARE("oct-git-compare", '\uf0ac'),
    GIT_FORK_PRIVATE("oct-git-fork-private", '\uf06a'),
    GIT_MERGE("oct-git-merge", '\uf023'),
    GIT_PULL_REQUEST("oct-git-pull-request", '\uf009'),
    GIT_PULL_REQUEST_ABANDONED("oct-git-pull-request-abandoned", '\uf009'),
    GLOBE("oct-globe", '\uf0b6'),
    GRAPH("oct-graph", '\uf043'),
    HEART("oct-heart", '\u2665'),
    HISTORY("oct-history", '\uf07e'),
    HOME("oct-home", '\uf08d'),
    HORIZONTAL_RULE("oct-horizontal-rule", '\uf070'),
    HUBOT("oct-hubot", '\uf09d'),
    INBOX("oct-inbox", '\uf0cf'),
    INFO("oct-info", '\uf059'),
    ISSUE_CLOSED("oct-issue-closed", '\uf028'),
    ISSUE_OPENED("oct-issue-opened", '\uf026'),
    ISSUE_REOPENED("oct-issue-reopened", '\uf027'),
    ITALIC("oct-italic", '\uf0e4'),
    JERSEY("oct-jersey", '\uf019'),
    KEY("oct-key", '\uf049'),
    KEYBOARD("oct-keyboard", '\uf00d'),
    LAW("oct-law", '\uf0d8'),
    LIGHT_BULB("oct-light-bulb", '\uf000'),
    LINK("oct-link", '\uf05c'),
    LINK_EXTERNAL("oct-link-external", '\uf07f'),
    LIST_ORDERED("oct-list-ordered", '\uf062'),
    LIST_UNORDERED("oct-list-unordered", '\uf061'),
    LOCATION("oct-location", '\uf060'),
    LOCK("oct-lock", '\uf06a'),
    LOGO_GIST("oct-logo-gist", '\uf0ad'),
    LOGO_GITHUB("oct-logo-github", '\uf092'),
    LOG_IN("oct-log-in", '\uf036'),
    LOG_OUT("oct-log-out", '\uf032'),
    MAIL("oct-mail", '\uf03b'),
    MAIL_READ("oct-mail-read", '\uf03c'),
    MAIL_REPLY("oct-mail-reply", '\uf051'),
    MARKDOWN("oct-markdown", '\uf0c9'),
    MARK_GITHUB("oct-mark-github", '\uf00a'),
    MEGAPHONE("oct-megaphone", '\uf077'),
    MENTION("oct-mention", '\uf0be'),
    MICROSCOPE("oct-microscope", '\uf0dd'),
    MILESTONE("oct-milestone", '\uf075'),
    MIRROR("oct-mirror", '\uf024'),
    MIRROR_PRIVATE("oct-mirror-private", '\uf06a'),
    MIRROR_PUBLIC("oct-mirror-public", '\uf024'),
    MORTAR_BOARD("oct-mortar-board", '\uf0d7'),
    MUTE("oct-mute", '\uf080'),
    NO_NEWLINE("oct-no-newline", '\uf09c'),
    OCTOFACE("oct-octoface", '\uf008'),
    ORGANIZATION("oct-organization", '\uf037'),
    PACKAGE("oct-package", '\uf0c4'),
    PAINTCAN("oct-paintcan", '\uf0d1'),
    PENCIL("oct-pencil", '\uf058'),
    PERSON("oct-person", '\uf018'),
    PERSON_ADD("oct-person-add", '\uf018'),
    PERSON_FOLLOW("oct-person-follow", '\uf018'),
    PIN("oct-pin", '\uf041'),
    PLUG("oct-plug", '\uf0d4'),
    PLUS("oct-plus", '\uf05d'),
    PRIMITIVE_DOT("oct-primitive-dot", '\uf052'),
    PRIMITIVE_SQUARE("oct-primitive-square", '\uf053'),
    PULSE("oct-pulse", '\uf085'),
    QUESTION("oct-question", '\uf02c'),
    QUOTE("oct-quote", '\uf063'),
    RADIO_TOWER("oct-radio-tower", '\uf030'),
    REMOVE_CLOSE("oct-remove-close", '\uf081'),
    REPO("oct-repo", '\uf001'),
    REPO_CLONE("oct-repo-clone", '\uf04c'),
    REPO_CREATE("oct-repo-create", '\uf05d'),
    REPO_DELETE("oct-repo-delete", '\uf001'),
    REPO_FORCE_PUSH("oct-repo-force-push", '\uf04a'),
    REPO_FORKED("oct-repo-forked", '\uf002'),
    REPO_PULL("oct-repo-pull", '\uf006'),
    REPO_PUSH("oct-repo-push", '\uf005'),
    REPO_SYNC("oct-repo-sync", '\uf087'),
    ROCKET("oct-rocket", '\uf033'),
    RSS("oct-rss", '\uf034'),
    RUBY("oct-ruby", '\uf047'),
    SEARCH("oct-search", '\uf02e'),
    SEARCH_SAVE("oct-search-save", '\uf02e'),
    SERVER("oct-server", '\uf097'),
    SETTINGS("oct-settings", '\uf07c'),
    SHIELD("oct-shield", '\uf0e1'),
    SIGN_IN("oct-sign-in", '\uf036'),
    SIGN_OUT("oct-sign-out", '\uf032'),
    SQUIRREL("oct-squirrel", '\uf0b2'),
    STAR("oct-star", '\uf02a'),
    STAR_ADD("oct-star-add", '\uf02a'),
    STAR_DELETE("oct-star-delete", '\uf02a'),
    STOP("oct-stop", '\uf08f'),
    SYNC("oct-sync", '\uf087'),
    TAG("oct-tag", '\uf015'),
    TAG_ADD("oct-tag-add", '\uf015'),
    TAG_REMOVE("oct-tag-remove", '\uf015'),
    TASKLIST("oct-tasklist", '\uf0e5'),
    TELESCOPE("oct-telescope", '\uf088'),
    TERMINAL("oct-terminal", '\uf0c8'),
    TEXT_SIZE("oct-text-size", '\uf0e3'),
    THREE_BARS("oct-three-bars", '\uf05e'),
    THUMBSDOWN("oct-thumbsdown", '\uf0db'),
    THUMBSUP("oct-thumbsup", '\uf0da'),
    TOOLS("oct-tools", '\uf031'),
    TRASHCAN("oct-trashcan", '\uf0d0'),
    TRIANGLE_DOWN("oct-triangle-down", '\uf05b'),
    TRIANGLE_LEFT("oct-triangle-left", '\uf044'),
    TRIANGLE_RIGHT("oct-triangle-right", '\uf05a'),
    TRIANGLE_UP("oct-triangle-up", '\uf0aa'),
    UNFOLD("oct-unfold", '\uf039'),
    UNMUTE("oct-unmute", '\uf0ba'),
    VERSIONS("oct-versions", '\uf064'),
    WATCH("oct-watch", '\uf0e0'),
    X("oct-x", '\uf081'),
    ZAP("oct-zap", '\u26A1');

    private static final String FONT_RESOURCE = "META-INF/resources/octicons/3.3.0/fonts/octicons.ttf";
    private static final Font FONT;

    static {
        FONT = Font.loadFont(Octicons.class.getClassLoader().getResource(FONT_RESOURCE).toExternalForm(), 16);
    }

    public static Octicons findByDescription(String description) {
        for (Octicons font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    public static Font getFont() {
        return FONT;
    }

    private String description;
    private char code;

    Octicons(String description, char code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getFontFamily() {
        return FONT.getFamily();
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