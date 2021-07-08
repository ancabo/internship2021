package tests;

import java.util.ArrayList;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.TestBase;
import pages.ChatPage;
import pages.GeneralInfoPage;
import pages.HomePage;
import pages.SocialMediaPage;

public class HomeTest extends TestBase{
	HomePage homePage;
	SocialMediaPage socialMedia;
	GeneralInfoPage generalInfo;
	ChatPage chat;
	
	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(driver);
		socialMedia = new SocialMediaPage(driver);
		generalInfo = new GeneralInfoPage(driver);
		chat = new ChatPage(driver);
	}

	@Test
	public void verifyHomeTab() {
		//verify page title
		Assert.assertEquals(getTitle(), "HOME | Intern", "Title is not as expected");
		Assert.assertEquals(homePage.getHeaderText(), "HOME & AWAY", "Not as expected");
		Assert.assertTrue(homePage.homeTabDisplayed(), "Home tab is not displayed"); 
	}

	@Test
	public void verifyBackground() { 
		Assert.assertTrue(homePage.backgroundDisplayed(), "Background is not displayed");
	}

	@Test  // //span[.='ADDRESS']/../../following-sibling::*[2]/p
	public void verifySocialMedia() throws InterruptedException { 
		
//		Assert.assertTrue(socialMedia.facebookIconDisplayed(), "Facebook icon is not displayed");
//		Assert.assertTrue(socialMedia.twiterIconDisplayed(), "Twiter icon is not displayed");
//		Assert.assertTrue(socialMedia.pinterestIconDisplayed(), "Pinterest icon is not displayed");
//		socialMedia.facebookClicked();
//		socialMedia.switchTo(1);
//		Assert.assertTrue(socialMedia.getUrl().contains("facebook"), "Facebook page is not displayed");
//		driver.close();
//		socialMedia.switchTo(0);
//
//
//		socialMedia.twitterClicked();
//		socialMedia.switchTo(1);
//		Assert.assertTrue(socialMedia.getUrl().contains("twitter"), "Twiter page is not displayed");
//		driver.close();
//		socialMedia.switchTo(0);
//
//		//Click the Pinterest icon
//		socialMedia.pinterestClicked();
//		socialMedia.switchTo(1);
//		Assert.assertTrue(socialMedia.getUrl().contains("pinterest"), "Pinterest page is not displayed");
//		driver.close();
		
		Assert.assertEquals(socialMedia.getSocialMediaIcons().size(), 3, "There are not 3 icons");
		Assert.assertEquals(socialMedia.getSocialMediaLinkList().size(), 3, "There are not 3 links");
	
		ArrayList<String> socialMediaList = socialMedia.getSocialMediaLinkList() ;
		Assert.assertEquals(socialMediaList.get(0), "http://www.facebook.com/wix", "The fb link is not ok");
		Assert.assertEquals(socialMediaList.get(1), "http://www.twitter.com/wix", "The twiter link is not ok");
		Assert.assertEquals(socialMediaList.get(2), "http://pinterest.com/wixcom/", "The pinterest link is not ok");

	}

	@Test
	public void verifyAdults() throws InterruptedException { 
		waitPageLoad(1000);
		homePage.frameWixHotels();

		//implicitWait(20);
		Assert.assertTrue(homePage.adultsDisplayed(), "Adults field is not displayed");
		Assert.assertTrue(homePage.adultsUpDisplayed(), "Adults up button is not displayed");
		
		homePage.adultsUpClicked();
		homePage.adultsUpClicked();
		
		//implicitWait(20);
		Assert.assertEquals( homePage.adultsgetText(), "Adults" + '\n' +"3");
		
		implicitWait(20);
		Assert.assertTrue(homePage.adultsDownDisplayed(), "Adults down button is not displayed");
		homePage.adultsDownClicked();

		implicitWait(20);
		Assert.assertEquals( homePage.adultsgetText(), "Adults" + '\n' + "2");
		implicitWait(40);

	}

	@Test
	public void verifyKids() throws InterruptedException { 
		Thread.sleep(1000);
		homePage.frameWixHotels();

		Assert.assertTrue(homePage.kidsDisplayed(), "Kids field is not displayed");
		Assert.assertTrue(homePage.kidsUpDisplayed(), "Kids up button is not displayed");
		homePage.kidsUpClicked();
		homePage.kidsUpClicked();

		Assert.assertEquals( homePage.kidsGetText(), "2");
		Thread.sleep(1000);

		Assert.assertTrue(homePage.kidsDownDisplayed(), "Kids down button is not displayed");
		homePage.kidsDownClicked();

		Assert.assertEquals( homePage.kidsGetText(), "1");
		Thread.sleep(1000);

	}


	@Test
	public void verifyChat() throws InterruptedException {
		waitPageLoad(3000);

		//swich to frame
		chat.switchToChat();

		//Validate that the Chat button exists 
		Assert.assertTrue(chat.chatBtnisDisplayed(), "Chat is not displayed");

		//Click the chat button
		chat.chatBtnClicked();

		//Enter a message/emoji 
		chat.emojiBtnClicked();
		Assert.assertTrue(chat.emojiBtnDisplayed(), "Emoji button is not selected");

		chat.emojiClicked();
		Assert.assertTrue(chat.emojiDisplayed(), "Emoji is not selected");

		chat.sendEmojiClicked();

		Assert.assertTrue(chat.expectedEmojiDisplayed(), "Emoji is not dispayed");

		//Enter all the information and click the submit button
		Assert.assertTrue(chat.formDisplayed(), "Chat is not displayed");

		chat.nameClicked();
		chat.nameSendDisplayed();
		Assert.assertTrue(chat.nameDisplayed(), "Name is not displayed");

		chat.emailClicked();
		chat.emailSendDisplayed();
		Assert.assertTrue(chat.emailDisplayed(), "Email is not displayed");

		chat.messageClicked();
		chat.messageSendDisplayed();
		Assert.assertTrue(chat.messageDisplayed(), "Name is not displayed");

		chat.submitClicked();
		Assert.assertTrue(chat.submitDisplayed(), "Submit has a problem");

		//Click the attachment button
		Assert.assertTrue(chat.attachmentDisplayed(), "Chat is not displayed");
		chat.addFileDisplayed();

		implicitWait(10);

	}

	@Test 
	public void verifyGeneralInfo() { 
//		//Validate that the address exists at the bottom of the page
//		Assert.assertTrue(generalInfo.addressDisplayed(), "Address is not displayed");
//		Assert.assertTrue(generalInfo.addressDisplayed1(), "Address is not displayed");
//		Assert.assertTrue(generalInfo.addressDisplayed2(), "Address is not displayed");
//
//
//		//Validate that the contact information exist at the bottom of the page
//		Assert.assertTrue(generalInfo.addressDisplayed(), "Contact is not displayed");
//		Assert.assertTrue(generalInfo.addressDisplayed1(), "Contact is not displayed");
//
//		generalInfo.contactAcceptDisplayed2();
//		driver.switchTo().defaultContent();
//
//		Assert.assertTrue(generalInfo.contactDisplayed2(), "Contact is not displayed");
//
//
//		//Validate that the site information exist at the bottom of the page
//		Assert.assertTrue(generalInfo.homeDisplayed1(), "Home&Away is not displayed");
//		Assert.assertTrue(generalInfo.homeDisplayed2(), "Home&Away is not displayed");
//		Assert.assertTrue(generalInfo.homeDisplayed3(), "Home&Away is not displayed");
//		driver.switchTo().defaultContent();
		
		Assert.assertEquals(generalInfo.getGeneralInfoTitles().size(), 4, "There are not 4 titles");
		Assert.assertEquals(generalInfo.getGeneralInfoTitleText().size(), 4, "There are not 4 titles");
	
		ArrayList<String> generalInfoList = generalInfo.getGeneralInfoTitleText() ;
		Assert.assertEquals(generalInfoList.get(0), "ADDRESS", "The Adress title is not ok");
		Assert.assertEquals(generalInfoList.get(1), "CONTACT", "The Contact title is not ok");
		Assert.assertEquals(generalInfoList.get(2), "HOME & AWAY", "The Home&Away title is not ok");
		Assert.assertEquals(generalInfoList.get(3), "WE ACCEPT", "The accept title is not ok");
		
		
	}

	@Test
	void verifyBookNow() throws InterruptedException {
		//Validate that the Book Now button exists 
		Assert.assertTrue(homePage.bookNowDisplayed(), "Book Now is not displayed");

		//Click the Book Now button
		homePage.bookNowClicked();

		Assert.assertTrue( homePage.roomsDisplayed(), "Rooms page is not displayed");
	}
	
	@Test 
	public void verifySearch() throws InterruptedException { 
		//waitPageLoad(4000);
		Thread.sleep(3000);
		
		//Validate that frame exists
		homePage.frameWixHotels();

		//Click the check in field
		homePage.checkInClicked();
		implicitWait(100);
		
		//switch to default
		driver.switchTo().defaultContent();
		implicitWait(100);
		

		//Click on a date (later than today)
		//switch to check-in frame
		homePage.switchToframe();
		Thread.sleep(1000);
		//implicitWait(100);

		//select a date ->later than today
		homePage.dataCheckInClicked();
		implicitWait(100);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckIn(), "12 Jul 2021");

		//switch to default
		driver.switchTo().defaultContent();

		homePage.switchToframe();

		homePage.dataCheckOutClicked();

		Thread.sleep(1000);
		
		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckOut(), "24 Jul 2021");

		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		homePage.frameWixHotels();

		Thread.sleep(1000);

		//Validate that the Search button exists
		Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");

		//Click the Search button (after the other fields are completed)
		homePage.searchBtnClicked();

		Thread.sleep(2000);

		homePage.switchTo(0);

		Assert.assertTrue(getCurrentURL().contains("rooms"), "Rooms page is not displayed");	
		driver.close();

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

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckIn(), "12 Jul 2021");


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

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckIn(), "17 Aug 2021");

		//switch to default
		driver.switchTo().defaultContent();

		homePage.switchToframe();

		Thread.sleep(1000);
		homePage.dataCheckOutClicked();

		Thread.sleep(1000);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckOut(), "24 Aug 2021");

		homePage.adultsUpClicked();
		homePage.kidsUpClicked();

		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		homePage.frameWixHotels();

		Thread.sleep(1000);

		//Validate that the Search button exists
		Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");

		//Click the Search button (after the other fields are completed)
		homePage.searchBtnClicked();

		Thread.sleep(2000);

		homePage.switchTo(0);

		Assert.assertTrue(getCurrentURL().contains("rooms"), "Rooms page is not displayed");	
		driver.close();

		Thread.sleep(3000);
	}
}
