/*
 * $Id$
 *
 * Copyright (C) 2015 Observatoire thonier, IRD
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
package fr.ird.common.uuid;

import java.util.UUID;

/**
 * Utilitaire générant un identifiant unique se fondant sur une classe..
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.0
 * @date 13 janv. 2015
 *
 * $LastChangedDate$
 *
 * $LastChangedRevision$
 *
 */
public class TopiaID {

    /**
     * Créé un topiaId pour une certaine classe.
     *
     * @param clazz la classe de base
     * @return a generated topiaId
     */
    public static String create(Class clazz) {
        UUID uuid = UUID.randomUUID();
        return clazz.getName() + '-' + uuid.toString() + '-' + System.currentTimeMillis();

//        if (!clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers())) {
//            throw new IllegalArgumentException(
//                    "Only interface and asbstract class is permit to create id: " + clazz);
//        }
//        double random = Math.random();
//        while (Double.toString(random).contains("E-")) {
//            random = Math.random();
//        }
//        return clazz.getName() + '#' + System.currentTimeMillis() + '#'
//                + random;
    }
}
