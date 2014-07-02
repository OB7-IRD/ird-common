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
 * @version 1.0
 * @since 1.0
 * @date 13 févr. 2014
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
            System.out.println("!configFileExist(): so create the default configuration");
            createDefaultDirectory();
            copyDefaultFile();

            try {
                System.out.println("-------- " + AppConfig.getConfigFile(filepath, filename));
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
