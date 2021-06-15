package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


public class TestBase {
	public static WebDriver driver;
	

	@BeforeTest(alwaysRun = true)
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
    	driver.get("https://ancabota09.wixsite.com/intern");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
