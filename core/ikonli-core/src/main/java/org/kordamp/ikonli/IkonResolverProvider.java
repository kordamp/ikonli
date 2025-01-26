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
