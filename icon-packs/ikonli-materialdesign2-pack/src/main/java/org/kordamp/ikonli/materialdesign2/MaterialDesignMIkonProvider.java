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
package org.kordamp.ikonli.materialdesign2;

import org.kordamp.ikonli.IkonProvider;
import org.kordamp.jipsy.annotations.ServiceProviderFor;
import org.osgi.service.component.annotations.Component;

/**
 * @author Andres Almiray
 */
@ServiceProviderFor(IkonProvider.class)
@Component(service = IkonProvider.class)
public class MaterialDesignMIkonProvider implements IkonProvider<MaterialDesignM> {
    @Override
    public Class<MaterialDesignM> getIkon() {
        return MaterialDesignM.class;
    }
}