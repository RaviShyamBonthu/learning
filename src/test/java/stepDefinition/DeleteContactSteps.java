package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DeleteContactsPage;

public class DeleteContactSteps {

    private WebDriver driver = Hooks.driver;
    DeleteContactsPage dcp = new DeleteContactsPage(driver);

    @When("user is able to navigate to the  Contacts page")
    public void user_navigates_the_contact_page() throws InterruptedException {
        dcp.navigateContactsPage();

    }

    @Then("user is able to delete the created contacts")
    public void userIsAbleToDeleteTheCreatedContacts() {
        dcp.performTableOperation("pavani pemmadi","delete");
        dcp.performOperationOnPopUp("DELETE");

    }
}
