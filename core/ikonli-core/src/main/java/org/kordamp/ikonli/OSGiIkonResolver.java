/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2025 Andres Almiray
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
package org.kordamp.ikonli;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service = IkonResolver.class)
public class OSGiIkonResolver extends AbstractIkonResolver implements IkonResolver {
    private FontLoader fontLoader;

    public OSGiIkonResolver() {
    }

    @Reference
    protected void setFontLoader(FontLoader fontLoader) {
        this.fontLoader = fontLoader;
    }

    @Reference(
        cardinality = ReferenceCardinality.MULTIPLE,
        policyOption = ReferencePolicyOption.GREEDY,
        unbind = "unbindIkonHandler"
    )
    protected void bindIkonHandler(IkonHandler handler) {
        if (registerHandler(handler)) {
            fontLoader.loadFont(handler);
        }
    }

    protected void unbindIkonHandler(IkonHandler handler) {
        unregisterHandler(handler);
    }
}
