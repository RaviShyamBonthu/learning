package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

public class LoginSteps{
	
	private WebDriver driver = Hooks.driver;
	LoginPage lp = new LoginPage(driver);
	
	@Given("Launch the Cogmento application")
	public void launch_application() {
		Hooks.launchApplication();
	}

	@And("Click {string} button on welcome page")
	public void click_login_button_on_welcome_page(String loginlnk) {
		lp.clickLogin(loginlnk);
	}
	
	@And("Verify the Title on login page")
	public void verify_pagetitle() {
		lp.verifyTitle();
	}
	
	@When("User enters Username and password on login page")
	public void user_enters_username_and_password_on_login_page() {
	    lp.enterCredentials();
	}
	
	@And("Click {string} button on login page")
	public void user_clicks_the_login_button_on_login_page(String loginbtn) throws InterruptedException {
	    lp.clickLogin(loginbtn);
	}
	
	@Then("Verify the Cogmento logo on dashboard page")
	public void verify_the_cogmento_logo_on_dashboard_page() {
		lp.verifyLogo();
	}
	
}
