package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.Hooks;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CasesPageAllFields {
    private WebDriver driver = Hooks.driver;

    public CasesPageAllFields(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='item-text' and text()='Cases']") WebElement leftPanelEntity;
    @FindBy(xpath = "//span[@class='selectable ' and text()='Cases']") WebElement casesHeader;
    @FindBy(xpath = "//button[text()='Create']") WebElement createButton;
    @FindBy(xpath = "//i[@class='save icon']") WebElement saveButton;
    public void navigateToCasesPage() throws InterruptedException {
        leftPanelEntity.click();
        Thread.sleep(3000);
    }

    public void verifyCasesPage() {
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

    public void selectItemFromDropdown(String sDropdownItem, String sSearchValue) {
        By locTxtDropDown = By.xpath(String.format(pageDropDown, sDropdownItem));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locTxtDropDown)).click();
        //select the text in drop down.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(selectValueDropDown, sSearchValue))));
        //click on element in select value in drop down
        driver.findElement(By.xpath(String.format(selectValueDropDown, sSearchValue))).click();
    }

    String privateAccess = "//label[text()='Access']/following::div/div[2]/div[@class='ui fluid multiple selection dropdown']";
    String publicLoc = "(//label[text()='Access']/following::div/div/button[contains(@class,positive)])[1]";
    String accessDropDown = "//div[@class='visible menu transition']/div/span[contains(text(),'%s')]";

    public void setPrivate(String users, String[] names) {
        WebElement publicAccess = driver.findElement(By.xpath(publicLoc));
        driver.findElement(By.xpath(publicLoc)).click();
        Assert.assertTrue(publicAccess.isDisplayed());
        if (users.equals("withusers")) {
            driver.findElement(By.xpath(privateAccess)).click();
            List<String> entity = new ArrayList<>(Arrays.asList(names));
            for (String sEntity : entity) {
                String updatedLoc = String.format(accessDropDown, sEntity);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(updatedLoc)));
                driver.findElement(By.xpath(updatedLoc)).click();
            }
        }
    }

    private String comboBoxXpath = "//label[text()='%s'] //parent:: div //div[@role='combobox']//input";
    private static final By locListBox = By.xpath("//div[contains(@class,'ui active visible fluid')]//div[@role='option']");
    private final String locExistItem = "//div[contains(@class,'ui active visible fluid')]//div[@role='option']//span[contains(text(),'%s')]";
    private final String locNewItem = "//div[contains(@class,'ui active visible fluid')]//div[@role='option']//span/b[contains(text(),'%s')]";

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean searchNSelectItemFromList(String searchLocator, String value) {
        String updatedLocator = String.format(comboBoxXpath, searchLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(updatedLocator)));
        driver.findElement(By.xpath(updatedLocator)).click();
        WebElement ele = driver.findElement(By.xpath(updatedLocator));
        Actions action = new Actions(driver);
        action.moveToElement(ele).sendKeys(value).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locListBox));
        boolean Exists = isElementPresent(By.xpath(String.format(locExistItem, value)));
        //verify the combo box list is exists or not
        if (Exists) {
            //click on exist item in list
            driver.findElement(By.xpath(String.format(locExistItem, value))).click();
        } else {
            boolean NewExists = isElementPresent(By.xpath(String.format(locNewItem, value)));
            if (!NewExists) {
                System.out.println("Item is not displayed");
                return false;
            }
            //click on new item in list
            driver.findElement(By.xpath(String.format(locNewItem, value))).click();
        }
        return true;
    }
    public void casesEnterSAllFields(HashMap<String,String> objMapCases) {
        if (objMapCases.containsKey("Title")) {
            titleField.sendKeys(objMapCases.get("Title"));
        }
        String user = "";
        if(objMapCases.containsKey("user")) {
            user = objMapCases.get("user");
        }
        if(objMapCases.containsKey("names")) {
            setPrivate(user, new String[]{objMapCases.get("names")});
        }
        if(objMapCases.containsKey("assignTo")) {
            selectItemFromDropdown("Assigned To",objMapCases.get("assignTo"));
        }
        if(objMapCases.containsKey("Company")) {
            searchNSelectItemFromList("Company",objMapCases.get("Company"));
        }
        if(objMapCases.containsKey("Contacts")) {
            searchNSelectItemFromList("Contact",objMapCases.get("Contacts"));
        }
        if(objMapCases.containsKey("Deal")) {
            searchNSelectItemFromList("Deal",objMapCases.get("Deal"));
        }
        String typeDropDown = "";
        if(objMapCases.containsKey("Type")) {
            typeDropDown = objMapCases.get("Type");
        }
        if(objMapCases.containsKey("selValue")) {
            selectItemFromDropdown(typeDropDown,objMapCases.get("selValue"));
        }
        if(objMapCases.containsKey("Priority")) {
            selectItemFromDropdown("Priority",objMapCases.get("Priority"));
        }
        if(objMapCases.containsKey("Status")) {
            selectItemFromDropdown("Status",objMapCases.get("Status"));
        }

    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    @FindBy(xpath = "//span[@class='selectable ']") WebElement caseCreatedHeader;
    public void createdCases() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(caseCreatedHeader));
        assertTrue(caseCreatedHeader.isDisplayed());
    }

}
