package tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ChatPage;
import pages.ContactPage;
import pages.GeneralInfoPage;
import pages.MenuPage;
import pages.SocialMediaPage;
import common.TestBase;

public class ContactTest extends TestBase{
	
	private ContactPage contactPage;
	private MenuPage homeMenu;
	private SocialMediaPage socialMedia;
	private GeneralInfoPage generalInfo;
	private ChatPage chat;
	
	@BeforeMethod
	public void BeforeTest() {
		
		contactPage = new ContactPage(driver);
		homeMenu = new MenuPage(driver);
		socialMedia = new SocialMediaPage(driver);
		generalInfo = new GeneralInfoPage(driver);
		chat = new ChatPage(driver);
        
	  }
	
	
	@Test
	public void verifyContactButton() {
		
		//verify that the CONTACT button is displayed on Home Page
		Assert.assertTrue(contactPage.contactButtonDisplayed(), "Contact button is not displayed on Home Page");
		logReport("Pass", "Contact button displayed ok");
		
	}
	
	@Test
	public void verifyHomeMenu(){
		
		SoftAssert softAssert = new SoftAssert();
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		softAssert.assertEquals(homeMenu.getHomeMenuTitles().size(), 5, "There are not 5 titles");
		softAssert.assertEquals(homeMenu.getHomeMenuTitlesText().size(), 5, "There are not 5 titles");
		logReport("Pass", "The number of buttons ok");
		
		ArrayList<String> homeMenuTextList = homeMenu.getHomeMenuTitlesText() ;
		
		softAssert.assertTrue(homeMenu.homeButtonDisplayed(), "Home button is not displayed on Home Page");
		logReport("Pass", "Home button is displayed on Home Page");
		softAssert.assertEquals(homeMenuTextList.get(0), "HONE", "The HOME title is not ok");
		logReport("Pass", "HOME text ok");
		
		softAssert.assertTrue(homeMenu.exploreButtonDisplayed(), "Explore button is not displayed on Home Page");
		logReport("Pass", "Explore button is displayed on Home Page");
		softAssert.assertEquals(homeMenuTextList.get(1), "EXPLORE", "The EXPLORE title is not ok");
		logReport("Pass", "EXPLORE text ok");
		
		softAssert.assertTrue(homeMenu.roomsButtonDisplayed(), "Rooms button is not displayed on Home Page");
		logReport("Pass", "Rooms button is displayed on Home Page");
		softAssert.assertEquals(homeMenuTextList.get(2), "ROOMS", "The ROOMS title is not ok");
		logReport("Pass", "ROOMS text ok");
		
		softAssert.assertTrue(homeMenu.contactButtonDisplayed(), "Contact button is not displayed on Home Page");
		logReport("Pass", "Contact button is displayed on Home Page");
		softAssert.assertEquals(homeMenuTextList.get(3), "CONTACT", "The CONTACT title is not ok");
		logReport("Pass", "CONTACT text ok");
		
		softAssert.assertTrue(homeMenu.bookNowButtonGoodDisplayed(), "Book Now button is not displayed on Home Page");
		logReport("Pass", "Book Now  button is displayed on Home Page");
		logReport("Info", "Book Now / xpath like other buttons");
		softAssert.assertEquals(homeMenuTextList.get(4), "BOOK NOW", "The BOOK NOW title is not ok");
		logReport("Fail", "BOOK NOW text ok");
		logReport("Info", "Book Now / different xpath from the other buttons");
		softAssert.assertEquals(homeMenu.getTextBookNowButtonGood(), "BOOK NOW", "The BOOK NOW title is not ok");
		logReport("Pass", "BOOK NOW text ok");
		
	}
	
	@Test
	public void verifyContactText(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		//verify page title
		//Assert.assertEquals(contactPage.getPageTitle(), "CONTACT | Intern", "Title is not as expected");
		
		//verify "CONTACT US" text
		Assert.assertTrue(contactPage.contactUsDisplayed(), "CONTACT US is not displayed");
		Assert.assertEquals(contactPage.getContactUsText(), "CONTACT US");
		logReport("Pass", "Contact us text ok");
		
		//verify the paragraph
		Assert.assertTrue(contactPage.paragraphDisplayed(), "Paragraph is not displayed");
		logReport("Pass", "Paragraph displayed ok");
		
		//verify TALK TO US
		Assert.assertTrue(contactPage.talkToUsDisplayed(), "TALK TO US is not displayed");
		Assert.assertEquals(contactPage.getTalkToUsText(), "TALK TO US");
		logReport("Pass", "Talk to us text displayed ok");
		
	}
	
	
	@Test
	public void verifyBackgroundImg(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		//verify the background image
		Assert.assertTrue(contactPage.backgroundImgDisplayed(), "background img is not displayed"); 
		logReport("Pass", "Background image displayed ok");
		
	}
	
	
	@Test
	public void verifyMessage(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		//verify name field visibility
		Assert.assertTrue(contactPage.nameDisplayed(), "Name field is not displayed");
		logReport("Pass", "Name field ok");
		
		//verify email field visibility
		Assert.assertTrue(contactPage.emailDisplayed(), "Email field is not displayed");
		logReport("Pass", "Email field ok");
		
		//verify phone field visibility
		Assert.assertTrue(contactPage.phoneDisplayed(), "Phone field is not displayed");
		logReport("Pass", "Phone field ok");
		
		//verify message box visibility
		Assert.assertTrue(contactPage.messageDisplayed(), "Message field is not displayed");
		logReport("Pass", "Message field ok");
		
		//verify submit button visibility
		Assert.assertTrue(contactPage.submitBDisplayed(), "The submit button is not displayed");
		logReport("Pass", "Submit button ok");
		
		//complete the fields and click submit
		contactPage.completeFields();
		contactPage.clickSubmit();
		
		//verify the human verification message visibility 
		Assert.assertTrue(contactPage.verificationMsgDisplayed(), "The human verification message is not displayed");
		logReport("Pass", "Human verification message ok");
	}
	
	@Test
	public void verifyEmptySubmit(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		contactPage.clickSubmit();
		
		//check that the name/email/message fields are colored in red
		Assert.assertEquals(contactPage.getNameColour(), "rgba(255, 64, 64, 0.1)");
		logReport("Pass", "Name field color ok");
		Assert.assertEquals(contactPage.getEmailColour(), "rgba(255, 64, 64, 0.1)");
		logReport("Pass", "Email field color ok");
		Assert.assertEquals(contactPage.getMessageColour(), "rgba(255, 64, 64, 0.1)");
		logReport("Pass", "Message field color ok");
		
	}
	
	@Test
	public void verifyWrongSubmit(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		//complete the email field with a wrong format
		contactPage.completeWrongEmail();
		
		contactPage.clickSubmit();
		
		//check that the name and message fields are colored in red and the email border is red
		Assert.assertEquals(contactPage.getNameColour(), "rgba(255, 64, 64, 0.1)");
		logReport("Pass", "Name field color ok");
		Assert.assertEquals(contactPage.getEmailBorderColour(), "rgb(255, 64, 64)");
		logReport("Pass", "Email field color ok");
		Assert.assertEquals(contactPage.getMessageColour(), "rgba(255, 64, 64, 0.1)");
		logReport("Pass", "Message field color ok");
		
	}
	
	
	@Test
	public void verifyChat(){
		
//		//click the contact button from the home page
		contactPage.clickContact();		
		
//		Thread.sleep(2000);
//		
//		//change the frame
//		chat.switchToChat();
//		
//		//check the chat button visibility
//		Assert.assertTrue(chat.chatBtnisDisplayed(), "The chat button is not displayed");
//		chat.chatBtnClicked();
//		
//		//send a text
//		//Assert.assertTrue(contactPage.textareDisplayed(), "Textare field is not displayed");
//		//contactPage.sendTextChat();
//		
//		Thread.sleep(2000);
//		
//		//visibility of chat message response
//		//Assert.assertTrue(contactPage.chatMsgDisplayed(), "Chat message box is not displayed");
//		
//		//submit button
//		Assert.assertTrue(chat.submitDisplayed(), "Submit button is not displayed");
//		chat.submitClicked();
//		
//		//check the visibility of the name error
//		//Assert.assertTrue(contactPage.nameErrDisplayed(), "Name error is not displayed");
//		
//		//check the visibility of the email error
//		//Assert.assertTrue(contactPage.emailErrDisplayed(), "Email error is not displayed");
//		
//		//name field visibility + type a name
//		Assert.assertTrue(chat.nameDisplayed(), "Name field is not displayed");
//		//contactpage.completeName();
//		
//		//email field visibility + type wrong format email
//		Assert.assertTrue(chat.emailDisplayed(), "Email field is not displayed");
//		//contactPage.completeWrongEmailChat();
//		
//		//message field visibility + type message
//		Assert.assertTrue(chat.messageDisplayed(), "Message field is not displayed");
//		chat.messageClicked();
//		chat.messageSendDisplayed();
//		
//		//email error message visibility + clear the email field
//		//Assert.assertTrue(contactPage.emailErrChatDisplayed(), "Email error message is not displayed");
//		//contactPage.clearEmail();
//		
//		//type the correct format of email
//		chat.emailSendDisplayed();
//		
//		//click the submit button
//		chat.submitClicked();
//		
//		//check the visibility thank you message
//		//Assert.assertTrue(contactPage.thxMsgDisplayed(), "Thank you message box is not displayed");
//		
//		//visibility of the attachment button
//		Assert.assertTrue(chat.attachmentDisplayed(), "Attachment button is not displayed");
//		
//		//send an attachment
//		chat.addFileDisplayed();
//		
//		Thread.sleep(5000);
//		
//		//check the attachment is sent
//		//Assert.assertEquals(contactPage.getSentMessage(), "Sent");
//		
//		//visibility of emoji button
//		Assert.assertTrue(chat.emojiBtnDisplayed(),"Emoji button is not displayed");
//		chat.emojiBtnClicked();
//		
//		//visibility of emojis box
//		//Assert.assertTrue(contactPage.emojiBoxDisplayed(),"Emoji box is not displayed");
//		
//		//choose and send an emoji
//		Assert.assertTrue(chat.emojiDisplayed(),"Emoji is not displayed");
//		chat.emojiClicked();
//		//contactPage.enter();
//		
//		Thread.sleep(2000);
//		
//		//check the emoji is sent
//		//Assert.assertEquals(contactPage.getSentMessage(), "Sent");
		
		waitPageLoad(3000);

		//swich to frame
		chat.switchToChat();

		//Validate that the Chat button exists 
		Assert.assertTrue(chat.chatBtnisDisplayed(), "Chat is not displayed");
		logReport("Pass", "Chat button is displayed ok");

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
		Assert.assertTrue(chat.attachmentDisplayed(), "Chat is not displayed");
		logReport("Pass", "Attachment button is displayed ok");
		
		chat.addFileDisplayed();

		implicitWait(10);

		
	}
	
	@Test
	public void verifySocialBar1(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		//facebook
		Assert.assertTrue(contactPage.fbDisplayed(), "Fb icon is not displayed");
		logReport("Pass", "Fb icon is displayed ok");
		Assert.assertEquals(contactPage.getFbLink(), "http://www.facebook.com/wix");
		logReport("Pass", "Fb link ok");
		
		//twitter
		Assert.assertTrue(contactPage.twitterDisplayed(), "Twitter icon is not displayed");
		logReport("Pass", "Twitter icon is displayed ok");
		Assert.assertEquals(contactPage.getTwLink(), "http://www.twitter.com/wix");
		logReport("Pass", "Twitter link ok");
		
		//pinterest
		Assert.assertTrue(contactPage.pinterestDisplayed(), "Pinterest icon is not displayed");
		logReport("Pass", "Pinterest icon is displayed ok");
		Assert.assertEquals(contactPage.getPintLink(), "http://pinterest.com/wixcom/");
		logReport("Pass", "Pinterest link ok");
		
	}
	
	
	@Test
	public void verifySocialBar2(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
//		
//		//facebook
//		Assert.assertTrue(socialMedia.facebookIconDisplayed(), "Fb icon is not displayed");
//		//Assert.assertEquals(contactPage.getFb2Link(), "http://www.facebook.com/wix");
//		
//		//twitter
//		Assert.assertTrue(socialMedia.twiterIconDisplayed(), "Twitter icon is not displayed");
//		//Assert.assertEquals(contactPage.getTw2Link(), "http://www.twitter.com/wix");
//		
//		//pinterest
//		Assert.assertTrue(socialMedia.pinterestIconDisplayed(), "Pinterest icon is not displayed");
//		//Assert.assertEquals(contactPage.getPint2Link(), "http://pinterest.com/wixcom/");
//		
		

		Assert.assertEquals(socialMedia.getSocialMediaIcons().size(), 3, "There are not 3 icons");
		logReport("Pass", "The number of icons ok");
		Assert.assertEquals(socialMedia.getSocialMediaLinkList().size(), 3, "There are not 3 links");
		logReport("Pass", "The number of links ok");
		
		ArrayList<String> socialMediaList = socialMedia.getSocialMediaLinkList() ;
		Assert.assertEquals(socialMediaList.get(0), "http://www.facebook.com/wix", "The fb link is not ok");
		logReport("Pass", "Fb link ok");
		
		socialMedia.facebookClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("facebook"), "Facebook page is not displayed");
		logReport("Pass", "Facebook page is displayed ok");
		driver.close();
		socialMedia.switchToTab(0);
		
		Assert.assertEquals(socialMediaList.get(1), "http://www.twitter.com/wix", "The twiter link is not ok");
		logReport("Pass", "Twitter link ok");
		socialMedia.twitterClicked();
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("twitter"), "Twiter page is not displayed");
		logReport("Pass", "Twiter page is displayed ok");
		driver.close();
		socialMedia.switchToTab(0);
		
		Assert.assertEquals(socialMediaList.get(2), "http://pinterest.com/wixcom/", "The pinterest link is not ok");
		socialMedia.pinterestClicked();
		logReport("Pass", "Pinterest link ok");
		socialMedia.switchToTab(1);
		Assert.assertTrue(socialMedia.getUrl().contains("pinterest"), "Pinterest page is not displayed");
		logReport("Pass", "Pinterest page is displayed ok");
		driver.close();
	
	}
	
	
	@Test
	public void verifyMap(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
		//change the frame
		contactPage.changeFrame();
		
		//check the visibility of the map
		Assert.assertTrue(contactPage.mapDisplayed(), "The map is not displayed");
		logReport("Pass", "The map is displayed ok");
		
		//click and hold the map
		//contactPage.clickAndHoldMap();
		
		//check the visibility of the full screen button
		Assert.assertTrue(contactPage.fullScreenBDisplayed(), "The full screen button of the map is not displayed");
		logReport("Pass", "Fullscreen button is displayed ok");
		
		//check the visibility of the map after click the full screen button
		contactPage.clickFullScreenB();
		Assert.assertTrue(contactPage.mapDisplayed(), "The map is not displayed");
		logReport("Pass", "Fullscreen map is displayed ok");
		
		//click and hold the maximized map
		//contactPage.clickAndHoldMap();
		
		//minimize the map and then check the visibility
		contactPage.clickFullScreenB();
		Assert.assertTrue(contactPage.mapDisplayed(), "The map is not displayed");
		
		//terms of use
		Assert.assertTrue(contactPage.mapTermsDisplayed(), "Map terms of use button is not displayed");
		logReport("Pass", "Terms of use button is displayed ok");
		Assert.assertEquals(contactPage.getMapTermsLink(), "https://www.google.com/intl/en_US/help/terms_maps.html");
		logReport("Pass", "Terms of use link ok");
		
		//report a map error
		Assert.assertTrue(contactPage.mapErrorDisplayed(), "Report a map error button is not displayed");
		logReport("Pass", "Report a map error button is displayed ok");
		Assert.assertEquals(contactPage.getMapErrorLink(), "https://www.google.com/maps/@37.77065,-122.387301,14z/data=!5m1!1e4!10m1!1e1!12b1?source=apiv3&rapsrc=apiv3");
		logReport("Pass", "Report a map error button link ok");
		
		//change the frame
		driver.switchTo().defaultContent();
		
	}


	@Test
	public void verifyGeneralInfo(){
		
		//click the contact button from the home page
		contactPage.clickContact();		
		waitPageLoad(3000);
		
//		//address
//		Assert.assertTrue(generalInfo.addressDisplayed(), "Address title is not displayed"); 
//		//Assert.assertEquals(contactPage.getAddressTitle(), "ADDRESS");
//		Assert.assertTrue(generalInfo.addressDisplayed1(), "Address line 1 is not displayed");
//		//Assert.assertEquals(contactPage.getAddress1Text(), "500 Terry Francois Street");
//		Assert.assertTrue(generalInfo.addressDisplayed2(), "Address line 2 is not displayed");
//		//Assert.assertEquals(contactPage.getAddress2Text(), "San Francisco, CA 94158");
//		
//		//contact
//		Assert.assertTrue(generalInfo.contactDisplayed(), "Contact title is not displayed"); 
//		//Assert.assertEquals(contactPage.getContactTitle(), "CONTACT");
//		Assert.assertTrue(generalInfo.contactDisplayed1(), "Contact line 1 is not displayed");
//		//Assert.assertEquals(contactPage.getContact1Text(), "info@mysite.com");
//		Assert.assertTrue(generalInfo.contactDisplayed2(), "Contact line 2 is not displayed");
//		//Assert.assertEquals(contactPage.getContact2Text(), "Tel: 123-456-7890");
//		
//		//home&away 
//		Assert.assertTrue(generalInfo.homeDisplayed1(), "Home&Away title is not displayed"); 
//		//Assert.assertEquals(contactPage.getHaTitle(), "HOME & AWAY");
//		Assert.assertTrue(generalInfo.homeDisplayed2(), "Home&Away line 1 is not displayed");
//		//Assert.assertEquals(contactPage.getHa1Text(), "© 2023 by HOME & AWAY");
//		Assert.assertTrue(generalInfo.homeDisplayed3(), "Home&Away line 2 is not displayed");
//		//Assert.assertEquals(contactPage.getHa2Text(), "Proudly created with Wix.com");
//		
//		//payment
//		//Assert.assertTrue(contactPage.payTitleDisplayed(), "Payment title is not displayed"); 
//		//Assert.assertEquals(contactPage.getPayTitle(), "WE ACCEPT");
//		//Assert.assertTrue(contactPage.paymentDisplayed(), "Payment methods are not displayed");
		
		
		
		Assert.assertEquals(generalInfo.getGeneralInfoTitles().size(), 4, "There are not 4 titles");
		Assert.assertEquals(generalInfo.getGeneralInfoTitleText().size(), 4, "There are not 4 titles");
		logReport("Pass", "The number of titles ok");
		
		ArrayList<String> generalInfoList = generalInfo.getGeneralInfoTitleText() ;
		Assert.assertEquals(generalInfoList.get(0), "ADDRESS", "The Adress title is not ok");
		logReport("Pass", "Adress title ok");
		Assert.assertEquals(generalInfoList.get(1), "CONTACT", "The Contact title is not ok");
		logReport("Pass", "Contact title ok");
		Assert.assertEquals(generalInfoList.get(2), "HOME & AWAY", "The Home&Away title is not ok");
		logReport("Pass", "Home&Away title ok");
		Assert.assertEquals(generalInfoList.get(3), "WE ACCEPT", "The accept title is not ok");
		logReport("Pass", "Payment title ok");
		
	}
  		
}
