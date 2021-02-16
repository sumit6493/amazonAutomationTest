package pages;

import com.amazon.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;

import static java.time.temporal.ChronoUnit.SECONDS;

public class LoginScreenObjects extends BasePage {
    public LoginScreenObjects(AppiumDriver driver) {
        super(driver);
    }

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "sso_splash_logo")
    public WebElement onBoardingLogo;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(id = "sign_in_button")
    public WebElement signInButton;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_email_login']")
    public WebElement mobileNumberTextField;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='continue']")
    public WebElement continueButton;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
    public WebElement passTextField;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign-In']")
    public WebElement submitButton;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//*[@text='Incorrect phone number']")
    public WebElement incorrectPhoneError;

    @WithTimeout(time = Constants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//*[@text='Your password is incorrect']")
    public WebElement incorrectPasswordError;
}