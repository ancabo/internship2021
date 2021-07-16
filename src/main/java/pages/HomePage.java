package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.openqa.selenium.By;
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


	public TestBase upClickedAdults(int number) {
		int i=0;
		while(i<number) {
			click(upAdultsBtn);
			i++;
		}
		return this;
	}

	public TestBase upClickedKids(int number) {
		int i=0;
		while(i<number) {
			click(upKidsClick);
			i++;
		}
		return this;
	}

	public TestBase downClickedKids(int number) {
		int i=0;
		while(i<number) {
			click(downKids);
			i++;
		}
		return this;
	}

	public TestBase downClickedAdults(int number) {
		int i=0;
		while(i<number) {
			click(downAdultsBtn);
			i++;
		}
		return this;
	}

	public String adultsgetText() {
		return adults.getText();
	}

	public boolean adultsDownDisplayed() {
		return display(downAdultsBtn);
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

	public String kidsGetText() {
		return kids.getText();
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
		fluentWaitElementPresentBy(5,1, By.xpath("/html/body/div/main/div/nav/button[2]"));
		click(nextMonth);
		return this;
	}


	//////////////////////Provider updates

	private WebElement in_day, out_day, in_luna;
	

	private void inData(String zi1) throws InterruptedException {
//		String zi ="", luna ="", an ="";
//		String[] var = zi1.split(" ");
//		zi = var[0];	
//		luna = var[1];
//		an = var[2];
		in_day = driver.findElement(By.xpath("//span[contains(text(), " + zi1 +")]"));
//		in_luna = driver.findElement(By.xpath("//div[contains(text(), '" + luna +"')]"));
//		
//		System.out.println(luna +" "+ an);
//		System.out.println(in_luna.getText());
//		if((luna +" "+ an) == in_luna.getText()) {
//			click(nextMonth);
//		}
	}
	

	public TestBase setCheckInAndClick(String zi) throws InterruptedException {
		inData(zi);
		click(in_day);
		return this;
	}

	private void outData(String zi) throws InterruptedException {
		out_day = driver.findElement(By.xpath("//button[@day-button-aria='day']/span[contains(text(), " + zi + ")]"));
	}

	public TestBase setCheckOutAndClick(String zi) throws InterruptedException {
		outData(zi);
		click(out_day);
		return this;
	}


	///////////////Read from Text File


	public Vector<String> ReadFromFile() throws IOException, InterruptedException {
		String TestFile = "C:\\Users\\z004c2sx\\eclipse-workspace\\internship2021\\testData\\testData.txt";
		FileReader FR = new FileReader(TestFile);
		try (BufferedReader BR = new BufferedReader(FR)) {
			String Content = "";
			String checkInData = "", checkInData1 = " ", checkOutData = "", checkOutData1 = "", nrAdults = "", nrKids = "";
			Vector<String> info = new Vector<>();

			while((Content = BR.readLine())!= null){
				String[] var = Content.split(";");
				
				checkInData = var[0];
				String[] var1 = checkInData.split(" ");
				checkInData1 = var1[0];
				
				checkOutData = var[1];
				String[] var2 = checkOutData.split(" ");
				checkOutData1 = var2[0];
				
				nrAdults = var[2];	
				nrKids = var[3];
				
				info.add(checkInData1);
				info.add(checkOutData1);
				info.add(nrAdults);
				info.add(nrKids) ;
				//System.out.println(chechInData + checkOutData);
			}
			return info;
		}
	}

}
