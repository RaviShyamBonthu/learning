package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.ContactsCreatedMandatoryField;

public class ContactStepsForMandatoryField {

    private WebDriver driver = Hooks.driver;
    ContactsCreatedMandatoryField cpm = new ContactsCreatedMandatoryField(driver);

    @Then("user navigates the contact page")
    public void user_navigates_the_contact_page() throws InterruptedException {
        cpm.navigateContactsPage();
    }

    @And("user is verify the contacts page")
    public void userIsVerifyTheContactsPage() {
     cpm.verifyContactPage();
    }

    @When("user is click on create new button")
    public void userIsClickOnCreateNewButton() {
        cpm.createNewButton();
    }

    @And("user is enter contacts page mandatory field")
    public void userIsEnterContactsPageMandatoryField() {
        cpm.enterContactFlied();
    }

    @Then("user is able to click the save button")
    public void userIsAbleToClickTheSaveButton() {
        cpm.saveButton();
    }

    @And("verify that the user is able to save contacts")
    public void verifyThatTheUserIsAbleToSaveContacts() {
        cpm.verifySavedContacts();
    }

}
