package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesPageRubbishBin;

import java.util.HashMap;

public class CasesRubbishBinSteps {
    private WebDriver driver = Hooks.driver;
    CasesPageRubbishBin cpr = new CasesPageRubbishBin(driver);
    String caseTitle = Hooks.getRandomString("TestCase",9);
    @Then("user is able to navigate to the cases page")
    public void userIsAbleToNavigateToTheCasesPage() throws InterruptedException {
        cpr.navigateCasesPage();
    }

    @And("verify that user is on cases page")
    public void verifyThatUserIsOnCasesPage() {
        cpr.verifyCasesTitle();
    }

    @When("user is able to click on create button")
    public void userIsAbleToClickOnCreateButton() {
        cpr.clickOnCreateButton();
    }

    @And("user is able to enter the cases fields")
    public void userIsAbleToEnterTheCasesFields() {
        HashMap<String,String> objCases = new HashMap<String,String>();
        objCases.put("Title",caseTitle);
        objCases.put("DropDown","Assigned To");
        objCases.put("selectItem","Ravi Shyam Bonthu");
        cpr.enterFieldsCases(objCases);

    }

    @Then("user is able to click on save button")
    public void userIsAbleToClickOnSaveButton() {
        cpr.clickOnSaveButton();
    }

    @And("Verify that user is able to created the cases page")
    public void verifyThatUserIsAbleToCreatedTheCasesPage() {
        cpr.casesCreated();
    }

    @Then("user is able to delete the created case")
    public void userIsAbleToDeleteTheCreatedCase() throws InterruptedException {
        cpr.deleteCreatedCases(caseTitle,"delete");
        cpr.clickOnDelete("Confirm Deletion","DELETE");
    }

    @And("verify that user is able to delete the created case")
    public void verifyThatUserIsAbleToDeleteTheCreatedCase() {
        cpr.verifyCasesListNotDisplay(caseTitle);
    }

    @Then("user is able to click on Rubbish Bin")
    public void userIsAbleToClickOnRubbishBin() throws InterruptedException {
        cpr.rubbishBin("Case");
    }

    @And("Verify that user is able to see the deleted case in ribbish Bin")
    public void verifyThatUserIsAbleToSeeTheDeletedCaseInRibbishBin() throws InterruptedException {
        cpr.selectedCheckBox(caseTitle);
    }
}
