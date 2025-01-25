package org.kordamp.ikonli;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service = IkonResolver.class)
public class OSGiIkonResolver extends AbstractIkonResolver implements IkonResolver {
    private FontLoader fontLoader;

    public OSGiIkonResolver() {
    }
    
    @Reference
    protected void setFontLoader(FontLoader fontLoader) {
        this.fontLoader = fontLoader;
    }
    
    @Reference(
        cardinality = ReferenceCardinality.MULTIPLE,
        policyOption = ReferencePolicyOption.GREEDY,
        unbind = "unbindIkonHandler"
    )
    protected void bindIkonHandler(IkonHandler handler) {
        if (registerHandler(handler)) {
            fontLoader.loadFont(handler);
        }
    }

    protected void unbindIkonHandler(IkonHandler handler) {
        unregisterHandler(handler);
    }
}
