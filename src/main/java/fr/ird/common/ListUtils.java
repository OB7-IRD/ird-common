/*
 * $Id: ListUtils.java 589 2015-05-04 15:37:35Z lebranch $
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
package fr.ird.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaire permettant la manipulation de liste.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.0
 * @date 18 févr. 2015
 *
 * $LastChangedDate: 2015-05-04 17:37:35 +0200 (lun., 04 mai 2015) $
 *
 * $LastChangedRevision: 589 $
 *
 */
public class ListUtils {

    /**
     * Flitre les éléments de type <T> d'une liste de type <E> .
     *
     * @param <T> le type des éléments à filtrer
     * @param <E> le type des éléments de la liste à filtrer
     * @param classz le nom de la classe
     * @param l une liste de type <T>
     * @return une liste contenant les éléments de type <T>
     */
    public static <T extends E, E> List<T> filter(Class<T> classz, List<E> l) {
        List<T> list = new ArrayList<T>();
        for (E e : l) {
            if (e.getClass().equals(classz)) {
                list.add((T) e);
            }
        }
        return list;
    }
}
