package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//   features = "Features/welcome.feature",
   features = "Features",
   glue = "stepDefinitions",
   tags = "@failed",
   plugin = {"pretty", "html:Reports/CucumberTestReport.html"}  
   )

public class TestRunner {}
