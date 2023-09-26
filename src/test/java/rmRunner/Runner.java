package rmRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/", glue= {"stepDefinitions","hooks"}, plugin = { "pretty",
		"html:target/cucumber-reports", "json:target/cucumber.json" },monochrome = true, publish = true,
		tags = "@CM")
public class Runner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
