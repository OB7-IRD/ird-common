package fr.ird.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;

/**
 * Miscellaneous class utility methods.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @version 1.0
 * @since 1.0
 * @date 13 déc. 2013
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
     * @param date
     * @param dateRef
     * @return true or false
     */
    public static boolean dateEqual(Date date, Date dateRef) {
        if (date == null || dateRef == null) {
            return false;
        }
        DateTime dateCourante = new DateTime(date);

        DateTime dateReference = new DateTime(dateRef);

        return dateCourante.getYear() == dateReference.getYear()
                && dateCourante.getMonthOfYear() == dateReference.getMonthOfYear()
                && dateCourante.getDayOfMonth() == dateReference.getDayOfMonth();
    }

    /**
     * Compares the date with the specified dateRef for next based on the
     * millisecond instant, chronology and time zone.
     *
     * @param date
     * @param dateRef
     * @return true of false
     */
    public static boolean dateAfter(Date date, Date dateRef) {
        if (date == null || dateRef == null) {
            return false;
        }
        DateTime dateCourante = new DateTime(date);

        DateTime dateReference = new DateTime(dateRef);

        return dateCourante.compareTo(dateReference) > 0;
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
        int dateInMinutes = dt.getHourOfDay() * 60 + dt.getMinuteOfHour();
        float res = (hoursInMinutes - dateInMinutes) / 60f;
        if (dateInMinutes > hoursInMinutes) {
            res = (dateInMinutes - hoursInMinutes) / 60f;
        }
        return Math.round(res);
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
     * Gives the number of minutes associated with a date time.
     *
     * @param date
     * @return
     */
    public static int getMinutes(Date date) {
        final DateTime d = new DateTime(date.getTime());
        return d.getMinuteOfHour();
    }
}
