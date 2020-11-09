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

import javafx.scene.text.Font;
import org.kordamp.ikonli.AbstractIkonResolver;
import org.kordamp.ikonli.IkonHandler;

import java.util.ServiceLoader;

/**
 * @author Andres Almiray
 */
public class IkonResolver extends AbstractIkonResolver {
    private static final IkonResolver INSTANCE;

    static {
        INSTANCE = new IkonResolver();

        ServiceLoader<IkonHandler> loader = resolveServiceLoader();
        for (IkonHandler handler : loader) {
            HANDLERS.add(handler);
            handler.setFont(Font.loadFont(handler.getFontResource().toExternalForm(), 16));
        }
    }

    private IkonResolver() {

    }

    private static ServiceLoader<IkonHandler> resolveServiceLoader() {
        if (null != IkonHandler.class.getModule().getLayer()) {
            return ServiceLoader.load(IkonHandler.class.getModule().getLayer(), IkonHandler.class);
        }
        return ServiceLoader.load(IkonHandler.class);
    }

    public static IkonResolver getInstance() {
        return INSTANCE;
    }
}
