package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DashBoard;
public class DashBoardSteps {
    private WebDriver driver = Hooks.driver;
    DashBoard  db = new DashBoard(driver);
    @When("I navigate to the dashboard")
    public void iNavigateToTheDashboard() throws InterruptedException {
        db.navigateDashBoardPage();
    }

    @Then("I should see the dashboard with key information")
    public void iShouldSeeTheDashboardWithKeyInformation() {
        db.keyInformation();
    }
}


