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
	    
	    @Test 
		public void verifySocialMedia() throws InterruptedException { 
			Assert.assertTrue(homePage.facebookIconDisplayed(), "Facebook icon is not displayed");
			Assert.assertTrue(homePage.twiterIconDisplayed(), "Twiter icon is not displayed");
			Assert.assertTrue(homePage.pinterestIconDisplayed(), "Pinterest icon is not displayed");
			homePage.facebookClicked();
			homePage.switchTo(1);
		    Assert.assertTrue(homePage.getUrl().contains("facebook"), "Facebook page is not displayed");
		    homePage.closeDriver();
		    homePage.switchTo(0);
		    
		    homePage.twitterClicked();
		    homePage.switchTo(1);
			Assert.assertTrue(homePage.getUrl().contains("twitter"), "Twiter page is not displayed");
			homePage.closeDriver();
			homePage.switchTo(0);
			
			//Click the Pinterest icon
			homePage.pinterestClicked();
			homePage.switchTo(1);
			Assert.assertTrue(homePage.getUrl().contains("pinterest"), "Pinterest page is not displayed");
			homePage.closeDriver();
		
		}

}
