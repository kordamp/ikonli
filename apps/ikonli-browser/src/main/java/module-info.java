/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2021 Andres Almiray
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
module org.kordamp.ikonli.browser {
    exports org.kordamp.ikonli.browser;
    opens org.kordamp.ikonli.browser;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires com.miglayout.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.desktoppanefx.core;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.boxicons;

    uses org.kordamp.ikonli.IkonHandler;
    uses org.kordamp.ikonli.IkonProvider;
}
