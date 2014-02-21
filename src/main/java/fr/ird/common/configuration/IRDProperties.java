package fr.ird.common.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The <em>IRDProperties</em> class represents a persistent set of properties.
 * This properties are stored in a file.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @version 1.0
 * @since 1.0
 * @date 13 févr. 2014
 */
public abstract class IRDProperties {

    protected static String PROJECT_NAME;
    protected static String PROJECT_CONFIG_FILENAME;

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

}
