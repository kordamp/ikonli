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
package org.kordamp.ikonli;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class IkonResolverProvider {
    private static volatile IkonResolver instance;

    private IkonResolverProvider() {
    }

    public static IkonResolver getInstance(FontLoader fontLoader) {
        IkonResolver localInstance = instance;
        if (localInstance == null) {
            synchronized (IkonResolverProvider.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = createIkonResolver(fontLoader);
                }
            }
        }
        return localInstance;
    }

    private static IkonResolver createIkonResolver(FontLoader fontLoader) {
        return tryGetOSGiResolver().orElseGet(() -> DefaultIkonResolver.getInstance(fontLoader));
    }

    private static java.util.Optional<IkonResolver> tryGetOSGiResolver() {
        try {
            if (!isOSGiAvailable()) {
                return java.util.Optional.empty();
            }

            Bundle bundle = FrameworkUtil.getBundle(IkonResolverProvider.class);
            if (bundle == null) {
                return java.util.Optional.empty();
            }

            BundleContext context = bundle.getBundleContext();
            if (context == null) {
                return java.util.Optional.empty();
            }

            ServiceReference<IkonResolver> ref = context.getServiceReference(IkonResolver.class);
            if (ref == null) {
                return java.util.Optional.empty();
            }

            IkonResolver resolver = context.getService(ref);
            return java.util.Optional.ofNullable(resolver);

        } catch (NoClassDefFoundError | IllegalStateException e) {
            return java.util.Optional.empty();
        }
    }

    private static boolean isOSGiAvailable() {
        try {
            Class.forName("org.osgi.framework.BundleContext");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
