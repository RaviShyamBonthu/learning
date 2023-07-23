package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesPageEdit;

import java.util.HashMap;

public class CasesEditSteps {
    private WebDriver driver = Hooks.driver;
    CasesPageEdit cpe = new CasesPageEdit(driver);
    String caseTitle = Hooks.getRandomString("TestCase",9);
    @Then("user is navigate to cases page")
    public void userIsNavigateToCasesPage() throws InterruptedException {
        cpe.navigateCasesPage();

    }

    @And("user is verify the cases page")
    public void userIsVerifyTheCasesPage() {
        cpe.verifyCasesTitle();

    }

    @When("user is click on create button")
    public void userIsClickOnCreateButton() {
        cpe.clickOnCreateButton();
    }

    @And("user is enter fields in cases create page")
    public void userIsEnterFieldsInCasesCreatePage() {
        HashMap<String,String> objCases = new HashMap<String,String>();
        objCases.put("Title",caseTitle);
        objCases.put("DropDown","Assigned To");
        objCases.put("selectItem","Ravi Shyam Bonthu");
        cpe.enterFieldsCases(objCases);
    }

    @Then("verify that user is saved the created case page")
    public void verifyThatUserIsSavedTheCreatedCasePage() {
        cpe.clickOnSaveButton();
        cpe.verifyCasesCreated();
    }

    @And("user is edit the case title in created cases page")
    public void userIsEditTheCaseTitleInCreatedCasesPage() throws InterruptedException {
        HashMap<String,String> objCases = new HashMap<String,String>();
        objCases.put("existCase",caseTitle);
        cpe.editCreatedCases(objCases);
    }
}
