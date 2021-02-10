package com.amazon.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {
    public static ConfigProperties testCp = ConfigProperties.getInstance();

    public static AppiumDriver driver;

    public static AppiumDriver getDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app",System.getProperty("user.dir")+"/Amazon_shopping.apk" );
        caps.setCapability("deviceName", testCp.getDeviceName());
        caps.setCapability("platformVersion",testCp.getDevicePlatformName());
        caps.setCapability("platformName",testCp.getDevicePlatformName());
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("udid",testCp.getDeviceId());
        return driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }
}
