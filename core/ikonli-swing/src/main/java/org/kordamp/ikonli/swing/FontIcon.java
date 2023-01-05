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
package org.kordamp.ikonli.swing;

import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class FontIcon implements Icon {
    private static final Object LOCK = new Object[0];

    private Font font;
    private int width = 8;
    private int height = 8;

    private int iconSize = 8;
    private Color iconColor = Color.BLACK;
    private Ikon ikon;

    public void paintIcon(Component c, Graphics g, int x, int y) {
        int w = getIconWidth();
        int h = getIconHeight();
        if (w <= 0 || h <= 0) return;

        g.translate(x, y);
        Color previousColor = g.getColor();
        Font previousFont = g.getFont();

        try {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setFont(font);
            g2.setColor(iconColor);

            int sy = g2.getFontMetrics().getAscent();
            int code = ikon.getCode();

            if (code <= '\uFFFF') {
                g2.drawString(String.valueOf((char) code), 0, sy);
            } else {
                char[] charPair = Character.toChars(code);
                String symbol = new String(charPair);
                g2.drawString(symbol, 0, sy);
            }
        } finally {
            g.translate(-x, -y);
            g.setColor(previousColor);
            g.setFont(previousFont);
        }
    }

    public ImageIcon toImageIcon() {
        return toImageIcon(this);
    }

    public ImageIcon toImageIcon(Icon icon) {
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        icon.paintIcon(null, image.getGraphics(), 0, 0);
        return new ImageIcon(image);
    }

    public Ikon getIkon() {
        return ikon;
    }

    public void setIkon(Ikon ikon) {
        requireNonNull(iconColor, "Argument 'iconFont' must not be null");
        this.ikon = ikon;
        synchronized (LOCK) {
            IkonHandler ikonHandler = org.kordamp.ikonli.swing.IkonResolver.getInstance().resolve(ikon.getDescription());
            font = ((Font) ikonHandler.getFont()).deriveFont(Font.PLAIN, iconSize);
            setProperties();
        }
    }

    public int getIconSize() {
        return iconSize;
    }

    public void setIconSize(int iconSize) {
        if (iconSize > 0) {
            this.iconSize = iconSize;
            if (null != font) {
                font = font.deriveFont(Font.PLAIN, iconSize);
                setProperties();
            }
        }
    }

    protected void setProperties() {
        BufferedImage tmp = new BufferedImage(iconSize, iconSize,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = getLocalGraphicsEnvironment().createGraphics(tmp);
        g2.setFont(font);
        this.width = g2.getFontMetrics().charWidth(ikon.getCode());
        this.height = g2.getFontMetrics().getHeight();

        g2.dispose();
    }

    public Color getIconColor() {
        return iconColor;
    }

    public void setIconColor(Color iconColor) {
        requireNonNull(iconColor, "Argument 'iconColor' must not be null");
        this.iconColor = iconColor;
    }

    public int getIconHeight() {
        return height;
    }

    public int getIconWidth() {
        return width;
    }

    public static FontIcon of(Ikon ikon) {
        return of(ikon, 8, Color.BLACK);
    }

    public static FontIcon of(Ikon ikon, int iconSize) {
        return of(ikon, iconSize, Color.BLACK);
    }

    public static FontIcon of(Ikon ikon, Color iconColor) {
        return of(ikon, 8, iconColor);
    }

    public static FontIcon of(Ikon ikon, int iconSize, Color iconColor) {
        FontIcon icon = new FontIcon();
        icon.setIkon(ikon);
        icon.setIconSize(iconSize);
        icon.setIconColor(iconColor);
        return icon;
    }
}
