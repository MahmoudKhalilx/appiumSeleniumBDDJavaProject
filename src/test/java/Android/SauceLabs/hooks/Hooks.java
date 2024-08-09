package Android.SauceLabs.hooks;

import Android.SauceLabs.androidSetUp.BaseTestAndroid;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

public class Hooks extends BaseTestAndroid {
    private static boolean isAppiumStarted = false;

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        if (!isAppiumStarted) {
            StartAppium();
            isAppiumStarted = true;
        }
        startDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        stopDriver();
        if (scenario.getSourceTagNames().contains("@LastScenario")) {
            stopService();
            isAppiumStarted = false;
        }
    }
}