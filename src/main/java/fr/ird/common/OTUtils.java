package fr.ird.common;

import java.util.HashMap;

/**
 * Miscellaneous class utility methods for the purposes of OT.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @version 1.0
 * @since 1.0
 * @date 14 févr. 2014
 */
public class OTUtils extends Utils {

    /**
     * Transforms some coordinates in <em>Degrees Decimal</em> to <em>Degrees
     * Minutes</em>.
     *
     * @param coord the longitude or latitute in degrees decimal
     * @return Integer the value in degrees minutes
     */
    public static Integer degreesDecimalToDegreesMinutes(Double coord) {
        coord = Math.abs(coord);
        long resultat = 100 * (int) Math.floor(coord);
        resultat += Math.round((coord * 60) % 60);
        return (int) resultat;
    }

    /**
     * Donne la valeur décimale associée à l'orientation de la rose des vents.
     *
     * @param cr
     * @return
     */
    public static double compassRoseToDegres(String cr) {
        return getCompassRose().get(cr);
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
     * @return
     */
    public static HashMap<String, Double> getCompassRose() {
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
}