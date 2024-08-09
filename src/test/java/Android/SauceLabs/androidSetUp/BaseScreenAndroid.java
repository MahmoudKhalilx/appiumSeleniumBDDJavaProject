package Android.SauceLabs.androidSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreenAndroid {
    public AndroidDriver driver;

    public BaseScreenAndroid(AndroidDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
