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
module org.kordamp.ikonli.fontawesome6 {
    requires org.kordamp.ikonli.core;
    requires static org.kordamp.jipsy.annotations;
    exports org.kordamp.ikonli.fontawesome6;

    provides org.kordamp.ikonli.IkonHandler
        with org.kordamp.ikonli.fontawesome6.FontAwesomeBrandsIkonHandler,
            org.kordamp.ikonli.fontawesome6.FontAwesomeRegularIkonHandler,
            org.kordamp.ikonli.fontawesome6.FontAwesomeSolidIkonHandler;
    provides org.kordamp.ikonli.IkonProvider
        with org.kordamp.ikonli.fontawesome6.FontAwesomeBrandsIkonProvider,
            org.kordamp.ikonli.fontawesome6.FontAwesomeRegularIkonProvider,
            org.kordamp.ikonli.fontawesome6.FontAwesomeSolidIkonProvider;
}