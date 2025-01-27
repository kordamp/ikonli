/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2025 Andres Almiray
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
package org.kordamp.ikonli.sampler.swing;

import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.IkonProvider;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.EnumSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.TreeMap;

import static java.util.EnumSet.allOf;

/**
 * @author Andres Almiray
 */
public class Sampler {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sampler::launch);
    }

    private static void launch() {
        JTabbedPane tabPane = new JTabbedPane();

        Map<String, IkonProvider> ikons = new TreeMap<>();
        ServiceLoader<IkonProvider> providers = ServiceLoader.load(IkonProvider.class);
        for (IkonProvider provider : providers) {
            ikons.put(provider.getIkon().getSimpleName(), provider);
        }
        for (IkonProvider provider : ikons.values()) {
            createTab(tabPane, provider.getIkon(), new DemoTab(allOf(provider.getIkon())));
        }

        JFrame frame = new JFrame("Ikonli Sampler");
        frame.add(tabPane);
        frame.setSize(new Dimension(1024, 1024));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                pane.add(new JLabel(FontIcon.of(value, 48)));
            }
        }
    }
}
