package org.kordamp.ikonli.antdesignicons;

import org.kordamp.ikonli.IkonProvider;
import org.kordamp.jipsy.ServiceProviderFor;

/**
 * @author Andres Almiray
 */
@ServiceProviderFor(IkonProvider.class)
public class AntDesignIconsFilledIkonProvider implements IkonProvider<AntDesignIconsFilled> {
    @Override
    public Class<AntDesignIconsFilled> getIkon() {
        return AntDesignIconsFilled.class;
    }
}