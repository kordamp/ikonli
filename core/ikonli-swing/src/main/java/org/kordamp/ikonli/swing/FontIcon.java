/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2020 Andres Almiray
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

import javax.swing.Icon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    private BufferedImage buffer;

    private int iconSize = 8;
    private Color iconColor = Color.BLACK;
    private Ikon ikon;

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

    public void paintIcon(Component c, Graphics g, int x, int y) {
        synchronized (LOCK) {
            if (buffer == null) {
                buffer = new BufferedImage(getIconWidth(), getIconHeight(),
                    BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2 = (Graphics2D) buffer.getGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setFont(font);
                g2.setColor(iconColor);

                int sy = g2.getFontMetrics().getAscent();
                g2.drawString(String.valueOf(ikon.getCode()), 0, sy);

                g2.dispose();
            }

            g.drawImage(buffer, x, y, null);
        }
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

        synchronized (LOCK) {
            buffer = null;
        }
    }

    public Color getIconColor() {
        return iconColor;
    }

    public void setIconColor(Color iconColor) {
        requireNonNull(iconColor, "Argument 'iconColor' must not be null");
        this.iconColor = iconColor;
        synchronized (LOCK) {
            buffer = null;
        }
    }

    public int getIconHeight() {
        return height;
    }

    public int getIconWidth() {
        return width;
    }
}
