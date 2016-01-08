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
package org.kordamp.ikonli.weathericons;

import javafx.scene.text.Font;
import org.kordamp.ikonli.Ikon;

/**
 * @author Andres Almiray
 */
public enum WeatherIcons implements Ikon {
    // latest is f0c3
    ALIEN("wi-alien", '\uf075'),
    BAROMETER("wi-barometer", '\uf079'),
    CELSIUS("wi-celsius", '\uf03c'),
    CLOUD("wi-cloud", '\uf041'),
    CLOUDY("wi-cloudy", '\uf013'),
    CLOUDY_GUSTS("wi-cloudy-gusts", '\uf011'),
    CLOUDY_WINDY("wi-cloudy-windy", '\uf012'),
    CLOUD_DOWN("wi-cloud-down", '\uf03d'),
    CLOUD_REFRESH("wi-cloud-refresh", '\uf03e'),
    CLOUD_UP("wi-cloud-up", '\uf040'),
    DAY_CLOUDY("wi-day-cloudy", '\uf002'),
    DAY_CLOUDY_GUSTS("wi-day-cloudy-gusts", '\uf000'),
    DAY_CLOUDY_HIGH("wi-day-cloudy-high", '\uf07d'),
    DAY_CLOUDY_WINDY("wi-day-cloudy-windy", '\uf001'),
    DAY_FOG("wi-day-fog", '\uf003'),
    DAY_HAIL("wi-day-hail", '\uf004'),
    DAY_HAZE("wi-day-haze", '\uf0b6'),
    DAY_LIGHTNING("wi-day-lightning", '\uf005'),
    DAY_LIGHT_WIND("wi-day-light-wind", '\uf0c4'),
    DAY_RAIN("wi-day-rain", '\uf008'),
    DAY_RAIN_MIX("wi-day-rain-mix", '\uf006'),
    DAY_RAIN_WIND("wi-day-rain-wind", '\uf007'),
    DAY_SHOWERS("wi-day-showers", '\uf009'),
    DAY_SLEET("wi-day-sleet", '\uf0b2'),
    DAY_SLEET_STORM("wi-day-sleet-storm", '\uf068'),
    DAY_SNOW("wi-day-snow", '\uf00a'),
    DAY_SNOW_THUNDERSTORM("wi-day-snow-thunderstorm", '\uf06b'),
    DAY_SNOW_WIND("wi-day-snow-wind", '\uf065'),
    DAY_SPRINKLE("wi-day-sprinkle", '\uf00b'),
    DAY_STORM_SHOWERS("wi-day-storm-showers", '\uf00e'),
    DAY_SUNNY("wi-day-sunny", '\uf00d'),
    DAY_SUNNY_OVERCAST("wi-day-sunny-overcast", '\uf00c'),
    DAY_THUNDERSTORM("wi-day-thunderstorm", '\uf010'),
    DAY_WINDY("wi-day-windy", '\uf085'),
    DEGREES("wi-degrees", '\uf042'),
    DIRECTION_DOWN("wi-direction-down", '\uf044'),
    DIRECTION_DOWN_LEFT("wi-direction-down-left", '\uf043'),
    DIRECTION_DOWN_RIGHT("wi-direction-down-right", '\uf088'),
    DIRECTION_LEFT("wi-direction-left", '\uf048'),
    DIRECTION_RIGHT("wi-direction-right", '\uf04d'),
    DIRECTION_UP("wi-direction-up", '\uf058'),
    DIRECTION_UP_LEFT("wi-direction-up-left", '\uf087'),
    DIRECTION_UP_RIGHT("wi-direction-up-right", '\uf057'),
    DUST("wi-dust", '\uf063'),
    EARTHQUAKE("wi-earthquake", '\uf0c6'),
    FAHRENHEIT("wi-fahrenheit", '\uf045'),
    FIRE("wi-fire", '\uf0c7'),
    FLOOD("wi-flood", '\uf07c'),
    FOG("wi-fog", '\uf014'),
    GALE_WARNING("wi-gale-warning", '\uf0cd'),
    HAIL("wi-hail", '\uf015'),
    HORIZON("wi-horizon", '\uf047'),
    HORIZON_ALT("wi-horizon-alt", '\uf046'),
    HOT("wi-hot", '\uf072'),
    HUMIDITY("wi-humidity", '\uf07a'),
    HURRICANE("wi-hurricane", '\uf073'),
    HURRICANE_WARNING("wi-hurricane-warning", '\uf0cf'),
    LIGHTNING("wi-lightning", '\uf016'),
    LUNAR_ECLIPSE("wi-lunar-eclipse", '\uf070'),
    METEOR("wi-meteor", '\uf071'),
    MOONRISE("wi-moonrise", '\uf0c9'),
    MOONSET("wi-moonset", '\uf0ca'),
    MOON_FULL("wi-moon-full", '\uf0a3'),
    MOON_NEW("wi-moon-new", '\uf095'),
    MOON_WANING_CRESCENT_1("wi-moon-waning-crescent-1", '\uf0ab'),
    MOON_WANING_CRESCENT_2("wi-moon-waning-crescent-2", '\uf0ac'),
    MOON_WANING_CRESCENT_3("wi-moon-waning-crescent-3", '\uf0ad'),
    MOON_WANING_CRESCENT_4("wi-moon-waning-crescent-4", '\uf0ae'),
    MOON_WANING_CRESCENT_5("wi-moon-waning-crescent-5", '\uf0af'),
    MOON_WANING_CRESCENT_6("wi-moon-waning-crescent-6", '\uf0b0'),
    MOON_WANING_GIBBOUS_1("wi-moon-waning-gibbous-1", '\uf0a4'),
    MOON_WANING_GIBBOUS_2("wi-moon-waning-gibbous-2", '\uf0a5'),
    MOON_WANING_GIBBOUS_3("wi-moon-waning-gibbous-3", '\uf0a6'),
    MOON_WANING_GIBBOUS_4("wi-moon-waning-gibbous-4", '\uf0a7'),
    MOON_WANING_GIBBOUS_5("wi-moon-waning-gibbous-5", '\uf0a8'),
    MOON_WANING_GIBBOUS_6("wi-moon-waning-gibbous-6", '\uf0a9'),
    MOON_WAXING_CRESENT_1("wi-moon-waxing-cresent-1", '\uf096'),
    MOON_WAXING_CRESENT_2("wi-moon-waxing-cresent-2", '\uf097'),
    MOON_WAXING_CRESENT_3("wi-moon-waxing-cresent-3", '\uf098'),
    MOON_WAXING_CRESENT_4("wi-moon-waxing-cresent-4", '\uf099'),
    MOON_WAXING_CRESENT_5("wi-moon-waxing-cresent-5", '\uf09a'),
    MOON_WAXING_CRESENT_6("wi-moon-waxing-cresent-6", '\uf09b'),
    MOON_WAXING_GIBBOUS_1("wi-moon-waxing-gibbous-1", '\uf09d'),
    MOON_WAXING_GIBBOUS_2("wi-moon-waxing-gibbous-2", '\uf09e'),
    MOON_WAXING_GIBBOUS_3("wi-moon-waxing-gibbous-3", '\uf09f'),
    MOON_WAXING_GIBBOUS_4("wi-moon-waxing-gibbous-4", '\uf0a0'),
    MOON_WAXING_GIBBOUS_5("wi-moon-waxing-gibbous-5", '\uf0a1'),
    MOON_WAXING_GIBBOUS_6("wi-moon-waxing-gibbous-6", '\uf0a2'),
    NA("wi-na", '\uf07b'),
    NIGHT_ALT_CLOUDY("wi-night-alt-cloudy", '\uf086'),
    NIGHT_ALT_CLOUDY_GUSTS("wi-night-alt-cloudy-gusts", '\uf022'),
    NIGHT_ALT_CLOUDY_HIGH("wi-night-alt-cloudy-high", '\uf07e'),
    NIGHT_ALT_CLOUDY_WINDY("wi-night-alt-cloudy-windy", '\uf023'),
    NIGHT_ALT_HAIL("wi-night-alt-hail", '\uf024'),
    NIGHT_ALT_LIGHTNING("wi-night-alt-lightning", '\uf025'),
    NIGHT_ALT_PARTLY_CLOUDY("wi-night-alt-partly-cloudy", '\uf081'),
    NIGHT_ALT_RAIN("wi-night-alt-rain", '\uf028'),
    NIGHT_ALT_RAIN_MIX("wi-night-alt-rain-mix", '\uf026'),
    NIGHT_ALT_RAIN_WIND("wi-night-alt-rain-wind", '\uf027'),
    NIGHT_ALT_SHOWERS("wi-night-alt-showers", '\uf029'),
    NIGHT_ALT_SLEET("wi-night-alt-sleet", '\uf0b4'),
    NIGHT_ALT_SLEET_STORM("wi-night-alt-sleet-storm", '\uf06a'),
    NIGHT_ALT_SNOW("wi-night-alt-snow", '\uf02a'),
    NIGHT_ALT_SNOW_THUNDERSTORM("wi-night-alt-snow-thunderstorm", '\uf06d'),
    NIGHT_ALT_SNOW_WIND("wi-night-alt-snow-wind", '\uf067'),
    NIGHT_ALT_SPRINKLE("wi-night-alt-sprinkle", '\uf02b'),
    NIGHT_ALT_STORM_SHOWERS("wi-night-alt-storm-showers", '\uf02c'),
    NIGHT_ALT_THUNDERSTORM("wi-night-alt-thunderstorm", '\uf02d'),
    NIGHT_CLEAR("wi-night-clear", '\uf02e'),
    NIGHT_CLOUDY("wi-night-cloudy", '\uf031'),
    NIGHT_CLOUDY_GUSTS("wi-night-cloudy-gusts", '\uf02f'),
    NIGHT_CLOUDY_HIGH("wi-night-cloudy-high", '\uf080'),
    NIGHT_CLOUDY_WINDY("wi-night-cloudy-windy", '\uf030'),
    NIGHT_FOG("wi-night-fog", '\uf04a'),
    NIGHT_HAIL("wi-night-hail", '\uf032'),
    NIGHT_LIGHTNING("wi-night-lightning", '\uf033'),
    NIGHT_PARTLY_CLOUDY("wi-night-partly-cloudy", '\uf083'),
    NIGHT_RAIN("wi-night-rain", '\uf036'),
    NIGHT_RAIN_MIX("wi-night-rain-mix", '\uf034'),
    NIGHT_RAIN_WIND("wi-night-rain-wind", '\uf035'),
    NIGHT_SHOWERS("wi-night-showers", '\uf037'),
    NIGHT_SLEET("wi-night-sleet", '\uf0b3'),
    NIGHT_SLEET_STORM("wi-night-sleet-storm", '\uf069'),
    NIGHT_SNOW("wi-night-snow", '\uf038'),
    NIGHT_SNOW_THUNDERSTORM("wi-night-snow-thunderstorm", '\uf06c'),
    NIGHT_SNOW_WIND("wi-night-snow-wind", '\uf066'),
    NIGHT_SPRINKLE("wi-night-sprinkle", '\uf039'),
    NIGHT_STORM_SHOWERS("wi-night-storm-showers", '\uf03a'),
    NIGHT_THUNDERSTORM("wi-night-thunderstorm", '\uf03b'),
    RAIN("wi-rain", '\uf019'),
    RAINDROP("wi-raindrop", '\uf078'),
    RAINDROPS("wi-raindrops", '\uf04e'),
    RAIN_MIX("wi-rain-mix", '\uf017'),
    RAIN_WIND("wi-rain-wind", '\uf018'),
    REFRESH("wi-refresh", '\uf04c'),
    REFRESH_ALT("wi-refresh-alt", '\uf04b'),
    SANDSTORM("wi-sandstorm", '\uf082'),
    SHOWERS("wi-showers", '\uf01a'),
    SLEET("wi-sleet", '\uf0b5'),
    SMALL_CRAFT_ADVISORY("wi-small-craft-advisory", '\uf0cc'),
    SMOG("wi-smog", '\uf074'),
    SMOKE("wi-smoke", '\uf062'),
    SNOW("wi-snow", '\uf01b'),
    SNOWFLAKE_COLD("wi-snowflake-cold", '\uf076'),
    SNOW_WIND("wi-snow-wind", '\uf064'),
    SOLAR_ECLIPSE("wi-solar-eclipse", '\uf06e'),
    SPRINKLE("wi-sprinkle", '\uf01c'),
    STARS("wi-stars", '\uf077'),
    STORM_SHOWERS("wi-storm-showers", '\uf01d'),
    STORM_WARNING("wi-storm-warning", '\uf0ce'),
    STRONG_WIND("wi-strong-wind", '\uf050'),
    SUNRISE("wi-sunrise", '\uf051'),
    SUNSET("wi-sunset", '\uf052'),
    THERMOMETER("wi-thermometer", '\uf055'),
    THERMOMETER_EXTERIOR("wi-thermometer-exterior", '\uf053'),
    THERMOMETER_INTERNAL("wi-thermometer-internal", '\uf054'),
    THUNDERSTORM("wi-thunderstorm", '\uf01e'),
    TIME_1("wi-time-1", '\uf08a'),
    TIME_10("wi-time-10", '\uf093'),
    TIME_11("wi-time-11", '\uf094'),
    TIME_12("wi-time-12", '\uf089'),
    TIME_2("wi-time-2", '\uf08b'),
    TIME_3("wi-time-3", '\uf08c'),
    TIME_4("wi-time-4", '\uf08d'),
    TIME_5("wi-time-5", '\uf08e'),
    TIME_6("wi-time-6", '\uf08f'),
    TIME_7("wi-time-7", '\uf090'),
    TIME_8("wi-time-8", '\uf091'),
    TIME_9("wi-time-9", '\uf092'),
    TORNADO("wi-tornado", '\uf056'),
    TRAIN("wi-train", '\uf0cb'),
    TSUNAMI("wi-tsunami", '\uf0c5'),
    UMBRELLA("wi-umbrella", '\uf084'),
    VOLCANO("wi-volcano", '\uf0c8'),
    WINDY("wi-windy", '\uf021'),
    WIND_BEAUFORT_0("wi-wind-beaufort-0", '\uf0b7'),
    WIND_BEAUFORT_1("wi-wind-beaufort-1", '\uf0b8'),
    WIND_BEAUFORT_10("wi-wind-beaufort-10", '\uf0c1'),
    WIND_BEAUFORT_11("wi-wind-beaufort-11", '\uf0c2'),
    WIND_BEAUFORT_12("wi-wind-beaufort-12", '\uf0c3'),
    WIND_BEAUFORT_2("wi-wind-beaufort-2", '\uf0b9'),
    WIND_BEAUFORT_3("wi-wind-beaufort-3", '\uf0ba'),
    WIND_BEAUFORT_4("wi-wind-beaufort-4", '\uf0bb'),
    WIND_BEAUFORT_5("wi-wind-beaufort-5", '\uf0bc'),
    WIND_BEAUFORT_6("wi-wind-beaufort-6", '\uf0bd'),
    WIND_BEAUFORT_7("wi-wind-beaufort-7", '\uf0be'),
    WIND_BEAUFORT_8("wi-wind-beaufort-8", '\uf0bf'),
    WIND_BEAUFORT_9("wi-wind-beaufort-9", '\uf0c0'),
    WIND_DIRECTION("wi-wind-direction", '\uf0b1');

    private static final String FONT_RESOURCE = "META-INF/resources/weathericons/2.0.1/fonts/weathericons-regular-webfont.ttf";
    private static final Font FONT;

    static {
        FONT = Font.loadFont(WeatherIcons.class.getClassLoader().getResource(FONT_RESOURCE).toExternalForm(), 16);
    }

    public static WeatherIcons findByDescription(String description) {
        for (WeatherIcons font : values()) {
            if (font.getDescription().equals(description)) {
                return font;
            }
        }
        throw new IllegalArgumentException("Icon description '" + description + "' is invalid!");
    }

    public static Font getFont() {
        return FONT;
    }

    private String description;
    private char code;

    WeatherIcons(String description, char code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getFontFamily() {
        return FONT.getFamily();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public char getCode() {
        return code;
    }
}