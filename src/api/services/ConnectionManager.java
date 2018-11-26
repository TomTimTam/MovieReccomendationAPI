package api.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import static api.services.PropertiesReader.GetProperties;

public class ConnectionManager {

    //Input  : HttpMethod (e.g. "GET"), .properties filename for api and the base url
    //Properties file is read into a HttpURLConnection to the given url.
    //Output : Instantiated HttpURLConnection with fully setup properties.
    public static HttpURLConnection SetConnection(String httpMethodType, String propertiesFileName, URL url) throws Exception {
        //Instantiate connection and build properties
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Properties properties = GetProperties(propertiesFileName);

        //Set connection type
        connection.setRequestMethod(httpMethodType);

        Enumeration enuKeys = properties.keys();
        while (enuKeys.hasMoreElements()) {
            String key = (String) enuKeys.nextElement();
            String value = properties.getProperty(key);
            connection.setRequestProperty(key, value);
            System.out.println(key + ": " + value);
        }

        System.out.println();
        return connection;
    }
}
