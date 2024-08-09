package Android.SauceLabs.Screens.android.SauceLabs;

import Android.SauceLabs.androidSetUp.BaseScreenAndroid;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreenAndroid {

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }


    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    public WebElement UsernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    public WebElement PasswordField;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    public WebElement LoginBtn;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"][1]")
    public WebElement LoginErrorMessage;

    public String LoginErrorMessageAssert(){
        LoginErrorMessage.getText();

        return LoginErrorMessage.getText();
    }

    public void EnterUsername(String Username){
        UsernameField.sendKeys(Username);
    }
    public void EnterPassword(String Password){
        PasswordField.sendKeys(Password);
    }

    public void LoginBtn(){
        LoginBtn.click();

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    public WebElement AssertProducts;

    public void AssertProducts(){
        AssertProducts.getText();

    }
    public boolean assertUsernameAndPass(){
        UsernameField.isDisplayed();

        return true;
    }

}

