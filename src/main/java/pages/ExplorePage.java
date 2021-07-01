package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage {

	protected WebDriver driver;


	public ExplorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"i6kl732v1label\"]")
	private WebElement exploreBtn;

	@FindBy(xpath = "//*[@id=\"i6ksjvsy\"]/h2")
	private WebElement text;

	@FindBy(xpath = "//div/wix-image/img")
	private WebElement background;

	@FindBy(xpath = "//*[@id=\"img_0_i6rlbitx\"]")
	private WebElement facebookIcon;

	@FindBy(xpath = "//*[@id='img_1_i6rlbitx']/img")
	private WebElement twiterIcon;

	@FindBy(xpath = "//*[@id='i3175p-i6rlbitx']/a")
	private WebElement pinterestIcon;

	@FindBy(xpath = "//*[@id='i0odz-i6rlbitx']/a")
	private WebElement facebookClick;

	@FindBy(xpath = "//*[@id='i220sc-i6rlbitx']/a")
	private WebElement twitterClick;

	@FindBy(xpath = "//*[@id='i3175p-i6rlbitx']/a")
	private WebElement pinterestClick;

	@FindBy(xpath = "//iframe[@title='Wix Hotels']")
	private WebElement wixHotels;

	@FindBy(xpath = "//*[@id=\"i6lurq9f\"]/h2")
	private WebElement amenties;

	@FindBy(xpath = "//*[@id=\"i6lvcm6t_1\"]/p/span")
	private WebElement cleaning;

	@FindBy(xpath ="//*[@id=\"i6lvcgoj_0\"]/p/span")
	private WebElement parking;

	@FindBy(xpath = "//*[@id=\"i6lvciyu_1\"]/p/span")
	private WebElement furnished;

	@FindBy(xpath = "//*[@id=\"i6kugnss\"]/p/span")
	private WebElement wifi;

	@FindBy(xpath = "//*[@id=\"i6lvdfkt\"]/p/span")
	private WebElement airport;

	@FindBy(xpath = "//*[@id=\"i6kvcfzq\"]/h2")
	private WebElement exploreCity;

	@FindBy(xpath = "//*[@id=\"i6kv3ge8\"]/p[1]")
	private WebElement chinaTown;

	@FindBy(xpath = "//*[@id=\"i6kvbhmb\"]/p[1]")
	private WebElement haightAshbury;

	@FindBy(xpath ="//*[@id=\"i6kvbkw0\"]/p[1]")
	private WebElement bridge;

	@FindBy(className  = "color_15")
	private WebElement isaddress;

	@FindBy(xpath = "//*[@id='i71wvfxg']/p[1]")
	private WebElement address1;

	@FindBy(xpath = "	//*[@id='i71wvfxg']/p[2]")
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

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean exploreBtnDisplayed() {
		return exploreBtn.isDisplayed();
	}

	public void exploreBtnClicked() {
		 exploreBtn.click();
	}

	public String amentiesGetText() {
		return amenties.getText();
	}

	public String cleaningGetText() {
		return cleaning.getText();
	}

	public String parkingGetText() {
		return parking.getText();
	}

	public String furnishedGetText() {
		return furnished.getText();
	}

	public String wifiGetText() {
		return wifi.getText();
	}

	public String airportGetText() {
		return airport.getText();
	}

	public String exploreCityGetText() {
		return exploreCity.getText();
	}

	public String chinaTownGetText() {
		return chinaTown.getText();
	}

	public String haightAshburyGetText() {
		return haightAshbury.getText();
	}

	public String bridgeGetText() {
		return bridge.getText();
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

	public String textEqual() {
		return text.getText();
	}

	//////////////////chat
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
	////////////////////
}
