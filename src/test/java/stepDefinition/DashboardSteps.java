package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DashboardPage;

public class DashboardSteps {
	
	private WebDriver driver = Hooks.driver;
	DashboardPage db = new DashboardPage(driver);
	
//	@Given("I am logged in")
//	public void i_am_logged_in() {
//	    db.verifyLogged();
//	}

	@When("I navigate to the dashboard")
	public void i_navigate_to_the_dashboard() {
	    db.dashBoardNavigation();
	}

	@Then("I should see the dashboard with key information")
	public void i_should_see_the_dashboard_with_key_information()  {
	    db.dashBoardInformation();
	}

}
