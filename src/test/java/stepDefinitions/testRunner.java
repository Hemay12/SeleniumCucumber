package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;	
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="H:\\BDD_start\\src\\test\\resources\\features", 
	glue= {"stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
	)

public class testRunner {
	
}