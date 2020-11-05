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
package org.kordamp.ikonli.sampler.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.bpmn.Bpmn;
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
import org.kordamp.ikonli.javafx.FontIcon;
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
import org.kordamp.ikonli.simpleicons.SimpleIcons;
import org.kordamp.ikonli.themify.Themify;
import org.kordamp.ikonli.typicons.Typicons;
import org.kordamp.ikonli.weathericons.WeatherIcons;
import org.kordamp.ikonli.websymbols.Websymbols;
import org.kordamp.ikonli.win10.Win10;
import org.kordamp.ikonli.zondicons.Zondicons;

import java.net.URL;
import java.util.EnumSet;

import static java.util.EnumSet.allOf;

/**
 * @author Andres Almiray
 */
public class Sampler extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL location = getClass().getResource("sampler.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        TabPane tabPane = fxmlLoader.load();
        tabPane.getTabs().add(new DemoTab(Bpmn.class, allOf(Bpmn.class)));
        tabPane.getTabs().add(new DemoTab(Captainicon.class, allOf(Captainicon.class)));
        tabPane.getTabs().add(new DemoTab(CoreUiBrands.class, allOf(CoreUiBrands.class)));
        tabPane.getTabs().add(new DemoTab(CoreUiFree.class, allOf(CoreUiFree.class)));
        tabPane.getTabs().add(new DemoTab(Dashicons.class, allOf(Dashicons.class)));
        tabPane.getTabs().add(new DemoTab(Devicons.class, allOf(Devicons.class)));
        tabPane.getTabs().add(new DemoTab(Elusive.class, allOf(Elusive.class)));
        tabPane.getTabs().add(new DemoTab(Entypo.class, allOf(Entypo.class)));
        tabPane.getTabs().add(new DemoTab(Evaicons.class, allOf(Evaicons.class)));
        tabPane.getTabs().add(new DemoTab(Feather.class, allOf(Feather.class)));
        tabPane.getTabs().add(new DemoTab(FluentUiFilledAL.class, allOf(FluentUiFilledAL.class)));
        tabPane.getTabs().add(new DemoTab(FluentUiFilledMZ.class, allOf(FluentUiFilledMZ.class)));
        tabPane.getTabs().add(new DemoTab(FluentUiRegularAL.class, allOf(FluentUiRegularAL.class)));
        tabPane.getTabs().add(new DemoTab(FluentUiRegularMZ.class, allOf(FluentUiRegularMZ.class)));
        tabPane.getTabs().add(new DemoTab(FontAwesome.class, allOf(FontAwesome.class)));
        tabPane.getTabs().add(new DemoTab(FontAwesomeBrands.class, allOf(FontAwesomeBrands.class)));
        tabPane.getTabs().add(new DemoTab(FontAwesomeSolid.class, allOf(FontAwesomeSolid.class)));
        tabPane.getTabs().add(new DemoTab(FontAwesomeRegular.class, allOf(FontAwesomeRegular.class)));
        tabPane.getTabs().add(new DemoTab(Fontelico.class, allOf(Fontelico.class)));
        tabPane.getTabs().add(new DemoTab(Foundation.class, allOf(Foundation.class)));
        tabPane.getTabs().add(new DemoTab(HawconsFilled.class, allOf(HawconsFilled.class)));
        tabPane.getTabs().add(new DemoTab(HawconsStroke.class, allOf(HawconsStroke.class)));
        tabPane.getTabs().add(new DemoTab(Icomoon.class, allOf(Icomoon.class)));
        tabPane.getTabs().add(new DemoTab(Ionicons4Material.class, allOf(Ionicons4Material.class)));
        tabPane.getTabs().add(new DemoTab(Ionicons4IOS.class, allOf(Ionicons4IOS.class)));
        tabPane.getTabs().add(new DemoTab(Ionicons4Logo.class, allOf(Ionicons4Logo.class)));
        tabPane.getTabs().add(new DemoTab(Ionicons.class, allOf(Ionicons.class)));
        tabPane.getTabs().add(new DemoTab(LigatureSymbols.class, allOf(LigatureSymbols.class)));
        tabPane.getTabs().add(new DemoTab(LineAwesomeBrands.class, allOf(LineAwesomeBrands.class)));
        tabPane.getTabs().add(new DemoTab(LineAwesomeSolid.class, allOf(LineAwesomeSolid.class)));
        tabPane.getTabs().add(new DemoTab(LineAwesomeRegular.class, allOf(LineAwesomeRegular.class)));
        tabPane.getTabs().add(new DemoTab(Linecons.class, allOf(Linecons.class)));
        tabPane.getTabs().add(new DemoTab(Maki.class, allOf(Maki.class)));
        tabPane.getTabs().add(new DemoTab(Maki2.class, allOf(Maki2.class)));
        tabPane.getTabs().add(new DemoTab(Mapicons.class, allOf(Mapicons.class)));
        tabPane.getTabs().add(new DemoTab(Material.class, allOf(Material.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignA.class, allOf(MaterialDesignA.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignB.class, allOf(MaterialDesignB.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignC.class, allOf(MaterialDesignC.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignD.class, allOf(MaterialDesignD.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignE.class, allOf(MaterialDesignE.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignF.class, allOf(MaterialDesignF.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignG.class, allOf(MaterialDesignG.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignH.class, allOf(MaterialDesignH.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignI.class, allOf(MaterialDesignI.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignJ.class, allOf(MaterialDesignJ.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignK.class, allOf(MaterialDesignK.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignL.class, allOf(MaterialDesignL.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignM.class, allOf(MaterialDesignM.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignN.class, allOf(MaterialDesignN.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignO.class, allOf(MaterialDesignO.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignP.class, allOf(MaterialDesignP.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignQ.class, allOf(MaterialDesignQ.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignR.class, allOf(MaterialDesignR.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignS.class, allOf(MaterialDesignS.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignT.class, allOf(MaterialDesignT.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignU.class, allOf(MaterialDesignU.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignV.class, allOf(MaterialDesignV.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignW.class, allOf(MaterialDesignW.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignX.class, allOf(MaterialDesignX.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignY.class, allOf(MaterialDesignY.class)));
        tabPane.getTabs().add(new DemoTab(MaterialDesignZ.class, allOf(MaterialDesignZ.class)));
        tabPane.getTabs().add(new DemoTab(Medicons.class, allOf(Medicons.class)));
        tabPane.getTabs().add(new DemoTab(MetrizeIcons.class, allOf(MetrizeIcons.class)));
        tabPane.getTabs().add(new DemoTab(Microns.class, allOf(Microns.class)));
        tabPane.getTabs().add(new DemoTab(Ociicons.class, allOf(Ociicons.class)));
        tabPane.getTabs().add(new DemoTab(Octicons.class, allOf(Octicons.class)));
        tabPane.getTabs().add(new DemoTab(Openiconic.class, allOf(Openiconic.class)));
        tabPane.getTabs().add(new DemoTab(PaymentFont.class, allOf(PaymentFont.class)));
        tabPane.getTabs().add(new DemoTab(RemixiconAL.class, allOf(RemixiconAL.class)));
        tabPane.getTabs().add(new DemoTab(RemixiconMZ.class, allOf(RemixiconMZ.class)));
        tabPane.getTabs().add(new DemoTab(Runestroicons.class, allOf(Runestroicons.class)));
        tabPane.getTabs().add(new DemoTab(SimpleIcons.class, allOf(SimpleIcons.class)));
        tabPane.getTabs().add(new DemoTab(Themify.class, allOf(Themify.class)));
        tabPane.getTabs().add(new DemoTab(Typicons.class, allOf(Typicons.class)));
        tabPane.getTabs().add(new DemoTab(WeatherIcons.class, allOf(WeatherIcons.class)));
        tabPane.getTabs().add(new DemoTab(Websymbols.class, allOf(Websymbols.class)));
        tabPane.getTabs().add(new DemoTab(Win10.class, allOf(Win10.class)));
        tabPane.getTabs().add(new DemoTab(Zondicons.class, allOf(Zondicons.class)));

        Scene scene = new Scene(tabPane);
        scene.getStylesheets().add("org/kordamp/ikonli/sampler/javafx/sampler.css");

        primaryStage.setTitle("Ikonli Sampler");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(1024);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Sampler.class);
    }

    private static class DemoTab extends Tab {
        private DemoTab(Class<? extends Ikon> iconFontClass, EnumSet<? extends Ikon> enumSet) throws Exception {
            super(iconFontClass.getSimpleName());
            setClosable(false);

            GridPane pane = new GridPane();
            ScrollPane scrollPane = new ScrollPane(pane);
            setContent(scrollPane);

            int column = 0;
            int row = 0;
            int index = 0;
            for (Ikon value : enumSet) {
                FontIcon icon = FontIcon.of(value);
                icon.getStyleClass().setAll("font-icon");
                pane.add(icon, column++, row);
                GridPane.setMargin(icon, new Insets(10, 10, 10, 10));
                if (++index % 10 == 0) {
                    column = 0;
                    row++;
                }
            }
        }
    }
}
