/*
 * $Id$
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

import junit.framework.TestCase;
import org.joda.time.DateTime;

/**
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.1
 * @date 19 juin 2014
 *
 * $LastChangedDate$
 *
 * $LastChangedRevision$
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

}
