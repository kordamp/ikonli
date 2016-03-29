/*
 * Copyright 2015-2016 Andres Almiray. <aalmiray@yahoo.com>
 *
 * This file is part of Ikonli
 *
 * Ikonli is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Ikonli is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Ikonli. If not, see <http://www.gnu.org/licenses/>.
 *
 * ========================================================================
 *
 * This library is distributed under the terms of the GNU General Public
 * License with the following clarification and special exception:
 *
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole
 * combination.
 *
 * As an special exception, the copyright holders of this library give
 * you permission to use this library under the terms of the Apache
 * Software License v2 and forego the licensing terms of the GNU General
 * Public License if and only if the library is used as part of an
 * executable and/or application that makes use of the APIs of either the
 * Griffon Framework (https://github.com/griffon/griffon) or the
 * Basilisk Framework (https://github.com/basilisk-fw/basilisk).
 *
 * ========================================================================
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
package org.kordamp.ikonli;

import org.kordamp.ikonli.devicons.Devicons;
import org.kordamp.ikonli.elusive.Elusive;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.fontelico.Fontelico;
import org.kordamp.ikonli.foundation.Foundation;
import org.kordamp.ikonli.ionicons.Ionicons;
import org.kordamp.ikonli.maki.Maki;
import org.kordamp.ikonli.material.Material;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.metrizeicons.MetrizeIcons;
import org.kordamp.ikonli.octicons.Octicons;
import org.kordamp.ikonli.openiconic.Openiconic;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.typicons.Typicons;
import org.kordamp.ikonli.weathericons.WeatherIcons;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.EnumSet;

import static java.util.EnumSet.allOf;

/**
 * @author Andres Almiray
 */
public class Sampler {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                launch();
            }
        });
    }

    private static void launch() {
        JTabbedPane tabPane = new JTabbedPane();

        createTab(tabPane, Devicons.class, new DemoTab(allOf(Devicons.class)));
        createTab(tabPane, Elusive.class, new DemoTab(allOf(Elusive.class)));
        createTab(tabPane, Feather.class, new DemoTab(allOf(Feather.class)));
        createTab(tabPane, FontAwesome.class, new DemoTab(allOf(FontAwesome.class)));
        createTab(tabPane, Fontelico.class, new DemoTab(allOf(Fontelico.class)));
        createTab(tabPane, Foundation.class, new DemoTab(allOf(Foundation.class)));
        createTab(tabPane, Ionicons.class, new DemoTab(allOf(Ionicons.class)));
        createTab(tabPane, Maki.class, new DemoTab(allOf(Maki.class)));
        createTab(tabPane, Material.class, new DemoTab(allOf(Material.class)));
        createTab(tabPane, MaterialDesign.class, new DemoTab(allOf(MaterialDesign.class)));
        createTab(tabPane, MetrizeIcons.class, new DemoTab(allOf(MetrizeIcons.class)));
        createTab(tabPane, Octicons.class, new DemoTab(allOf(Octicons.class)));
        createTab(tabPane, Openiconic.class, new DemoTab(allOf(Openiconic.class)));
        createTab(tabPane, Typicons.class, new DemoTab(allOf(Typicons.class)));
        createTab(tabPane, WeatherIcons.class, new DemoTab(allOf(WeatherIcons.class)));

        JFrame frame = new JFrame("Ikonli Sampler");
        frame.add(tabPane);
        frame.setSize(new Dimension(1024, 1024));
        frame.setVisible(true);
    }

    private static void createTab(JTabbedPane tabPane, Class<? extends Ikon> iconFontClass, DemoTab tab) {
        tabPane.add(iconFontClass.getSimpleName(), tab);
    }

    private static class DemoTab extends JScrollPane {
        private DemoTab(EnumSet<? extends Ikon> enumSet) {
            JPanel pane = new JPanel(new GridLayout(0, 10, 10, 10));
            setViewportView(pane);

            for (Ikon value : enumSet) {
                FontIcon icon = new FontIcon();
                icon.setIkon(value);
                icon.setIconSize(48);
                pane.add(new JLabel(icon));
            }
        }
    }
}