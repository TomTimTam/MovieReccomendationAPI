package api.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class PropertiesReader {

    // Input  : Filename
    // Reads properties into file.
    // Output : Properties object
    static Properties GetProperties(String propertiesFileName) throws Exception {
        try {
            File file = new File(propertiesFileName);
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            return properties;
        } catch (IOException exception) {
            System.out.println("an error occurred while reading the properties file: '" + propertiesFileName + "'");
        }

        return null;
    }
}
