package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.TestBase;

public class HomePage extends TestBase{
	protected WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElements//

	@FindBy(xpath = "//div[@id='i6ksxrtk']/h1/a")
	private WebElement header;

	@FindBy(xpath = "//p[.='HOME']")
	private WebElement homeTab;

	@FindBy(xpath = "//div/wix-image/img")
	private WebElement background;

	@FindBy(xpath = "//iframe[@title='Wix Hotels']")
	private WebElement wixHotels;

	@FindBy(xpath = "//li[@class='adults']")
	private WebElement adults;
	
	@FindBy(xpath = "//*[@id=\"adults\"]/a[1]")
	private WebElement upAdultsBtn;

	@FindBy(xpath = "//*[@id=\"adults\"]/a[2]")
	private WebElement downAdultsBtn;

	@FindBy(xpath = "//*[@id='i6tj0u8x']/a/span")
	private WebElement bookNowClick;

	@FindBy(xpath = "//a[@class='_2k7xj']")
	private WebElement roomsDisplay;

	@FindBy(xpath = "//*[@id=\"children\"]")
	private WebElement kids;

	@FindBy(xpath = "//*[@id=\"children\"]/a[1]")
	private WebElement upKidsClick;

	@FindBy(xpath = "//*[@id=\"children\"]/a[2]")
	private WebElement downKids;

	@FindBy(xpath = "//span[@class='nr31w']" )
	private WebElement bookNow;

	@FindBy(xpath = "//button[@id='check-in'][1]")
	private WebElement dataBtnCheckIn;

	@FindBy(xpath = "//iframe[contains(@name,'i6kppi75')]")
	private WebElement frame1;

	@FindBy(xpath = "//*[@id='check-in-value']")
	private WebElement actualDateCheckIn;

	@FindBy(xpath = "//span[contains(text(),'20')]")
	private WebElement dataCheckIn;

	@FindBy(xpath = "//button[@day-button-aria='day']/span[contains(text(),'30')]")
	private WebElement checkOutData;

	@FindBy(xpath = "//*[@id='check-out-value']")
	private WebElement actualDateCheckOut;

	@FindBy(xpath = "//button[@wix-bi='SEARCH']")
	private WebElement searchButton;
	
	@FindBy(xpath ="//button[@day-button-aria='day']/span[contains(text(),'21')]")
	private WebElement dataCheckIn2;

	@FindBy(xpath ="/html/body/div/main/div/nav/button[2]")
	private WebElement nextMonth;

	@FindBy(xpath ="//button[@id='check-in'][1]")
	private WebElement dataBtn;
	
	//Actions on WebElements//

	public String getHeaderText(){
		return header.getText();
	}

	public boolean homeTabDisplayed(){
		return display(homeTab);
	}

	public boolean backgroundDisplayed() {
		return display(background);
	}

	public void switchTo(int number) {
		ArrayList<String> windowH = new ArrayList<String>(driver.getWindowHandles());
		if(number == 1) {
			driver.switchTo().window(windowH.get(1));
		}
		else {
			driver.switchTo().window(windowH.get(0));
		}
	}

	public void frameWixHotels() {
		//waitElementIsVisible(wixHotels, 10);
		waitForFrameAndSwitch(wixHotels);
	}

	public boolean adultsDisplayed() {
		return display(adults);
	}

	public boolean adultsUpDisplayed() {
		return display(upAdultsBtn);
	}
	
	public TestBase adultsUpClicked() {
		//waitElementIsClickable(1000, By.xpath("//*[@id=\"adults\"]/a[1]"));
		click(upAdultsBtn);
		return this;
	}

	public String adultsgetText() {
		return adults.getText();
	}
	
	public boolean adultsDownDisplayed() {
		return display(downAdultsBtn);
	}

	public TestBase adultsDownClicked() {
		click(downAdultsBtn);
		return this;
	}

	public boolean kidsDisplayed() {
		return display(kids);
	}

	public boolean kidsDownDisplayed() {
		return display(downKids);
	}
	
	public boolean kidsUpDisplayed() {
		return display(upKidsClick);
	}
	
	public TestBase kidsUpClicked() {
		click(upKidsClick);
		return this;
	}

	public String kidsGetText() {
		return kids.getText();
	}

	public TestBase kidsDownClicked() {
		click(downKids);
		return this;
	}


	public boolean bookNowDisplayed() {
		return display(bookNow);
	}

	public boolean bookNowClicked() {
		return display(bookNowClick);
	}

	public boolean roomsDisplayed() {
		return display(roomsDisplay);
	}

	public TestBase checkInClicked() {
		waitElementIsClickable(20, dataBtnCheckIn);
		click(dataBtnCheckIn);
		return this; 
	}

	public void switchToframe() {
		waitForFrameAndSwitch(frame1);
	}

	public TestBase dataCheckInClicked() {
		waitElementIsClickable(400, dataCheckIn);
		click(dataCheckIn);
		return this;
	}

	public TestBase dataBtnClicked() {
		waitElementIsClickable(30, dataBtn);
		click(dataBtn);
		return this;
	}
	public String actualDateCheckIn() {
		return actualDateCheckIn.getText();
	}

	public TestBase dataCheckOutClicked() {
		waitElementIsClickable(10,checkOutData);
		click(checkOutData);
		return this;
	}
	
	public String actualDateCheckOut() {
		return actualDateCheckOut.getText();
	}

	public boolean searchBtnDisplayed() {
		waitElementIsVisible(searchButton, 10);
		return display(searchButton);
	}

	public TestBase searchBtnClicked() {
		click(searchButton);
		return this;
	}

	public TestBase dataCheckIn1Clicked() {
		waitElementIsClickable(10,dataCheckIn2);
		click(dataCheckIn2);
		return this;
	}

	public TestBase nextMonthClicked() {
		//waitElementIsClickable(5,nextMonth);
		click(nextMonth);
		return this;
	}
}
