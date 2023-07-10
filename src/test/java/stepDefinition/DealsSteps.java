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

    @And("User verify the deals title")
    public void user_verify_the_deals_title() {
        dealsPage.verifyDealsText();
    }
    @Then("user click on create button")
    public void user_click_on_create_button() {
        dealsPage.createDeals();
    }



}
