package tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ChatPage;
import pages.ContactPage;
import pages.GeneralInfoPage;
import pages.SocialMediaPage;
import common.TestBase;

public class ContactTest extends TestBase{
	
	private ContactPage contactPage;
	private SocialMediaPage socialMedia;
	private GeneralInfoPage generalInfo;
	private ChatPage chat;
	
	@BeforeMethod
	public void BeforeTest() {
		
		contactPage = new ContactPage(driver);
		socialMedia = new SocialMediaPage(driver);
		generalInfo = new GeneralInfoPage(driver);
		chat = new ChatPage(driver);
        
	  }
	
	
	@Test
	public void verifyContactButton() {
		
		//verify that the CONTACT button is displayed on Home Page
		Assert.assertTrue(contactPage.contactButtonDisplayed(), "Contact button is not displayed on Home Page");
		
	}
	
	@Test
	public void verifyContactText() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(1000);
		
		//verify page title
		Assert.assertEquals(contactPage.getPageTitle(), "CONTACT | Intern", "Title is not as expected");
		
		//verify "CONTACT US" text
		Assert.assertTrue(contactPage.contactUsDisplayed(), "CONTACT US is not displayed");
		Assert.assertEquals(contactPage.getContactUsText(), "CONTACT US");
		
		//verify the paragraph
		Assert.assertTrue(contactPage.paragraphDisplayed(), "Paragraph is not displayed");
		
		//verify TALK TO US
		Assert.assertTrue(contactPage.talkToUsDisplayed(), "TALK TO US is not displayed");
		Assert.assertEquals(contactPage.getTalkToUsText(), "TALK TO US");
		
	}
	
	
	@Test
	public void verifyBackgroundImg() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(1000);
		
		//verify the background image
		Assert.assertTrue(contactPage.backgroundImgDisplayed(), "background img is not displayed"); 
		
	}
	
	
	@Test
	public void verifyMessage() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(2000);
		
		//verify name field visibility
		Assert.assertTrue(contactPage.nameDisplayed(), "Name field is not displayed");
		
		//verify email field visibility
		Assert.assertTrue(contactPage.emailDisplayed(), "Email field is not displayed");
		
		//verify phone field visibility
		Assert.assertTrue(contactPage.phoneDisplayed(), "Phone field is not displayed");
		
		//verify message box visibility
		Assert.assertTrue(contactPage.messageDisplayed(), "Message field is not displayed");
		
		//verify submit button visibility
		Assert.assertTrue(contactPage.submitBDisplayed(), "The submit button is not displayed");
		
		//complete the fields and click submit
		contactPage.completeFields();
		contactPage.clickSubmit();
		
		//verify the human verification message visibility 
		Assert.assertTrue(contactPage.verificationMsgDisplayed(), "The human verification message is not displayed");
	}
	
	@Test
	public void verifyEmptySubmit() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(2000);
		
		contactPage.clickSubmit();
		
		//check that the name/email/message fields are colored in red
		Assert.assertEquals(contactPage.getNameColour(), "rgba(255, 64, 64, 0.1)");
		Assert.assertEquals(contactPage.getEmailColour(), "rgba(255, 64, 64, 0.1)");
		Assert.assertEquals(contactPage.getMessageColour(), "rgba(255, 64, 64, 0.1)");
		
	}
	
	@Test
	public void verifyWrongSubmit() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(2000);
		
		//complete the email field with a wrong format
		contactPage.completeWrongEmail();
		
		contactPage.clickSubmit();
		
		//check that the name and message fields are colored in red and the email border is red
		Assert.assertEquals(contactPage.getNameColour(), "rgba(255, 64, 64, 0.1)");
		Assert.assertEquals(contactPage.getEmailBorderColour(), "rgb(255, 64, 64)");
		Assert.assertEquals(contactPage.getMessageColour(), "rgba(255, 64, 64, 0.1)");
		
	}
	
	
	@Test
	public void verifyChat() throws InterruptedException{
		
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
	public void verifySocialBar1() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(2000);
		
		//facebook
		Assert.assertTrue(contactPage.fbDisplayed(), "Fb icon is not displayed");
		Assert.assertEquals(contactPage.getFbLink(), "http://www.facebook.com/wix");
		
		//twitter
		Assert.assertTrue(contactPage.twitterDisplayed(), "Twitter icon is not displayed");
		Assert.assertEquals(contactPage.getTwLink(), "http://www.twitter.com/wix");
		
		//pinterest
		Assert.assertTrue(contactPage.pinterestDisplayed(), "Pinterest icon is not displayed");
		Assert.assertEquals(contactPage.getPintLink(), "http://pinterest.com/wixcom/");
		
	}
	
	
	@Test
	public void verifySocialBar2() throws InterruptedException{
//		
//		//click the contact button from the home page
//		contactPage.clickContact();		
//		Thread.sleep(2000);
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
		Assert.assertEquals(socialMedia.getSocialMediaLinkList().size(), 3, "There are not 3 links");
	
		ArrayList<String> socialMediaList = socialMedia.getSocialMediaLinkList() ;
		Assert.assertEquals(socialMediaList.get(0), "http://www.facebook.com/wix", "The fb link is not ok");
		Assert.assertEquals(socialMediaList.get(1), "http://www.twitter.com/wix", "The twiter link is not ok");
		Assert.assertEquals(socialMediaList.get(2), "http://pinterest.com/wixcom/", "The pinterest link is not ok");
	}
	
	
	@Test
	public void verifyMap() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(1000);
		
		//change the frame
		contactPage.changeFrame();
		
		//check the visibility of the map
		Assert.assertTrue(contactPage.mapDisplayed(), "The map is not displayed");
		
		//click and hold the map
		contactPage.clickAndHoldMap();
		
		//check the visibility of the full screen button
		Assert.assertTrue(contactPage.fullScreenBDisplayed(), "The full screen button of the map is not displayed");
		
		//check the visibility of the map after click the full screen button
		contactPage.clickFullScreenB();
		Assert.assertTrue(contactPage.mapDisplayed(), "The map is not displayed");
		
		//click and hold the maximized map
		contactPage.clickAndHoldMap();
		
		//minimize the map and then check the visibility
		contactPage.clickFullScreenB();
		Assert.assertTrue(contactPage.mapDisplayed(), "The map is not displayed");
		
		//terms of use
		Assert.assertTrue(contactPage.mapTermsDisplayed(), "Map terms of use button is not displayed");
		Assert.assertEquals(contactPage.getMapTermsLink(), "https://www.google.com/intl/en_US/help/terms_maps.html");
		
		//report a map error
		Assert.assertTrue(contactPage.mapErrorDisplayed(), "Report a map error button is not displayed");
		Assert.assertEquals(contactPage.getMapErrorLink(), "https://www.google.com/maps/@37.77065,-122.387301,14z/data=!5m1!1e4!10m1!1e1!12b1?source=apiv3&rapsrc=apiv3");
		
		//change the frame
		driver.switchTo().defaultContent();
		
	}


	@Test
	public void verifyGeneralInfo() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(1000);
		
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
		
		
		
		Assert.assertEquals(generalInfo.getGeneralInfoTitles().size(), 5, "There are not 5 titles");//in plus Thanks for submiting
		Assert.assertEquals(generalInfo.getGeneralInfoTitleText().size(), 4, "There are not 4 titles");
	
		ArrayList<String> generalInfoList = generalInfo.getGeneralInfoTitleText() ;
		Assert.assertEquals(generalInfoList.get(0), "ADDRESS", "The Adress title is not ok");
		Assert.assertEquals(generalInfoList.get(1), "CONTACT", "The Contact title is not ok");
		Assert.assertEquals(generalInfoList.get(2), "HOME & AWAY", "The Home&Away title is not ok");
		Assert.assertEquals(generalInfoList.get(3), "WE ACCEPT", "The accept title is not ok");
		
	}
  		
}
