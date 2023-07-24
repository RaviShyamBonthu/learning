package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.Hooks;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashBoard {
    private WebDriver driver = Hooks.driver;
    String getCogTitle = "Cogmento CRM";

    public DashBoard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//*[@id='top-header-menu']//child::div[@class='header item']") WebElement cogmentoHeader;
    @FindBy (xpath="//a[@href='/contacts/1b86f82b-6409-456e-8478-14031013fb6e']") WebElement contactInfo;
    @FindBy(xpath="//a[@href='/contacts/1b86f82b-6409-456e-8478-14031013fb6e']") WebElement contactActivity;


    public void navigateDashBoardPage() throws InterruptedException {
         String cogmentoTitle = driver.getTitle();
        System.out.println(cogmentoTitle);
        assertEquals(cogmentoTitle,getCogTitle);
        Thread.sleep(2000);

    }
    public void keyInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(contactInfo.isDisplayed());
        contactActivity.click();
        wait.until(ExpectedConditions.visibilityOf(cogmentoHeader));
        assertTrue(cogmentoHeader.isDisplayed());
    }

}

