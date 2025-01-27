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
package org.kordamp.ikonli.gradle

import groovy.transform.CompileStatic
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject
import java.nio.file.Files

@CompileStatic
class NativeImageResourceGeneratorTask extends DefaultTask {
    @OutputDirectory
    final DirectoryProperty outputDirectory

    @Input
    final Property<String> groupId

    @Input
    final Property<String> artifactId

    @Input
    final Property<String> version

    @Input
    final Property<String> iconPackName

    @Inject
    NativeImageResourceGeneratorTask(ObjectFactory objects) {
        outputDirectory = objects.directoryProperty()
        groupId = objects.property(String)
        artifactId = objects.property(String)
        version = objects.property(String)
        iconPackName = objects.property(String)
    }

    @TaskAction
    void generateResourceConfigFile() {
        File resourceConfig = outputDirectory.get().file("${groupId.get()}/${artifactId.get()}/resources-config.json").asFile
        Files.createDirectories(resourceConfig.parentFile.toPath())

        resourceConfig.text = """
{
  "resources": {
    "includes": [
      {
        "pattern": "META-INF/resources/${iconPackName.get()}/${version.get()}/fonts/*.ttf"
      }
    ]
  }
}      
"""
    }
}
