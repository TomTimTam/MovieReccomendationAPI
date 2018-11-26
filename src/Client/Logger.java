package Client;

import java.io.File;
import java.io.FileInputStream;;
import java.util.Properties;

public class Logger {
    public static String CreateLog(String user, String message){
        File file = new File(propertiesFileName);
        FileInputStream fileInput = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInput);
        fileInput.close();

    }

}
//TODO : THIS FILE