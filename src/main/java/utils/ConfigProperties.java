package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")){
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTestProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

}
