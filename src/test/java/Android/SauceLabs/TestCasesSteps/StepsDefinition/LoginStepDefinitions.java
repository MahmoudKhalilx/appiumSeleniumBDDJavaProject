package Android.SauceLabs.TestCasesSteps.StepsDefinition;
import Android.SauceLabs.Screens.android.SauceLabs.LoginScreen;
import Android.SauceLabs.androidSetUp.BaseTestAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;

import static Android.SauceLabs.androidSetUp.BaseTestAndroid.driver;

public class LoginStepDefinitions  extends BaseTestAndroid {

    private LoginScreen loginScreen;

    public LoginStepDefinitions() {
        this.loginScreen = new LoginScreen(driver);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws MalformedURLException {
  Assert.assertTrue(loginScreen.assertUsernameAndPass(),"UsernameAndPass is enabled");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginScreen.EnterUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginScreen.EnterPassword(password);
    }

    @When("I tap on the login button")
    public void i_tap_on_the_login_button() {
       loginScreen.LoginBtn();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        String Actual =loginScreen.AssertProducts.getText();
Assert.assertEquals(Actual,"PRODUCTS");

    }

    @Then("i Have To Get Error Message {string}")
    public void iHaveToGetErrorMessage(String Expected) {
        String Actual =loginScreen.AssertProducts.getText();
        Assert.assertEquals(Actual, Expected,"true");

    }
}