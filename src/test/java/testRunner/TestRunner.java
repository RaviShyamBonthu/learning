package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//  features = "Features/.feature",
   features = "src/test/resources/Features",
   glue = "stepDefinition",
   tags = "@Test2",
   plugin = {"pretty", "html:src/test/resources/Reports/CucumberTestReport.html"}
   )

public class TestRunner {}
