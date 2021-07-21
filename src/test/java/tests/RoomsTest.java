package tests;

import java.util.ArrayList;
import java.util.Vector;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.TestBase;
import pages.ChatPage;
import pages.GeneralInfoPage;
import pages.RoomsPage;
import pages.SocialMediaPage;

public class RoomsTest extends TestBase{

	private RoomsPage roomsPage;
	private SocialMediaPage socialMedia;
	private GeneralInfoPage generalInfo;
	private ChatPage chat;

	@BeforeMethod
	public void beforeTest() {

		roomsPage = new RoomsPage(driver);
		socialMedia = new SocialMediaPage(driver);
		generalInfo = new GeneralInfoPage(driver);
		chat = new ChatPage(driver);

	}



	@Test
	public void verifyRoomsButton() {

		//verify that the ROOMS button is displayed on Home Page
		Assert.assertTrue(roomsPage.roomsButtonDisplayed(), "Rooms button is not displayed on Home Page");

	}


	@Test
	public void verifyRoomsText(){

		roomsPage.clickRooms();
		waitPageLoad(3000);

		//verify page title
		//Assert.assertEquals(roomsPage.getPageTitle(), "ROOMS | Intern", "Title is not as expected");

		//verify "ROOMS" text
		Assert.assertTrue(roomsPage.roomsDisplayed(), "ROOMS is not displayed"); 
		Assert.assertEquals(roomsPage.getRoomsText(), "ROOMS");

		//verify the paragraph
		Assert.assertTrue(roomsPage.paragraphDisplayed(), "Paragraph is not displayed");

		//verify STAY IN THE CITY
		Assert.assertTrue(roomsPage.stayInTheCityDisplayed(), "STAY IN THE CITY is not displayed");
		Assert.assertEquals(roomsPage.getStayInTheCityText(), "STAY IN THE CITY");

	}


	@Test
	public void verifyBackgroundImg(){

		roomsPage.clickRooms();
		waitPageLoad(3000);

		//verify the background image
		Assert.assertTrue(roomsPage.backgroundImgDisplayed(), "background img is not displayed"); 

	}


	@Test
	public void verifyCheckIn(){

		roomsPage.clickRooms();
		waitPageLoad(5000);

		//change the frame
		roomsPage.changeFrameBookARoom();

		//verify check in field is visible
		Assert.assertTrue(roomsPage.checkinDisplayed(), "Check in field is not displayed"); 
		roomsPage.clickCheckin();

		//verify the check in calendar is displayed for July
		Assert.assertTrue(roomsPage.checkinCalendarDisplayed(), "Check in calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckinCalendarTitle(), "July 2021");

		//next month icon
		Assert.assertTrue(roomsPage.nextMonthBDisplayed(), "Next month button is not displayed");
		roomsPage.clicknextMonthB(1);

		//next month calendar visibility
		Assert.assertTrue(roomsPage.checkinCalendarDisplayed(), "Check in calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckinCalendarTitle(), "August 2021");

		//choose a date from August
		Assert.assertTrue(roomsPage.checkinDate1Displayed(), "Check in date1 is not displayed");
		roomsPage.clickCheckinDate1();

		//check the date is displayed in check in field
		Assert.assertEquals(roomsPage.getCheckinText(), "17 Aug 2021");
		roomsPage.clickCheckin();

		//verify the check in calendar is displayed for August
		Assert.assertTrue(roomsPage.checkinCalendarDisplayed(), "Check in calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckinCalendarTitle(), "August 2021");

		//previous month icon
		Assert.assertTrue(roomsPage.prevMonthBDisplayed(), "Previous month button is not displayed");
		roomsPage.clickPrevMonthB(1);

		//verify the check in calendar is displayed for July
		Assert.assertTrue(roomsPage.checkinCalendarDisplayed(), "Check in calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckinCalendarTitle(), "July 2021");

		//choose a date from July
		Assert.assertTrue(roomsPage.checkinDate2Displayed(), "Check in date2 is not displayed");
		roomsPage.clickCheckinDate2();

		//check the date is displayed in check in field
		Assert.assertEquals(roomsPage.getCheckinText(), "28 Jul 2021");
		roomsPage.clickCheckin();

		//choose a date before today
		roomsPage.clickPrevMonthB(1);
		//Thread.sleep(1000);
		Assert.assertTrue(roomsPage.checkinDate3Displayed(), "Check in date3 is not displayed");
		roomsPage.clickCheckinDate3();

		//check the date is not displayed in check in field
		Assert.assertEquals(roomsPage.getCheckinText(), "28 Jul 2021");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test
	public void verifyCheckOut(){

		roomsPage.clickRooms();
		waitPageLoad(7000);

		//change the frame
		roomsPage.changeFrameBookARoom();

		//verify check out field is visible
		Assert.assertTrue(roomsPage.checkoutDisplayed(), "Check out field is not displayed"); 
		roomsPage.clickCheckout();

		//verify the check out calendar is displayed 
		Assert.assertTrue(roomsPage.checkoutCalendarDisplayed(), "Check out calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckoutCalendarTitle(), "July 2021");

		//next month icon
		Assert.assertTrue(roomsPage.nextMonthB2Displayed(), "Next month button is not displayed");
		roomsPage.clicknextMonthB2(1);

		//next month calendar visibility (August)
		Assert.assertTrue(roomsPage.checkoutCalendarDisplayed(), "Check out calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckoutCalendarTitle(), "August 2021");

		//choose a date from August
		Assert.assertTrue(roomsPage.checkoutDate1Displayed(), "Check out date1 is not displayed");
		roomsPage.clickCheckoutDate1();

		//check the date is displayed in check out field 
		Assert.assertEquals(roomsPage.getCheckoutText(), "30 Aug 2021");
		roomsPage.clickCheckout();

		//July month calendar visibility 
		Assert.assertTrue(roomsPage.checkoutCalendarDisplayed(), "Check out calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckoutCalendarTitle(), "August 2021");

		//previous month icon  
		Assert.assertTrue(roomsPage.prevMonthB2Displayed(), "Previous month button is not displayed");
		roomsPage.clickPrevMonthB2(1);

		//June month calendar visibility
		Assert.assertTrue(roomsPage.checkoutCalendarDisplayed(), "Check out calendar is not displayed");
		Assert.assertEquals(roomsPage.getCheckoutCalendarTitle(), "July 2021");

		//choose a date from July
		Assert.assertTrue(roomsPage.checkoutDate2Displayed(), "Check out date2 is not displayed");
		roomsPage.clickCheckoutDate2();

		//check the date is displayed in check out field 
		Assert.assertEquals(roomsPage.getCheckoutText(), "31 Jul 2021");
		roomsPage.clickCheckout();

		//choose a date before check in
		roomsPage.setCheckInDate();
		Assert.assertTrue(roomsPage.checkoutDate3Displayed(), "Check out date3 is not displayed");
		roomsPage.clickCheckoutDate3();

		//check the date is not displayed in check in field
		Assert.assertEquals(roomsPage.getCheckoutText(), "31 Jul 2021");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test
	public void verifyAdults(){

		roomsPage.clickRooms();
		waitPageLoad(5000);

		//change the frame
		roomsPage.changeFrameBookARoom();

		//verify Adults field is visible
		Assert.assertTrue(roomsPage.adultsDisplayed(), "Adults field is not displayed");

		//verify Adults Up icon is visible
		Assert.assertTrue(roomsPage.adultsUpDisplayed(), "Adults up icon is not displayed");
		roomsPage.clickAdultsUp(2);

		//verify that the no. of Adults has increased
		//Assert.assertEquals(roomsPage.getAdultsText(), "2 Adults");
		//roomsPage.clickAdultsUp(2);

		//verify that the no. of Adults has increased
		Assert.assertEquals(roomsPage.getAdultsText(), "3 Adults");

		//verify Adults Down icon is visible
		Assert.assertTrue(roomsPage.adultsDownDisplayed(), "Adults down icon is not displayed");
		roomsPage.clickAdultsDown(1);

		//verify that the no. of Adults has dropped
		Assert.assertEquals(roomsPage.getAdultsText(), "2 Adults");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test
	public void verifyKids(){

		roomsPage.clickRooms();
		waitPageLoad(5000);

		//change the frame
		roomsPage.changeFrameBookARoom();

		//verify Kids field is visible
		Assert.assertTrue(roomsPage.kidsDisplayed(), "Kids field is not displayed");

		//verify Kids Up icon is visible
		Assert.assertTrue(roomsPage.kidsUpDisplayed(), "Kids up icon is not displayed");
		roomsPage.clickKidsUp(2);

		//verify that the no. of Kids has increased
		//Assert.assertEquals(roomsPage.getKidsText(), "2 Kids");
		//roomsPage.clickKidsUp();

		//verify that the no. of Kids has increased
		Assert.assertEquals(roomsPage.getKidsText(), "2 Kids");

		//verify Kids Down icon is visible
		Assert.assertTrue(roomsPage.kidsDownDisplayed(), "Kids down icon is not displayed");
		roomsPage.clickKidsDown(1);

		//verify that the no. of Kids has dropped
		Assert.assertEquals(roomsPage.getKidsText(), "1 Kids");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test
	public void verifySearch(){

		roomsPage.clickRooms();
		waitPageLoad(7000);

		//change the frame  
		roomsPage.changeFrameBookARoom();

		//verify Search button is visible
		Assert.assertTrue(roomsPage.searchBDisplayed(), "Search button is not displayed");
		roomsPage.clickSearch();

		//verify the check in calendar is displayed
		Assert.assertTrue(roomsPage.checkinCalendarDisplayed(), "Check in calendar is not displayed");

		//complete the fields for search and click search
		roomsPage.completeDatesForSearch();
		roomsPage.clickSearch();

		//verify that the results are displayed
		Assert.assertTrue(roomsPage.searchResultDisplayed(), "Results for search are not displayed");

		//change the frame
		driver.switchTo().defaultContent();

	}
	
	@DataProvider(name = "completeData")
	public Object[][] createData() {
	 return new Object[][] {
	   //{ "25, Sunday July 2021", "30, Friday July 2021", 2, 3 },
	   //{ "28, Wednesday July 2021", "31, Saturday July 2021", 3, 1 },
	   { "17, Tuesday August 2021", "27, Friday August 2021", 4, 2 },
	   //{ "12, Sunday September 2021", "18, Saturday September 2021", 3, 3 },
	   //{ "20, Wednesday October 2021", "23, Saturday October 2021", 2, 0 },
	 };
	}
	
	@Test(dataProvider = "completeData")
	public void checkinDataProvider(String checkinDate, String checkoutDate, int adultsNr, int kidsNr) throws InterruptedException{ //check in, check out, adults, kids
		
		roomsPage.clickRooms();
		waitPageLoad(8000);

		//change the frame  
		roomsPage.changeFrameBookARoom();
		
		//complete check in field
		roomsPage.clickCheckin();
		roomsPage.changeMonth(checkinDate);
		Thread.sleep(2000);
		roomsPage.clickCheckinDate(checkinDate);
		
		//complete check out field
		Thread.sleep(2000);
		roomsPage.clickCheckoutDate(checkoutDate);
		
		//complete the aduls field
		roomsPage.clickAdultsUp(adultsNr - 1);
		
		//complete the kids field
		roomsPage.clickKidsUp(kidsNr);
		
		//click search button
		roomsPage.clickSearch();
		
		//verify that the results are displayed
		Assert.assertTrue(roomsPage.searchResultDisplayed(), "Results for search are not displayed");
		Assert.assertEquals(roomsPage.getCheckinText(), "17 Aug 2021");
		Assert.assertEquals(roomsPage.getCheckoutText(), "27 Aug 2021");
		Assert.assertEquals(roomsPage.getAdultsText(), "4 Adults");
		Assert.assertEquals(roomsPage.getKidsText(), "2 Kids");
		
	}
	
	@Test
	public void checkInTextFile() throws InterruptedException{

		Vector<String> data = roomsPage.readFromFile();
		int n = data.size()/4;
		int k = 0;
		
		for(int i=0; i<n; i++) {
					
			roomsPage.clickRooms();
			waitPageLoad(10000);
			Thread.sleep(7000);

			//change the frame  
			roomsPage.changeFrameBookARoom();
		
			//complete check in field
			Thread.sleep(5000);
			roomsPage.clickCheckin();
			roomsPage.changeMonth(data.get(k));
			Thread.sleep(3000);
			roomsPage.clickCheckinDate(data.get(k)); k++;
				
			//complete check out field
			Thread.sleep(3000);
			roomsPage.clickCheckoutDate(data.get(k)); k++;
		
			//complete the aduls field
			roomsPage.clickAdultsUp(Integer.parseInt(data.get(k)) - 1); k++;
		
			//complete the kids field
			roomsPage.clickKidsUp(Integer.parseInt(data.get(k))); k++;
		
			//click search button
			roomsPage.clickSearch();
		
			//verify that the results are displayed
			Assert.assertTrue(roomsPage.searchResultDisplayed(), "Results for search are not displayed");
			String adults = data.get(k-2) + " Adults";
			Assert.assertEquals(roomsPage.getAdultsText(), adults);
			String kids = data.get(k-1) + " Kids";
			Assert.assertEquals(roomsPage.getKidsText(), kids);
			
			if (i<n)
				navigateToURL("https://ancabota09.wixsite.com/intern");
			
		}
		
	}


	@Test
	public void verifyClear(){

		roomsPage.clickRooms();
		waitPageLoad(7000);

		//change the frame  
		roomsPage.changeFrameBookARoom();

		//complete the fields for search and click search
		roomsPage.clickCheckin();
		roomsPage.completeDatesForSearch();		
		roomsPage.clickSearch();

		//verify that the results are displayed
		Assert.assertTrue(roomsPage.searchResultDisplayed(), "Results for search are not displayed");

		//verify that the clear button is displayed and click clear
		Assert.assertTrue(roomsPage.clearBDisplayed(), "Clear button is not displayed");
		roomsPage.clickClear();

		//verify that all the rooms are displayed again 
		Assert.assertTrue(roomsPage.ourRoomsDisplayed(), "All the Rooms are not displayed after clear");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test   
	public void verifyBookNow(){

		roomsPage.clickRooms();
		waitPageLoad(7000);

		//change the frame  
		roomsPage.changeFrameBookARoom();

		//complete the fields for search and click search
		roomsPage.clickCheckin();
		roomsPage.completeDatesForSearch();
		roomsPage.clickSearch();

		//verify that the results are displayed
		Assert.assertTrue(roomsPage.searchResultDisplayed(), "Results for search are not displayed");

		//verify that the book now buttons are displayed
		Assert.assertTrue(roomsPage.bookNow1Displayed(), "Book Now button 1 is not displayed");
		roomsPage.clickBookNow1();
		Assert.assertTrue(roomsPage.bookNow2Displayed(), "Book Now button 2 is not displayed");
		roomsPage.clickBookNow2();
		Assert.assertTrue(roomsPage.bookNow3Displayed(), "Book Now button 3 is not displayed");
		roomsPage.clickBookNow3();

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test   
	public void verifyStandardSuite(){

		roomsPage.clickRooms();
		waitPageLoad(7000);

		//change the frame  
		roomsPage.changeFrameBookARoom();

		//check the visibility of standard suite title
		Assert.assertTrue(roomsPage.standardSuiteDisplayed(), "Standard Suite is not displayed");

		//image
		Assert.assertTrue(roomsPage.img1Displayed(), "Img 1 is not displayed"); 

		//check the visibility of the price
		Assert.assertTrue(roomsPage.price1Displayed(), "The price is not displayed");		

		//check the visibility of the More Info button
		Assert.assertTrue(roomsPage.moreInfo1Displayed(), "More Info1 is not displayed"); 
		roomsPage.clickMoreInfo1();

		//check the title visibility
		Assert.assertTrue(roomsPage.standardSuite2Displayed(), "The room title is not dispalyed");

		//read our policies
		Assert.assertTrue(roomsPage.politiciesDisplayed(), "Read our policies button is not displayed");
		Assert.assertEquals(roomsPage.getPoliciesText(), "Read Our Policies");

		//back to Our Rooms button
		Assert.assertTrue(roomsPage.backBDisplayed(), "Go back icon is not displayed");
		roomsPage.clickBack();

		//check all the rooms are displayed
		Assert.assertTrue(roomsPage.ourRoomsDisplayed(), "All the Rooms are not displayed after click the back button");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test   
	public void verifyCottage(){

		roomsPage.clickRooms();
		waitPageLoad(7000);

		//change the frame  
		roomsPage.changeFrameBookARoom();

		//check the visibility of cottage title
		Assert.assertTrue(roomsPage.cottageDisplayed(), "Cottage is not displayed");

		//image
		Assert.assertTrue(roomsPage.img2Displayed(), "Img 2 is not displayed"); 

		//check the visibility of the price
		Assert.assertTrue(roomsPage.price2Displayed(), "The price is not displayed");		

		//check the visibility of the More Info button
		Assert.assertTrue(roomsPage.moreInfo2Displayed(), "More Info2 is not displayed"); 
		roomsPage.clickMoreInfo2();

		//check the title visibility
		Assert.assertTrue(roomsPage.cottage2Displayed(), "The room title is not dispalyed");

		//read our policies
		Assert.assertTrue(roomsPage.politiciesDisplayed(), "Read our policies button is not displayed");
		Assert.assertEquals(roomsPage.getPoliciesText(), "Read Our Policies");

		//back to Our Rooms button
		Assert.assertTrue(roomsPage.backBDisplayed(), "Go back icon is not displayed");
		roomsPage.clickBack();

		//check all the rooms are displayed
		Assert.assertTrue(roomsPage.ourRoomsDisplayed(), "All the Rooms are not displayed after click the back button");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test   
	public void verifyClassicApp(){

		roomsPage.clickRooms();
		waitPageLoad(7000);

		//change the frame  
		roomsPage.changeFrameBookARoom();

		//check the visibility of cottage title
		Assert.assertTrue(roomsPage.classicAppDisplayed(), "Classic App is not displayed");

		//image
		Assert.assertTrue(roomsPage.img3Displayed(), "Img 3 is not displayed"); 

		//check the visibility of the price
		Assert.assertTrue(roomsPage.price3Displayed(), "The price is not displayed");		

		//check the visibility of the More Info button
		Assert.assertTrue(roomsPage.moreInfo3Displayed(), "More Info3 is not displayed"); 
		roomsPage.clickMoreInfo3();

		//check the title visibility
		Assert.assertTrue(roomsPage.classicApp2Displayed(), "The room title is not dispalyed");

		//read our policies
		Assert.assertTrue(roomsPage.politiciesDisplayed(), "Read our policies button is not displayed");
		Assert.assertEquals(roomsPage.getPoliciesText(), "Read Our Policies");

		//back to Our Rooms button
		Assert.assertTrue(roomsPage.backBDisplayed(), "Go back icon is not displayed");
		roomsPage.clickBack();

		//check all the rooms are displayed
		Assert.assertTrue(roomsPage.ourRoomsDisplayed(), "All the Rooms are not displayed after click the back button");

		//change the frame
		driver.switchTo().defaultContent();

	}


	@Test
	public void verifyChat(){

		//click the contact button from the home page
		roomsPage.clickRooms();		


		
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
//		//Assert.assertTrue(roomsPage.textareDisplayed(), "Textare field is not displayed");
//		//roomsPage.sendTextChat();
//		
//		Thread.sleep(2000);
//		
//		//visibility of chat message response
//		//Assert.assertTrue(roomsPage.chatMsgDisplayed(), "Chat message box is not displayed");
//		
//		//submit button
//		Assert.assertTrue(chat.submitDisplayed(), "Submit button is not displayed");
//		chat.submitClicked();
//		
//		//check the visibility of the name error
//		//Assert.assertTrue(roomsPage.nameErrDisplayed(), "Name error is not displayed");
//		
//		//check the visibility of the email error
//		//Assert.assertTrue(roomsPage.emailErrDisplayed(), "Email error is not displayed");
//		
//		//name field visibility + type a name
//		Assert.assertTrue(chat.nameDisplayed(), "Name field is not displayed");
//		//roomsPage.completeName();
//		
//		//email field visibility + type wrong format email
//		Assert.assertTrue(chat.emailDisplayed(), "Email field is not displayed");
//		//roomsPage.completeWrongEmailChat();
//		
//		//message field visibility + type message
//		Assert.assertTrue(chat.messageDisplayed(), "Message field is not displayed");
//		chat.messageClicked();
//		chat.messageSendDisplayed();
//		
//		//email error message visibility + clear the email field
//		//Assert.assertTrue(roomsPage.emailErrChatDisplayed(), "Email error message is not displayed");
//		//roomsPage.clearEmail();
//		
//		//type the correct format of email
//		chat.emailSendDisplayed();
//		
//		//click the submit button
//		chat.submitClicked();
//		
//		//check the visibility thank you message
//		//Assert.assertTrue(roomsPage.thxMsgDisplayed(), "Thank you message box is not displayed");
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
//		//Assert.assertEquals(roomsPage.getSentMessage(), "Sent");
//		
//		//visibility of emoji button
//		Assert.assertTrue(chat.emojiBtnDisplayed(),"Emoji button is not displayed");
//		chat.emojiBtnClicked();
//		
//		//visibility of emojis box
//		//Assert.assertTrue(roomsPage.emojiBoxDisplayed(),"Emoji box is not displayed");
//		
//		//choose and send an emoji
//		Assert.assertTrue(chat.emojiDisplayed(),"Emoji is not displayed");
//		chat.emojiClicked();
//		//roomsPage.enter();
//		
//		Thread.sleep(2000);
//		
//		//check the emoji is sent
//		//Assert.assertEquals(roomsPage.getSentMessage(), "Sent");
		waitPageLoad(5000);

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
	public void verifySocialBar(){

		//click the rooms button from the home page
		roomsPage.clickRooms();		
		waitPageLoad(5000);
		
		//		//facebook
		//		Assert.assertTrue(socialMedia.facebookIconDisplayed(), "Fb icon is not displayed");
		//		//Assert.assertEquals(roomsPage.getFb2Link(), "http://www.facebook.com/wix");
		//		
		//		//twitter
		//		Assert.assertTrue(socialMedia.twiterIconDisplayed(), "Twitter icon is not displayed");
		//		//Assert.assertEquals(roomsPage.getTw2Link(), "http://www.twitter.com/wix");
		//		
		//		//pinterest
		//		Assert.assertTrue(socialMedia.pinterestIconDisplayed(), "Pinterest icon is not displayed");
		//		//Assert.assertEquals(roomsPage.getPint2Link(), "http://pinterest.com/wixcom/");


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
	public void verifyGeneralInfo(){

		//click the contact button from the home page
		roomsPage.clickRooms();		
		waitPageLoad(5000);

		//		//address
		//		Assert.assertTrue(generalInfo.addressDisplayed(), "Address title is not displayed"); 
		//		//Assert.assertEquals(roomsPage.getAddressTitle(), "ADDRESS");
		//		Assert.assertTrue(generalInfo.addressDisplayed1(), "Address line 1 is not displayed");
		//		//Assert.assertEquals(roomsPage.getAddress1Text(), "500 Terry Francois Street");
		//		Assert.assertTrue(generalInfo.addressDisplayed2(), "Address line 2 is not displayed");
		//		//Assert.assertEquals(roomsPage.getAddress2Text(), "San Francisco, CA 94158");
		//		
		//		//contact
		//		Assert.assertTrue(generalInfo.contactDisplayed(), "Contact title is not displayed"); 
		//		//Assert.assertEquals(roomsPage.getContactTitle(), "CONTACT");
		//		Assert.assertTrue(generalInfo.contactDisplayed1(), "Contact line 1 is not displayed");
		//		//Assert.assertEquals(roomsPage.getContact1Text(), "info@mysite.com");
		//		Assert.assertTrue(generalInfo.contactDisplayed2(), "Contact line 2 is not displayed");
		//		//Assert.assertEquals(roomsPage.getContact2Text(), "Tel: 123-456-7890");
		//		
		//		//home&away 
		//		Assert.assertTrue(generalInfo.homeDisplayed1(), "Home&Away title is not displayed"); 
		//		//Assert.assertEquals(roomsPage.getHaTitle(), "HOME & AWAY");
		//		Assert.assertTrue(generalInfo.homeDisplayed2(), "Home&Away line 1 is not displayed");
		//		//Assert.assertEquals(roomsPage.getHa1Text(), "© 2023 by HOME & AWAY");
		//		Assert.assertTrue(generalInfo.homeDisplayed3(), "Home&Away line 2 is not displayed");
		//		//Assert.assertEquals(roomsPage.getHa2Text(), "Proudly created with Wix.com");
		//		
		//		//payment
		//		//Assert.assertTrue(roomsPage.payTitleDisplayed(), "Payment title is not displayed"); 
		//		//Assert.assertEquals(roomsPage.getPayTitle(), "WE ACCEPT");
		//		//Assert.assertTrue(roomsPage.paymentDisplayed(), "Payment methods are not displayed");


		Assert.assertEquals(generalInfo.getGeneralInfoTitles().size(), 4, "There are not 4 titles");
		Assert.assertEquals(generalInfo.getGeneralInfoTitleText().size(), 4, "There are not 4 titles");

		ArrayList<String> generalInfoList = generalInfo.getGeneralInfoTitleText() ;
		Assert.assertEquals(generalInfoList.get(0), "ADDRESS", "The Adress title is not ok");
		Assert.assertEquals(generalInfoList.get(1), "CONTACT", "The Contact title is not ok");
		Assert.assertEquals(generalInfoList.get(2), "HOME & AWAY", "The Home&Away title is not ok");
		Assert.assertEquals(generalInfoList.get(3), "WE ACCEPT", "The accept title is not ok");

	}

}
