package Android.SauceLabs.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Android/SauceLabs/Feature",
        glue = {"Android.SauceLabs.TestCasesSteps.StepsDefinition","Android.SauceLabs.hooks"},
        plugin = {"pretty", "html:target/report/cucumber"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
