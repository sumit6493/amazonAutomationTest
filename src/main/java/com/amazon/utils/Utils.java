package com.amazon.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static WebElement waitForElementVisibile(AppiumDriver driver, WebElement element, long timeout) {
        try {
            return new WebDriverWait(driver, timeout)
                    .ignoring(StaleElementReferenceException.class)
                    .until((ExpectedConditions.visibilityOf(element)));
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement waitForElementClickable(AppiumDriver driver, WebElement element, long timeout) {
        try {
            return new WebDriverWait(driver, timeout)
                    .ignoring(StaleElementReferenceException.class)
                    .until((ExpectedConditions.elementToBeClickable(element)));
        } catch (Exception e) {
            return null;
        }
    }

    public static void scrollToBottom(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy)).release().perform();
    }
}
