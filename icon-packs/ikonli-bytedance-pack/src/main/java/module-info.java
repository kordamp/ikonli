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
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldALIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldALIkonProvider;
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldMZIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldMZIkonProvider;
import org.kordamp.ikonli.bytedance.BytedanceIconsExtraBoldALIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsExtraBoldALIkonProvider;
import org.kordamp.ikonli.bytedance.BytedanceIconsExtraBoldMZIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsExtraBoldMZIkonProvider;
import org.kordamp.ikonli.bytedance.BytedanceIconsRegularALIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsRegularALIkonProvider;
import org.kordamp.ikonli.bytedance.BytedanceIconsRegularMZIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsRegularMZIkonProvider;
import org.kordamp.ikonli.bytedance.BytedanceIconsThinALIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsThinALIkonProvider;
import org.kordamp.ikonli.bytedance.BytedanceIconsThinMZIkonHandler;
import org.kordamp.ikonli.bytedance.BytedanceIconsThinMZIkonProvider;

/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2023 Andres Almiray
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
module org.kordamp.ikonli.bytedance {
    requires org.kordamp.ikonli.core;
    requires static org.kordamp.jipsy.annotations;
    exports org.kordamp.ikonli.bytedance;

    provides org.kordamp.ikonli.IkonHandler
            with BytedanceIconsThinALIkonHandler,
                    BytedanceIconsThinMZIkonHandler,
                    BytedanceIconsRegularALIkonHandler,
                    BytedanceIconsRegularMZIkonHandler,
                    BytedanceIconsBoldALIkonHandler,
                    BytedanceIconsBoldMZIkonHandler,
                    BytedanceIconsExtraBoldALIkonHandler,
                    BytedanceIconsExtraBoldMZIkonHandler;
    provides org.kordamp.ikonli.IkonProvider
            with BytedanceIconsThinALIkonProvider,
                    BytedanceIconsThinMZIkonProvider,
                    BytedanceIconsRegularALIkonProvider,
                    BytedanceIconsRegularMZIkonProvider,
                    BytedanceIconsBoldALIkonProvider,
                    BytedanceIconsBoldMZIkonProvider,
                    BytedanceIconsExtraBoldALIkonProvider,
                    BytedanceIconsExtraBoldMZIkonProvider;

}