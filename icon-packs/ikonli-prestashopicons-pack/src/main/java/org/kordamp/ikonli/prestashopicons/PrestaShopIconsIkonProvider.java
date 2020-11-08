package org.kordamp.ikonli.prestashopicons;

import org.kordamp.ikonli.IkonProvider;
import org.kordamp.jipsy.ServiceProviderFor;

/**
 * @author Andres Almiray
 */
@ServiceProviderFor(IkonProvider.class)
public class PrestaShopIconsIkonProvider implements IkonProvider<PrestaShopIcons> {
    @Override
    public Class<PrestaShopIcons> getIkon() {
        return PrestaShopIcons.class;
    }
}