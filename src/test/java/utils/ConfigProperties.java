package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    static Properties properties = new Properties();

    public static String getProperty(String parameter) { // url  email
        if (properties.toString().equals("{}")) {
            initProperties();
        }
        return properties.getProperty(parameter);
    }

    private static void initProperties() {
        String target = System.getProperty("target", "prod");
        // src/test/resources/prod.properties
        String path = String.format("src/test/resources/%s.properties", target);
        try (FileReader fileReader = new FileReader(path)) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}