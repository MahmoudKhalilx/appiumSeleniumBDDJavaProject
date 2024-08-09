package Android.SauceLabs.androidSetUp;

import Android.SauceLabs.resources.utilities.config.EmulatorManager;
import Android.SauceLabs.resources.utilities.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestAndroid {


    public static AndroidDriver driver;
    public AppiumDriverLocalService service;
    EmulatorManager emulatorManager=new EmulatorManager();

    //@BeforeTest
    public void StartAppium() throws MalformedURLException {
        //StartDevice
        //EmulatorManager emulatorManager=new EmulatorManager();
        emulatorManager.startEmulator1();



        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    //@BeforeClass
    public void startDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                //  .setDeviceName(DeviceName)
                .setAdbPort(Integer.parseInt(ConfigReader.getProperty("setAdbPort")))

                .setUdid(ConfigReader.getProperty("DeviceName"))
                .setApp(ConfigReader.getProperty("AppPath"))
                .setAppPackage(ConfigReader.getProperty("AppPackage"))
                .setAppActivity(ConfigReader.getProperty("AppActivity"));

        driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL(ConfigReader.getProperty("newURL")), options
        );

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


   // @AfterClass
    public void stopDriver(){
        if (driver != null) {
            driver.quit();

        }
    }
   // @AfterTest
    public void stopService(){

        if (service != null) {
            service.stop();
        }

        emulatorManager.stopEmulator1();
    }
}