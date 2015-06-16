/*
 * $Id$
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
package fr.ird.common.list;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <em>NonNullableArrayList</em> forbid to add a null object in ArrayList.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.0
 * @date 9 déc. 2013
 * @see Collection
 * @see ArrayList
 *
 * $LastChangedDate$
 *
 * $LastChangedRevision$
 */
public class NonNullableArrayList<E> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        if (e != null) {
            return super.add(e);
        }
        return false;
    }

    @Override
    public void add(int index, E element) {
        if (element != null) {
            super.add(index, element);
        }
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position or <tt>null</tt>
     * if the element to be stored is null
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        if (element != null) {
            return super.set(index, element);
        }
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (e != null) {
                changed |= this.add(e);
            }
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (e != null) {
                changed = true;
                this.add(index, e);
                index += 1;
            }
        }
        return changed;
    }

}
