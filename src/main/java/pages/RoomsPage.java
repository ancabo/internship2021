package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.TestBase;

public class RoomsPage extends TestBase{
	
	protected WebDriver driver;
	
	public RoomsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElements//
	
	@FindBy(xpath = "(//p[@class='ccDUc'])[3]")
	private WebElement roomsButton;
	
	@FindBy(id = "i6lwrp18")
	private WebElement rooms;
	
	@FindBy(id = "i6lwrp17")
	private WebElement paragraph;
	
	@FindBy(xpath = "//*[@id=\"i6lxanil\"]/h3/font")
	private WebElement stayInTheCity;
	
	@FindBy(xpath = "//div[@id='mediajg145x8i1']")
	private WebElement backgroundImg;
	
	@FindBy(xpath = "//iframe[@title='Book a Room']")
	private WebElement frameBookARoom;
	
	@FindBy(xpath = "//div[@id='check-in']")
	private WebElement checkin;
	
	@FindBy(xpath = "(//div[@wix-calendar])[1]")
	private WebElement checkinCalendar; 
			
	@FindBy(xpath = "(//div[@ng-bind=\"title\"])[1]")
	private WebElement checkinCalendarTitle;
	
	@FindBy(xpath = "(//button[@aria-label=\"Next month\"])[1]")
	private WebElement nextMonthB;
	
	@FindBy(xpath = "//button[@aria-label=\"17, Tuesday August 2021\"]")
	private WebElement checkinDate1;
	
	@FindBy(xpath = "(//button[@aria-label=\"Previous month\"])[1]")
	private WebElement previousMonthB;
	
	@FindBy(xpath = "//button[@aria-label=\"28, Wednesday July 2021\"]")
	private WebElement checkinDate2;
	
	@FindBy(xpath = "//button[@aria-label=\"6, Sunday June 2021\"]")
	private WebElement checkinDate3;
	
	@FindBy(xpath = "//div[@id='check-out']")
	private WebElement checkout;
	
	@FindBy(xpath = "(//div[@wix-calendar])[2]")
	private WebElement checkoutCalendar; 
			
	@FindBy(xpath = "(//div[@ng-bind=\"title\"])[2]")
	private WebElement checkoutCalendarTitle;
	
	@FindBy(xpath = "(//button[@aria-label=\"Next month\"])[2]")
	private WebElement nextMonthB2;
	
	@FindBy(xpath = "//button[@aria-label=\"30, Monday August 2021\"]")
	private WebElement checkoutDate1;
	
	@FindBy(xpath = "(//button[@aria-label=\"Previous month\"])[2]")
	private WebElement previousMonthB2;
	
	@FindBy(xpath = "(//button[@aria-label=\"31, Saturday July 2021\"])[2]")
	private WebElement checkoutDate2;
	
	@FindBy(xpath = "(//button[@aria-label=\"20, Tuesday July 2021\"])[2]")
	private WebElement checkoutDate3;
	
	@FindBy(xpath = "//li[@class='adults']")
	private WebElement adults;
	
	@FindBy(xpath = "(//a[@aria-label='Increment'])[1]")
	private WebElement adultsUp;
	
	@FindBy(xpath = "(//a[@aria-label=\"Decrement\"])[1]")
	private WebElement adultsDown;
	
	@FindBy(xpath = "//*[@id=\"children\"]")
	private WebElement kids;
	
	@FindBy(xpath = "(//a[@aria-label='Increment'])[2]")
	private WebElement kidsUp;
	
	@FindBy(xpath = "(//a[@aria-label='Decrement'])[2]")
	private WebElement kidsDown;
	
	@FindBy(xpath = "//button[@wix-bi=\"SEARCH\"]")
	private WebElement search;
	
	@FindBy(xpath = "//span[contains(text(),'Results for:')]")
	private WebElement searchResult;
	
	@FindBy(xpath = "//a[@wix-bi=\"CLEAR_SEARCH\"]")
	private WebElement clear;
	
	@FindBy(xpath = "//span[contains(text(),'Our Rooms')]")
	private WebElement ourRooms;
	
	@FindBy(xpath = "(//button[@stranslate=\"booking.BOOK_NOW\"])[1]")
	private WebElement bookNow1;
	
	@FindBy(xpath = "(//button[@stranslate=\"booking.BOOK_NOW\"])[2]")
	private WebElement bookNow2;
	
	@FindBy(xpath = "(//button[@stranslate=\"booking.BOOK_NOW\"])[3]")
	private WebElement bookNow3;
	
	@FindBy(xpath = "(//a[@wix-bi=\"ROOM_DETAILS\"])[1]")
	private WebElement standardSuite;
	
	@FindBy(xpath = "(//a[@wix-bi=\"ROOM_DETAILS\"])[2]")
	private WebElement cottage;
	
	@FindBy(xpath = "(//a[@wix-bi=\"ROOM_DETAILS\"])[3]")
	private WebElement classicApp;
	
	@FindBy(xpath = "(//img[@role=\"presentation\"])[1]")
	private WebElement img1;
	
	@FindBy(xpath = "(//img[@role=\"presentation\"])[2]")
	private WebElement img2;
	
	@FindBy(xpath = "(//img[@role=\"presentation\"])[3]")
	private WebElement img3;
	
	@FindBy(xpath = "(//span[@class=\"value\"])[3]")
	private WebElement price1;
	
	@FindBy(xpath = "(//span[@class=\"value\"])[4]")
	private WebElement price2;
	
	@FindBy(xpath = "(//span[@class=\"value\"])[5]")
	private WebElement price3;
	
	@FindBy(xpath = "(//button[@wix-bi=\"ROOM_DETAILS\"])[1]")
	private WebElement moreInfo1;
	
	@FindBy(xpath = "(//button[@wix-bi=\"ROOM_DETAILS\"])[2]")
	private WebElement moreInfo2;
	
	@FindBy(xpath = "(//button[@wix-bi=\"ROOM_DETAILS\"])[3]")
	private WebElement moreInfo3;
	
	@FindBy(xpath = "//span[@stranslate=\"Standard Suite\"]")
	private WebElement standardSuite2;
	
	@FindBy(xpath = "//span[@stranslate=\"Cottage\"]")
	private WebElement cottage2;
	
	@FindBy(xpath = "//span[@stranslate=\"Classic App\"]")
	private WebElement classicApp2;
	
	@FindBy(xpath = "//a[@class=\"policies\"]")
	private WebElement policies;
	
	@FindBy(xpath = "//button[@aria-label=\"Go back to rooms list\"]")
	private WebElement back;
	
	
	//Actions on WebElements//	
	
	public boolean roomsButtonDisplayed() {
		return roomsButton.isDisplayed();
	}
	
	public void clickRooms() {
		roomsButton.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean roomsDisplayed() {
		return rooms.isDisplayed();
	}
	
	public String getRoomsText() {
		return rooms.getText();
	}
	
	public boolean paragraphDisplayed() {
		return paragraph.isDisplayed();
	}
	
	public boolean stayInTheCityDisplayed() { 
		return stayInTheCity.isDisplayed();
	}
	
	public String getStayInTheCityText() {
		return stayInTheCity.getText();
	}
	
	public boolean backgroundImgDisplayed() { 
		return backgroundImg.isDisplayed();
	}
	
	public void changeFrameBookARoom() {
		driver.switchTo().frame(frameBookARoom);
	}
	
	public boolean checkinDisplayed() {
		return checkin.isDisplayed();
	}
	
	public void clickCheckin() {
		checkin.click();
	}
	
	public String getCheckinText() {
		return checkin.getText();
	}
	
	public boolean checkinCalendarDisplayed() {
		return checkinCalendar.isDisplayed();
	}
	
	public String getCheckinCalendarTitle() {
		return checkinCalendarTitle.getText();
	}
	
	public boolean nextMonthBDisplayed() {
		return nextMonthB.isDisplayed();
	}
	
	public void clicknextMonthB() {
		nextMonthB.click();
	}
	
	public String getNextMonthCheckinCalendarText() {
		return checkinCalendar.getText();
	}
	
	public boolean checkinDate1Displayed() {
		return checkinDate1.isDisplayed();
	}
	
	public String getCheckinDate1Text() {
		return checkinDate1.getText();
	}
	
	public void clickCheckinDate1() {
		checkinDate1.click();
	}
	
	public boolean prevMonthBDisplayed() {
		return previousMonthB.isDisplayed();
	}
	
	public void clickPrevMonthB() {
		previousMonthB.click();
	}
	
	public String getPrevMonthCheckinCalendarText() {
		return checkinCalendarTitle.getText();
	}
	
	public boolean checkinDate2Displayed() {
		return checkinDate2.isDisplayed();
	}
	
	public String getCheckinDate2Text() {
		return checkinDate2.getText();
	}
	
	public void clickCheckinDate2() {
		checkinDate2.click();
	}
	
	public boolean checkinDate3Displayed() {
		return checkinDate3.isDisplayed();
	}
	
	public String getCheckinDate3Text() {
		return checkinDate3.getText();
	}
	
	public void clickCheckinDate3() {
		checkinDate3.click();
	}
	
	public boolean checkoutDisplayed() {
		return checkout.isDisplayed();
	}
	
	public void clickCheckout() {
		checkout.click();
	}
	
	public String getCheckoutText() {
		return checkout.getText();
	}
	
	public boolean checkoutCalendarDisplayed() {
		return checkoutCalendar.isDisplayed();
	}
	
	public String getCheckoutCalendarTitle() {
		return checkoutCalendarTitle.getText();
	}
	
	public boolean nextMonthB2Displayed() {
		return nextMonthB2.isDisplayed();
	}
	
	public void clicknextMonthB2() {
		nextMonthB2.click();
	}
	
	public String getNextMonthCheckoutCalendarText() {
		return checkoutCalendar.getText();
	}
	
	public boolean checkoutDate1Displayed() {
		return checkoutDate1.isDisplayed();
	}
	
	public String getCheckoutDate1Text() {
		return checkoutDate1.getText();
	}
	
	public void clickCheckoutDate1() {
		checkoutDate1.click();
	}
	
	public boolean prevMonthB2Displayed() {
		return previousMonthB2.isDisplayed();
	}
	
	public void clickPrevMonthB2() {
		previousMonthB2.click();
	}
	
	public String getPrevMonthCheckoutCalendarText() {
		return checkoutCalendarTitle.getText();
	}
	
	public boolean checkoutDate2Displayed() {
		return checkoutDate2.isDisplayed();
	}
	
	public String getCheckoutDate2Text() {
		return checkoutDate2.getText();
	}
	
	public void clickCheckoutDate2() {
		checkoutDate2.click();
	}
	
	public void setCheckInDate() {
		checkin.click();
		checkinDate2.click();
	}
	
	public boolean checkoutDate3Displayed() {
		return checkoutDate3.isDisplayed();
	}
	
	public String getCheckoutDate3Text() {
		return checkoutDate3.getText();
	}
	
	public void clickCheckoutDate3() {
		checkoutDate3.click();
	}
	
	public boolean adultsDisplayed() {
		return adults.isDisplayed();
	}
	
	public boolean adultsUpDisplayed() {
		return adultsUp.isDisplayed();
	}
	
	public void clickAdultsUp() {
		adultsUp.click();
	}
	
	public String getAdultsText() {
		return adults.getText();
	}
	
	public boolean adultsDownDisplayed() {
		return adultsDown.isDisplayed();
	}
	
	public void clickAdultsDown() {
		adultsDown.click();
	}
	
	public boolean kidsDisplayed() {
		return kids.isDisplayed();
	}
	
	public boolean kidsUpDisplayed() {
		return kidsUp.isDisplayed();
	}
	
	public void clickKidsUp() {
		kidsUp.click();
	}
	
	public String getKidsText() {
		return kids.getText();
	}
	
	public boolean kidsDownDisplayed() {
		return kidsDown.isDisplayed();
	}
	
	public void clickKidsDown() {
		kidsDown.click();
	}
	
	public boolean searchBDisplayed() {
		return search.isDisplayed();
	}
	
	public void clickSearch() {
		search.click();
	}
	
	public void completeDatesForSearch() {
		clickCheckinDate2();
		clickCheckoutDate2();		
	}
	
	public boolean searchResultDisplayed() {
		return searchResult.isDisplayed();
	}
	
	public boolean clearBDisplayed() {
		return clear.isDisplayed();
	}
	
	public void clickClear() {
		clear.click();
	}
	
	public boolean ourRoomsDisplayed() {
		return ourRooms.isDisplayed();
	}
	
	public boolean bookNow1Displayed() {
		return bookNow1.isDisplayed();
	}
	
	public void clickBookNow1() {
		bookNow1.click();
	}
	
	public boolean bookNow2Displayed() {
		return bookNow2.isDisplayed();
	}
	
	public void clickBookNow2() {
		bookNow2.click();
	}
	
	public boolean bookNow3Displayed() {
		return bookNow3.isDisplayed();
	}
	
	public void clickBookNow3() {
		bookNow3.click();
	}
	
	public boolean standardSuiteDisplayed() {
		return standardSuite.isDisplayed();
	}
	
	public void clickStandardSuite() {
		standardSuite.click();
	}
	
	public boolean cottageDisplayed() {
		return cottage.isDisplayed();
	}
	
	public void clickCottage() {
		cottage.click();
	}
	
	public boolean classicAppDisplayed() {
		return classicApp.isDisplayed();
	}
	
	public void clickClassicApp() {
		classicApp.click();
	}
	
	public boolean img1Displayed() {
		return img1.isDisplayed();
	}
	
	public boolean img2Displayed() {
		return img2.isDisplayed();
	}
	
	public boolean img3Displayed() {
		return img3.isDisplayed();
	}
	
	public boolean price1Displayed() {
		return price1.isDisplayed();
	}
	
	public boolean price2Displayed() {
		return price2.isDisplayed();
	}
	
	public boolean price3Displayed() {
		return price3.isDisplayed();
	}
	
	public boolean moreInfo1Displayed() {
		return moreInfo1.isDisplayed();
	}
	
	public void clickMoreInfo1() {
		moreInfo1.click();
	}
	
	public boolean moreInfo2Displayed() {
		return moreInfo2.isDisplayed();
	}
	
	public void clickMoreInfo2() {
		moreInfo2.click();
	}
	
	public boolean moreInfo3Displayed() {
		return moreInfo3.isDisplayed();
	}
	
	public void clickMoreInfo3() {
		moreInfo3.click();
	}
	
	public boolean standardSuite2Displayed() {
		return standardSuite2.isDisplayed();
	}
	
	public boolean cottage2Displayed() {
		return cottage2.isDisplayed();
	}
	
	public boolean classicApp2Displayed() {
		return classicApp2.isDisplayed();
	}
	
	public boolean politiciesDisplayed() {
		return policies.isDisplayed();
	}
	
	public String getPoliciesText() {
		return policies.getText();
	}
	
	public String getPoliciesLink() {
		return policies.getAttribute("href");
	}
	
	public boolean backBDisplayed() {
		return back.isDisplayed();
	} 
	
	public void clickBack() {
		back.click();
	}

}
