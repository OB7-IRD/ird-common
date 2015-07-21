/*
 * $Id: OTUtils.java 509 2015-02-26 10:39:32Z lebranch $
 *
 * Copyright (C) 2013 Julien Lebranchu <julien.lebranchu@ird.fr>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.ird.common;

import fr.ird.common.list.comprehesion.Func;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Miscellaneous class utility methods for the purposes of OT. Un quadrant est
 * une répsentation du globe divisé en quatre au niveau de l'équateur et du
 * «Prime Meridian».
 *
 * @see
 * <a href="http://commons.wikimedia.org/wiki/File:Cartesian-coordinate-system-with-quadrant.svg">Cartesian
 * coordinate system with quadrant</a>
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @version 1.0
 * @since 1.0
 * @date 14 févr. 2014
 *
 * $LastChangedDate: 2015-02-26 11:39:32 +0100 (jeu. 26 févr. 2015) $
 *
 * $LastChangedRevision: 509 $
 */
public class OTUtils extends Utils {

    /**
     * Transforms some coordinates in <em>Degrees Decimal</em> to <em>Degrees
     * Minutes</em>.
     *
     * @param coord the longitude or latitute in degrees decimal
     * @return Integer the value in degrees minutes
     */
    public static int degreesDecimalToDegreesMinutes(final Double coord) {
        final Double nCoord = Math.abs(coord);
        long resultat = 100 * (int) Math.floor(nCoord);
        resultat += Math.round((nCoord * 60) % 60);
        return (int) resultat;
    }

    /**
     * Transforms some coordinates in <em>Degrees Minutes</em> to <em>Degrees
     * Decimal</em>.
     *
     * @param coord the longitude or latitute in degrees minute
     * @return Double the value in degrees decimal
     */
    public static double degreesMinutesToDegreesDecimal(final Integer coord) {
        final double resFloor = Math.floor(coord / 100);
        final double resDecimal = ((coord / 100.0) % 1) / 60 * 100;
        return resDecimal + resFloor;
    }

    /**
     * Donne le degré décimale associée à l'orientation de la rose des vents.
     * Par exemple, l'orientation E, pour EAST, retournera 90.0.
     *
     * @param orientation une orientation de la rose des vents
     * @return Double the value in degrees decimal
     */
    public static double compassRoseToDegres(final String orientation) {
        return getCompassRose().get(orientation);
    }
    public static final String NORTH = "N";
    public static final String NORTH_BY_EAST = "NbE";
    public static final String NORTH_NORTHEAST = "NNE";
    public static final String NORTHEAST_BY_NORTH = "NEbN";
    public static final String NORTHEAST = "NE";
    public static final String NORTHEAST_BY_EAST = "NEbE";
    public static final String EAST_NORTHEAST = "ENE";
    public static final String EAST_BY_NORTH = "EbN";
    public static final String EAST = "E";
    public static final String EAST_BY_SOUTH = "EbS";
    public static final String EAST_SOUTHEAST = "ESE";
    public static final String SOUTHEAST_BY_EAST = "SEbE";
    public static final String SOUTHEAST = "SE";
    public static final String SOUTHEAST_BY_SOUTH = "SEbS";
    public static final String SOUTH_SOUTHEAST = "SSE";
    public static final String SOUTH_BY_EAST = "SbE";
    public static final String SOUTH = "S";
    public static final String SOUTH_BY_WEST = "SbW";
    public static final String SOUTH_SOUTHWEST = "SSW";
    public static final String SOUTHWEST_BY_SOUTH = "SWbS";
    public static final String SOUTHWEST = "SW";
    public static final String SOUTHWEST_BY_WEST = "SWbW";
    public static final String WEST_SOUTHWEST = "WSW";
    public static final String WEST_BY_SOUTH = "WbS";
    public static final String WEST = "W";
    public static final String WEST_BY_NORTH = "WbN";
    public static final String WEST_NORTHWEST = "WNW";
    public static final String NORTHWEST_BY_WEST = "NWbW";
    public static final String NORTHWEST = "NW";
    public static final String NORTHWEST_BY_NORTH = "NWbN";
    public static final String NORTH_NORTHWEST = "NNW";
    public static final String NORTH_BY_WEST = "NbW";
    public static final Double NORTH_DEGRE = 0.0;
    public static final Double NORTH_BY_EAST_DEGRE = 11.25;
    public static final Double NORTH_NORTHEAST_DEGRE = 22.5;
    public static final Double NORTHEAST_BY_NORTH_DEGRE = 33.75;
    public static final Double NORTHEAST_DEGRE = 45.0;
    public static final Double NORTHEAST_BY_EAST_DEGRE = 56.25;
    public static final Double EAST_NORTHEAST_DEGRE = 67.5;
    public static final Double EAST_BY_NORTH_DEGRE = 78.75;
    public static final Double EAST_DEGRE = 90.0;
    public static final Double EAST_BY_SOUTH_DEGRE = 101.25;
    public static final Double EAST_SOUTHEAST_DEGRE = 112.5;
    public static final Double SOUTHEAST_BY_EAST_DEGRE = 123.75;
    public static final Double SOUTHEAST_DEGRE = 135.0;
    public static final Double SOUTHEAST_BY_SOUTH_DEGRE = 146.25;
    public static final Double SOUTH_SOUTHEAST_DEGRE = 157.5;
    public static final Double SOUTH_BY_EAST_DEGRE = 168.75;
    public static final Double SOUTH_DEGRE = 180.0;
    public static final Double SOUTH_BY_WEST_DEGRE = 191.25;
    public static final Double SOUTH_SOUTHWEST_DEGRE = 202.5;
    public static final Double SOUTHWEST_BY_SOUTH_DEGRE = 213.75;
    public static final Double SOUTHWEST_DEGRE = 225.0;
    public static final Double SOUTHWEST_BY_WEST_DEGRE = 236.25;
    public static final Double WEST_SOUTHWEST_DEGRE = 247.5;
    public static final Double WEST_BY_SOUTH_DEGRE = 258.75;
    public static final Double WEST_DEGRE = 270.0;
    public static final Double WEST_BY_NORTH_DEGRE = 281.25;
    public static final Double WEST_NORTHWEST_DEGRE = 292.5;
    public static final Double NORTHWEST_BY_WEST_DEGRE = 303.75;
    public static final Double NORTHWEST_DEGRE = 315.0;
    public static final Double NORTHWEST_BY_NORTH_DEGRE = 326.25;
    public static final Double NORTH_NORTHWEST_DEGRE = 337.5;
    public static final Double NORTH_BY_WEST_DEGRE = 348.75;
    private static HashMap<String, Double> compassRose;

    /**
     * Association de chaque orientation au sein de la rose des vents au dégré
     * décimal associé.
     *
     * @return la rose des vents
     */
    public static Map<String, Double> getCompassRose() {
        if (compassRose == null) {
            compassRose = new HashMap<String, Double>();
            compassRose.put(OTUtils.NORTH, OTUtils.NORTH_DEGRE);
            compassRose.put(OTUtils.NORTH_BY_EAST, OTUtils.NORTH_BY_EAST_DEGRE);
            compassRose.put(OTUtils.NORTH_NORTHEAST, OTUtils.NORTH_NORTHEAST_DEGRE);
            compassRose.put(OTUtils.NORTHEAST_BY_NORTH, OTUtils.NORTHEAST_BY_NORTH_DEGRE);
            compassRose.put(OTUtils.NORTHEAST, OTUtils.NORTHEAST_DEGRE);
            compassRose.put(OTUtils.NORTHEAST_BY_EAST, OTUtils.NORTHEAST_BY_EAST_DEGRE);
            compassRose.put(OTUtils.EAST_NORTHEAST, OTUtils.EAST_NORTHEAST_DEGRE);
            compassRose.put(OTUtils.EAST_BY_NORTH, OTUtils.EAST_BY_NORTH_DEGRE);
            compassRose.put(OTUtils.EAST, OTUtils.EAST_DEGRE);
            compassRose.put(OTUtils.EAST_BY_SOUTH, OTUtils.EAST_BY_SOUTH_DEGRE);
            compassRose.put(OTUtils.EAST_SOUTHEAST, OTUtils.EAST_SOUTHEAST_DEGRE);
            compassRose.put(OTUtils.SOUTHEAST_BY_EAST, OTUtils.SOUTHEAST_BY_EAST_DEGRE);
            compassRose.put(OTUtils.SOUTHEAST, OTUtils.SOUTHEAST_DEGRE);
            compassRose.put(OTUtils.SOUTHEAST_BY_SOUTH, OTUtils.SOUTHEAST_BY_SOUTH_DEGRE);
            compassRose.put(OTUtils.SOUTH_SOUTHEAST, OTUtils.SOUTH_SOUTHEAST_DEGRE);
            compassRose.put(OTUtils.SOUTH_BY_EAST, OTUtils.SOUTH_BY_EAST_DEGRE);
            compassRose.put(OTUtils.SOUTH, OTUtils.SOUTH_DEGRE);
            compassRose.put(OTUtils.SOUTH_BY_WEST, OTUtils.SOUTH_BY_WEST_DEGRE);
            compassRose.put(OTUtils.SOUTH_SOUTHWEST, OTUtils.SOUTH_SOUTHWEST_DEGRE);
            compassRose.put(OTUtils.SOUTHWEST_BY_SOUTH, OTUtils.SOUTHWEST_BY_SOUTH_DEGRE);
            compassRose.put(OTUtils.SOUTHWEST, OTUtils.SOUTHWEST_DEGRE);
            compassRose.put(OTUtils.SOUTHWEST_BY_WEST, OTUtils.SOUTHWEST_BY_WEST_DEGRE);
            compassRose.put(OTUtils.WEST_SOUTHWEST, OTUtils.WEST_SOUTHWEST_DEGRE);
            compassRose.put(OTUtils.WEST_BY_SOUTH, OTUtils.WEST_BY_SOUTH_DEGRE);
            compassRose.put(OTUtils.WEST, OTUtils.WEST_DEGRE);
            compassRose.put(OTUtils.WEST_BY_NORTH, OTUtils.WEST_BY_NORTH_DEGRE);
            compassRose.put(OTUtils.WEST_NORTHWEST, OTUtils.WEST_NORTHWEST_DEGRE);
            compassRose.put(OTUtils.NORTHWEST_BY_WEST, OTUtils.NORTHWEST_BY_WEST_DEGRE);
            compassRose.put(OTUtils.NORTHWEST, OTUtils.NORTHWEST_DEGRE);
            compassRose.put(OTUtils.NORTHWEST_BY_NORTH, OTUtils.NORTHWEST_BY_NORTH_DEGRE);
            compassRose.put(OTUtils.NORTH_NORTHWEST, OTUtils.NORTH_NORTHWEST_DEGRE);
            compassRose.put(OTUtils.NORTH_BY_WEST, OTUtils.NORTH_BY_WEST_DEGRE);
        }
        return compassRose;
    }

    /**
     * Applique une fonction sur une liste. Par exemple, il est possible de
     * multiplier par deux toutes les valeurs d'une liste d'entier.
     *
     * @see {@link fr.ird.common.list.comprehesion.Func}
     * @param <T> le type genérique de la fonction
     * @param list la liste à traiter
     * @param f la fonction à appliquer
     */
    public static <T> void applyToListInPlace(List<T> list, Func<T, T> f) {
        ListIterator<T> itr = list.listIterator();
        while (itr.hasNext()) {
            T output = f.apply(itr.next());
            itr.set(output);
        }
    }

    /**
     * Creating a mapping from the input list to the output list.
     *
     * @see {@link fr.ird.common.list.comprehesion.Func}
     * @param <In> le type du paramètre d'entrée
     * @param <Out> le type du paramètre de sortie
     * @param in la liste d'entrée
     * @param f la fonction à appliquer
     * @return la nouvelle liste
     */
    public static <In, Out> List<Out> map(List<In> in, Func<In, Out> f) {
        List<Out> out = new ArrayList<Out>(in.size());
        for (In inObj : in) {
            out.add(f.apply(inObj));
        }
        return out;
    }

    /**
     * Convertit une latitude exprimée par un entier dans un quadrant en degré
     * décimal.
     *
     * @param quandrant représente le quadrant
     * @param latitude la latitude à signer
     * @return la latitude signé
     */
    public static int signLatitude(int quandrant, int latitude) {
        if (quandrant == 3 || quandrant == 2) {
            latitude = -1 * latitude;
        }
        return latitude;
    }

    /**
     * Convertit une longitude exprimée par un entier dans un quadrant en degré
     * décimal.
     *
     * @param quandrant représente le quadrant
     * @param longitude la longitude à convertir
     * @return la longitude en degré décimal
     */
    public static int signLongitude(int quandrant, int longitude) {
        if (quandrant == 3 || quandrant == 4) {
            longitude = -1 * longitude;
        }
        return longitude;
    }

    /**
     * Convertit une latitude exprimée par un entier dans un quadrant en degré
     * décimal.
     *
     * @param quandrant représente le quadrant
     * @param latitude la latitude à convertir
     * @return la latitude en degré décimal
     */
    public static Double convertLatitude(int quandrant, int latitude) {
        if (quandrant == 3 || quandrant == 2) {
            latitude = -1 * latitude;
        }
        return convertLatitude(latitude);
    }

    /**
     * Convertit une longitude exprimée par un entier dans un quadrant en degré
     * décimal.
     *
     * @param quandrant représente le quadrant
     * @param longitude la longitude à convertir
     * @return la longitude en degré décimal
     */
    public static Double convertLongitude(int quandrant, int longitude) {
        if (quandrant == 3 || quandrant == 4) {
            longitude = -1 * longitude;
        }
        return convertLongitude(longitude);
    }

    /**
     * Convertit une latitude exprimée par un entier signé en degré décimal.
     *
     *
     * @param latitude la latitude à convertir
     * @return la latitude en degré décimal
     */
    public static Double convertLatitude(int latitude) {
        return degreesMinutesToDegreesDecimal(latitude);

    }

    /**
     * Convertit une longitude exprimée par un entier signé en degré décimal.
     *
     *
     * @param longitude la longitude à convertir
     * @return la longitude en degré décimal
     */
    public static Double convertLongitude(int longitude) {
        return degreesMinutesToDegreesDecimal(longitude);

    }
}
