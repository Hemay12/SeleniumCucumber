package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;	
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src\\test\\resources\\features\\features", 
	glue= {"stepDefinitions"},
	plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
    monochrome = true,
    dryRun = false
	)

public class testRunner {
	
}
