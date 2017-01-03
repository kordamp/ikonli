/*
 * Copyright 2015-2017 Andres Almiray
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
import org.kordamp.ikonli.hawcons.HawconsFilled;
import org.kordamp.ikonli.hawcons.HawconsStroke;
import org.kordamp.ikonli.icomoon.Icomoon;
import org.kordamp.ikonli.ionicons.Ionicons;
import org.kordamp.ikonli.maki.Maki;
import org.kordamp.ikonli.maki2.Maki2;
import org.kordamp.ikonli.material.Material;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.metrizeicons.MetrizeIcons;
import org.kordamp.ikonli.octicons.Octicons;
import org.kordamp.ikonli.openiconic.Openiconic;
import org.kordamp.ikonli.runestroicons.Runestroicons;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.typicons.Typicons;
import org.kordamp.ikonli.weathericons.WeatherIcons;
import org.kordamp.ikonli.websymbols.Websymbols;

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
        createTab(tabPane, HawconsFilled.class, new DemoTab(allOf(HawconsFilled.class)));
        createTab(tabPane, HawconsStroke.class, new DemoTab(allOf(HawconsStroke.class)));
        createTab(tabPane, Icomoon.class, new DemoTab(allOf(Icomoon.class)));
        createTab(tabPane, Ionicons.class, new DemoTab(allOf(Ionicons.class)));
        createTab(tabPane, Maki.class, new DemoTab(allOf(Maki.class)));
        createTab(tabPane, Maki2.class, new DemoTab(allOf(Maki2.class)));
        createTab(tabPane, Material.class, new DemoTab(allOf(Material.class)));
        createTab(tabPane, MaterialDesign.class, new DemoTab(allOf(MaterialDesign.class)));
        createTab(tabPane, MetrizeIcons.class, new DemoTab(allOf(MetrizeIcons.class)));
        createTab(tabPane, Octicons.class, new DemoTab(allOf(Octicons.class)));
        createTab(tabPane, Openiconic.class, new DemoTab(allOf(Openiconic.class)));
        createTab(tabPane, Runestroicons.class, new DemoTab(allOf(Runestroicons.class)));
        createTab(tabPane, Typicons.class, new DemoTab(allOf(Typicons.class)));
        createTab(tabPane, WeatherIcons.class, new DemoTab(allOf(WeatherIcons.class)));
        createTab(tabPane, Websymbols.class, new DemoTab(allOf(Websymbols.class)));

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