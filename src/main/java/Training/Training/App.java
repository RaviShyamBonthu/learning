package Training.Training;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        WebDriverManager.chromedriver().setup();
        
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        WebDriver driver = new ChromeDriver(options);
        
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://www.gmail.com");
        System.out.println("page title - " + driver.getTitle());
        
        driver.quit();
    }
}
