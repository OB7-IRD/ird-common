/*
 * $Id: UtilsTest.java 388 2014-07-11 12:24:57Z lebranch $
 *
 * Copyright (C) 2014 Julien Lebranchu <julien.lebranchu@ird.fr>
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

import static fr.ird.common.Utils.pDateTime;
import java.util.regex.Matcher;
import junit.framework.TestCase;
import org.joda.time.DateTime;

/**
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.1
 * @date 19 juin 2014
 *
 * $LastChangedDate: 2014-07-11 14:24:57 +0200 (ven. 11 juil. 2014) $
 *
 * $LastChangedRevision: 388 $
 */
public class UtilsTest extends TestCase {

    public void testDateIsTheNextDay() {
        DateTime dt = new DateTime(2014, 1, 1, 0, 0);
        DateTime dtmone = new DateTime(2013, 12, 31, 23, 0);

        DateTime d = new DateTime(2014, 6, 25, 0, 0);

        assertFalse(Utils.dateIsTheNextDay(dtmone, d));
        assertFalse(Utils.dateIsTheNextDay(d, dtmone));
        assertTrue(Utils.dateIsTheNextDay(dtmone, dt));
    }

    public void testDateEqual() {
        DateTime dt = new DateTime(2014, 1, 1, 0, 0);
        DateTime dtplus = new DateTime(2014, 1, 1, 23, 0);

        DateTime d = new DateTime(2014, 6, 25, 0, 0);

        assertFalse(Utils.dateEqual(dtplus, d));

        assertTrue(Utils.dateEqual(dtplus, dt));
    }

    public void testRound() {
        assertEquals(38.5, Utils.round(38.499999, 2));
    }

    public void testDateTimeMatch() {

        String field = "1899-12-30 15:57:00.0";
        Matcher matcher = pDateTime.matcher(field);
        assertTrue(matcher.matches());
        assertEquals("1899-12-30", matcher.group("date"));
        assertEquals("15:57:00.0", matcher.group("time"));

    }

}
