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
module org.kordamp.ikonli.materialdesign {
    requires org.kordamp.ikonli.core;
    requires static org.kordamp.jipsy;
    exports org.kordamp.ikonli.materialdesign;

    provides org.kordamp.ikonli.IkonHandler
        with org.kordamp.ikonli.materialdesign.MaterialDesignAIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignBIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignCIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignDIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignEIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignFIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignGIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignHIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignIIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignJIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignKIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignLIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignMIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignNIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignOIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignPIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignQIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignRIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignSIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignTIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignUIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignVIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignWIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignXIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignYIkonHandler,
            org.kordamp.ikonli.materialdesign.MaterialDesignZIkonHandler;
}