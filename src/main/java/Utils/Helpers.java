package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helpers {
    public static String getProperty(String propertyKey) throws IOException {

        Properties properties = new Properties();
        InputStream inputStream = Helpers.class.getClassLoader().getResourceAsStream(Constants.propertiesFileName);
        if (inputStream != null){
            properties.load(inputStream);
        }else {
            throw new FileNotFoundException("File not found");
        }
        return properties.getProperty(propertyKey);
    }
}
