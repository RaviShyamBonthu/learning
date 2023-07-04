package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesPage;
import java.util.HashMap;

public class CasesSteps {
    private WebDriver driver = Hooks.driver;
    CasesPage cmp = new CasesPage(driver);
    String caseTitle = Hooks.getRandomString("TestCase",9);

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
        HashMap<String,String>  objCases = new HashMap<String,String>();
        objCases.put("Title",caseTitle);
//        objCases.put("DropDown","Assigned To");
//        objCases.put("selectItem","Ravi Shyam Bonthu");
        cmp.enterFields(objCases);
    }

    @Then("User click on save button")
    public void userClickOnSaveButton() {
        cmp.clickOnSaveButton();
    }

    @And("User is see the information for cases which is created")
    public void userIsSeeTheInformationForCasesWhichIsCreated() {
        cmp.createdCasesSuccess();
    }

}
