package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class CasesPageEdit {

    @FindBy(xpath = "//span[@class='item-text' and text()='Cases']") WebElement leftPanelEntity;
    @FindBy(xpath = "//span[@class='selectable ' and text()='Cases']") WebElement casesHeader;
    @FindBy(xpath = "//button[text()='Create']") WebElement createButton;
    @FindBy(xpath = "//i[@class='save icon']") WebElement saveButton;
    private WebDriver driver = Hooks.driver;

    public CasesPageEdit(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

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
                driver.findElement(By.xpath(String.format(viewXPath, sSearchValue))).click();
                //Check page header
                //checkPageHeader(sSearchValue, "view page is not displayed");
                break;
            }
            case "edit": {
                driver.findElement(By.xpath(String.format(editXPath, sSearchValue))).click();
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
    public void enterFieldsCases(HashMap<String, String> objMapCaseFields) {
        if (objMapCaseFields.containsKey("Title")) {
            titleField.sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
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
    public void verifyCasesCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(caseCreatedHeader));
        assertTrue(caseCreatedHeader.isDisplayed());
    }
    public void editCreatedCases(HashMap<String,String> mapCasesEdit) throws InterruptedException {
        navigateCasesPage();
        performTableOperation(mapCasesEdit.get("existCase"),"edit");
        enterFieldsCases(mapCasesEdit);
        saveButton.click();
        verifyCasesCreated();
    }
}
