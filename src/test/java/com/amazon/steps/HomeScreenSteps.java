package com.amazon.steps;

import com.amazon.utils.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import pages.HomeScreenObjects;

import java.util.Random;

import static com.amazon.utils.Constants.*;
import static com.amazon.utils.Utils.*;

public class HomeScreenSteps extends DriverFactory  {

    String itemName;
    String itemPrice;

    HomeScreenObjects homeScreenObjects = new HomeScreenObjects(driver);


    @Given("^user is in onBoarding screen$")
    public void userIsInOnBoardingScreen() {
        homeScreenObjects.onBoardingLogo.isDisplayed();
    }

    @When("^login with valid user credentials$")
    public void loginWithValidUserID() throws InterruptedException {
        homeScreenObjects.signInButton.click();
        waitForElementClickable(driver,homeScreenObjects.mobileNumberTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS ).sendKeys(MOBILE_NUMBER);
        homeScreenObjects.continueButton.click();
        waitForElementClickable(driver,homeScreenObjects.mobileNumberTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS ).sendKeys(PASSWORD);
        homeScreenObjects.submitButton.click();
    }

    @And("^user navigates to home page after successful login$")
    public void verifyHomePageAfterSuccessfulLogin() {
        Assert.assertTrue("Search text field did NOT observed after login", homeScreenObjects.shopByCategoryBtn.isDisplayed());
    }

    @And("^search for (.*)$")
    public void searchForInchTV(String searchedText) {
        waitForElementClickable(driver, homeScreenObjects.searchTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS).click();
        waitForElementClickable(driver, homeScreenObjects.searchTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS).sendKeys(searchedText);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @And("^select any random result from searched list$")
    public void selectItemFromList() {
        Random random = new Random();
        int index = random.nextInt(4);
        itemName = homeScreenObjects.itemNames.get(index).getText();
        itemPrice = homeScreenObjects.itemPrices.get(index).getAttribute("content-desc");
        homeScreenObjects.itemNames.get(index).click();
    }

    @And("^click on Add to cart from product detail page$")
    public void addToCart(){
        waitForElementVisibile(driver,homeScreenObjects.favouriteIcon, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS);
        scrollToBottom(driver);
        homeScreenObjects.addToCartBtn.click();
    }

    @And("^user navigates to cart page$")
    public void userNavigatesToCartPage() {
        homeScreenObjects.cartIcon.click();
    }

    @Then("^user can see same product in cart page$")
    public void userCanSeeSameProductInCartPage() {

        Assert.assertEquals(homeScreenObjects.cartItemName.getAttribute("content-desc"), itemName);
        Assert.assertEquals(homeScreenObjects.cartItemPrice.getText(), itemPrice);
    }
}
