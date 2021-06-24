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

}
