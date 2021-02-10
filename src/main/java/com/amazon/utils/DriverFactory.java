package com.amazon.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    public static AppiumDriver driver;

    public static AppiumDriver getDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app","/Users/sumitkumarsharma/Downloads/Amazon_shopping.apk" );
        caps.setCapability("deviceName", "Samsung Noete 8");
        caps.setCapability("platformVersion","9");
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("udid","988e50343356314d5830");
        return driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }
}
