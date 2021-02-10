package pages;

import com.amazon.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class HomeScreenObjects extends BasePage {

   public HomeScreenObjects(AppiumDriver driver){
       super(driver);
   }

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "sso_splash_logo")
    public WebElement onBoardingLogo;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "sign_in_button")
    public WebElement signInButton;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement mobileNumberTextField;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.Button")
    public WebElement continueButton;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement passTextField;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign-In']")
    public WebElement submitButton;

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
    @AndroidFindBy(id = "add-to-cart-button")
    public WebElement addToCartBtn;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "chrome_action_bar_cart_count")
    public WebElement cartIcon;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View[3]/android.view.View")
    public WebElement cartItemName;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.view.View[3]/android.widget.ListView/android.view.View[1]")
    public WebElement cartItemPrice;

    @WithTimeout(time = Constants.DEFAULT_EXTENDED_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "amazon-lists-empty-heart-svg")
    public WebElement favouriteIcon;


}
