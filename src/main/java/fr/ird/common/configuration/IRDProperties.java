/*
 * $Id$
 *
 * Copyright (C) 2014 Julien Lebranchu <julien.lebranchu@ird.fr>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.ird.common.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The <em>IRDProperties</em> class represents a persistent set of properties.
 * This properties are stored in a file.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.0
 * @date 13 févr. 2014
 *
 * $LastChangedDate$
 *
 * $LastChangedRevision$
 */
public abstract class IRDProperties {

    protected static String PROJECT_NAME;
    protected static String PROJECT_CONFIG_FILENAME;
    protected static String PROJECT_CONFIG_COMMENT;

    /**
     * Load all properties of an application.
     *
     * @return the property of IRD application
     * @throws FileNotFoundException
     * @throws IOException
     *
     */
    public Properties loadProperties() throws FileNotFoundException, IOException, Exception {
        if (PROJECT_NAME == null && PROJECT_CONFIG_FILENAME == null) {
            throw new Exception("You must set PROJECT_CONFIG_FILENAME and PROJECT_NAME.");
        }

        Properties prop = new Properties();

        String filepath = AppConfig.getRelativeConfigPath(PROJECT_NAME);
        String filename = PROJECT_CONFIG_FILENAME;
        FileInputStream fis = new FileInputStream(AppConfig.getConfigFile(filepath, filename));
        prop.loadFromXML(fis);
        return prop;
    }

    public void createConfigFile() throws Exception {
        if (PROJECT_NAME == null && PROJECT_CONFIG_FILENAME == null) {
            throw new Exception("You must set PROJECT_CONFIG_FILENAME and PROJECT_NAME.");
        }
        String filepath = AppConfig.getRelativeConfigPath(PROJECT_NAME);
        String filename = PROJECT_CONFIG_FILENAME;
        if (!configFileExist()) {
            System.out.println("Create the default configuration file");
            createDefaultDirectory();
            copyDefaultFile();

            try {
//                System.out.println("-------- " + AppConfig.getConfigFile(filepath, filename));
                FileOutputStream fos = new FileOutputStream(AppConfig.getConfigFile(filepath, filename));
                createDefaultProperties().storeToXML(fos, PROJECT_CONFIG_COMMENT);
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(IRDProperties.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public abstract Properties createDefaultProperties();

    public abstract void createDefaultDirectory();

    public abstract void copyDefaultFile();

    public boolean configFileExist() {
        String filepath = AppConfig.getRelativeConfigPath(PROJECT_NAME);
        String filename = PROJECT_CONFIG_FILENAME;
        boolean exist = AppConfig.getConfigFile(filepath, filename).exists();
        exist &= AppConfig.getConfigFile(filepath, filename).length() > 0;
        return exist;
    }

    public boolean configDirectoryExist() {
        String filepath = AppConfig.getRelativeConfigPath(PROJECT_NAME);
        return new File(AppConfig.getConfigDirectory(filepath)).exists();
    }

}
