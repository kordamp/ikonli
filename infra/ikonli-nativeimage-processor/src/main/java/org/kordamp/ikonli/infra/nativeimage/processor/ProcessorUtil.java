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
import javax.tools.FileObject;
import javax.tools.JavaFileManager.Location;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Andres Almiray
 * @since 12.4.0
 */
public final class ProcessorUtil {
    private ProcessorUtil() {
        // noop
    }

    static void generate(Location location, String fileName, String content, Context context) throws IOException {
        if (null == content || content.isEmpty()) return;

        FileObject resource = context.getProcessingEnv().getFiler().createResource(
            location,
            "",
            fileName,
            context.getElements().toArray(new Element[0]));

        write(content, resource);
    }

    static void write(String text, FileObject resource) throws IOException {
        Writer writer = null;
        try {
            writer = resource.openWriter();
            writer.write(text);
            writer.flush();
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

    public static String stacktrace(Exception e) {
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }
}
