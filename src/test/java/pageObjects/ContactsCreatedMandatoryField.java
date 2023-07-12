package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactsCreatedMandatoryField {
    private WebDriver driver = Hooks.driver;

    public ContactsCreatedMandatoryField(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='item-text' and text()='Contacts']")
    WebElement leftPanelEntity;
    @FindBy(xpath = "//span[@class='selectable ' and text()='Contacts']")
    WebElement contactsHeader;
    @FindBy(xpath = "//button[text()='Create']")
    WebElement createNewButton;

    @FindBy(xpath = "//input[@name='first_name']") WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']") WebElement lastName;
    @FindBy(xpath = "//i[@class='save icon']") WebElement saveButton;
    @FindBy(xpath ="//label[text()='Description']/parent::div/textarea" ) WebElement description;
    @FindBy(xpath = "//label[text()='Status']/.././div[@role='listbox']") WebElement statusDropDown;





    public void navigateContactsPage() throws InterruptedException {
        leftPanelEntity.click();
        Thread.sleep(3000);
    }

    public void verifyContactPage() {
        System.out.println("Contacts text Verify");
        String contactsHeaderText = contactsHeader.getText();
        assertEquals(contactsHeaderText,"Contacts");
        System.out.println("verification completed");

    }

    public void createNewButton() {
        createNewButton.click();
    }
    public  void enterContactFlied(){
        firstName.sendKeys("avinash");
        lastName.sendKeys("mummana");
    }
    public void saveButton(){
        saveButton.click();
    }

    @FindBy(xpath = "//span[@class='selectable ']") WebElement contactHeader;
    public void verifySavedContacts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactHeader));
        assertTrue(contactHeader.isDisplayed());
    }

}

