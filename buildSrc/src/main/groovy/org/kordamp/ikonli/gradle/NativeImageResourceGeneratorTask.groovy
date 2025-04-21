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
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files

@CompileStatic
abstract class NativeImageResourceGeneratorTask extends DefaultTask {
    @OutputDirectory
    abstract DirectoryProperty getOutputDirectory()

    @Input
    abstract Property<String> getGroupId()

    @Input
    abstract  Property<String> getArtifactId()

    @Input
    abstract  Property<String> getVersion()

    @Input
    abstract  Property<String> getIconPackName()

    @TaskAction
    void generateResourceConfigFile() {
        def outputDir = outputDirectory.get().asFile.toPath()
        def resourceConfig = outputDir.resolve("META-INF/native-image/${groupId.get()}/${artifactId.get()}/resources-config.json")
        Files.createDirectories(resourceConfig.parent)

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
