package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesPage;
import pageObjects.DealsPage;

public class DealsSteps {
    private WebDriver driver = Hooks.driver;
    DealsPage dealsPage = new DealsPage(driver);
    @Then("User navigates to the Deals page")
    public void userNavigatesToTheDealsPage()throws InterruptedException {
        dealsPage.navigateToDealsPage();
        System.out.println("passed the step");

    }

    @Then("verifies the Deals text")
    public void verifies_the_deals_text() {
        verifies_the_deals_text();
    }

    @When("User click on create button")
    public void userClickOnCreateButton() {
       dealsPage.createDeals();
    }

    @And("user enter fields in cases module")
    public void userEnterFieldsInCasesModule() throws InterruptedException {
        dealsPage.enterFields();
    }

}
