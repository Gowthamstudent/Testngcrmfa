package cucumber.option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/featureCRMFA",glue = {"stepDefinition","hooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"pretty","html:CucumberReports.html"
				,"json:reports/result.json", 
				"junit:reports/result.xml" 
				}
		)

public class TestRunner {

}
