package pages;

import com.amazon.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class HomeScreenObjects extends BasePage {

    public HomeScreenObjects(AppiumDriver driver) {
        super(driver);
    }

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "web_home_shop_by_department_label")
    public WebElement shopByCategoryBtn;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "rs_search_src_text")
    public WebElement searchTextField;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "item_title")
    public List<WebElement> itemNames;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "rs_results_price")
    public List<WebElement> itemPrices;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add to Cart\")")
    public WebElement addToCartBtn;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "action_bar_cart_image")
    public WebElement cartIcon;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View[3]/android.view.View")
    public WebElement cartItemName;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.view.View[3]/android.widget.ListView/android.view.View[1]")
    public WebElement cartItemPrice;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='heart-state-save']")
    public WebElement favouriteIcon;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_burger")
    public WebElement hamburgerIcon;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Settings\")")
    public WebElement settingsLink;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign out\")")
    public WebElement signOutBtn;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "android:id/button2")
    public WebElement signOutLink;

    // Method used to check for the element is visible or not
    public boolean checkIfElementExist(AppiumDriver driver) {
        try {
            return ((AndroidDriver) driver)
                    .findElementByAndroidUIAutomator("new UiSelector().textContains(\"Add to Cart\")")
                    .isDisplayed();
        } catch (NoSuchElementException ex) {
        }
        return false;
    }
}
