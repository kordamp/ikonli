package org.kordamp.ikonli.prestashopicons;

import org.kordamp.ikonli.AbstractIkonHandler;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;
import org.kordamp.jipsy.ServiceProviderFor;

/**
 * @author Andres Almiray
 */
@ServiceProviderFor(IkonHandler.class)
public class PrestaShopIconsIkonHandler extends AbstractIkonHandler {
    @Override
    public boolean supports(String description) {
        return description != null && description.startsWith("ps-");
    }

    @Override
    public Ikon resolve(String description) {
        return PrestaShopIcons.findByDescription(description);
    }

    @Override
    public String getFontResourcePath() {
        return "META-INF/resources/prestashopicons/0.8.0/fonts/prestashop-icon-font.ttf";
    }

    @Override
    public String getFontFamily() {
        return "prestashop-official-pack";
    }
}