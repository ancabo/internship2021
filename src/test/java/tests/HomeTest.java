package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@Test
	public void verifyAdults() throws InterruptedException { 
		Thread.sleep(1000);
		homePage.frameWixHotels();

		Assert.assertTrue(homePage.adultsDisplayed(), "Adults field is not displayed");
		homePage.adultsUpClicked();
		homePage.adultsUpClicked();

		Thread.sleep(1000);
		Assert.assertTrue( homePage.twoUpAdultsDisplayed(), "There are not 3 adults");
		Thread.sleep(1000);

		homePage.adultsDownClicked();

		Assert.assertTrue( homePage.oneDownAdultsDisplayed(), "There are not 2 adults");
		Thread.sleep(1000);

	}

	@Test
	public void verifyKids() throws InterruptedException { 
		homePage.frameWixHotels1();

		Assert.assertTrue(homePage.kidsDisplayed(), "Kids field is not displayed");
		homePage.kidsUpClicked();
		homePage.kidsUpClicked();

		Assert.assertTrue( homePage.twoUpKidsDisplayed(), "There are not 3 kids");
		Thread.sleep(1000);

		homePage.kidsDownClicked();

		Assert.assertTrue( homePage.oneDownKidsDisplayed(), "There are not 2 kids");
		Thread.sleep(1000);

	}


	@Test
	public void verifyChat() throws InterruptedException {
		Thread.sleep(3000);

		//swich to frame
		homePage.switchToChat();

		Thread.sleep(1000);

		//Validate that the Chat button exists 
		Assert.assertTrue(homePage.chatBtnisDisplayed(), "Chat is not displayed");

		//Click the chat button
		homePage.chatBtnClicked();

		Thread.sleep(1000);

		//Enter a message/emoji 
		homePage.emojiBtnClicked();
		Assert.assertTrue(homePage.emojiBtnDisplayed(), "Emoji button is not selected");

		Thread.sleep(1000);
		homePage.emojiClicked();
		Assert.assertTrue(homePage.emojiDisplayed(), "Emoji is not selected");

		Thread.sleep(1000);

		homePage.sendEmojiClicked();

		Assert.assertTrue(homePage.expectedEmojiDisplayed(), "Emoji is not dispayed");

		//Enter all the information and click the submit button
		Assert.assertTrue(homePage.formDisplayed(), "Chat is not displayed");

		homePage.nameClicked();
		homePage.nameSendDisplayed();
		Assert.assertTrue(homePage.nameDisplayed(), "Name is not displayed");

		Thread.sleep(1000);

		homePage.emailClicked();
		homePage.emailSendDisplayed();
		Assert.assertTrue(homePage.emailDisplayed(), "Email is not displayed");

		Thread.sleep(1000);

		homePage.messageClicked();
		homePage.messageSendDisplayed();
		Assert.assertTrue(homePage.messageDisplayed(), "Name is not displayed");

		Thread.sleep(1000);

		homePage.submitClicked();
		Assert.assertTrue(homePage.submitDisplayed(), "Submit has a problem");

		Thread.sleep(3000);

		//Click the attachment button
		Assert.assertTrue(homePage.attachmentDisplayed(), "Chat is not displayed");
		homePage.addFileDisplayed();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

	@Test 
	public void verifyGeneralInfo() { 
		//Validate that the address exists at the bottom of the page
		Assert.assertTrue(homePage.addressDisplayed(), "Address is not displayed");
		Assert.assertTrue(homePage.addressDisplayed1(), "Address is not displayed");
		Assert.assertTrue(homePage.addressDisplayed2(), "Address is not displayed");


		//Validate that the contact information exist at the bottom of the page
		Assert.assertTrue(homePage.addressDisplayed(), "Contact is not displayed");
		Assert.assertTrue(homePage.addressDisplayed1(), "Contact is not displayed");

		homePage.contactAcceptDisplayed2();
		driver.switchTo().defaultContent();

		Assert.assertTrue(homePage.contactDisplayed2(), "Contact is not displayed");


		//Validate that the site information exist at the bottom of the page
		Assert.assertTrue(homePage.homeDisplayed1(), "Home&Away is not displayed");
		Assert.assertTrue(homePage.homeDisplayed2(), "Home&Away is not displayed");
		Assert.assertTrue(homePage.homeDisplayed3(), "Home&Away is not displayed");
		driver.switchTo().defaultContent();
	}

	@Test
	void verifyBookNow() throws InterruptedException {
		//Validate that the Book Now button exists 
		Assert.assertTrue(homePage.bookNowDisplayed(), "Book Now is not displayed");

		//Click the Book Now button
		homePage.bookNowClicked();

		Assert.assertTrue( homePage.roomsDisplayed(), "Rooms page is not displayed");

		Thread.sleep(1000);
	}

	@Test 
	public void verifySearch() throws InterruptedException { 
		Thread.sleep(3000);

		//Validate that frame exists
		homePage.frameWixHotels();
		Thread.sleep(3000);

		//Click the check in field
		homePage.checkInClicked();
		Thread.sleep(1000);

		//switch to default
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		//Click on a date (later than today)
		//switch to check-in frame
		homePage.switchToframe();
		Thread.sleep(1000);

		//select a date ->later than today
		Thread.sleep(1000);
		homePage.dataCheckInClicked();
		Thread.sleep(3000);

		homePage.frameWixHotels1();
		Assert.assertEquals(homePage.actualDateCheckIn(), "29 Jun 2021");

		//switch to default
		driver.switchTo().defaultContent();

		homePage.switchToframe();

		Thread.sleep(1000);
		homePage.dataCheckOutClicked();

		Thread.sleep(1000);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckOut(), "6 Jul 2021");

		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		homePage.frameWixHotels1();

		Thread.sleep(1000);

		//Validate that the Search button exists
		Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");

		//Click the Search button (after the other fields are completed)
		homePage.searchBtnClicked();

		Thread.sleep(2000);

		homePage.switchTo(0);

		Assert.assertTrue(homePage.getUrl().contains("rooms"), "Rooms page is not displayed");	
		homePage.closeDriver();

		Thread.sleep(3000);
	}

	@Test 
	public void verifyCheckIn() throws InterruptedException { 
		Thread.sleep(3000);

		//Validate that frame exists
		homePage.frameWixHotels();
		Thread.sleep(3000);

		//Click the check in field
		homePage.checkInClicked();
		Thread.sleep(1000);

		//switch to default
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		//Click on a date (later than today)
		//switch to check-in frame
		homePage.switchToframe();
		Thread.sleep(1000);

		//select a date ->later than today
		Thread.sleep(1000);
		homePage.dataCheckInClicked();
		Thread.sleep(3000);

		homePage.frameWixHotels1();
		Assert.assertEquals(homePage.actualDateCheckIn(), "30 Jun 2021");


		Thread.sleep(1000);
		WebDriverWait wait1 = new WebDriverWait(driver, 3000);
		WebElement dataBtn = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='check-in'][1]")));
		dataBtn.click();

		//switch to default
		driver.switchTo().defaultContent();

		//switch to check-in frame
		homePage.switchToframe();

		Thread.sleep(1000);

		homePage.switchToframe();
		homePage.nextMonthClicked();

		Thread.sleep(1000);
		homePage.dataCheckIn1Clicked();
		Thread.sleep(3000);

		homePage.frameWixHotels1();
		Assert.assertEquals(homePage.actualDateCheckIn(), "30 Jul 2021");

		//switch to default
		driver.switchTo().defaultContent();

		homePage.switchToframe();

		Thread.sleep(1000);
		homePage.dataCheckOutClicked();

		Thread.sleep(1000);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckOut(), "6 Aug 2021");

		homePage.adultsUpClicked();
		homePage.kidsUpClicked();

		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		homePage.frameWixHotels1();

		Thread.sleep(1000);

		//Validate that the Search button exists
		Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");

		//Click the Search button (after the other fields are completed)
		homePage.searchBtnClicked();

		Thread.sleep(2000);

		homePage.switchTo(0);

		Assert.assertTrue(homePage.getUrl().contains("rooms"), "Rooms page is not displayed");	
		homePage.closeDriver();

		Thread.sleep(3000);
	}
}
