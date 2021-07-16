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
	}


	@Test
	public void verifyInfo() throws InterruptedException { 

		//Validate that the Explore button exists 
		Assert.assertTrue(explorePage.exploreBtnDisplayed(), "Title button is not displayed");

		//Click the Explore button
		explorePage.exploreBtnClicked();
		implicitWait(10);

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
		implicitWait(10);

		Assert.assertTrue(explorePage.backgroundDisplayed(), "Background is not displayed");
	}

	@Test 
	public void verifySocialMedia() throws InterruptedException { 
		//Click the Explore button
		explorePage.exploreBtnClicked();
		waitPageLoad(3000);


		Assert.assertEquals(socialMedia.getSocialMediaIcons().size(), 3, "There are not 3 icons");
		Assert.assertEquals(socialMedia.getSocialMediaLinkList().size(), 3, "There are not 3 links");

		ArrayList<String> socialMediaList = socialMedia.getSocialMediaLinkList() ;
		Assert.assertEquals(socialMediaList.get(0), "http://www.facebook.com/wix", "The fb link is not ok");

		socialMedia.facebookClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("facebook"), "Facebook page is not displayed");
		driver.close();
		socialMedia.switchToTab(0);

		Assert.assertEquals(socialMediaList.get(1), "http://www.twitter.com/wix", "The twiter link is not ok");
		socialMedia.twitterClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("twitter"), "Twiter page is not displayed");
		driver.close();
		socialMedia.switchToTab(0);

		Assert.assertEquals(socialMediaList.get(2), "http://pinterest.com/wixcom/", "The pinterest link is not ok");
		socialMedia.pinterestClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("pinterest"), "Pinterest page is not displayed");
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

		ArrayList<String> generalInfoList = generalInfo.getGeneralInfoTitleText() ;
		Assert.assertEquals(generalInfoList.get(5), "ADDRESS", "The Adress title is not ok");
		Assert.assertEquals(generalInfoList.get(6), "CONTACT", "The Contact title is not ok");
		Assert.assertEquals(generalInfoList.get(7), "HOME & AWAY", "The Home&Away title is not ok");
		Assert.assertEquals(generalInfoList.get(8), "WE ACCEPT", "The accept title is not ok");
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

}
