package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesPageAllFields;

import java.util.HashMap;

public class CasesAllFieldsSteps {
    private WebDriver driver = Hooks.driver;
    CasesPageAllFields cpf = new CasesPageAllFields(driver);
    String caseTitle = Hooks.getRandomString("TestCase",9);
    @Then("User is navigates to cases page")
    public void user_is_navigates_to_cases_page() throws InterruptedException {
        cpf.navigateToCasesPage();
    }
    @Then("Verify user is on cases Page")
    public void verify_user_is_on_cases_page() {
        cpf.verifyCasesPage();
    }
    @Then("User is able to click on create button")
    public void user_is_able_to_click_on_create_button() {
        cpf.clickOnCreateButton();
    }
    @When("User is enter the cases fields in cases page")
    public void user_is_enter_the_cases_fields_in_cases_page() {
        HashMap<String,String> objCases = new HashMap<String,String>();
        objCases.put("Title",caseTitle);
        objCases.put("user","withusers");
        objCases.put("names","Ravi Shyam Bonthu");
        objCases.put("assignTo","Ravi Shyam Bonthu");
        objCases.put("Company","tcs");
        objCases.put("Contacts","ravi shyambonthu");
        objCases.put("Deal","testdeal1682683941");
        objCases.put("Type","Type");
        objCases.put("selValue","Technical Support");
        objCases.put("Priority","High");
        objCases.put("Status","Enquiring");
        cpf.casesEnterSAllFields(objCases);
    }

    @Then("User is able to click on save button")
    public void userIsAbleToClickOnSaveButton() {
         cpf.clickOnSaveButton();
    }

    @And("verify that user is able to save the created cases")
    public void verifyThatUserIsAbleToSaveTheCreatedCases() {
        cpf.createdCases();
    }
}
