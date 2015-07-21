/*
 * $Id: OTUtilsTest.java 388 2014-07-11 12:24:57Z lebranch $
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

import static fr.ird.common.Utils.round;
import junit.framework.TestCase;

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
public class OTUtilsTest extends TestCase {

    public void testDegreesDecimalToDegreesMinutes() {
        assertEquals(3830, OTUtils.degreesDecimalToDegreesMinutes(38.5));
        assertEquals(4000, OTUtils.degreesDecimalToDegreesMinutes(40d));
        assertEquals(2000, OTUtils.degreesDecimalToDegreesMinutes(-20.0));

    }

    public void testDegreesMinutesToDegreesDecimal() {
        assertEquals(38.5, round(OTUtils.degreesMinutesToDegreesDecimal(3830), 2));
        assertEquals(0.15, round(OTUtils.degreesMinutesToDegreesDecimal(9), 2));
        assertEquals(-0.15, round(OTUtils.degreesMinutesToDegreesDecimal(-9), 2));
    }
}
