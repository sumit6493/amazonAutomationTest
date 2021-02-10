package com.amazon.hooks;

import com.amazon.utils.DriverFactory;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class ScenarioHooks {
    private AppiumDriver driver = null;

//    @Before
    public void beforeScenario(Scenario scn) throws Exception {
        driver = DriverFactory.getDriver();
        System.out.println("Relaunching app...");
        driver.launchApp();
    }

    @After
    public void afterScenario(Scenario scn) {
        if (scn.isFailed()) {
            File file = driver.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File("Screenshot.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.resetApp();
    }
}
