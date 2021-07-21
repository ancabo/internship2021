package tests;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

	@DataProvider(name = "Check-In")
	public Object[][] dataProvFunc(){
		return new Object[][]{
			{"26, Monday July 2021", "30, Friday July 2021", 3, 1},
			{"25, Sunday July 2021", "30, Friday July 2021", 5, 5},
			{"23, Friday July 2021", "30, Friday July 2021", 15, 2}
			//{"22", "28", 2, 1},
			//{"25", "29", 13, 5},
			//{"24", "29", 5, 6},
			//{"26", "30", 3, 5}
		};
	}

	@Test
	public void verifyHomeTab() {
		//verify page title
		Assert.assertEquals(getTitle(), "HOME | Intern", "Title is not as expected");
		logReport("Info", "Home title ok");
		Assert.assertEquals(homePage.getHeaderText(), "HOME & AWAY", "Not as expected");
		logReport("Info", "Home header ok");
		Assert.assertTrue(homePage.homeTabDisplayed(), "Home tab is not displayed"); 
		logReport("Info", "Home tab ok");
	}

	@Test
	public void verifyBackground() { 
		Assert.assertTrue(homePage.backgroundDisplayed(), "Background is not displayed");
		logReport("Pass", "Background - ok");
	}

	@Test
	public void verifySocialMedia() throws InterruptedException { 

		Assert.assertEquals(socialMedia.getSocialMediaIcons().size(), 3, "There are not 3 icons");
		logReport("Info", "The number of icons - ok");
		Assert.assertEquals(socialMedia.getSocialMediaLinkList().size(), 3, "There are not 3 links");
		logReport("Info", "The number of links - ok");

		ArrayList<String> socialMediaList = socialMedia.getSocialMediaLinkList() ;
		Assert.assertEquals(socialMediaList.get(0), "http://www.facebook.com/wix", "The fb link is not ok");
		logReport("Info", "The fb link is ok");

		socialMedia.facebookClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("facebook"), "Facebook page is not displayed");
		logReport("Pass", "Facebook page is displayed ok");

		driver.close();
		socialMedia.switchToTab(0);

		Assert.assertEquals(socialMediaList.get(1), "http://www.twitter.com/wix", "The twiter link is not ok");
		logReport("Info", "The twitter link is ok");
		socialMedia.twitterClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("twitter"), "Twiter page is not displayed");
		logReport("Pass", "Twiter page is displayed ok");
		driver.close();
		socialMedia.switchToTab(0);

		Assert.assertEquals(socialMediaList.get(2), "http://pinterest.com/wixcom/", "The pinterest link is not ok");
		logReport("Info", "The pinterest link is ok");
		socialMedia.pinterestClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("pinterest"), "Pinterest page is not displayed");
		logReport("Pass", "Pinterest page is displayed ok");
		driver.close();

	}

	@Test
	public void verifyAdults() throws InterruptedException { 
		waitPageLoad(1000);
		implicitWait(10);
		homePage.frameWixHotels();

		Assert.assertTrue(homePage.adultsDisplayed(), "Adults field is not displayed");
		logReport("Info", "Adults field is displayed ok");
		Assert.assertTrue(homePage.adultsUpDisplayed(), "Adults up button is not displayed");
		logReport("Info", "Adults up button is displayed ok");

		homePage.upClickedAdults(2);

		Assert.assertEquals( homePage.adultsgetText(), "Adults" + '\n' +"3");
		logReport("Pass", "Adults number as expected - up button ok");

		implicitWait(20);
		Assert.assertTrue(homePage.adultsDownDisplayed(), "Adults down button is not displayed");
		logReport("Info", "Adults down button is displayed ok");
		homePage.downClickedAdults(1);

		implicitWait(20);
		Assert.assertEquals( homePage.adultsgetText(), "Adults" + '\n' + "2");
		logReport("Pass", "Adults number as expected - down button ok");
		implicitWait(40);

	}

	@Test
	public void verifyKids() throws InterruptedException { 
		waitPageLoad(1000);
		homePage.frameWixHotels();

		Assert.assertTrue(homePage.kidsDisplayed(), "Kids field is not displayed");
		logReport("Info", "Kids field is displayed ok");
		Assert.assertTrue(homePage.kidsUpDisplayed(), "Kids up button is not displayed");
		logReport("Info", "Kids up button is displayed ok");
		homePage.upClickedKids(2);

		Assert.assertEquals( homePage.kidsGetText(), "2");
		logReport("Pass", "Kids number as expected - up button ok");
		implicitWait(20);

		Assert.assertTrue(homePage.kidsDownDisplayed(), "Kids down button is not displayed");
		logReport("Info", "Kids down button is displayed ok");
		homePage.downClickedKids(1);

		implicitWait(20);
		Assert.assertEquals( homePage.kidsGetText(), "1");
		logReport("Pass", "Kids number as expected - down button ok");

		implicitWait(10);

	}


	@Test
	public void verifyChat() throws InterruptedException {
		waitPageLoad(3000);

		//swich to frame
		chat.switchToChat();

		//Validate that the Chat button exists 
		Assert.assertTrue(chat.chatBtnisDisplayed(), "Chat is not displayed");
		logReport("Info", "Chat is displayed ok");

		//Click the chat button
		chat.chatBtnClicked();

		//Enter a message/emoji 
		chat.emojiBtnClicked();
		Assert.assertTrue(chat.emojiBtnDisplayed(), "Emoji button is not selected");
		logReport("Info", "Emoji button is selected ok");

		chat.emojiClicked();
		Assert.assertTrue(chat.emojiDisplayed(), "Emoji is not selected");
		logReport("Info", "Emoji is selected ok");

		chat.sendEmojiClicked();

		Assert.assertTrue(chat.expectedEmojiDisplayed(), "Emoji is not dispayed");
		logReport("Info", "Emoji is dispayed ok");


		//Enter all the information and click the submit button
		Assert.assertTrue(chat.formDisplayed(), "Chat is not displayed");
		logReport("Info", "Chat is dispayed ok");

		chat.nameClicked();
		chat.nameSendDisplayed();
		Assert.assertTrue(chat.nameDisplayed(), "Name is not displayed");
		logReport("Info", "Name is dispayed ok");

		chat.emailClicked();
		chat.emailSendDisplayed();
		Assert.assertTrue(chat.emailDisplayed(), "Email is not displayed");
		logReport("Info", "Email is dispayed ok");

		chat.messageClicked();
		chat.messageSendDisplayed();
		Assert.assertTrue(chat.messageDisplayed(), "Name is not displayed");
		logReport("Info", "Mesaage is dispayed ok");

		chat.submitClicked();
		Assert.assertTrue(chat.submitDisplayed(), "Submit has a problem");
		logReport("Info", "Submit ok");

		//Click the attachment button
		Assert.assertTrue(chat.attachmentDisplayed(), "Attachment button is not displayed");
		logReport("Info", "Attachment button is displayed ok");
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
		logReport("Info", "The number of titles is ok");

		ArrayList<String> generalInfoList = generalInfo.getGeneralInfoTitleText() ;
		Assert.assertEquals(generalInfoList.get(0), "ADDRESS", "The Adress title is not ok");
		logReport("Pass", "The Adress title is ok");
		Assert.assertEquals(generalInfoList.get(1), "CONTACT", "The Contact title is not ok");
		logReport("Pass", "The Contact title is ok");
		Assert.assertEquals(generalInfoList.get(2), "HOME & AWAY", "The Home&Away title is not ok");
		logReport("Pass", "The Home&Away title is ok");
		Assert.assertEquals(generalInfoList.get(3), "WE ACCEPT", "The accept title is not ok");
		logReport("Pass", "The accept title is ok");


	}

	@Test
	void verifyBookNow() throws InterruptedException {
		//Validate that the Book Now button exists 
		Assert.assertTrue(homePage.bookNowDisplayed(), "Book Now is not displayed");
		logReport("Info", "Book Now page is displayed ok");

		//Click the Book Now button
		homePage.bookNowClicked();

		Assert.assertTrue( homePage.roomsDisplayed(), "Rooms page is not displayed");
		logReport("Info", "Rooms page is displayed ok");
	}

	@Test 
	public void verifySearch() throws InterruptedException { 
		waitPageLoad(3000);

		//Validate that frame exists
		homePage.frameWixHotels();
		//implicitWait(50);
		Thread.sleep(100);

		//Click the check in field
		homePage.checkInClicked();
		implicitWait(20);

		//switch to default
		driver.switchTo().defaultContent();
		implicitWait(10);

		//Click on a date (later than today)
		//switch to check-in frame
		homePage.switchToframe();

		//select a date ->later than today
		//implicitWait(50);
		Thread.sleep(1000);


		homePage.dataCheckInClicked();
		implicitWait(50);


		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckIn(), "20 Jul 2021");
		logReport("Pass", "CheckIn data is ok");

		implicitWait(30);

		//switch to default
		driver.switchTo().defaultContent();

		homePage.switchToframe();

		implicitWait(40);
		homePage.dataCheckOutClicked();

		Thread.sleep(200);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckOut(), "30 Jul 2021");
		logReport("Pass", "CheckOut data is ok");

		implicitWait(10);
		driver.switchTo().defaultContent();

		homePage.frameWixHotels();

		//Validate that the Search button exists
		Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");
		logReport("Info", "Search button is displayed ok");

		//Click the Search button (after the other fields are completed)
		homePage.searchBtnClicked();

		implicitWait(20);
		homePage.switchTo(0);

		Assert.assertTrue(getCurrentURL().contains("rooms"), "Rooms page is not displayed");	
		logReport("Info", "Rooms page is displayed ok");
		driver.close();

	}
	@Test 
	public void verifyCheckIn() throws InterruptedException { 
		//Thread.sleep(3000);
		waitPageLoad(4000);

		//Validate that frame exists
		homePage.frameWixHotels();
		//Thread.sleep(3000);
		implicitWait(50);

		//Click the check in field
		homePage.checkInClicked();
		Thread.sleep(1000);

		//switch to default
		driver.switchTo().defaultContent();
		//Thread.sleep(1000);

		//Click on a date (later than today)
		//switch to check-in frame
		homePage.switchToframe();
		//Thread.sleep(1000);

		//select a date ->later than today
		Thread.sleep(1000);
		//implicitWait(20);
		homePage.dataCheckInClicked();
		//Thread.sleep(3000);
		implicitWait(50);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckIn(), "20 Jul 2021");
		logReport("Pass", "CheckIn data is ok");

		homePage.dataBtnClicked();

		//switch to default
		driver.switchTo().defaultContent();

		//switch to check-in frame
		homePage.switchToframe();

		Thread.sleep(1000);

		//implicitWait(15);
		homePage.switchToframe();

		//Thread.sleep(1000);
		homePage.dataCheckIn1Clicked();
		//Thread.sleep(3000);
		implicitWait(15);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckIn(), "21 Jul 2021");
		logReport("Pass", "CheckIn1 data is ok");

		//switch to default
		driver.switchTo().defaultContent();

		homePage.switchToframe();

		Thread.sleep(1000);
		//implicitWait(20);
		homePage.dataCheckOutClicked();

		Thread.sleep(1000);

		homePage.frameWixHotels();
		Assert.assertEquals(homePage.actualDateCheckOut(), "30 Jul 2021");
		logReport("Pass", "CheckOut data is ok");

		homePage.upClickedAdults(1);
		homePage.upClickedKids(1);

		//Thread.sleep(1000);
		implicitWait(10);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		homePage.frameWixHotels();

		//Thread.sleep(1000);

		//Validate that the Search button exists
		Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");
		logReport("Info", "Search button is displayed ok");

		//Click the Search button (after the other fields are completed)
		homePage.searchBtnClicked();

		//Thread.sleep(2000);
		implicitWait(20);

		homePage.switchTo(0);

		Assert.assertTrue(getCurrentURL().contains("rooms"), "Rooms page is not displayed");	
		logReport("Info", "Rooms page is displayed ok");
		driver.close();

		//Thread.sleep(3000);
	}

	@Test(dataProvider = "Check-In")
	public void checkIn(String checkInDate, String checkOutDate, int nrAdults, int nrKids) throws InterruptedException {

		waitPageLoad(4000);

		//Validate that frame exists
		homePage.frameWixHotels();
		implicitWait(50);
		Thread.sleep(1000);

		//Click the check in field
		homePage.checkInClicked();
		Thread.sleep(1000);

		//switch to default
		driver.switchTo().defaultContent();

		//Click on a date (later than today)
		//switch to check-in frame
		homePage.switchToframe();

		//select a date ->later than today
		Thread.sleep(1000);

		homePage.setCheckInAndClick(checkInDate);
		implicitWait(50);
		Thread.sleep(3000);

		homePage.frameWixHotels();
		//Assert.assertEquals(homePage.actualDateCheckIn(), "20 Jul 2021");

		//switch to default
		driver.switchTo().defaultContent();

		homePage.switchToframe();

		Thread.sleep(1000);
		homePage.setCheckOutAndClick(checkOutDate);

		Thread.sleep(1000);

		homePage.frameWixHotels();
		//Assert.assertEquals(homePage.actualDateCheckOut(), "30 Jul 2021");

		//homePage.upClickedAdults(1);
		homePage.upClickedAdults(nrAdults-1);
		homePage.upClickedKids(nrKids);

		implicitWait(10);
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		homePage.frameWixHotels();

		//Validate that the Search button exists
		Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");
		logReport("Info", "Search button is displayed ok");

		//Click the Search button (after the other fields are completed)
		homePage.searchBtnClicked();

		implicitWait(20);

		homePage.switchTo(0);

		Assert.assertTrue(getCurrentURL().contains("rooms"), "Rooms page is not displayed");	
		logReport("Info", "Rooms page is displayed ok");
		driver.close();
	}

	@Test
	public void checkInText() throws InterruptedException, IOException {

		int i = 0;
		int nrTeste = 3;
		while(nrTeste != 0) {
			nrTeste--;
			waitPageLoad(4000);
			Thread.sleep(2000);

			//Validate that frame exists
			homePage.frameWixHotels();
			implicitWait(100);

			//Click the check in field
			homePage.checkInClicked();
			//Thread.sleep(1000);
			implicitWait(100);

			//switch to default
			driver.switchTo().defaultContent();

			//Click on a date (later than today)
			//switch to check-in frame
			homePage.switchToframe();

			//select a date ->later than today
			Thread.sleep(1000);

			Vector<String> info = homePage.ReadFromFile();

			homePage.setCheckInAndChangeMonthText(info.get(i), info.get(++i) );


			implicitWait(50);
			Thread.sleep(3000);

			homePage.frameWixHotels();
			//Assert.assertEquals(homePage.actualDateCheckIn(), "20 Jul 2021");

			//switch to default
			driver.switchTo().defaultContent();

			homePage.switchToframe();

			//Thread.sleep(1000);
			implicitWait(20);
			homePage.setCheckOutAndClickText(info.get(++i));

			Thread.sleep(1000);

			homePage.frameWixHotels();
			//Assert.assertEquals(homePage.actualDateCheckOut(), "30 Jul 2021");

			//homePage.upClickedAdults(1);

			int getNrAdults = Integer.parseInt(info.get(++i));
			int getNrKids = Integer.parseInt(info.get(++i));

			homePage.upClickedAdults(getNrAdults-1);
			homePage.upClickedKids(getNrKids);

			implicitWait(10);
			driver.switchTo().defaultContent();

			Thread.sleep(1000);
			homePage.frameWixHotels();

			//Validate that the Search button exists
			Assert.assertTrue(homePage.searchBtnDisplayed(), "Search button is not displayed");
			logReport("Info", "Search button is displayed ok");

			//Click the Search button (after the other fields are completed)
			homePage.searchBtnClicked();

			implicitWait(20);

			homePage.switchTo(0);

			Assert.assertTrue(getCurrentURL().contains("rooms"), "Rooms page is not displayed");	
			logReport("Info", "Rooms page is displayed ok");
			//driver.close();
			i++;
			if (nrTeste != 0) 
				navigateToURL("https://ancabota09.wixsite.com/intern");
		}
	}
}
