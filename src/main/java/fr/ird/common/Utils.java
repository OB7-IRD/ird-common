/*
 * $Id$
 *
 * Copyright (C) 2013 Julien Lebranchu <julien.lebranchu@ird.fr>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
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

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Miscellaneous class utility methods.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.0
 * @date 13 déc. 2013
 *
 * $LastChangedDate$
 *
 * $LastChangedRevision$
 */
public class Utils {

    public static void printMatrix(List<Map<String, Object>> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("\n\n*******************************************");
            System.out.println("\t\tNo result");
            System.out.println("*******************************************\n\n");
            return;
        }
        final PrettyPrinter printer = new PrettyPrinter(System.out);
        String[][] resultsArray2D = null;
        String[] array = null;
        int i = 0;
        int pos = 0;
        for (Map<String, Object> result : results) {
            if (i == 0) {//Rempli le tableau avec les entetes
                resultsArray2D = new String[results.size() + 1][result.entrySet().size() + 1];
                pos = 0;
                array = new String[result.entrySet().size() + 1];
                array[pos] = "Nb";
                for (Map.Entry<String, Object> entry : result.entrySet()) {
                    pos += 1;
                    array[pos] = entry.getKey();
                }
                resultsArray2D[i] = array;
            }
            i += 1;
            pos = 0;
            array = new String[result.entrySet().size() + 1];
            array[pos] = "" + i;
            for (Map.Entry<String, Object> entry : result.entrySet()) {
                pos += 1;
                if (entry.getValue() != null) {
                    array[pos] = entry.getValue().toString();
                } else {
                    array[pos] = "";
                }
            }
            resultsArray2D[i] = array;
        }

        printer.print(resultsArray2D);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Compares the equality of two dates, It checks the year, month and day.
     *
     * @param current
     * @param reference
     * @return true or false
     */
    public static boolean dateEqual(Date current, Date reference) {
        if (current == null || reference == null) {
            return false;
        }
        DateTime dtCourante = new DateTime(current);

        DateTime dtReference = new DateTime(reference);

        return dateEqual(dtCourante, dtReference);
    }
    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy").withZone(DateTimeZone.forTimeZone(TimeZone.getDefault()));

    /**
     * Compares the equality of two dates, It checks the year, month and day.
     *
     * @param current
     * @param reference
     * @return true or false
     */
    public static boolean dateEqual(DateTime current, DateTime reference) {
        if (current == null || reference == null) {
            return false;
        }

        return current.getYear() == reference.getYear()
                && current.getMonthOfYear() == reference.getMonthOfYear()
                && current.getDayOfMonth() == reference.getDayOfMonth();
    }

    /**
     * Compares if the two date are contigous. It checks the year, month and
     * day.
     *
     * @param current
     * @param next
     * @return true or false
     */
    public static boolean dateIsTheNextDay(Date current, Date next) {
        if (current == null || next == null) {
            return false;
        }
        DateTime cDay = new DateTime(current);

        DateTime nDay = new DateTime(next);

        return dateIsTheNextDay(cDay, nDay);
    }

    /**
     * Compares if the two date are contigous. It checks the year, month and
     * day.
     *
     * @param current
     * @param next
     * @return true or false
     */
    public static boolean dateIsTheNextDay(DateTime current, DateTime next) {
        if (current == null || next == null) {
            return false;
        }

        return dateEqual(current, next.minusDays(1));

    }

    /**
     * Compares the date with the specified dateRef for next based on the
     * millisecond instant, chronology and time zone.
     *
     * @param date
     * @param referenceDate
     * @return true of false
     */
    public static boolean dateAfter(Date date, Date referenceDate) {
        if (date == null || referenceDate == null) {
            return false;
        }
        DateTime dateCourante = new DateTime(date);

        DateTime dateReference = new DateTime(referenceDate);

        return dateAfter(dateCourante, dateReference);
    }

    /**
     * Compares the date with the specified dateRef for next based on the
     * millisecond instant, chronology and time zone.
     *
     * @param date
     * @param referenceDate
     * @return true of false
     */
    public static boolean dateAfter(DateTime date, DateTime referenceDate) {
        if (referenceDate == null || referenceDate == null) {
            return false;
        }

        return date.compareTo(referenceDate) > 0;
    }

    /**
     * This method calculates the difference between a date object and a
     * constant time expressed with an integer.
     *
     * @param date
     * @param hoursInMinutes the number of minutes in the hour
     * @return difference between hours and constant time
     */
    public static int differenceHoursWithConstantTime(Date date, int hoursInMinutes) {
        final DateTime dt = new DateTime(date.getTime());
        return differenceHoursWithConstantTime(dt, hoursInMinutes);
    }

    /**
     * This method calculates the difference between a date object and a
     * constant time expressed with an integer.
     *
     * @param date
     * @param hoursInMinutes the number of minutes in the hour
     * @return difference between hours and constant time
     */
    public static int differenceHoursWithConstantTime(DateTime date, int hoursInMinutes) {
        int dateInMinutes = date.getHourOfDay() * 60 + date.getMinuteOfHour();
        float res = (hoursInMinutes - dateInMinutes) / 60f;
        if (dateInMinutes > hoursInMinutes) {
            res = (dateInMinutes - hoursInMinutes) / 60f;
        }
        return Math.round(res);
    }

    /**
     * Calculates the number of whole days between the two specified datetimes.
     * This method corectly handles any daylight savings time changes that may
     * occur during the interval.
     *
     * @param start the start instant, must not be null
     * @param end the end instant, must not be null
     * @return the number of days between two dates
     */
    public static int daysBetween(Date start, Date end) {
        return daysBetween(new DateTime(start.getTime()), new DateTime(end.getTime()));
    }

    /**
     * Calculates the number of whole days between the two specified datetimes.
     * This method corectly handles any daylight savings time changes that may
     * occur during the interval.
     *
     * @param start the start instant, must not be null
     * @param end the end instant, must not be null
     * @return the number of days between two dates
     */
    public static int daysBetween(DateTime start, DateTime end) {
        return Days.daysBetween(start, end).getDays();
    }

    /**
     * Calculates the number of whole hours between the two specified datetimes.
     * This method corectly handles any daylight savings time changes that may
     * occur during the interval.
     *
     * @param start the start instant, must not be null
     * @param end the end instant, must not be null
     * @return the number of hours between two dates
     */
    public static int hoursBetween(Date start, Date end) {
        DateTime startTime = new DateTime(start.getTime());
        DateTime endTime = new DateTime(end.getTime());
        return hoursBetween(startTime, endTime);
    }

    /**
     * Calculates the number of whole hours between the two specified datetimes.
     * This method corectly handles any daylight savings time changes that may
     * occur during the interval.
     *
     * @param start the start instant, must not be null
     * @param end the end instant, must not be null
     * @return the number of hours between two dates
     */
    public static int hoursBetween(DateTime start, DateTime end) {
        Period p = new Period(start, end);
//        System.out.println(PeriodFormat.getDefault().print(p));
        return p.getHours();
    }

    /**
     * Gives the number of hours associated with a date time.
     *
     * @param date
     * @return
     */
    public static int getHours(Date date) {
        final DateTime d = new DateTime(date.getTime());
        return d.getHourOfDay();
    }

    /**
     * Gives the number of hours associated with a date time.
     *
     * @param date
     * @return
     */
    public static int getHours(DateTime date) {
        return date.getHourOfDay();
    }

    /**
     * Gives the number of minutes associated with a date time.
     *
     * @param date
     * @return
     */
    public static int getMinutes(Date date) {
        final DateTime d = new DateTime(date.getTime());
        return d.getMinuteOfHour();
    }

    /**
     * Gives the number of minutes associated with a date time.
     *
     * @param date
     * @return
     */
    public static int getMinutes(DateTime date) {
        return date.getMinuteOfHour();
    }

    public static DateTime convertDate(Date date) {
        return date == null ? null : new DateTime(date);
    }

    public static java.sql.Date convertDate(DateTime date) {
        return new java.sql.Date(date.getMillis());
    }

    /**
     * List directory contents for a resource folder. Not recursive. This is
     * basically a brute-force implementation. Works for regular files and also
     * JARs.
     *
     * @author Greg Briggs
     * @param clazz Any java class that lives in the same place as the resources
     * you want.
     * @param path Should end with "/", but not start with one.
     * @return Just the name of each member item, not the full paths.
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String[] getResourceListing(Class clazz, String path) throws URISyntaxException, IOException {
        URL dirURL = clazz.getClassLoader().getResource(path);
        if (dirURL != null && dirURL.getProtocol().equals("file")) {
            /* A file path: easy enough */
            return new File(dirURL.toURI()).list();
        }

        if (dirURL == null) {
            /*
             * In case of a jar file, we can't actually find a directory.
             * Have to assume the same jar as clazz.
             */
            String me = clazz.getName().replace(".", "/") + ".class";
            dirURL = clazz.getClassLoader().getResource(me);
        }

        if (dirURL.getProtocol().equals("jar")) {
            /* A JAR path */
            String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!")); //strip out only the JAR file
            JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
            Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
            Set<String> result = new HashSet<String>(); //avoid duplicates in case it is a subdirectory
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (name.startsWith(path)) { //filter according to the path
                    String entry = name.substring(path.length());
                    int checkSubdir = entry.indexOf("/");
                    if (checkSubdir >= 0) {
                        // if it is a subdirectory, we just return the directory name
                        entry = entry.substring(0, checkSubdir);
                    }
                    result.add(entry);
                }
            }
            return result.toArray(new String[result.size()]);
        }

        throw new UnsupportedOperationException("Cannot list files for URL " + dirURL);
    }
}
