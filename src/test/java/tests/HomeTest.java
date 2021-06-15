package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomeTest {
	private WebDriver driver;
	
	 @BeforeTest
	    public void beforeTest() {
	        ChromeOptions options = new ChromeOptions();
	        options.setAcceptInsecureCerts(true);
	    
	      //  options.AddArguments("--disable-gpu");
	        //  driver = new FirefoxDriver();
	      	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	    	driver.get("https://ancabota09.wixsite.com/intern");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    @AfterTest
	    public void afterTest() {
	    	if (driver != null)
				driver.quit();
	    }
	    
	    
	    @Test
	    public void verifyHomeTab() {
	    	 //verify page title
	    	 HomePage homePage = new HomePage(driver);
	    	 Assert.assertEquals(homePage.getPageTitle(), "HOME | Intern", "Title is not as expected");
	    	 Assert.assertEquals(homePage.getHeaderText(), "HOME & AWAY", "Not as expected");
	      	 Assert.assertTrue(homePage.homeTabDisplayed(), "Home tab is not displayed"); 
	    }

}
