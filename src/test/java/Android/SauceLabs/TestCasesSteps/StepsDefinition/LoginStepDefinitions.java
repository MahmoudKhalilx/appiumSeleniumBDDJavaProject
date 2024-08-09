package Android.SauceLabs.TestCasesSteps.StepsDefinition;
import Android.SauceLabs.Screens.android.SauceLabs.LoginScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static Android.SauceLabs.androidSetUp.BaseTestAndroid.driver;

public class LoginStepDefinitions {

    private LoginScreen loginScreen;

    public LoginStepDefinitions() {
        // Assume you have a way to get the driver, perhaps from a context or dependency injection
        this.loginScreen = new LoginScreen(driver);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {

    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginScreen.EnterUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginScreen.EnterPassword(password);
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        String Actual =loginScreen.AssertProducts.getText();
Assert.assertEquals(Actual,"PRODUCTS");
    }
}