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
package org.kordamp.ikonli.infra.nativeimage.processor;

import org.kordamp.ikonli.infra.nativeimage.annotations.ProxyConfig;

import javax.lang.model.element.Element;
import java.util.Set;
import java.util.TreeSet;

import static java.util.stream.Collectors.joining;

/**
 * @author Andres Almiray
 * @since 12.4.0
 */
class ProxyConfigGenerator extends AbstractGenerator {
    public static final String OPTION_DISABLE = "disable.proxy.config";

    public ProxyConfigGenerator() {
        super("proxy-config.json", OPTION_DISABLE);
    }

    @Override
    protected String generateConfig(Context context) {
        Set<String> collector = new TreeSet<>();

        for (Element element : context.getElements()) {
            if (null != element.getAnnotation(ProxyConfig.class)) {
                String className = elementTypeName(element.asType());
                collector.add(className);
            }
        }

        if (collector.isEmpty()) return null;

        return String.format("[%n" +
            "  {%n" +
            "    \"interfaces\": [%s]%n" +
            "  }%n]", collector.stream()
            .map(c -> "\"" + c + "\"")
            .collect(joining(",")));
    }
}
