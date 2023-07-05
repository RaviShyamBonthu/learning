package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CasesDelete;
import pageObjects.CasesPage;

import java.util.HashMap;

public class CasesDeleteSteps {
    private WebDriver driver = Hooks.driver;

    CasesDelete cd = new CasesDelete(driver);
    String caseTitle = Hooks.getRandomString("TestCase",9);

    @Then("User is navigate to cases page")
    public void user_is_navigate_to_cases_page() throws InterruptedException {
        cd.navigateCasesPage();
    }

    @And("verifies the Cases Title")
    public void verifiesTheCasesTitle() {
        cd.verifyTitleCases();
    }

    @Then("Click on create button in cases page")
    public void clickOnCreateButtonInCasesPage() {
        cd.clickOnCreateButton();
    }

    @And("user enter the fields in cases module")
    public void userEnterTheFieldsInCasesModule() {
        HashMap<String,String> objCases = new HashMap<String,String>();
        objCases.put("Title",caseTitle);
        objCases.put("DropDown","Assigned To");
        objCases.put("selectItem","Ravi Shyam Bonthu");
        cd.enterFieldsCases(objCases);

    }

    @When("User is click on save button")
    public void userIsClickOnSaveButton() {
        cd.clickOnSaveButton();
    }

    @And("User is see the information on cases page are created")
    public void userIsSeeTheInformationOnCasesPageAreCreated() {
        cd.casesCreated();
    }

    @Then("user is navigate leftpanelEntity for cases")
    public void userIsNavigateLeftpanelEntityForCases() throws InterruptedException {
       cd.navigateCasesPage();
    }

    @And("user is delete the created cases")
    public void userIsDeleteTheCreatedCases() {
        cd.deleteCreatedCases(caseTitle,"delete");
        cd.clickOnDelete("Confirm Deletion","DELETE");
    }

    @Then("verify the list is deleted")
    public void verifyTheListIsDeleted() {
        cd.verifyCasesListNotDisplay(caseTitle);
    }
}
