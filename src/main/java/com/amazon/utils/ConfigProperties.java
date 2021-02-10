package com.amazon.utils;

import java.io.File;
import java.util.Properties;

public class ConfigProperties {
    private static ConfigProperties _instance = null;
    private Properties properties;

    private ConfigProperties() throws RuntimeException {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("test.config"));
        } catch (Exception e) {
            throw new RuntimeException(e);
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

    public String getAppPath() {
        String testEnv = properties.getProperty("app_path");
        String application = null;
        String app_path = properties.getProperty("application_path");
        if (testEnv.equalsIgnoreCase("local")) {
            File appFile = new File(app_path);
            application = appFile.getAbsolutePath();
        } else {
            application = app_path;
        }
        return application;
    }

    public String getDeviceId() {
        return properties.getProperty("device_platform");
    }

    public String getOsVersion() {
        return properties.getProperty("device.os.version");
    }

}
