package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DeleteDealsPage;

import java.util.HashMap;

public class DeleteDealsSteps {
    private WebDriver driver = Hooks.driver;
    DeleteDealsPage ddp = new DeleteDealsPage(driver);
    String dealTitle = Hooks.getRandomString("Tasks",8);

    @Then("User is navigate to Deals page page")
    public void userIsNavigateToDealsPagePage() throws InterruptedException {
        ddp.navigateDealsPage();
    }

    @And("verifies the Deals Title")
    public void verifiesTheDealsTitle() {
        ddp.verifyTitleDeals();
    }

    @Then("Click on create button in Deals page")
    public void clickOnCreateButtonInDealsPage() {
        ddp.clickOnCreateButton();
    }

    @And("user enter the fields in Deals module")
    public void userEnterTheFieldsInDealsModule() {
        HashMap<String,String> objDealsMap = new HashMap<>();
        objDealsMap.put("Title",dealTitle);
        objDealsMap.put("DropDown","Assigned To");
        objDealsMap.put("selectItem","Ravi Shyam Bonthu");
        ddp.enterFieldsDeals(objDealsMap);
    }

    @When("User is click on save button")
    public void userIsClickOnSaveButton() {
        ddp.clickOnSaveButton();
    }

    @And("User is see the information on Deals page are created")
    public void userIsSeeTheInformationOnDealsPageAreCreated() {
         ddp.dealsCreated();
    }

    @Then("user is delete the created Deals")
    public void userIsDeleteTheCreatedDeals() throws InterruptedException {
        ddp.deleteCreatedDeals(dealTitle,"delete");
        ddp.clickOnDelete("Confirm Deletion","DELETE");
    }

    @And("verify the deal is deleted")
    public void verifyTheDealIsDeleted() throws InterruptedException {
        ddp.verifyCasesListNotDisplay(dealTitle);
    }
}
