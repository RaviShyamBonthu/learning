package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesPage;

public class CasesSteps {
    private WebDriver driver = Hooks.driver;
    CasesPage cmp = new CasesPage(driver);

    @Then("User navigates to the Cases page")
    public void user_navigates_to_the_cases_page() throws InterruptedException {
        cmp.navigateToCases();
        System.out.println("passed the step");
    }
    @Then("verifies the Cases text")
    public void verifies_the_cases_text() {
        cmp.verifyCasesText();
    }

    @When("User click on create button")
    public void userClickOnCreateButton() {
        cmp.createCases();
    }

    @And("user enter fields in cases module")
    public void userEnterFieldsInCasesModule() throws InterruptedException {
        cmp.enterFields();
    }

//    @When("User click on create button")
//    public void userClickOnCreateButton() {
//        cmp.createCases();
//    }

//    @And("Enter the field in cogmento module")
//    public void enterTheFieldInCogmentoModule() {
//        cmp.enterFields();
//    }
}
