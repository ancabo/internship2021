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
	
	public String textEqual() {
		return text.getText();
	}
}
