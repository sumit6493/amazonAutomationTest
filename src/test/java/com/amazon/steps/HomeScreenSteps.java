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
import pages.LoginScreenObjects;

import java.util.Random;

import static com.amazon.utils.Constants.*;
import static com.amazon.utils.Utils.*;

public class HomeScreenSteps extends DriverFactory {

    String itemName;
    String itemPrice;

    HomeScreenObjects homeScreenObjects = new HomeScreenObjects(driver);
    LoginScreenObjects loginScreenObjects = new LoginScreenObjects(driver);


    @Given("^user is in onBoarding screen$")
    public void userIsInOnBoardingScreen() {
        loginScreenObjects.onBoardingLogo.isDisplayed();
    }

    @When("^user login with valid user credentials$")
    public void loginWithValidUserID() {
        loginScreenObjects.signInButton.click();
        waitForElementClickable(driver, loginScreenObjects.mobileNumberTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS).sendKeys(MOBILE_NUMBER);
        loginScreenObjects.continueButton.click();
        waitForElementClickable(driver, loginScreenObjects.passTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS).sendKeys(PASSWORD);
        loginScreenObjects.submitButton.click();
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
        itemName = homeScreenObjects.itemNames.get(1).getText();
        itemPrice = homeScreenObjects.itemPrices.get(1).getAttribute("content-desc");
        homeScreenObjects.itemNames.get(index).click();
    }

    //    scrolling the screen for 10 times until the element is visible.
    @And("^click on Add to cart from product detail page$")
    public void addToCart() {
        waitForElementVisibile(driver, homeScreenObjects.favouriteIcon, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS);
        for (int i = 0; i <= 10; i++) {
            if (!homeScreenObjects.checkIfElementExist(driver)) {
                scrollToBottom(driver);
            } else break;
        }
        homeScreenObjects.addToCartBtn.click();
    }

    @And("^user navigates to cart page$")
    public void userNavigatesToCartPage() {
        homeScreenObjects.cartIcon.click();
    }

    @Then("^user can see same product in cart page$")
    public void userCanSeeSameProductInCartPage() {
        Assert.assertEquals("cart Item name is NOT as search result page", homeScreenObjects.cartItemName.getAttribute("content-desc"), itemName);
        Assert.assertEquals("cart Item price is NOT as search result page", homeScreenObjects.cartItemPrice.getText(), itemPrice);
    }

    @And("^user navigates to Sign In Screen$")
    public void userNavigatesToSignInScreen() {
        loginScreenObjects.signInButton.click();
    }

    @When("^user enter (.*) mobile number$")
    public void userEnterInvalidMobileNumber(String value) {
        if (value.equalsIgnoreCase("valid")) {
            waitForElementClickable(driver, loginScreenObjects.mobileNumberTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS).sendKeys(MOBILE_NUMBER);
        } else
            waitForElementClickable(driver, loginScreenObjects.mobileNumberTextField, DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS).sendKeys(INVALID_MOBILE_NUMBER);
    }

    @And("^click on (.*) button$")
    public void clickOnContinueButton(String button) {
        if (button.equalsIgnoreCase("continue")) {
            loginScreenObjects.continueButton.click();
        } else
            loginScreenObjects.submitButton.click();
    }

    @Then("^user can see incorrect phone number error message$")
    public void userCanSeeIncorrectPhoneNumberErrorMessage() {
        Assert.assertTrue("Incorrect phone number error message did NOT appear", loginScreenObjects.incorrectPhoneError.isDisplayed());
    }

    @And("^enters (.*) password$")
    public void enterPassword(String value) {
        if (value.equalsIgnoreCase("valid")) {
            loginScreenObjects.passTextField.sendKeys(PASSWORD);
        } else
            loginScreenObjects.passTextField.sendKeys(INVALID_PASSWORD);
    }

    @Then("^user can see incorrect password error message$")
    public void userCanSeeIncorrectPasswordErrorMessage() {
        Assert.assertTrue("Incorrect phone number error message did NOT appear", loginScreenObjects.incorrectPasswordError.isDisplayed());
    }

    @And("^user selects settings through hamburger menu$")
    public void userSelectsSettingsThroughHamburgerMenu() {
        homeScreenObjects.hamburgerIcon.click();
        homeScreenObjects.settingsLink.click();
    }

    @And("^user select Sign out through Settings$")
    public void userSelectSignOutThroughSettings() {
        homeScreenObjects.signOutBtn.click();
    }

    @And("^user click on Confirm Sign Out$")
    public void userClickOnConfirmSignOut() {
        homeScreenObjects.signOutLink.click();
    }

    @Then("^User is logged out from app$")
    public void userIsLoggedOutFromApp() {
        Assert.assertTrue("onboarding screen did NOT appear after successful login", loginScreenObjects.onBoardingLogo.isDisplayed());
    }
}
