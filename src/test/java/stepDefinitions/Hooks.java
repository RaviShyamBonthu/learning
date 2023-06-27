package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks{
	
	public static WebDriver driver;
	public static String url = "https://cogmento.com/";
	public static String user = "shyambonthu00@gmail.com";
	public static String pass = "Shyam@6009";
	
	@SuppressWarnings("deprecation")
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void launchApplication() {
		driver.get(url);
	}
	
	@After(order = 1)
	public void failedScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String folder = dateFormat.format(date);
			DateFormat timeFormat = new SimpleDateFormat("hh.mm.ss");
			String timeStamp = timeFormat.format(date);
			
			File file = new File(System.getProperty("user.dir")+"/Screenshots/"+ folder);
			if (!file.exists()) {
	            file.mkdir();
			}
			 String filepath = file+"/"+scenario.getName()+"_"+timeStamp+".png";
						
			TakesScreenshot ts = (TakesScreenshot) driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            File dest=new File(filepath);
            FileUtils.copyFile(src, dest);
		}
	}
	
	@After(order = 0)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
}
