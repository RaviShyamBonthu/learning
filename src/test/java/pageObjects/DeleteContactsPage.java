package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.Hooks;

import java.time.Duration;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteContactsPage {
    private WebDriver driver = Hooks.driver;

    public DeleteContactsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='item-text' and text()='Contacts']")
    WebElement leftPanelEntity;

    public void navigateContactsPage() throws InterruptedException {
        leftPanelEntity.click();
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//span[@class='selectable ' and text()='Contacts']") WebElement contactsHeader;
    @FindBy(xpath = "//button[text()='Create']") WebElement createNewButton;

    public void verifyContactPage() {
        System.out.println("Contacts text Verify");
        String contactsHeaderText = contactsHeader.getText();
        assertEquals(contactsHeaderText, "Contacts");
        System.out.println("verification completed");
    }

    public void clickOnCreateButton() {
        createNewButton.click();
    }

    String pageDropDown = "//label[text()='%s']/.././div[@role='listbox']";
    String selectValueDropDown = "//div[@class='visible menu transition']/div/span[text()='%s']";
    @FindBy(xpath = "//input[@name='title']") WebElement titleField;
    String tdLocator = "//a[text()='%s']";
    private final String viewXPath = "//a[text()='%s']/ancestor::td/following-sibling::td[@class='right aligned collapsing options-buttons-container']/a/button[@class='ui icon button']/i[@class='unhide icon']";
    private final String editXPath = "//a[text()='%s']/ancestor::td/following-sibling::td[@class='right aligned collapsing options-buttons-container']/a/button/i[@class='edit icon']";
    private final String deleteXPath = "//a[text()='%s']/ancestor::td/following-sibling::td[@class='right aligned collapsing options-buttons-container']/button/i[@class='trash icon']";
    By dlgLocDelete = By.xpath("//div[@class='ui modal transition visible active']");
    public void selectItemFromDropdown(String sDropdownItem, String sSearchValue) {
        By locTxtDropDown = By.xpath(String.format(pageDropDown, sDropdownItem));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locTxtDropDown)).click();
        //select the text in drop down.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(selectValueDropDown, sSearchValue))));
        //click on element in select value in drop down
        driver.findElement(By.xpath(String.format(selectValueDropDown, sSearchValue))).click();
    }

    @FindBy(xpath = "//input[@name='first_name']") WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']") WebElement lastName;
    @FindBy(xpath = "//label[text()='Status']/.././div[@role='listbox']") WebElement status;
    @FindBy(xpath = " //div[@class='visible menu transition']/div/span[text()='%s'") WebElement statusDropDown;
    @FindBy(xpath = "//label[text()='Description']/parent::div/textarea") WebElement description;
    @FindBy(xpath = "//i[@class='save icon']") WebElement saveButton;

    public void enterContactsALLFields(HashMap<String, String> mapContacts) throws InterruptedException {
        if (mapContacts.containsKey("FirstName")) {
            firstName.sendKeys(mapContacts.get("FirstName"));
        }
        if (mapContacts.containsKey("LastName")) {
            lastName.sendKeys(mapContacts.get("LastName"));
        }
        if (mapContacts.containsKey("Status")) {
            selectItemFromDropdown("Status",mapContacts.get("Status"));
        }
        if (mapContacts.containsKey("Description")) {
            //Thread.sleep(2000);
            description.sendKeys(mapContacts.get("Description"));
        }
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }
    @FindBy(xpath = "//span[@class='selectable ']") WebElement contactHeader;
    public void verifySavedContactsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactHeader));
        assertTrue(contactHeader.isDisplayed());
    }
    public void performTableOperation(String sSearchValue, String operation) {
        //find the Search value is displayed in the table
        By eleTable = By.xpath(String.format(tdLocator, sSearchValue));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(eleTable));
         switch (operation) {
            case "view": {
                driver.findElement(By.xpath(String.format(viewXPath, sSearchValue)));
                //Check page header
                //checkPageHeader(sSearchValue, "view page is not displayed");
                break;
            }
            case "edit": {
                driver.findElement(By.xpath(String.format(editXPath, sSearchValue)));
                // Check Page header
                //checkPageHeader(sSearchValue, "Edit page is not displayed");
                break;
            }
            case "delete": {
                driver.findElement(By.xpath(String.format(deleteXPath, sSearchValue))).click();
                //wait until popUp is displayed
                wait.until(ExpectedConditions.visibilityOfElementLocated(dlgLocDelete));
            }
        }
    }

    private static By popUpPage = By.xpath("//div[@class='ui page modals dimmer transition visible active']");
    private String popUpHeader = "//div[@class='ui page modals dimmer transition visible active']//div[@class='header' and text()='%s']";

    public void checkPopupIsDisplayed(String sHeaderName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait until pop up is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpPage));
        By updatePopUpLoc = By.xpath(String.format(popUpHeader, sHeaderName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(updatePopUpLoc));
    }

    private static By popUpHeader1 = By.xpath("//div[@class='ui modal transition visible active']");
    private static final String buttonOnPopup = "//div[@class='ui page modals dimmer transition visible active']//button[text()='%s']";

    //Perform action on popup
    public void performOperationOnPopUp(String sOperation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpHeader1));
        String sButton = "";
        switch (sOperation.toUpperCase()) {
            case "OK":
                sButton = "OK";
                break;
            case "CANCEL":
                sButton = "Cancel";
                break;
            case "DELETE":
                sButton = "Delete";
                break;
        }
        By popUpButtonLoc = By.xpath(String.format(buttonOnPopup, sButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpButtonLoc));
        driver.findElement(popUpButtonLoc).click();
    }


}



