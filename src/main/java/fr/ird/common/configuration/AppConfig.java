package fr.ird.common.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class utility for the application's configuration.
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @version 1.0
 * @author Pascal Cauquil <pascal.cauquil@ird.fr>
 * @since 0.1
 * @date 25 nov. 2013
 */
public class AppConfig {

    /**
     * Copy a file object using a stream object.
     *
     * @param source the source file to copy
     * @param dest the destination file of the copy
     * @throws IOException
     */
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    /**
     * Returns a File object representing a file found on the file system
     * according arbitrary rules. The relativePath argument must specify a
     * relative path inside the absolute directory determined by the system. If
     * relativePath is null the file will be searched directly under the
     * directory determined by the system. The fileName argument is the name of
     * the file to load, including its extension.
     * <p>
     * This method returns a File object if the file were found, or null if not
     * found.
     * <p>
     * This method is typically usefull to find the initial configuration file
     * of an application, when it is not possible to parametrize its path and
     * name.
     * <p>
     * The method will look at: <ol> <li>The user home directory</li>
     * <li>Under an arbitrary folder depending on the system <ul> <li>Linux:
     * /var/local</li> <li>Mac OS: /var/local</li> <li>Windows:
     * c:\Windows\system32\</li></ul></li> <li>The classpath</li> </ol>
     *
     * @param relativePath a relative path inside the absolute directory
     * determined by the system
     * @param fileName the name of the file to load
     * @return the file as a File, or null if not found
     */
    public static File getConfigFile(String relativePath, String fileName) {
        File file = null;
        ClassLoader classLoader = AppConfig.class.getClassLoader();

        String fullpath = AppConfig.getConfigFilePath(relativePath, fileName);

        if (fullpath != null) {
            file = new File(fullpath);
        }

        if (file == null) {
            file = new File(classLoader.getResource(fileName).getFile());
        }

        return file;
    }

    /**
     * Returns a String containing the file absolute path according arbitrary
     * rules. The relativePath argument must specify a relative path inside the
     * absolute directory determined by the system. If relativePath is null the
     * file will be searched directly under the directory determined by the
     * system. The fileName argument is the name of the file to load, including
     * its extension.
     * <p>
     * This method returns a String object if the file were found, or null if
     * not found.
     * <p>
     * This method is typically usefull to find the initial configuration file
     * of an application, when it is not possible to parametrize its path and
     * name.
     * <p>
     * The method will look at: <ol> <li>The user home directory</li>
     * <li>Under an arbitrary folder depending on the system <ul> <li>Linux:
     * /var/local</li> <li>Mac OS: /var/local</li> <li>Windows:
     * c:\Windows\system32\</li></ul></li> <li>The classpath</li> </ol>
     *
     * @param relativePath a relative path inside the absolute directory
     * determined by the system
     * @param fileName the name of the file to load
     * @return the file path as a String, or null if not found
     */
    public static String getConfigFilePath(String relativePath, String fileName) {
        String home = System.getProperty("user.home");
        String os = System.getProperty("os.name");
        String fullpath = null;

        if (relativePath == null) {
            relativePath = "";
        }

        if (home != null && !home.isEmpty()) {
            fullpath = home + File.separator + relativePath + File.separator + fileName;
        } else if (os != null && !os.isEmpty()) {
            if (os.contains("Linux")) {
                fullpath = "/var/local/" + relativePath + File.separator + fileName;
            }
            if (os.contains("Mac OS")) {
                fullpath = "/var/local/" + relativePath + File.separator + fileName;
            }
            if (os.contains("Windows")) {
                fullpath = "c:\\Windows\\system32\\" + relativePath + File.separator + fileName;
            }
        }

        return fullpath;
    }

    /**
     * Returns a String containing the directory absolute path according
     * arbitrary rules. The relativePath argument must specify a relative path
     * inside the absolute directory determined by the system. If relativePath
     * is null, the root directory determined by the system will be returned.
     * <p>
     * This method returns a String object if the directory were found, or null
     * if not found.
     * <p>
     * This method is typically usefull to find an application's configuration
     * directory, when it is not possible to parametrize it.
     * <p>
     * The method will look at: <ol> <li>The user home directory</li>
     * <li>Under an arbitrary folder depending on the system <ul> <li>Linux:
     * /var/local</li> <li>Mac OS: /var/local</li> <li>Windows:
     * c:\Windows\system32\</li></ul></li> <li>The classpath</li> </ol>
     *
     * @param relativePath a relative path inside the absolute directory
     * determined by the system
     * @return the path as a String, or null if not found
     */
    public static String getConfigDirectory(String relativePath) {
        String home = System.getProperty("user.home");
        String os = System.getProperty("os.name");
        String fullpath = null;

        if (relativePath == null) {
            relativePath = "";
        }

        if (home != null && !home.isEmpty()) {
            fullpath = home + File.separator + relativePath;
            return fullpath;
        }

        if (os != null && !os.isEmpty()) {
            if (os.contains("Linux")) {
                fullpath = "/var/local/" + relativePath;
            }
            if (os.contains("Mac OS")) {
                fullpath = "/var/local/" + relativePath;
            }
            if (os.contains("Windows")) {
                fullpath = "c:\\Windows\\system32\\" + relativePath;
            }

            if (fullpath != null) {
                return fullpath;
            }
        }

        return fullpath;
    }

    public static String getRelativeConfigPath(String projectName) {
        return "appconfig" + File.separator + projectName;
    }

}
