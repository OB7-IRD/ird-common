/*
 * $Id: ErrorMessage.java 509 2015-02-26 10:39:32Z lebranch $
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
 * Représente un message de type Erreur.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.1
 * @date 23 mai 2014
 *
 * $LastChangedDate: 2015-02-26 11:39:32 +0100 (jeu. 26 févr. 2015) $
 *
 * $LastChangedRevision: 509 $
 */
public class ErrorMessage extends Message {

    /**
     * Initializes a newly created ErrorMessage object so that it represents an
     * message with a specific code and many parameters.
     *
     * @param code the code of the message
     * @param label the key of the locale properties
     * @param params parameters to be applied to the message
     *
     */
    public ErrorMessage(String code, String label, ArrayList<Object> params) {
        super(code, label, params, ERROR);
    }

    /**
     * Initializes a newly created ErrorMessage object so that it represents an
     * message with a specific code.
     *
     * @param code the code of the message
     * @param label the key of the locale properties
     */
    public ErrorMessage(String code, String label) {
        super(code, label, ERROR);
    }

}
