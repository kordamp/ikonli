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
package org.kordamp.ikonli.browser;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.kordamp.bootstrapfx.BootstrapFX;

/**
 * @author Andres Almiray
 */
public class AboutDialog {
    public static void show() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Ikon Browser v" + Versions.IKONLI_VERSION);

        alert.getDialogPane().getScene()
            .getStylesheets().addAll(
            IkonBrowser.class.getResource("common.css").toExternalForm(),
            BootstrapFX.bootstrapFXStylesheet());
        alert.getDialogPane().lookupButton(ButtonType.OK)
            .getStyleClass().addAll("btn", "btn-primary");
        alert.getDialogPane().getStyleClass().add("dialog-content");

        alert.showAndWait();
    }
}
