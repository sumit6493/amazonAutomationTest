package com.amazon.hooks;

import com.amazon.utils.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;

public class Hooks {
    static AppiumDriver driver = null;

    @Before
    public static void setUpDriver() throws Exception {
        System.out.println("Starting the execution");
        driver = DriverFactory.getDriver();
    }

    @After
    public void quit() throws Exception{
        System.out.println("Closing the app");
        driver.quit();
    }
}
