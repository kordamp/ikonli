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
package org.kordamp.ikonli.browser;

import javafx.application.Application;

/**
 * @author Andres Almiray
 */
public class Launcher {
    public static void main(String[] args) {
        if (printVersion(args)) return;
        Application.launch(IkonBrowser.class, args);
    }

    private static boolean printVersion(String[] args) {
        if (args != null && args.length > 0) {
            for (String arg : args) {
                if ("-version" .equals(arg) || "--version" .equals(arg)) {
                    System.out.println("Ikonli Browser " + Versions.IKONLI_VERSION);
                    return true;
                }
            }
        }
        return false;
    }
}
