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
package org.kordamp.ikonli.ociicons;

import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum Ociicons implements Ikon {
    // latest is e940
    TWOFA("oci-2fa", '\ue900'),
    API("oci-api", '\ue901'),
    AUTHENTICATION("oci-authentication", '\ue902'),
    BATCH("oci-batch", '\ue903'),
    BILLING("oci-billing", '\ue904'),
    CDN("oci-cdn", '\ue905'),
    CLI("oci-cli", '\ue906'),
    CLOUD("oci-cloud", '\ue907'),
    CONFIG("oci-config", '\ue908'),
    CONFIG_SERVICE("oci-config-service", '\ue909'),
    CONTAINER("oci-container", '\ue90a'),
    CONTAINER_HOST("oci-container-host", '\ue90b'),
    CONTAINER_IMAGE("oci-container-image", '\ue90c'),
    CUSTOMER("oci-customer", '\ue90d'),
    DATABASE("oci-database", '\ue90e'),
    DEBUGGING("oci-debugging", '\ue90f'),
    DESKTOP("oci-desktop", '\ue910'),
    DEVELOPER("oci-developer", '\ue911'),
    DEVICES("oci-devices", '\ue912'),
    DISK("oci-disk", '\ue913'),
    DISTRIBUTION("oci-distribution", '\ue914'),
    DOCDB("oci-docdb", '\ue915'),
    FILE("oci-file", '\ue916'),
    FIREWALL("oci-firewall", '\ue917'),
    FIREWALL_RULE("oci-firewall-rule", '\ue918'),
    FUNCTIION("oci-functiion", '\ue919'),
    GIT("oci-git", '\ue91a'),
    HEALTH_MONITOR("oci-health-monitor", '\ue91b'),
    INVOICE("oci-invoice", '\ue91c'),
    IOT("oci-iot", '\ue91d'),
    KEY_VAULT("oci-key-vault", '\ue91e'),
    KEY("oci-key", '\ue91f'),
    LAPTOP("oci-laptop", '\ue920'),
    LEGACY_MAINFRAME("oci-legacy-mainframe", '\ue921'),
    LOAD_BALANCER("oci-load-balancer", '\ue922'),
    LOGGING("oci-logging", '\ue923'),
    MACHINE_LEARNING("oci-machine-learning", '\ue924'),
    MEDIA("oci-media", '\ue925'),
    MEDIA_STREAMING("oci-media-streaming", '\ue926'),
    MESSAGE("oci-message", '\ue927'),
    MOBILE("oci-mobile", '\ue928'),
    MONITORING("oci-monitoring", '\ue929'),
    ONPREM("oci-onprem", '\ue92a'),
    ORCHESTRATOR("oci-orchestrator", '\ue92b'),
    PIPELINE("oci-pipeline", '\ue92c'),
    POLICY_ENFORCE("oci-policy-enforce", '\ue92d'),
    POLICY_MANAGER("oci-policy-manager", '\ue92e'),
    QUEUE("oci-queue", '\ue92f'),
    SBOM("oci-sbom", '\ue930'),
    SCHEDULED_JOB("oci-scheduled-job", '\ue931'),
    SDK("oci-sdk", '\ue932'),
    SECURITY_SCANNING("oci-security-scanning", '\ue933'),
    SERVER_DISK("oci-server-disk", '\ue934'),
    SERVERLESS("oci-serverless", '\ue935'),
    SERVER_RACK("oci-server-rack", '\ue936'),
    SERVICE("oci-service", '\ue937'),
    SHELL("oci-shell", '\ue938'),
    SIGNATURE_JOB("oci-signature-job", '\ue939'),
    SOURCE_ARTIFACT("oci-source-artifact", '\ue93a'),
    STORAGE("oci-storage", '\ue93b'),
    SUPPORT_PERSONNEL("oci-support-personnel", '\ue93c'),
    TESTING("oci-testing", '\ue93d'),
    VM("oci-vm", '\ue93e'),
    VNET("oci-vnet", '\ue93f'),
    WEB("oci-web", '\ue940');

    private String description;
    private int code;

    Ociicons(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public static Ociicons findByDescription(String description) {
        for (Ociicons font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCode() {
        return code;
    }
}