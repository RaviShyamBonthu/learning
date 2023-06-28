package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DealsPage;

public class DealsSteps {

        private WebDriver driver = Hooks.driver;
        DealsPage cmp = new DealsPage(driver);

        @Then("User navigates to the Deals page")
        public void user_navigates_to_the_deals_page() throws InterruptedException {
            cmp.navigateToDeals();
            System.out.println("passed the step");
        }

        @Then("verifies the Deals text")
        public void verifies_the_deals_text() {
            cmp.verifyDealsText();
        }

        @When("User click on create button")
        public void userClickOnCreateButton() {
            cmp.createDeals();
        }

        @And("user enter fields in deals module")
        public void userEnterFieldsInDealsModule() throws InterruptedException {
            cmp.enterFields();
        }

    }



