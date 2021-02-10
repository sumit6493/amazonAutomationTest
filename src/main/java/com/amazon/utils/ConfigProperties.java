package com.amazon.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static ConfigProperties _instance = null;
    private Properties properties;

    private final String path = System.getProperty("user.dir")+"/src/test/resources/config/test.properties";

    public ConfigProperties() throws RuntimeException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("property file did NOT found at " + path);
        }
    }

    public static ConfigProperties getInstance() {
        if (_instance == null) {
            _instance = new ConfigProperties();
        }
        return _instance;
    }

    public String getDevicePlatformName() {
        return properties.getProperty("device_platform");
    }

    public String getDeviceName() {
        return properties.getProperty("device_name");
    }

    public String getDeviceId() {
        return properties.getProperty("device_ID");
    }
}
