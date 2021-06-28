package pages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
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

	@FindBy(xpath = "//*[@id='img_0_i6rlbitx']/img")
	private WebElement facebookIcon;

	@FindBy(xpath = "//*[@id='img_1_i6rlbitx']/img")
	private WebElement twiterIcon;

	@FindBy(xpath = "//*[@id='img_2_i6rlbitx']/img")
	private WebElement pinterestIcon;

	@FindBy(xpath = "//*[@id='i0odz-i6rlbitx']/a")
	private WebElement facebookClick;

	@FindBy(xpath = "//*[@id='i220sc-i6rlbitx']/a")
	private WebElement twitterClick;

	@FindBy(xpath = "//*[@id='i3175p-i6rlbitx']/a")
	private WebElement pinterestClick;

	@FindBy(xpath = "//iframe[@title='Wix Hotels']")
	private WebElement wixHotels;

	@FindBy(xpath = "//*[@id=\"adults-label\"]")
	private WebElement adultsLabel;

	@FindBy(xpath = "//*[@id=\"adults\"]/a[1]")
	private WebElement upAdultsClick;

	@FindBy(xpath = "//*[@id=\"adults\"]/span[contains(text(),'3')]")
	private WebElement twoUpAdults;

	@FindBy(xpath = "//*[@id=\"adults\"]/a[2]")
	private WebElement downAdults;

	@FindBy(xpath = "//*[@id='adults']/span[contains(text(),'2')]")
	private WebElement oneDownAdults;

	@FindBy(xpath = "//*[@id=\"i6tj0u8x\"]/a/span")
	private WebElement bookNowClick;

	@FindBy(xpath = "/html/body/div/div/div[4]/div/header/div/div[2]/div[2]/div/div/div[1]/a[@href='https://ancabota09.wixsite.com/intern/rooms']")
	private WebElement roomsDisplay;

	@FindBy(xpath = "//*[@id=\"children-label\"]")
	private WebElement kidsLabel;

	@FindBy(xpath = "//*[@id=\"children\"]/a[1]")
	private WebElement upKidsClick;

	@FindBy(xpath = "//*[@id=\"children\"]/span[contains(text(),'2')]")
	private WebElement twoUpKids;

	@FindBy(xpath = "//*[@id=\"children\"]/a[2]")
	private WebElement downKids;

	@FindBy(xpath = "//*[@id=\"children\"]/span[contains(text(),'1')]")
	private WebElement oneDownKids;

	@FindBy(className  = "color_15")
	private WebElement isaddress;

	@FindBy(xpath = "//*[@id='i71wvfxg']/p[1]")
	private WebElement address1;

	@FindBy(xpath = "//*[@id='i71wvfxg']/p[2]")
	private WebElement address2;

	@FindBy(xpath  = "//p[@class='font_8']")
	private WebElement iscontact;

	@FindBy(xpath = "//*[@id='i71ww6nk']/p[1]/object/a")
	private WebElement contact1;

	@FindBy(xpath = "//*[@id='i71ww6nk']/p[1]/object/a")
	private WebElement accept;

	@FindBy(xpath = "//*[@id='i71ww6nk']/p[2]")
	private WebElement contact2;

	@FindBy(xpath = "//*[@id='i6ktzy38']/p/span")
	private WebElement home;

	@FindBy(xpath = "//*[@id='i71wwqnj']/p[1]")
	private WebElement home1;

	@FindBy(xpath = "//*[@id='i71wwqnj']/p[2]")
	private WebElement home2;

	@FindBy(xpath = "//span[@class='nr31w']" )
	private WebElement bookNow;

	@FindBy(xpath = "//iframe[@title='Wix Chat']")
	private WebElement wixChat;

	@FindBy(xpath = "//*[@id=\"minimized-chat\"]")
	private WebElement minimizeChat;

	@FindBy(xpath = "//form[@class='MvNna']")
	private WebElement find;

	@FindBy(xpath = "//div[@class='wqK4U _1aQMT']")
	private WebElement expectedEmoji;

	@FindBy(xpath = "//button[@class='_14Qkd']")
	private WebElement emojiBtn;

	@FindBy(xpath = "//*[@id=\"emojis-tab-content-0\"]/button[1]")
	private WebElement selectEmoji;

	@FindBy(xpath = "//button[@class='_1TZEF Bgzzt']")
	private WebElement chatButton;

	@FindBy(xpath = "//*[@id=\"name\"]")
	private WebElement name;

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"message\"]")
	private WebElement message;

	@FindBy(xpath = "//button[@class='_1nJDH']")
	private WebElement submit;

	@FindBy(xpath = "//div[contains(text(),'Thanks! Message us here.')]")
	private WebElement submitExpected;

	@FindBy(xpath = "//button[@class='_14Qkd MXzRy']")
	private WebElement attach;

	@FindBy(xpath = ".//input[@type='file']")
	private WebElement file;

	@FindBy(xpath = "//button[@class='_14Qkd _3JsPd']")
	private WebElement sendBtn;

	@FindBy(xpath = "//button[@id='check-in'][1]")
	private WebElement dataBtnCheckIn;

	@FindBy(xpath = "//iframe[contains(@name,'i6kppi75')]")
	private WebElement frame1;

	@FindBy(xpath = "//*[@id='check-in-value']")
	private WebElement actualDateCheckIn;

	@FindBy(xpath = "//span[contains(text(),'30')]")
	private WebElement dataCheckIn;

	@FindBy(xpath = "//iframe[@title='Wix Hotels']")
	private WebElement wixxIframe;

	@FindBy(xpath = "//button[@day-button-aria='day']/span[contains(text(),'6')]")
	private WebElement checkOutData;

	@FindBy(xpath = "//*[@id='check-out-value']")
	private WebElement actualDateCheckOut;

	@FindBy(xpath = "//button[@wix-bi='SEARCH']")
	private WebElement searchButton;

	@FindBy(xpath ="//*[@id='search-widget']/form/ul/li[6]/button/span/span")
	private WebElement csearchButton;

	@FindBy(xpath ="//button[@day-button-aria='day']/span[contains(text(),'30')]")
	private WebElement dataCheckIn2;

	@FindBy(xpath ="/html/body/div/main/div/nav/button[2]")
	private WebElement nextMonth;

	//Actions on WebElements//
	public String getPageTitle(){
		return driver.getTitle();
	}

	public String getHeaderText(){
		return header.getText();
	}

	public boolean homeTabDisplayed(){
		return homeTab.isDisplayed();
	}

	public boolean backgroundDisplayed() {
		return background.isDisplayed();
	}

	public boolean facebookIconDisplayed() {
		return facebookIcon.isDisplayed();
	}

	public boolean twiterIconDisplayed() {
		return twiterIcon.isDisplayed();
	}

	public boolean pinterestIconDisplayed() {
		return pinterestIcon.isDisplayed();
	}

	public void facebookClicked() {
		facebookClick.click();
	}

	public void twitterClicked() {
		twitterClick.click();
	} 

	public void pinterestClicked() {
		pinterestClick.click();
	} 

	public String getUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void closeDriver() {
		driver.close();
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

	public WebDriver frameWixHotels() {
		return driver.switchTo().frame(wixHotels);
	}

	public WebDriver frameWixHotels1() {
		return driver.switchTo().frame(wixHotels);
	}

	public boolean adultsDisplayed() {
		return adultsLabel.isDisplayed();
	}

	public void adultsUpClicked() {
		upAdultsClick.click();
	}

	public boolean twoUpAdultsDisplayed() {
		return twoUpAdults.isDisplayed();
	}

	public void adultsDownClicked() {
		downAdults.click();
	}

	public boolean oneDownAdultsDisplayed() {
		return oneDownAdults.isDisplayed();
	}

	public boolean kidsDisplayed() {
		return kidsLabel.isDisplayed();
	}

	public void kidsUpClicked() {
		upKidsClick.click();
	}

	public boolean twoUpKidsDisplayed() {
		return twoUpKids.isDisplayed();
	}

	public void kidsDownClicked() {
		downKids.click();
	}

	public boolean oneDownKidsDisplayed() {
		return oneDownKids.isDisplayed();
	}

	public boolean addressDisplayed() {
		return isaddress.isDisplayed();
	}

	public boolean addressDisplayed1() {
		return address1.isDisplayed();
	}

	public boolean addressDisplayed2() {
		return address2.isDisplayed();
	}

	public boolean contactDisplayed() {
		return iscontact.isDisplayed();
	}

	public boolean contactDisplayed1() {
		return contact1.isDisplayed();
	}

	public boolean contactDisplayed2() {
		return contact2.isDisplayed();
	}

	public boolean contactAcceptDisplayed2() {
		return accept.isDisplayed();
	}

	public boolean homeDisplayed1() {
		return home.isDisplayed();
	}

	public boolean homeDisplayed2() {
		return home1.isDisplayed();
	}

	public boolean homeDisplayed3() {
		return home2.isDisplayed();
	}

	public boolean bookNowDisplayed() {
		return bookNow.isDisplayed();
	}

	public boolean bookNowClicked() {
		return bookNowClick.isDisplayed();
	}

	public boolean roomsDisplayed() {
		return roomsDisplay.isDisplayed();
	}

	public void switchToChat() {
		driver.switchTo().frame(wixChat);
	}

	public boolean chatBtnisDisplayed() {
		return minimizeChat.isDisplayed();
	}

	public void chatBtnClicked() {
		chatButton.click();
	}

	public void emojiBtnClicked() {
		emojiBtn.click();
	}

	public boolean emojiBtnDisplayed() {
		return emojiBtn.isDisplayed();
	}

	public void emojiClicked() {
		selectEmoji.click();
	}

	public boolean emojiDisplayed() {
		return selectEmoji.isDisplayed();
	}

	public void sendEmojiClicked() {
		sendBtn.click();
	}

	public boolean expectedEmojiDisplayed() {
		return expectedEmoji.isDisplayed();
	}

	public boolean formDisplayed() {
		return find.isDisplayed();
	}

	public void nameClicked() {
		name.click();
	}

	public boolean nameDisplayed() {
		return name.isDisplayed();
	}

	public void nameSendDisplayed() {
		name.sendKeys("Sorina Vancea");
	}

	public void emailClicked() {
		email.click();
	}

	public boolean emailDisplayed() {
		return email.isDisplayed();
	}

	public void emailSendDisplayed() {
		email.sendKeys("sorina.sorina61@yahoo.com");
	}

	public void messageClicked() {
		message.click();
	}

	public boolean messageDisplayed() {
		return email.isDisplayed();
	}

	public void messageSendDisplayed() {
		message.sendKeys("Buna ziua! Acesta este mesajul meu!");
	}

	public void submitClicked() {
		submit.click();
	}

	public boolean submitDisplayed() {
		return submitExpected.isDisplayed();
	}

	public boolean attachmentDisplayed() {
		return attach.isDisplayed();
	}

	public void addFileDisplayed() {
		file.sendKeys("C:\\Users\\z004c2sx\\Documents\\TestCase - Copy.xlsx");
	}

	public void checkInClicked() {
		dataBtnCheckIn.click();
	}

	public void switchToframe() {
		driver.switchTo().frame(frame1);
	}

	public void dataCheckInClicked() {
		dataCheckIn.click();
	}

	public String actualDateCheckIn() {
		return actualDateCheckIn.getText();
	}

	public void dataCheckOutClicked() {
		checkOutData.click();
	}

	public String actualDateCheckOut() {
		return actualDateCheckOut.getText();
	}

	public boolean searchBtnDisplayed() {
		return searchButton.isDisplayed();
	}

	public void searchBtnClicked() {
		csearchButton.click();
	}

	public void dataCheckIn1Clicked() {
		dataCheckIn2.click();
	}

	public void nextMonthClicked() {
		nextMonth.click();
	}
}
