package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomeTest {
	private WebDriver driver;
	HomePage homePage;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\z004c2sx\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		homePage = new HomePage(driver);
		
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
	    	 Assert.assertEquals(homePage.getPageTitle(), "HOME | Intern", "Title is not as expected");
	    	 Assert.assertEquals(homePage.getHeaderText(), "HOME & AWAY", "Not as expected");
	      	 Assert.assertTrue(homePage.homeTabDisplayed(), "Home tab is not displayed"); 
	    }
	    
	    @Test
		public void verifyBackground() { 
			Assert.assertTrue(homePage.backgroundDisplayed(), "Background is not displayed");
		}

}
