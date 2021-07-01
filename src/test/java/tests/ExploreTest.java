package tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ExplorePage;

public class ExploreTest {
	private WebDriver driver; 
	ExplorePage explorePage;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\z004c2sx\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		explorePage = new ExplorePage(driver);
		driver.get("https://ancabota09.wixsite.com/intern"); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}

	@AfterTest 
	public void afterClass() { 
		driver.quit(); 
	} 


	@Test
	public void verifyExploreButton() {
		Assert.assertTrue(explorePage.exploreBtnDisplayed(), "Explore button is not displayed");
	}
	
	
	@Test
	public void verifyInfo() throws InterruptedException { 

		//Validate that the Explore button exists 
		Assert.assertTrue(explorePage.exploreBtnDisplayed(), "Title button is not displayed");

		//Click the Explore button
		explorePage.exploreBtnClicked();
		Thread.sleep(3000);
		
		//Validate that the title "Explore the hotel" exists
		Assert.assertEquals(explorePage.textEqual(), "EXPLORE THE HOTEL", "Not as expected");

		//Validate that the "Amenities&Services" exists
		Assert.assertEquals(explorePage.amentiesGetText(), "AMENITIES & SERVICES", "Not as expected");

		//Validate that the "Cleaning Services" exists
		Assert.assertEquals(explorePage.cleaningGetText(), "Cleaning Services", "Not as expected");

		//Validate that the "Free Parking" exists
		Assert.assertEquals(explorePage.parkingGetText(), "Free Parking", "Not as expected");

		//Validate that the "Fully Furnished" exists
		Assert.assertEquals(explorePage.furnishedGetText(), "Fully Furnished", "Not as expected");

		//Validate that the "Free WIFI" exists
		Assert.assertEquals(explorePage.wifiGetText(), "Free WiFi", "Not as expected");

		//Validate that the "Airport Transfers" exists
		Assert.assertEquals(explorePage.airportGetText(), "Airport Transfers", "Not as expected");

		//Validate that the "Explore the city" title exists
		Assert.assertEquals(explorePage.exploreCityGetText(), "EXPLORE THE CITY", "Not as expected");

		//Validate that the "Chinatown" box exists
		Assert.assertEquals(explorePage.chinaTownGetText(), "Chinatown", "Not as expected");

		//Validate that the "Haight & Ashbury" box exists
		Assert.assertEquals(explorePage.haightAshburyGetText(), "Haight & Ashbury", "Not as expected");

		//Validate that the "Golden Gate Bridge" box exists
		Assert.assertEquals(explorePage.bridgeGetText(), "Golden Gate Bridge", "Not as expected");

		driver.switchTo().defaultContent();
	}

	@Test
	public void verifyBackground() throws InterruptedException { 
		//Click the Explore button
		explorePage.exploreBtnClicked();
		Thread.sleep(3000);

		Assert.assertTrue(explorePage.backgroundDisplayed(), "Background is not displayed");
	}

	@Test 
	public void verifySocialMedia() throws InterruptedException { 
		//Click the Explore button
		explorePage.exploreBtnClicked();
		Thread.sleep(3000);

		Assert.assertTrue(explorePage.facebookIconDisplayed(), "Facebook icon is not displayed");
		//Assert.assertTrue(explorePage.twiterIconDisplayed(), "Twiter icon is not displayed");
		Assert.assertTrue(explorePage.pinterestIconDisplayed(), "Pinterest icon is not displayed");
		explorePage.facebookClicked();
		explorePage.switchTo(1);
		Assert.assertTrue(explorePage.getUrl().contains("facebook"), "Facebook page is not displayed");
		explorePage.closeDriver();
		explorePage.switchTo(0);

		explorePage.twitterClicked();
		explorePage.switchTo(1);
		Assert.assertTrue(explorePage.getUrl().contains("twitter"), "Twiter page is not displayed");
		explorePage.closeDriver();
		explorePage.switchTo(0);

		//Click the Pinterest icon
		explorePage.pinterestClicked();
		explorePage.switchTo(1);
		Assert.assertTrue(explorePage.getUrl().contains("pinterest"), "Pinterest page is not displayed");
		explorePage.closeDriver();

	}


	@Test 
	public void verifyGeneralInfo() throws InterruptedException { 
		//Click the Explore button
		explorePage.exploreBtnClicked();
		Thread.sleep(3000);
		
		//Validate that the address exists at the bottom of the page
		Assert.assertTrue(explorePage.addressDisplayed(), "Address is not displayed");
		Assert.assertTrue(explorePage.addressDisplayed1(), "Address is not displayed");
		Assert.assertTrue(explorePage.addressDisplayed2(), "Address is not displayed");


		//Validate that the contact information exist at the bottom of the page
		Assert.assertTrue(explorePage.addressDisplayed(), "Contact is not displayed");
		Assert.assertTrue(explorePage.addressDisplayed1(), "Contact is not displayed");

		explorePage.contactAcceptDisplayed2();
		driver.switchTo().defaultContent();

		Assert.assertTrue(explorePage.contactDisplayed2(), "Contact is not displayed");


		//Validate that the site information exist at the bottom of the page
		Assert.assertTrue(explorePage.homeDisplayed1(), "Home&Away is not displayed");
		Assert.assertTrue(explorePage.homeDisplayed2(), "Home&Away is not displayed");
		Assert.assertTrue(explorePage.homeDisplayed3(), "Home&Away is not displayed");
		driver.switchTo().defaultContent();
	}

	@Test
	public void verifyChat() throws InterruptedException {
		//Click the Explore button
		explorePage.exploreBtnClicked();
		Thread.sleep(3000);

		//swich to frame
		explorePage.switchToChat();

		Thread.sleep(1000);

		//Validate that the Chat button exists 
		Assert.assertTrue(explorePage.chatBtnisDisplayed(), "Chat is not displayed");

		//Click the chat button
		explorePage.chatBtnClicked();

		Thread.sleep(1000);

		//Enter a message/emoji 
		explorePage.emojiBtnClicked();
		Assert.assertTrue(explorePage.emojiBtnDisplayed(), "Emoji button is not selected");

		Thread.sleep(1000);
		explorePage.emojiClicked();
		Assert.assertTrue(explorePage.emojiDisplayed(), "Emoji is not selected");

		Thread.sleep(1000);

		explorePage.sendEmojiClicked();

		Assert.assertTrue(explorePage.expectedEmojiDisplayed(), "Emoji is not dispayed");

		//Enter all the information and click the submit button
		Assert.assertTrue(explorePage.formDisplayed(), "Chat is not displayed");

		explorePage.nameClicked();
		explorePage.nameSendDisplayed();
		Assert.assertTrue(explorePage.nameDisplayed(), "Name is not displayed");

		Thread.sleep(1000);

		explorePage.emailClicked();
		explorePage.emailSendDisplayed();
		Assert.assertTrue(explorePage.emailDisplayed(), "Email is not displayed");

		Thread.sleep(1000);

		explorePage.messageClicked();
		explorePage.messageSendDisplayed();
		Assert.assertTrue(explorePage.messageDisplayed(), "Name is not displayed");

		Thread.sleep(1000);

		explorePage.submitClicked();
		Assert.assertTrue(explorePage.submitDisplayed(), "Submit has a problem");

		Thread.sleep(3000);

		//Click the attachment button
		Assert.assertTrue(explorePage.attachmentDisplayed(), "Chat is not displayed");
		explorePage.addFileDisplayed();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

}
