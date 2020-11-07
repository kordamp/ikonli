package org.kordamp.ikonli.antdesignicons;

import org.kordamp.ikonli.IkonProvider;
import org.kordamp.jipsy.ServiceProviderFor;

/**
 * @author Andres Almiray
 */
@ServiceProviderFor(IkonProvider.class)
public class AntDesignIconsOutlinedIkonProvider implements IkonProvider<AntDesignIconsOutlined> {
    @Override
    public Class<AntDesignIconsOutlined> getIkon() {
        return AntDesignIconsOutlined.class;
    }
}