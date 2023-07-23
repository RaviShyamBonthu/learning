package pageObjects;

import org.junit.Assert;
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

public class CasesPagePurge {
    private WebDriver driver = Hooks.driver;
    public CasesPagePurge(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class='item-text' and text()='Cases']")
    WebElement leftPanelEntity;
    @FindBy(xpath = "//span[@class='selectable ' and text()='Cases']") WebElement casesHeader;
    @FindBy(xpath = "//button[text()='Create']") WebElement createButton;
    @FindBy(xpath = "//i[@class='save icon']") WebElement saveButton;
    public void navigateCasesPage() throws InterruptedException {
        Thread.sleep(2000);
        leftPanelEntity.click();
        Thread.sleep(2000);
    }
    public void verifyCasesTitle(){
        System.out.println("cases text verification");
        String casesHeaderText = casesHeader.getText();
        assertEquals(casesHeaderText, "Cases");
    }
    public void clickOnCreateButton() {
        createButton.click();
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

    public void performTableOperation(String sSearchValue, String operation) {
        //find the Search value is displayed in the table
        By eleTable = By.xpath(String.format(tdLocator, sSearchValue));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(eleTable));
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

    private static By popUpHeader1 = By.xpath("//div[@class='ui page modals dimmer transition visible active']");
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

    public void enterFieldsCases(HashMap<String, String> objMapCaseFields) {
        if (objMapCaseFields.containsKey("Title")) {
            titleField.sendKeys(objMapCaseFields.get("Title"));
        }
        String dropDownTxt = "";
        if (objMapCaseFields.containsKey("DropDown")) {
            dropDownTxt = objMapCaseFields.get("DropDown");
        }
        if(objMapCaseFields.containsKey("selectItem")) {
            selectItemFromDropdown(dropDownTxt,objMapCaseFields.get("selectItem"));
        }
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }
    @FindBy(xpath = "//span[@class='selectable ']") WebElement caseCreatedHeader;
    public void casesCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(caseCreatedHeader));
        assertTrue(caseCreatedHeader.isDisplayed());
    }
    public void deleteCreatedCases(String sSelectValue,String sOperation) throws InterruptedException {
        navigateCasesPage();
        performTableOperation(sSelectValue,sOperation);
    }

    public void clickOnDelete(String sValue, String sOperator) {
        checkPopupIsDisplayed(sValue);
        performOperationOnPopUp(sOperator);
    }

    public void verifyCasesListNotDisplay(String selectVal) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='selectable ']")));
        System.out.println(driver.getPageSource().contains(selectVal));
        Assert.assertFalse(driver.getPageSource().contains(selectVal));
    }

    private final String rubbishBinPage = "//div[@class='ui menu']/a[text()='%s']";
    private final String rubbishBinCBox = "//td/a[text()='%s']/ancestor::tr//td[@class='collapsing']";
    private static By deIcon = By.xpath("//button[@class='ui basic button item']//parent::div/button[2]");
    public void rubbishBin(String operation) throws InterruptedException {
        Thread.sleep(3000);
        //wait until element is display of trash icon
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(deIcon));
        //click on trash icon
        driver.findElement(deIcon).click();
        String updatedRubbishBinPage = String.format(rubbishBinPage, operation);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(updatedRubbishBinPage)));
        //click on page in rubbish bin page
        driver.findElement(By.xpath(updatedRubbishBinPage)).click();
    }

    public void selectedCheckBox(String sCheckBox) {
        String upDatedCheckBox = String.format(rubbishBinCBox, sCheckBox);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(upDatedCheckBox)));
        //click on check box
        driver.findElement(By.xpath(upDatedCheckBox)).click();
    }
    private static By purgeButton = By.xpath("//button[@class='ui negative button']");
    private static By restoreButton = By.xpath("//i[@class='undo icon']");
    public void purgeSelected(String operation, String sPopUp)  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // scriptAction.waitUntilElementIsVisible(purgeButton, ApplicationConstants.MEDIUM_TIMEOUT);
        if (operation.equals("Purge")) {
            // click on PurgeSelected
            wait.until(ExpectedConditions.visibilityOfElementLocated(purgeButton));
            driver.findElement(purgeButton).click();
            performOperationOnPopUp(sPopUp);
        }
        //click on Restore
        else if (operation.equals("Restore")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(restoreButton));
            driver.findElement(restoreButton).click();
            performOperationOnPopUp(sPopUp);
        }
    }
}
