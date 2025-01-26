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
module org.kordamp.ikonli.lineawesome {
    requires org.kordamp.ikonli.core;
    requires static org.kordamp.jipsy.annotations;
	requires static org.osgi.service.component.annotations;
    exports org.kordamp.ikonli.lineawesome;

    provides org.kordamp.ikonli.IkonHandler
        with org.kordamp.ikonli.lineawesome.LineAwesomeBrandsIkonHandler,
            org.kordamp.ikonli.lineawesome.LineAwesomeRegularIkonHandler,
            org.kordamp.ikonli.lineawesome.LineAwesomeSolidIkonHandler;
    provides org.kordamp.ikonli.IkonProvider
        with org.kordamp.ikonli.lineawesome.LineAwesomeBrandsIkonProvider,
            org.kordamp.ikonli.lineawesome.LineAwesomeRegularIkonProvider,
            org.kordamp.ikonli.lineawesome.LineAwesomeSolidIkonProvider;
}