package Android.SauceLabs.TestCasesSteps;


import Android.SauceLabs.Screens.android.SauceLabs.LoginScreen;
import Android.SauceLabs.androidSetUp.BaseTestAndroid;
import org.testng.annotations.Test;

public class TC01Login extends BaseTestAndroid {



    @Test
    public void  loginSuccessfully() throws InterruptedException {
        LoginScreen LoginScreen=new LoginScreen(driver);
        LoginScreen.EnterUsername("standard_user");
        LoginScreen.EnterPassword("secret_sauce");

    }



}
