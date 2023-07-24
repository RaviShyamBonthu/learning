package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesPagePurge;

import java.util.HashMap;

public class CasesPagePurgeSteps {
    private WebDriver driver = Hooks.driver;
    CasesPagePurge cpp = new CasesPagePurge(driver);
    String caseTitle = Hooks.getRandomString("TestCase",9);
    @Then("User is navigate to the case page")
    public void userIsNavigateToTheCasePage() throws InterruptedException {
        cpp.navigateCasesPage();
    }

    @And("verify that user is able to there in cases page")
    public void verifyThatUserIsAbleToThereInCasesPage() {
        cpp.verifyCasesTitle();
    }

    @When("User is click on create button")
    public void userIsClickOnCreateButton() {
        cpp.clickOnCreateButton();
    }

    @And("User is able fill the cases page fields")
    public void userIsAbleFillTheCasesPageFields() {
        HashMap<String,String> objCases = new HashMap<String,String>();
        objCases.put("Title",caseTitle);
        objCases.put("DropDown","Assigned To");
        objCases.put("selectItem","Ravi Shyam Bonthu");
        cpp.enterFieldsCases(objCases);
    }

    @Then("User is able to the click on save button")
    public void userIsAbleToTheClickOnSaveButton() {
        cpp.clickOnSaveButton();
    }

    @And("User is verify that case created")
    public void userIsVerifyThatCaseCreated() {
        cpp.casesCreated();
    }

    @Then("User is able to delete the create case")
    public void userIsAbleToDeleteTheCreateCase() throws InterruptedException {
        cpp.deleteCreatedCases(caseTitle,"delete");
        cpp.clickOnDelete("Confirm Deletion","DELETE");
    }

    @And("User is verify that created case deleted")
    public void userIsVerifyThatCreatedCaseDeleted() {
        cpp.verifyCasesListNotDisplay(caseTitle);
    }

    @Then("User is click on RubbishBin")
    public void userIsClickOnRubbishBin() throws InterruptedException {
        cpp.rubbishBin("Case");
    }

    @And("User is able to click on deleted check box in rubbishBin page")
    public void userIsAbleToClickOnDeletedCheckBoxInRubbishBinPage() {
        cpp.selectedCheckBox(caseTitle);
    }

    @Then("user is able click on purge button")
    public void userIsAbleClickOnPurgeButton() throws InterruptedException {
        cpp.purgeSelected("Purge","OK");
    }
}
