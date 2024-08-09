package Android.SauceLabs.hooks;

import Android.SauceLabs.androidSetUp.BaseTestAndroid;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks extends BaseTestAndroid {
    @Before
    public void setUp() throws MalformedURLException {
        StartAppium();
        startDriver();
    }

    @After
    public void tearDown() {
        stopDriver();
        stopService();
    }
}
