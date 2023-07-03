package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import stepDefinition.Hooks;

public class LoginPage{
	
	private WebDriver driver = Hooks.driver;
	
	public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Log In']") WebElement loginlnk;
	@FindBy(name="email") WebElement emailtxt;
	@FindBy(name="password") WebElement passwordtxt;
	@FindBy(xpath="//*[text()='Login']") WebElement loginbtn;
	@FindBy(xpath="//*[@id=\"top-header-menu\"]//child::div[@class=\"header item\"]") WebElement Cogmentologo;
	
	public void clickLogin(String button) {
		if(button.equals("Log In")){
			loginlnk.click();
		}else if(button.equals("Login")) {
			loginbtn.click();
		}
	}
	
	public void enterCredentials() {
		emailtxt.sendKeys(Hooks.user);
		passwordtxt.sendKeys(Hooks.pass);
	}
	
	public void verifyTitle(){
		assertEquals("Cogmento CRM", driver.getTitle());
    }
	
	public void verifyLogo() {
		assertTrue(Cogmentologo.isDisplayed());
	}
		
}
