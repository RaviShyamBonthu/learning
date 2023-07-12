package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.Hooks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class DashboardPage {
    String summary = "Deals Summary";
    private WebDriver driver = Hooks.driver;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//*[@id='top-header-menu']//child::div[@class='header item']") WebElement cogmentoHeader;
    @FindBy(xpath="//a[@href='/contacts/1b86f82b-6409-456e-8478-14031013fb6e']") WebElement contactActivity;
    @FindBy (xpath="//div[@class='header' and text()='Deals Summary']") WebElement dealsSummary;
    @FindBy (xpath="//i[@class='large user red icon']") WebElement contactHeader;

    @FindBy (xpath="//a[@href='/contacts/1b86f82b-6409-456e-8478-14031013fb6e']") WebElement contactInfo;

    //a[@href='/contacts/1b86f82b-6409-456e-8478-14031013fb6e']

//	public void verifyLogged() {
//		assertEquals(true,cogmentoHeader);
//	}

    public void dashBoardNavigation() {
        String dashBoardSummary = dealsSummary.getText();
        assertEquals(dashBoardSummary,summary);
    }

    public void dashBoardInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue((contactInfo).isDisplayed());
        contactActivity.click();
        //compare with assert to get title or not
        wait.until(ExpectedConditions.visibilityOf(cogmentoHeader));
        assertTrue(contactHeader.isDisplayed());
    }
}

