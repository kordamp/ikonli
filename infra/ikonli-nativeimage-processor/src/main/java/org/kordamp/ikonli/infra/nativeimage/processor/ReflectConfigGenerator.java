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

import javax.lang.model.element.Element;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Andres Almiray
 * @since 12.4.0
 */
class ReflectConfigGenerator extends AbstractGenerator {
    public static final String OPTION_DISABLE = "disable.reflect.config";

    public ReflectConfigGenerator() {
        super("reflect-config.json", OPTION_DISABLE);
    }

    @Override
    protected String generateConfig(Context context) {
        Map<String, String> collector = new TreeMap<>();

        for (Element element : context.getElements()) {
            String className = elementTypeName(element.asType());
            if (!collector.containsKey(className)) {
                switch (element.getKind()) {
                    case INTERFACE:
                        collector.put(className, formatInterface(className));
                        break;
                    case ENUM:
                        collector.put(className, formatEnum(className));
                        break;
                    case CLASS:
                        collector.put(className, formatClass(className));
                        break;
                    default:
                        // noop
                        break;
                }
            }
        }

        if (collector.isEmpty()) return null;
        return "[\n" + String.join("\n,\n", collector.values()) + "\n]";
    }

    private String formatInterface(String name) {
        return String.format("" +
            "  {%n" +
            "    \"name\": \"%s\",%n" +
            "    \"queryAllPublicMethods\": true%n" +
            "  }", name);
    }

    private String formatEnum(String name) {
        return String.format("" +
            "  {%n" +
            "    \"name\": \"%s\",%n" +
            "    \"allDeclaredFields\": true,%n" +
            "    \"queryAllDeclaredMethods\": true%n" +
            "  }", name);
    }

    private String formatClass(String name) {
        return String.format("" +
            "  {%n" +
            "    \"name\": \"%s\",%n" +
            "    \"allDeclaredFields\": true,%n" +
            "    \"allPublicConstructors\": true,%n" +
            "    \"allPublicMethods\": true%n" +
            "  }", name);
    }
}
