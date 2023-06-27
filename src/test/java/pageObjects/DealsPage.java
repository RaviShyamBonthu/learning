package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.Hooks;

import static org.junit.Assert.assertEquals;

public class DealsPage {
    private WebDriver driver = Hooks.driver;
    public DealsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='item-text' and text()='Deals']") WebElement leftPanelEntity;
    public void navigateToCases() throws InterruptedException {
        leftPanelEntity.click();
        Thread.sleep(10000);
    }

    @FindBy(xpath="//span[@class='selectable ' and text()='Deals']") WebElement dealsHeader;
    public void verifyDealsText(){
        System.out.println("cases text verification");
        String dealsHeaderText = dealsHeader.getText();
        assertEquals(dealsHeaderText,"Deals");
        System.out.println("verification completed");
    }
    @FindBy(xpath = "//button[text()='Create']") WebElement createButton;
    @FindBy(xpath = "//input[@name='title']") WebElement titleField;
    public void createDeals() {
        createButton.click();
    }

    public void enterFields() throws InterruptedException {
        titleField.sendKeys("TestCases");
        Thread.sleep(3000);
    }


    public void navigateToDeals() {
    }
}


