package org.kordamp.ikonli.antdesignicons;

import org.kordamp.ikonli.AbstractIkonHandler;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;
import org.kordamp.jipsy.ServiceProviderFor;

/**
 * @author Andres Almiray
 */
@ServiceProviderFor(IkonHandler.class)
public class AntDesignIconsFilledIkonHandler extends AbstractIkonHandler {
    @Override
    public boolean supports(String description) {
        return description != null && description.startsWith("antf-");
    }

    @Override
    public Ikon resolve(String description) {
        return AntDesignIconsFilled.findByDescription(description);
    }

    @Override
    public String getFontResourcePath() {
        return "META-INF/resources/antdesignicons/4.0.0/fonts/AntDesign-Icons-Filled.ttf";
    }

    @Override
    public String getFontFamily() {
        return "AntDesign-Icons-Filled";
    }
}