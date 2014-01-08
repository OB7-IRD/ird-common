package fr.ird.common;


import java.math.BigDecimal;


/**
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @version 0.0
 * @date 13 déc. 2013
 */
public class Utils {

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}
