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

public class CasesPage {
    private WebDriver driver = Hooks.driver;

    public CasesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='item-text' and text()='Cases']") WebElement leftPanelEntity;
    String pageDropDown = "//label[text()='%s']/.././div[@role='listbox']";

    public void navigateToCases() throws InterruptedException {
        leftPanelEntity.click();
        Thread.sleep(5000);
    }

    @FindBy(xpath = "//span[@class='selectable ' and text()='Cases']") WebElement casesHeader;

    public void verifyCasesText() {
        System.out.println("cases text verification");
        String casesHeaderText = casesHeader.getText();
        assertEquals(casesHeaderText, "Cases");
        System.out.println("verification completed");
    }

    @FindBy(xpath = "//button[text()='Create']") WebElement createButton;
    @FindBy(xpath = "//input[@name='title']") WebElement titleField;
    @FindBy(xpath = "//label[text()='Assigned To']/following-sibling::div[@class='ui fluid selection dropdown']") WebElement assignedDropDown;
    String selectValueDropDown = "//div[@class='visible menu transition']/div/span[text()='%s']";
    @FindBy(xpath = "//i[@class='save icon']") WebElement saveButton;
    @FindBy(xpath = "//span[@class='selectable ']") WebElement caseCreatedHeader;

    public void createCases() {
        createButton.click();
    }

    public void selectItemFromDropdown(String sDropdownItem, String sSearchValue) {
        By locTxtDropDown = By.xpath(String.format(pageDropDown, sDropdownItem));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locTxtDropDown)).click();
        //select the text in drop down.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(selectValueDropDown, sSearchValue))));
        //click on element in select value in drop down
        driver.findElement(By.xpath(String.format(selectValueDropDown, sSearchValue))).click();
    }

    public void enterFields(HashMap<String, String> objMapCaseFields) throws InterruptedException {
        if (objMapCaseFields.containsKey("Title")) {
            titleField.sendKeys(objMapCaseFields.get("Title"));
        }
//        String dropDownTxt = "";
//        if (objMapCaseFields.containsKey("DropDown")) {
//            dropDownTxt = objMapCaseFields.get("DropDown");
//        }
//        if(objMapCaseFields.containsKey("selectItem")) {
//            selectItemFromDropdown(dropDownTxt,objMapCaseFields.get("selectItem"));
//        }
        Thread.sleep(2000);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void createdCasesSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(caseCreatedHeader));
        assertTrue(caseCreatedHeader.isDisplayed());
    }

}
