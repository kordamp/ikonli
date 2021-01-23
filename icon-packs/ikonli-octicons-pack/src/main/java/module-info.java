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
module org.kordamp.ikonli.octicons {
    requires org.kordamp.ikonli.core;
    requires static org.kordamp.jipsy;
    requires static org.kordamp.jipsy.annotations;
    exports org.kordamp.ikonli.octicons;

    provides org.kordamp.ikonli.IkonHandler
        with org.kordamp.ikonli.octicons.OcticonsIkonHandler;
    provides org.kordamp.ikonli.IkonProvider
        with org.kordamp.ikonli.octicons.OcticonsIkonProvider;
}