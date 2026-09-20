package com.sol.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {

            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
    public static String getServerUrl(String server){
        return properties.getProperty(server + ".url");
    }
    public static String getServerUsername(String server){
        return properties.getProperty(server + ".username");
    }
    public static String getServerPassword(String server){
        return properties.getProperty(server + ".password");
    }
}
