package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileReader {

    public static String readProperties(String propertyName) {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/config.properties");
            properties.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }

    public static Map<String, String> readJson(String path) {
        File file = new File(path);
        Map<String, String> result = new HashMap<>();
        try {
            return new ObjectMapper().readValue(file, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
