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
package org.kordamp.ikonli.sampler.swing;

import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.captainicon.Captainicon;
import org.kordamp.ikonli.coreui.CoreUiBrands;
import org.kordamp.ikonli.coreui.CoreUiFree;
import org.kordamp.ikonli.dashicons.Dashicons;
import org.kordamp.ikonli.devicons.Devicons;
import org.kordamp.ikonli.elusive.Elusive;
import org.kordamp.ikonli.entypo.Entypo;
import org.kordamp.ikonli.evaicons.Evaicons;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.fluentui.FluentUiFilledAL;
import org.kordamp.ikonli.fluentui.FluentUiFilledMZ;
import org.kordamp.ikonli.fluentui.FluentUiRegularAL;
import org.kordamp.ikonli.fluentui.FluentUiRegularMZ;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.fontawesome5.FontAwesomeBrands;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.fontelico.Fontelico;
import org.kordamp.ikonli.foundation.Foundation;
import org.kordamp.ikonli.hawconsfilled.HawconsFilled;
import org.kordamp.ikonli.hawconsstroke.HawconsStroke;
import org.kordamp.ikonli.icomoon.Icomoon;
import org.kordamp.ikonli.ionicons.Ionicons;
import org.kordamp.ikonli.ionicons4.Ionicons4IOS;
import org.kordamp.ikonli.ionicons4.Ionicons4Logo;
import org.kordamp.ikonli.ionicons4.Ionicons4Material;
import org.kordamp.ikonli.ligaturesymbols.LigatureSymbols;
import org.kordamp.ikonli.lineawesome.LineAwesomeBrands;
import org.kordamp.ikonli.lineawesome.LineAwesomeRegular;
import org.kordamp.ikonli.lineawesome.LineAwesomeSolid;
import org.kordamp.ikonli.linecons.Linecons;
import org.kordamp.ikonli.maki.Maki;
import org.kordamp.ikonli.maki2.Maki2;
import org.kordamp.ikonli.mapicons.Mapicons;
import org.kordamp.ikonli.material.Material;
import org.kordamp.ikonli.materialdesign.MaterialDesignA;
import org.kordamp.ikonli.materialdesign.MaterialDesignB;
import org.kordamp.ikonli.materialdesign.MaterialDesignC;
import org.kordamp.ikonli.materialdesign.MaterialDesignD;
import org.kordamp.ikonli.materialdesign.MaterialDesignE;
import org.kordamp.ikonli.materialdesign.MaterialDesignF;
import org.kordamp.ikonli.materialdesign.MaterialDesignG;
import org.kordamp.ikonli.materialdesign.MaterialDesignH;
import org.kordamp.ikonli.materialdesign.MaterialDesignI;
import org.kordamp.ikonli.materialdesign.MaterialDesignJ;
import org.kordamp.ikonli.materialdesign.MaterialDesignK;
import org.kordamp.ikonli.materialdesign.MaterialDesignL;
import org.kordamp.ikonli.materialdesign.MaterialDesignM;
import org.kordamp.ikonli.materialdesign.MaterialDesignN;
import org.kordamp.ikonli.materialdesign.MaterialDesignO;
import org.kordamp.ikonli.materialdesign.MaterialDesignP;
import org.kordamp.ikonli.materialdesign.MaterialDesignQ;
import org.kordamp.ikonli.materialdesign.MaterialDesignR;
import org.kordamp.ikonli.materialdesign.MaterialDesignS;
import org.kordamp.ikonli.materialdesign.MaterialDesignT;
import org.kordamp.ikonli.materialdesign.MaterialDesignU;
import org.kordamp.ikonli.materialdesign.MaterialDesignV;
import org.kordamp.ikonli.materialdesign.MaterialDesignW;
import org.kordamp.ikonli.materialdesign.MaterialDesignX;
import org.kordamp.ikonli.materialdesign.MaterialDesignY;
import org.kordamp.ikonli.materialdesign.MaterialDesignZ;
import org.kordamp.ikonli.medicons.Medicons;
import org.kordamp.ikonli.metrizeicons.MetrizeIcons;
import org.kordamp.ikonli.microns.Microns;
import org.kordamp.ikonli.ociicons.Ociicons;
import org.kordamp.ikonli.octicons.Octicons;
import org.kordamp.ikonli.openiconic.Openiconic;
import org.kordamp.ikonli.paymentfont.PaymentFont;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.remixicon.RemixiconMZ;
import org.kordamp.ikonli.runestroicons.Runestroicons;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.themify.Themify;
import org.kordamp.ikonli.typicons.Typicons;
import org.kordamp.ikonli.weathericons.WeatherIcons;
import org.kordamp.ikonli.websymbols.Websymbols;
import org.kordamp.ikonli.win10.Win10;
import org.kordamp.ikonli.zondicons.Zondicons;

import javax.swing.*;
import java.awt.*;
import java.util.EnumSet;

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

        createTab(tabPane, Captainicon.class, new DemoTab(allOf(Captainicon.class)));
        createTab(tabPane, CoreUiBrands.class, new DemoTab(allOf(CoreUiBrands.class)));
        createTab(tabPane, CoreUiFree.class, new DemoTab(allOf(CoreUiFree.class)));
        createTab(tabPane, Dashicons.class, new DemoTab(allOf(Dashicons.class)));
        createTab(tabPane, Devicons.class, new DemoTab(allOf(Devicons.class)));
        createTab(tabPane, Elusive.class, new DemoTab(allOf(Elusive.class)));
        createTab(tabPane, Entypo.class, new DemoTab(allOf(Entypo.class)));
        createTab(tabPane, Evaicons.class, new DemoTab(allOf(Evaicons.class)));
        createTab(tabPane, Feather.class, new DemoTab(allOf(Feather.class)));
        createTab(tabPane, FluentUiFilledAL.class, new DemoTab(allOf(FluentUiFilledAL.class)));
        createTab(tabPane, FluentUiFilledMZ.class, new DemoTab(allOf(FluentUiFilledMZ.class)));
        createTab(tabPane, FluentUiRegularAL.class, new DemoTab(allOf(FluentUiRegularAL.class)));
        createTab(tabPane, FluentUiRegularMZ.class, new DemoTab(allOf(FluentUiRegularMZ.class)));
        createTab(tabPane, FontAwesome.class, new DemoTab(allOf(FontAwesome.class)));
        createTab(tabPane, FontAwesomeBrands.class, new DemoTab(allOf(FontAwesomeBrands.class)));
        createTab(tabPane, FontAwesomeSolid.class, new DemoTab(allOf(FontAwesomeSolid.class)));
        createTab(tabPane, FontAwesomeRegular.class, new DemoTab(allOf(FontAwesomeRegular.class)));
        createTab(tabPane, Fontelico.class, new DemoTab(allOf(Fontelico.class)));
        createTab(tabPane, Foundation.class, new DemoTab(allOf(Foundation.class)));
        createTab(tabPane, HawconsFilled.class, new DemoTab(allOf(HawconsFilled.class)));
        createTab(tabPane, HawconsStroke.class, new DemoTab(allOf(HawconsStroke.class)));
        createTab(tabPane, Icomoon.class, new DemoTab(allOf(Icomoon.class)));
        createTab(tabPane, Ionicons4IOS.class, new DemoTab(allOf(Ionicons4IOS.class)));
        createTab(tabPane, Ionicons4Material.class, new DemoTab(allOf(Ionicons4Material.class)));
        createTab(tabPane, Ionicons4Logo.class, new DemoTab(allOf(Ionicons4Logo.class)));
        createTab(tabPane, Ionicons.class, new DemoTab(allOf(Ionicons.class)));
        createTab(tabPane, Ionicons4Material.class, new DemoTab(allOf(Ionicons4Material.class)));
        createTab(tabPane, Ionicons4IOS.class, new DemoTab(allOf(Ionicons4IOS.class)));
        createTab(tabPane, Ionicons4Logo.class, new DemoTab(allOf(Ionicons4Logo.class)));
        createTab(tabPane, LigatureSymbols.class, new DemoTab(allOf(LigatureSymbols.class)));
        createTab(tabPane, LineAwesomeBrands.class, new DemoTab(allOf(LineAwesomeBrands.class)));
        createTab(tabPane, LineAwesomeSolid.class, new DemoTab(allOf(LineAwesomeSolid.class)));
        createTab(tabPane, LineAwesomeRegular.class, new DemoTab(allOf(LineAwesomeRegular.class)));
        createTab(tabPane, Linecons.class, new DemoTab(allOf(Linecons.class)));
        createTab(tabPane, Maki.class, new DemoTab(allOf(Maki.class)));
        createTab(tabPane, Maki2.class, new DemoTab(allOf(Maki2.class)));
        createTab(tabPane, Mapicons.class, new DemoTab(allOf(Mapicons.class)));
        createTab(tabPane, Material.class, new DemoTab(allOf(Material.class)));
        createTab(tabPane, MaterialDesignA.class, new DemoTab(allOf(MaterialDesignA.class)));
        createTab(tabPane, MaterialDesignB.class, new DemoTab(allOf(MaterialDesignB.class)));
        createTab(tabPane, MaterialDesignC.class, new DemoTab(allOf(MaterialDesignC.class)));
        createTab(tabPane, MaterialDesignD.class, new DemoTab(allOf(MaterialDesignD.class)));
        createTab(tabPane, MaterialDesignE.class, new DemoTab(allOf(MaterialDesignE.class)));
        createTab(tabPane, MaterialDesignF.class, new DemoTab(allOf(MaterialDesignF.class)));
        createTab(tabPane, MaterialDesignG.class, new DemoTab(allOf(MaterialDesignG.class)));
        createTab(tabPane, MaterialDesignH.class, new DemoTab(allOf(MaterialDesignH.class)));
        createTab(tabPane, MaterialDesignI.class, new DemoTab(allOf(MaterialDesignI.class)));
        createTab(tabPane, MaterialDesignJ.class, new DemoTab(allOf(MaterialDesignJ.class)));
        createTab(tabPane, MaterialDesignK.class, new DemoTab(allOf(MaterialDesignK.class)));
        createTab(tabPane, MaterialDesignL.class, new DemoTab(allOf(MaterialDesignL.class)));
        createTab(tabPane, MaterialDesignM.class, new DemoTab(allOf(MaterialDesignM.class)));
        createTab(tabPane, MaterialDesignN.class, new DemoTab(allOf(MaterialDesignN.class)));
        createTab(tabPane, MaterialDesignO.class, new DemoTab(allOf(MaterialDesignO.class)));
        createTab(tabPane, MaterialDesignP.class, new DemoTab(allOf(MaterialDesignP.class)));
        createTab(tabPane, MaterialDesignQ.class, new DemoTab(allOf(MaterialDesignQ.class)));
        createTab(tabPane, MaterialDesignR.class, new DemoTab(allOf(MaterialDesignR.class)));
        createTab(tabPane, MaterialDesignS.class, new DemoTab(allOf(MaterialDesignS.class)));
        createTab(tabPane, MaterialDesignT.class, new DemoTab(allOf(MaterialDesignT.class)));
        createTab(tabPane, MaterialDesignU.class, new DemoTab(allOf(MaterialDesignU.class)));
        createTab(tabPane, MaterialDesignV.class, new DemoTab(allOf(MaterialDesignV.class)));
        createTab(tabPane, MaterialDesignW.class, new DemoTab(allOf(MaterialDesignW.class)));
        createTab(tabPane, MaterialDesignX.class, new DemoTab(allOf(MaterialDesignX.class)));
        createTab(tabPane, MaterialDesignY.class, new DemoTab(allOf(MaterialDesignY.class)));
        createTab(tabPane, MaterialDesignZ.class, new DemoTab(allOf(MaterialDesignZ.class)));
        createTab(tabPane, Medicons.class, new DemoTab(allOf(Medicons.class)));
        createTab(tabPane, MetrizeIcons.class, new DemoTab(allOf(MetrizeIcons.class)));
        createTab(tabPane, Microns.class, new DemoTab(allOf(Microns.class)));
        createTab(tabPane, Ociicons.class, new DemoTab(allOf(Ociicons.class)));
        createTab(tabPane, Octicons.class, new DemoTab(allOf(Octicons.class)));
        createTab(tabPane, Openiconic.class, new DemoTab(allOf(Openiconic.class)));
        createTab(tabPane, PaymentFont.class, new DemoTab(allOf(PaymentFont.class)));
        createTab(tabPane, RemixiconAL.class, new DemoTab(allOf(RemixiconAL.class)));
        createTab(tabPane, RemixiconMZ.class, new DemoTab(allOf(RemixiconMZ.class)));
        createTab(tabPane, Runestroicons.class, new DemoTab(allOf(Runestroicons.class)));
        createTab(tabPane, Typicons.class, new DemoTab(allOf(Typicons.class)));
        createTab(tabPane, Themify.class, new DemoTab(allOf(Themify.class)));
        createTab(tabPane, WeatherIcons.class, new DemoTab(allOf(WeatherIcons.class)));
        createTab(tabPane, Websymbols.class, new DemoTab(allOf(Websymbols.class)));
        createTab(tabPane, Win10.class, new DemoTab(allOf(Win10.class)));
        createTab(tabPane, Zondicons.class, new DemoTab(allOf(Zondicons.class)));

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
