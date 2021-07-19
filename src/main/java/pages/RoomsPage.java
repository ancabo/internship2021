package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

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
	
	//@FindBy(xpath = "(//button[@stranslate=\"booking.BOOK_NOW\"])[1]")
	//private WebElement bookNow1;
	
	//@FindBy(xpath = "(//button[@stranslate=\"booking.BOOK_NOW\"])[2]")
	//private WebElement bookNow2;
	
	//@FindBy(xpath = "(//button[@stranslate=\"booking.BOOK_NOW\"])[3]")
	//private WebElement bookNow3;	
	
	//@FindBy(xpath = "(//a[@wix-bi=\"ROOM_DETAILS\"])[1]")
	//private WebElement standardSuite;
	
	//@FindBy(xpath = "(//a[@wix-bi=\"ROOM_DETAILS\"])[2]")
	//private WebElement cottage;
	
	//@FindBy(xpath = "(//a[@wix-bi=\"ROOM_DETAILS\"])[3]")
	//private WebElement classicApp;
	
	//@FindBy(xpath = "(//img[@role=\"presentation\"])[1]")
	//private WebElement img1;
	
	//@FindBy(xpath = "(//img[@role=\"presentation\"])[2]")
	//private WebElement img2;
	
	//@FindBy(xpath = "(//img[@role=\"presentation\"])[3]")
	//private WebElement img3;
	
	//@FindBy(xpath = "(//span[@class=\"value\"])[3]")
	//private WebElement price1;
	
	//@FindBy(xpath = "(//span[@class=\"value\"])[4]")
	//private WebElement price2;
	
	//@FindBy(xpath = "(//span[@class=\"value\"])[5]")
	//private WebElement price3;
	
	//@FindBy(xpath = "(//button[@wix-bi=\"ROOM_DETAILS\"])[1]")
	//private WebElement moreInfo1;
	
	//@FindBy(xpath = "(//button[@wix-bi=\"ROOM_DETAILS\"])[2]")
	//private WebElement moreInfo2;
	
	//@FindBy(xpath = "(//button[@wix-bi=\"ROOM_DETAILS\"])[3]")
	//private WebElement moreInfo3;
	
	//@FindBy(xpath = "//span[@stranslate=\"Standard Suite\"]")
	//private WebElement standardSuite2;
	
	//@FindBy(xpath = "//span[@stranslate=\"Cottage\"]")
	//private WebElement cottage2;
	
	//@FindBy(xpath = "//span[@stranslate=\"Classic App\"]")
	//private WebElement classicApp2;
	
	@FindBy(xpath = "//a[@class=\"policies\"]")
	private WebElement policies;
	
	@FindBy(xpath = "//button[@aria-label=\"Go back to rooms list\"]")
	private WebElement back;
	
	
	//Actions on WebElements//	
	
	public boolean roomsButtonDisplayed() {
		return roomsButton.isDisplayed();
	}
	
	public void clickRooms() {
		click(roomsButton);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean roomsDisplayed() {
		return display(rooms);
	}
	
	public String getRoomsText() {
		return getText(rooms);
	}
	
	public boolean paragraphDisplayed() {
		return display(paragraph);
	}
	
	public boolean stayInTheCityDisplayed() { 
		return display(stayInTheCity);
	}
	
	public String getStayInTheCityText() {
		return getText(stayInTheCity);
	}
	
	public boolean backgroundImgDisplayed() { 
		return display(backgroundImg);
	}
	
	public void changeFrameBookARoom() {
		waitForFrameAndSwitch(frameBookARoom);
	}
	
	public boolean checkinDisplayed() {
		//waitElementIsVisible(checkin, 7);
		fluentWait(7,2, By.id("check-in"));
		return display(checkin);
	}
	
	public void clickCheckin() {
		click(checkin);
	}
	
	public String getCheckinText() {
		return getText(checkin);
	}
	
	public boolean checkinCalendarDisplayed() {
		return display(checkinCalendar);
	}
	
	public String getCheckinCalendarTitle() {
		return getText(checkinCalendarTitle);
	}
	
	public boolean nextMonthBDisplayed() {
		return display(nextMonthB);
	}
	
	public void clicknextMonthB(int nr) {
		for (int i=0; i<nr; i++)
			click(nextMonthB);
	}
	
	public String getNextMonthCheckinCalendarText() {
		return getText(checkinCalendar);
	}
	
	public boolean checkinDate1Displayed() {
		fluentWait(10,2, By.xpath("//button[@aria-label=\"17, Tuesday August 2021\"]"));
		return display(checkinDate1);
	}
	
	public String getCheckinDate1Text() {
		return getText(checkinDate1);
	}
	
	public void clickCheckinDate1() {
		fluentWait(8,2, By.xpath("//button[@aria-label=\"17, Tuesday August 2021\"]"));
		click(checkinDate1);
	}
	
	public boolean prevMonthBDisplayed() {
		return display(previousMonthB);
	}
	
	public void clickPrevMonthB(int nr) {
		for (int i=0; i<nr; i++)
			click(previousMonthB);
	}
	
	public String getPrevMonthCheckinCalendarText() {
		return getText(checkinCalendarTitle);
	}
	
	public boolean checkinDate2Displayed() {
		waitElementIsVisible(checkinDate2, 5);
		return display(checkinDate2);
	}
	
	public String getCheckinDate2Text() {
		return getText(checkinDate2);
	}
	
	public void clickCheckinDate2() {
		fluentWait(8,2, By.xpath("//button[@aria-label=\"28, Wednesday July 2021\"]"));
		click(checkinDate2);
	}
	
	public boolean checkinDate3Displayed() {
		waitElementIsVisible(checkinDate3, 5);
		return display(checkinDate3);
	}
	
	public String getCheckinDate3Text() {
		return getText(checkinDate3);
	}
	
	public void clickCheckinDate3() {
		fluentWait(8,2, By.xpath("//button[@aria-label=\"6, Sunday June 2021\"]"));
		click(checkinDate3);
	}
	
	public boolean checkoutDisplayed() {
		return display(checkout);
	}
	
	public void clickCheckout() {
		click(checkout);
	}
	
	public String getCheckoutText() {
		return getText(checkout);
	}
	
	public boolean checkoutCalendarDisplayed() {
		return display(checkoutCalendar);
	}
	
	public String getCheckoutCalendarTitle() {
		return getText(checkoutCalendarTitle);
	}
	
	public boolean nextMonthB2Displayed() {
		return display(nextMonthB2);
	}
	
	public void clicknextMonthB2(int nr) {
		for (int i=0; i<nr; i++)
			click(nextMonthB2);
	}
	
	public String getNextMonthCheckoutCalendarText() {
		return getText(checkoutCalendar);
	}
	
	public boolean checkoutDate1Displayed() {
		return display(checkoutDate1);
	}
	
	public String getCheckoutDate1Text() {
		return getText(checkoutDate1);
	}
	
	public void clickCheckoutDate1() {
		click(checkoutDate1);
	}
	
	public boolean prevMonthB2Displayed() {
		return display(previousMonthB2);
	}
	
	public void clickPrevMonthB2(int nr) {
		for (int i=0; i<nr; i++)
			click(previousMonthB2);
	}
	
	public String getPrevMonthCheckoutCalendarText() {
		return getText(checkoutCalendarTitle);
	}
	
	public boolean checkoutDate2Displayed() {
		return display(checkoutDate2);
	}
	
	public String getCheckoutDate2Text() {
		return getText(checkoutDate2);
	}
	
	public void clickCheckoutDate2() {
		click(checkoutDate2);
	}
	
	public void setCheckInDate() {
		click(checkin);
		click(checkinDate2);
	}
	
	public boolean checkoutDate3Displayed() {
		return display(checkoutDate3);
	}
	
	public String getCheckoutDate3Text() {
		return getText(checkoutDate3);
	}
	
	public void clickCheckoutDate3() {
		click(checkoutDate3);
	}
	
	public boolean adultsDisplayed() {
		return display(adults);
	}
	
	public boolean adultsUpDisplayed() {
		return display(adultsUp);
	}
	
	public void clickAdultsUp(int nr) {
		for (int i=0; i<nr; i++)
			click(adultsUp);
	}
	
	public String getAdultsText() {
		return getText(adults);
	}
	
	public boolean adultsDownDisplayed() {
		return display(adultsDown);
	}
	
	public void clickAdultsDown(int nr) {
		for (int i=0; i<nr; i++)
			click(adultsDown);
	}
	
	public boolean kidsDisplayed() {
		return display(kids);
	}
	
	public boolean kidsUpDisplayed() {
		return display(kidsUp);
	}
	
	public void clickKidsUp(int nr) {
		for (int i=0; i<nr; i++)
			click(kidsUp);
	}
	
	public String getKidsText() {
		return getText(kids);
	}
	
	public boolean kidsDownDisplayed() {
		return display(kidsDown);
	}
	
	public void clickKidsDown(int nr) {
		for (int i=0; i<nr; i++)
			click(kidsDown);
	}
	
	public boolean searchBDisplayed() {
		return display(search);
	}
	
	public void clickSearch() {
		click(search);
	}
	
	public void completeDatesForSearch() {
		clickCheckinDate2();
		clickCheckoutDate2();		
	}
	
	public boolean searchResultDisplayed() {
		return display(searchResult);
	}
	
	public boolean clearBDisplayed() {
		return display(clear);
	}
	
	public void clickClear() {
		click(clear);
	}
	
	public boolean ourRoomsDisplayed() {
		return display(ourRooms);
	}
	
	public WebElement bookNow(int no) {
		String xpath = "(//button[@stranslate=\"booking.BOOK_NOW\"])[" + no + "]";
		WebElement element = null;
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public boolean bookNow1Displayed() {
		return display(bookNow(1));
	}
	
	public void clickBookNow1() {
		click(bookNow(1));
	}
	
	public boolean bookNow2Displayed() {
		return display(bookNow(2));
	}
	
	public void clickBookNow2() {
		click(bookNow(2));
	}
	
	public boolean bookNow3Displayed() {
		return display(bookNow(3));
	}
	
	public void clickBookNow3() {
		click(bookNow(3));
	}
	
	public WebElement roomsType(int no) {
		String xpath = "(//a[@wix-bi=\"ROOM_DETAILS\"])[" + no + "]";
		WebElement element = null;
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public boolean standardSuiteDisplayed() {
		waitElementIsVisible(roomsType(1),10);
		return display(roomsType(1));
	}
	
	public void clickStandardSuite() {
		click(roomsType(1));
	}
	
	public boolean cottageDisplayed() {
		waitElementIsVisible(roomsType(2),10);
		return display(roomsType(2));
	}
	
	public void clickCottage() {
		click(roomsType(2));
	}
	
	public boolean classicAppDisplayed() {
		waitElementIsVisible(roomsType(3),10);
		return display(roomsType(3));
	}
	
	public void clickClassicApp() {
		click(roomsType(3));
	}
	
	public WebElement image(int no) {
		String xpath = "(//img[@role=\"presentation\"])[" + no + "]";
		WebElement element = null;
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public boolean img1Displayed() {
		return display(image(1));
	}
	
	public boolean img2Displayed() {
		return display(image(2));
	}
	
	public boolean img3Displayed() {
		return display(image(3));
	}
	
	public WebElement price(int no) {
		String xpath = "(//span[@class=\"value\"])[" + no + "]";
		WebElement element = null;
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public boolean price1Displayed() {
		return display(price(3));
	}
	
	public boolean price2Displayed() {
		return display(price(4));
	}
	
	public boolean price3Displayed() {
		return display(price(5));
	}
	
	public WebElement moreInfo(int no) {
		String xpath = "(//button[@wix-bi=\"ROOM_DETAILS\"])[" + no + "]";
		WebElement element = null;
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public boolean moreInfo1Displayed() {
		return display(moreInfo(1));
	}
	
	public void clickMoreInfo1() {
		click(moreInfo(1));
	}
	
	public boolean moreInfo2Displayed() {
		return display(moreInfo(2));
	}
	
	public void clickMoreInfo2() {
		click(moreInfo(2));
	}
	
	public boolean moreInfo3Displayed() {
		return display(moreInfo(3));
	}
	
	public void clickMoreInfo3() {
		click(moreInfo(3));
	}
	
	public WebElement roomsType2(String name) {
		String xpath = "//span[@stranslate=\"" + name + "\"]";
		WebElement element = null;
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public boolean standardSuite2Displayed() {
		return display(roomsType2("Standard Suite"));
	}
	
	public boolean cottage2Displayed() {
		return display(roomsType2("Cottage"));
	}
	
	public boolean classicApp2Displayed() {
		return display(roomsType2("Classic App"));
	}
	
	public boolean politiciesDisplayed() {
		return display(policies);
	}
	
	public String getPoliciesText() {
		return getText(policies);
	}
	
	public String getPoliciesLink() {
		return getAttributeValue(policies, "href");
	}
	
	public boolean backBDisplayed() {
		waitElementIsVisible(back,5);
		return display(back);
	} 
	
	public void clickBack() {
		waitElementIsClickable(10,back);
		click(back);
	}
	
	
	//actions for data provider
	
	public void clickCheckinDate(String checkin) {
		
		String xpath = "//button[@aria-label=\"" + checkin + "\"]";
		WebElement checkinDate = driver.findElement(By.xpath(xpath));
		waitElementIsClickable(10,checkinDate);
		click(checkinDate);
		
	}
	
	public void clickCheckoutDate(String checkout) {
		
		String xpath = "(//button[@aria-label=\"" + checkout + "\"])[2]";
		WebElement checkoutDate = driver.findElement(By.xpath(xpath));
		waitElementIsClickable(10,checkoutDate);
		click(checkoutDate);
		
	}
	

}
