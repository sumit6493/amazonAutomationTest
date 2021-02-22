package com.amazon.hooks;

import com.amazon.utils.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {
    static AppiumDriver driver = null;

    @Before
    public static void setUpDriver() throws Exception {
        System.out.println("Starting the execution");
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scn) throws IOException {
        if (scn.isFailed()) {
            TakesScreenshot ts = ((TakesScreenshot) driver);
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            File file = ts.getScreenshotAs(OutputType.FILE);
            // To embed the failed cases screenshot with report
            scn.embed(src, "image/png");
            // Save failed screenshots inside target folder
            File screenShotLocation = new File(System.getProperty("user.dir") + "/target/failedCase.png");
            FileUtils.copyFile(file, screenShotLocation);

        }
        System.out.println("Closing the app");
        driver.quit();
    }
}
