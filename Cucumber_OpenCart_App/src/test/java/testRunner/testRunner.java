package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//features"},
		glue= {"stepDefinitions","hooks"},
		plugin= {"pretty","html:reports/myreoirt.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"},
		dryRun=false, // checks maping between scenario and step definition mentods
		monochrome=true, //avoids junk characters in output
		publish =true, //to publish reports on cucumber server
		tags="@regression"  

		)


public class testRunner {

}
