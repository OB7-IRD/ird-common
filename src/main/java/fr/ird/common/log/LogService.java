/*
 * $Id: LogService.java 509 2015-02-26 10:39:32Z lebranch $
 *
 * Copyright (C) 2013 Observatoire thonier, IRD
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
package fr.ird.common.log;

import org.apache.log4j.Logger;

/**
 * Service de logs.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 0.9
 *
 *
 * $LastChangedDate: 2015-02-26 11:39:32 +0100 (jeu. 26 févr. 2015) $
 *
 * $LastChangedRevision: 509 $
 */
public class LogService {

    private static final LogService service = new LogService();
    private final static Logger logger = Logger.getLogger(LogService.class);

    /**
     * Constructeur privé car LogService est un singleton.
     */
    private LogService() {
    }

    /**
     * Log d'erreur dans le mapping ou les propriétés hibernate.
     *
     * @param message le message a retourner
     */
    public void logHibernateException(String message) {
        logger.error("L'utilisation du mapping ou des propriétés du fichier hibernate.cfg.xml pose problème: "
                + message);
    }

    /**
     * Log indiquant que le fichier conf.properties n'a pas été trouvé.
     */
    public void logFilePropertiesNotFound() {
        logger.error("Le fichier conf.properties est introuvable");
    }

    /**
     * *
     * @return LogService le service
     */
    public static LogService getService() {
        return service;
    }

    /**
     * Log d'erreur applicatif.
     *
     * @param message le message d'erreur
     */
    public void logApplicationError(String message) {
        logger.error(message);
    }

    /**
     * Log de debug applicatif.
     *
     * @param message le message de débug
     */
    public void logApplicationDebug(String message) {
        logger.debug(message);
    }

    /**
     * Log d'info applicatif.
     *
     * @param message le message d'information
     */
    public void logApplicationInfo(String message) {
        logger.info(message);
    }
}
