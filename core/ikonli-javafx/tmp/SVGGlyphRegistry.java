package org.kordamp.ikonli.javafx;

import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Andres Almiray
 */
public final class SVGGlyphRegistry {
    private static final SVGGlyphRegistry INSTANCE;
    private final Map<String, Map<String, String>> glyphCache = new ConcurrentHashMap<>();

    static {
        INSTANCE = new SVGGlyphRegistry();
    }

    public static SVGGlyphRegistry getInstance() {
        return INSTANCE;
    }

    private SVGGlyphRegistry() {
    }

    public String getSVGContent(Ikon ikon) {
        return resolveGlyphs(ikon).get(String.valueOf(ikon.getCode()));
    }

    private Map<String, String> resolveGlyphs(Ikon ikon) {
        String className = ikon.getClass().getName();
        Map<String, String> glyphs = glyphCache.get(className);
        if (glyphs == null) {
            glyphs = new LinkedHashMap<>();
            glyphCache.put(className, glyphs);
            try {
                loadGlyphs(glyphs, ikon);
            } catch (Exception e) {
                // ignore
                e.printStackTrace();
            }
        }
        return glyphs;
    }

    private void loadGlyphs(Map<String, String> glyphs, Ikon ikon) throws Exception {
        IkonHandler ikonHandler = IkonResolver.getInstance().resolveIkonHandler(ikon.getDescription());
        String resource = ikonHandler.getFontResourcePath();
        resource = resource.substring(0, resource.length() - 3) + "svg";

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        InputStream is = getClass().getClassLoader().getResourceAsStream(resource);
        Document doc = docBuilder.parse(is);
        doc.getDocumentElement().normalize();
        NodeList glyphsList = doc.getElementsByTagName("glyph");
        for (int i = 0; i < glyphsList.getLength(); i++) {
            Node glyphNode = glyphsList.item(i);
            Node unicodeNode = glyphNode.getAttributes().getNamedItem("unicode");
            if (unicodeNode == null) {
                continue;
            }
            String unicode = unicodeNode.getNodeValue();
            Node pathNode = glyphNode.getAttributes().getNamedItem("d");
            if (pathNode == null) {
                continue;
            }
            glyphs.put(unicode, pathNode.getNodeValue());
        }
    }
}
