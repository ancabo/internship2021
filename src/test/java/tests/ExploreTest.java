package tests;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.TestBase;
import pages.ChatPage;
import pages.ExplorePage;
import pages.GeneralInfoPage;
import pages.SocialMediaPage;

public class ExploreTest extends TestBase {
	ExplorePage explorePage;
	SocialMediaPage socialMedia;
	GeneralInfoPage generalInfo;
	ChatPage chat;

	@BeforeMethod
	public void beforeMethod() {
		explorePage = new ExplorePage(driver);
		socialMedia = new SocialMediaPage(driver);
		generalInfo = new GeneralInfoPage(driver);
		chat = new ChatPage(driver);
	}

	@Test
	public void verifyExploreButton() {
		Assert.assertTrue(explorePage.exploreBtnDisplayed(), "Explore button is not displayed");
		logReport("Pass", "Explore Button - ok");
	}


	@Test
	public void verifyInfo() throws InterruptedException { 

		//Validate that the Explore button exists 
		Assert.assertTrue(explorePage.exploreBtnDisplayed(), "Title button is not displayed");
		logReport("Pass", "Title Button - ok");

		//Click the Explore button
		explorePage.exploreBtnClicked();
		implicitWait(10);

		//Validate that the title "Explore the hotel" exists
		Assert.assertEquals(explorePage.textEqual(), "EXPLORE THE HOTEL", "Not as expected");
		logReport("Pass", "The title 'Explore the hotel' exists");

		//Validate that the "Amenities&Services" exists
		Assert.assertEquals(explorePage.amentiesGetText(), "AMENITIES & SERVICES", "Not as expected");
		logReport("Pass", "The \"Amenities&Services\" exists");

		//Validate that the "Cleaning Services" exists
		Assert.assertEquals(explorePage.cleaningGetText(), "Cleaning Services", "Not as expected");
		logReport("Pass", "The \"Cleaning Services\" exists");

		//Validate that the "Free Parking" exists
		Assert.assertEquals(explorePage.parkingGetText(), "Free Parking", "Not as expected");
		logReport("Pass", "The \"Free Parking\" exists");

		//Validate that the "Fully Furnished" exists
		Assert.assertEquals(explorePage.furnishedGetText(), "Fully Furnished", "Not as expected");
		logReport("Pass", "The \"Fully Furnished\" exists");

		//Validate that the "Free WIFI" exists
		Assert.assertEquals(explorePage.wifiGetText(), "Free WiFi", "Not as expected");
		logReport("Pass", "The \"Free WIFI\" exists");

		//Validate that the "Airport Transfers" exists
		Assert.assertEquals(explorePage.airportGetText(), "Airport Transfers", "Not as expected");
		logReport("Pass", "The \"Airport Transfers\" exists");

		//Validate that the "Explore the city" title exists
		Assert.assertEquals(explorePage.exploreCityGetText(), "EXPLORE THE CITY", "Not as expected");
		logReport("Pass", "The \"Explore the city\" title exists");

		//Validate that the "Chinatown" box exists
		Assert.assertEquals(explorePage.chinaTownGetText(), "Chinatown", "Not as expected");
		logReport("Pass", "The \"Chinatown\" box exists");

		//Validate that the "Haight & Ashbury" box exists
		Assert.assertEquals(explorePage.haightAshburyGetText(), "Haight & Ashbury", "Not as expected");
		logReport("Pass", "The \"Haight & Ashbury\" box exists");

		//Validate that the "Golden Gate Bridge" box exists
		Assert.assertEquals(explorePage.bridgeGetText(), "Golden Gate Bridge", "Not as expected");
		logReport("Pass", "The \"Golden Gate Bridge\" box exists");

		driver.switchTo().defaultContent();
	}

	@Test
	public void verifyBackground() throws InterruptedException { 
		//Click the Explore button
		explorePage.exploreBtnClicked();
		implicitWait(10);

		Assert.assertTrue(explorePage.backgroundDisplayed(), "Background is not displayed");
		logReport("Pass", "Background - ok");
	}

	@Test 
	public void verifySocialMedia() throws InterruptedException { 
		//Click the Explore button
		explorePage.exploreBtnClicked();
		waitPageLoad(3000);

		Assert.assertEquals(socialMedia.getSocialMediaIcons().size(), 3, "There are not 3 icons");
		logReport("Pass", "The number of icons - ok");
		Assert.assertEquals(socialMedia.getSocialMediaLinkList().size(), 3, "There are not 3 links");
		logReport("Pass", "The number of links - ok");

		ArrayList<String> socialMediaList = socialMedia.getSocialMediaLinkList() ;
		Assert.assertEquals(socialMediaList.get(0), "http://www.facebook.com/wix", "The fb link is not ok");
		logReport("Pass", "The fb link is ok");

		socialMedia.facebookClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("facebook"), "Facebook page is not displayed");
		logReport("Pass", "Facebook page is displayed ok");

		driver.close();
		socialMedia.switchToTab(0);

		Assert.assertEquals(socialMediaList.get(1), "http://www.twitter.com/wix", "The twiter link is not ok");
		logReport("Pass", "The twitter link is ok");
		socialMedia.twitterClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("twitter"), "Twiter page is not displayed");
		logReport("Pass", "Twiter page is displayed ok");
		driver.close();
		socialMedia.switchToTab(0);

		Assert.assertEquals(socialMediaList.get(2), "http://pinterest.com/wixcom/", "The pinterest link is not ok");
		logReport("Pass", "The pinterest link is ok");
		socialMedia.pinterestClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("pinterest"), "Pinterest page is not displayed");
		logReport("Pass", "Pinterest page is displayed ok");
		driver.close();

	}


	@Test 
	public void verifyGeneralInfo() throws InterruptedException { 
		//Click the Explore button
		explorePage.exploreBtnClicked();
		implicitWait(10);

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
		logReport("Pass", "The number of titles is ok");

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
	public void verifyChat() throws InterruptedException {
		//Click the Explore button
		explorePage.exploreBtnClicked();

		waitPageLoad(3000);

		//swich to frame
		chat.switchToChat();

		//Validate that the Chat button exists 
		Assert.assertTrue(chat.chatBtnisDisplayed(), "Chat is not displayed");
		logReport("Pass", "Chat is displayed ok");

		//Click the chat button
		chat.chatBtnClicked();

		//Enter a message/emoji 
		chat.emojiBtnClicked();
		Assert.assertTrue(chat.emojiBtnDisplayed(), "Emoji button is not selected");
		logReport("Pass", "Emoji button is selected ok");

		chat.emojiClicked();
		Assert.assertTrue(chat.emojiDisplayed(), "Emoji is not selected");
		logReport("Pass", "Emoji is selected ok");

		chat.sendEmojiClicked();

		Assert.assertTrue(chat.expectedEmojiDisplayed(), "Emoji is not dispayed");
		logReport("Pass", "Emoji is dispayed ok");


		//Enter all the information and click the submit button
		Assert.assertTrue(chat.formDisplayed(), "Chat is not displayed");
		logReport("Pass", "Chat is dispayed ok");

		chat.nameClicked();
		chat.nameSendDisplayed();
		Assert.assertTrue(chat.nameDisplayed(), "Name is not displayed");
		logReport("Pass", "Name is dispayed ok");

		chat.emailClicked();
		chat.emailSendDisplayed();
		Assert.assertTrue(chat.emailDisplayed(), "Email is not displayed");
		logReport("Pass", "Email is dispayed ok");

		chat.messageClicked();
		chat.messageSendDisplayed();
		Assert.assertTrue(chat.messageDisplayed(), "Name is not displayed");
		logReport("Pass", "Mesaage is dispayed ok");

		chat.submitClicked();
		Assert.assertTrue(chat.submitDisplayed(), "Submit has a problem");
		logReport("Pass", "Submit ok");

		//Click the attachment button
		Assert.assertTrue(chat.attachmentDisplayed(), "Attachment button is not displayed");
		logReport("Pass", "Attachment button is displayed ok");
		chat.addFileDisplayed();

		implicitWait(10);

	}

}
