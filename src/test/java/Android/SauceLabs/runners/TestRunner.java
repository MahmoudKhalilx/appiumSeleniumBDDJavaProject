package Android.SauceLabs.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Android/SauceLabs/Feature",
        glue = {"Android.SauceLabs.TestCasesSteps.StepsDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
