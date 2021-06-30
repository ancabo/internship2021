package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.ContactPage;

public class ContactTest {
	
	private WebDriver driver;
	private ContactPage contactPage;
	
	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\z004c2sy\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  	driver = new ChromeDriver();
	  	driver.manage().window().maximize();
		driver.get("https://ancabota09.wixsite.com/intern");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        contactPage = new ContactPage(driver);
        
	  }

	@AfterTest
	public void AfterTest() {
		if (driver != null)
			driver.close();
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
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(2000);
		
		//change the frame
		contactPage.changeChatFrame();
		
		//check the chat button visibility
		Assert.assertTrue(contactPage.chatButtonDisplayed(), "The chat button is not displayed");
		contactPage.clickChatB();
		
		//send a text
		Assert.assertTrue(contactPage.textareDisplayed(), "Textare field is not displayed");
		contactPage.sendTextChat();
		
		Thread.sleep(2000);
		
		//visibility of chat message response
		Assert.assertTrue(contactPage.chatMsgDisplayed(), "Chat message box is not displayed");
		
		//submit button
		Assert.assertTrue(contactPage.submitChatBDisplayed(), "Submit button is not displayed");
		contactPage.clickSubmitChatB();
		
		//check the visibility of the name error
		Assert.assertTrue(contactPage.nameErrDisplayed(), "Name error is not displayed");
		
		//check the visibility of the email error
		Assert.assertTrue(contactPage.emailErrDisplayed(), "Email error is not displayed");
		
		//name field visibility + type a name
		Assert.assertTrue(contactPage.nameChatDisplayed(), "Name field is not displayed");
		contactPage.completeName();
		
		//email field visibility + type wrong format email
		Assert.assertTrue(contactPage.emailChatDisplayed(), "Email field is not displayed");
		contactPage.completeWrongEmailChat();
		
		//message field visibility + type message
		Assert.assertTrue(contactPage.messageChatDisplayed(), "Message field is not displayed");
		contactPage.clickChatMessage();
		contactPage.completeChatMessage();
		
		//email error message visibility + clear the email field
		Assert.assertTrue(contactPage.emailErrChatDisplayed(), "Email error message is not displayed");
		contactPage.clearEmail();
		
		//type the correct format of email
		contactPage.completeEmailChat();
		
		//click the submit button
		contactPage.clickSubmitChatB();
		
		//check the visibility thank you message
		Assert.assertTrue(contactPage.thxMsgDisplayed(), "Thank you message box is not displayed");
		
		//visibility of the attachment button
		Assert.assertTrue(contactPage.attachmentBDisplayed(), "Attachment button is not displayed");
		
		//send an attachment
		contactPage.sendAttachment();
		
		Thread.sleep(5000);
		
		//check the attachment is sent
		Assert.assertEquals(contactPage.getSentMessage(), "Sent");
		
		//visibility of emoji button
		Assert.assertTrue(contactPage.emojiBDisplayed(),"Emoji button is not displayed");
		contactPage.clickEmojiB();
		
		//visibility of emojis box
		Assert.assertTrue(contactPage.emojiBoxDisplayed(),"Emoji box is not displayed");
		
		//choose and send an emoji
		Assert.assertTrue(contactPage.emojiDisplayed(),"Emoji is not displayed");
		contactPage.clickEmoji();
		contactPage.enter();
		
		Thread.sleep(2000);
		
		//check the emoji is sent
		Assert.assertEquals(contactPage.getSentMessage(), "Sent");
		
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
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(2000);
		
		//facebook
		Assert.assertTrue(contactPage.fb2Displayed(), "Fb icon is not displayed");
		Assert.assertEquals(contactPage.getFb2Link(), "http://www.facebook.com/wix");
		
		//twitter
		Assert.assertTrue(contactPage.twitter2Displayed(), "Twitter icon is not displayed");
		Assert.assertEquals(contactPage.getTw2Link(), "http://www.twitter.com/wix");
		
		//pinterest
		Assert.assertTrue(contactPage.pinterest2Displayed(), "Pinterest icon is not displayed");
		Assert.assertEquals(contactPage.getPint2Link(), "http://pinterest.com/wixcom/");
		
	}
	
	
	@Test
	public void verifyGeneralInfo() throws InterruptedException{
		
		//click the contact button from the home page
		contactPage.clickContact();		
		Thread.sleep(1000);
		
		//address
		Assert.assertTrue(contactPage.addressTitleDisplayed(), "Address title is not displayed"); 
		Assert.assertEquals(contactPage.getAddressTitle(), "ADDRESS");
		Assert.assertTrue(contactPage.address1Displayed(), "Address line 1 is not displayed");
		Assert.assertEquals(contactPage.getAddress1Text(), "500 Terry Francois Street");
		Assert.assertTrue(contactPage.address2Displayed(), "Address line 2 is not displayed");
		Assert.assertEquals(contactPage.getAddress2Text(), "San Francisco, CA 94158");
		
		//contact
		Assert.assertTrue(contactPage.contactTitleDisplayed(), "Contact title is not displayed"); 
		Assert.assertEquals(contactPage.getContactTitle(), "CONTACT");
		Assert.assertTrue(contactPage.contact1Displayed(), "Contact line 1 is not displayed");
		Assert.assertEquals(contactPage.getContact1Text(), "info@mysite.com");
		Assert.assertTrue(contactPage.contact2Displayed(), "Contact line 2 is not displayed");
		Assert.assertEquals(contactPage.getContact2Text(), "Tel: 123-456-7890");
		
		//home&away 
		Assert.assertTrue(contactPage.haTitleDisplayed(), "Home&Away title is not displayed"); 
		Assert.assertEquals(contactPage.getHaTitle(), "HOME & AWAY");
		Assert.assertTrue(contactPage.ha1Displayed(), "Home&Away line 1 is not displayed");
		Assert.assertEquals(contactPage.getHa1Text(), "© 2023 by HOME & AWAY");
		Assert.assertTrue(contactPage.ha2Displayed(), "Home&Away line 2 is not displayed");
		Assert.assertEquals(contactPage.getHa2Text(), "Proudly created with Wix.com");
		
		//payment
		Assert.assertTrue(contactPage.payTitleDisplayed(), "Payment title is not displayed"); 
		Assert.assertEquals(contactPage.getPayTitle(), "WE ACCEPT");
		Assert.assertTrue(contactPage.paymentDisplayed(), "Payment methods are not displayed");
		
	}
  		
}
