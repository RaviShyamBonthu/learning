package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.ContactsPageAllFields;

import java.util.HashMap;

public class ContactsPageStepsAllFields {

    private WebDriver driver = Hooks.driver;

    ContactsPageAllFields cpa = new ContactsPageAllFields(driver);

    @Then("User is navigate to contacts page")
    public void user_is_navigate_to_contacts_page() throws InterruptedException {
       cpa.navigateContactsPage();
    }

    @And("Verify user is on contacts page")
    public void verifyUserIsOnContactsPage() {
        cpa.verifyContactPage();
    }

    @When("User is click on create button")
    public void userIsClickOnCreateButton() {
        cpa.clickOnCreateButton();
    }

    @And("User is enter the all contacts fields")
    public void userIsEnterTheAllContactsFields() throws InterruptedException {
        HashMap<String,String> objMapContacts = new HashMap<>();
        objMapContacts.put("FirstName","pavani");
        objMapContacts.put("LastName","pemmadi");
        objMapContacts.put("Status","New");
        objMapContacts.put("Description","Hello avinash");
        cpa.enterContactsALLFields(objMapContacts);
    }

    @Then("User able to click the save button")
    public void userAbleToClickTheSaveButton() {
      cpa.clickOnSaveButton();
    }

    @And("verify that user is able to saved the contacts")
    public void verifyThatUserIsAbleToSavedTheContacts() {
        cpa.verifySavedContactsPage();
    }
}
