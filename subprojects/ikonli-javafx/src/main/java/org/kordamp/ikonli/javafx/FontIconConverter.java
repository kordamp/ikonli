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
package org.kordamp.ikonli.javafx;

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;
import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public class FontIconConverter extends StyleConverter<String, Ikon> {
    private static class Holder {
        static final FontIconConverter INSTANCE = new FontIconConverter();
        static final SequenceConverter SEQUENCE_INSTANCE = new SequenceConverter();
    }

    public static StyleConverter<String, Ikon> getInstance() {
        return Holder.INSTANCE;
    }

    private FontIconConverter() {

    }

    @Override
    public String toString() {
        return "FontIconConverter";
    }

    @Override
    public Ikon convert(ParsedValue<String, Ikon> value, Font font) {
        String description = value.getValue().trim();
        return IkonResolver.getInstance().resolveIkonHandler(description).resolve(description);
    }

    public static final class SequenceConverter extends StyleConverter<String, Ikon[]> {
        public static SequenceConverter getInstance() {
            return Holder.SEQUENCE_INSTANCE;
        }

        private SequenceConverter() {
            super();
        }

        @Override
        public Ikon[] convert(ParsedValue<String, Ikon[]> value, Font font) {
            String[] descriptions = value.getValue().split(",");
            Ikon[] ikons = new Ikon[descriptions.length];
            for (int i = 0; i < descriptions.length; i++) {
                String description = descriptions[i].trim();
                ikons[i] = IkonResolver.getInstance().resolveIkonHandler(description).resolve(description);
            }
            return ikons;
        }

        @Override
        public String toString() {
            return "FontIcon.SequenceConverter";
        }
    }
}