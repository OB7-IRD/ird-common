/*
 * $Id: WarningMessage.java 509 2015-02-26 10:39:32Z lebranch $
 *
 * Copyright (C) 2014 Observatoire thonier, IRD
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
package fr.ird.common.message;

import java.util.ArrayList;

/**
 * Représente un message de type Attention.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.1
 * @date 23 mai 2014
 *
 * $LastChangedDate: 2015-02-26 11:39:32 +0100 (jeu. 26 févr. 2015) $
 *
 * $LastChangedRevision: 509 $
 */
public class WarningMessage extends Message {

    public WarningMessage(String code, String label, ArrayList<Object> params) {
        super(code, label, params, WARNING);
    }

}
