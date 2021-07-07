package common;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMedia extends TestBase{

	protected WebDriver driver;

	public SocialMedia(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='img_0_i6rlbitx']/img")
	private WebElement facebookIcon;

	@FindBy(xpath = "//*[@id='img_1_i6rlbitx']/img")
	private WebElement twiterIcon;

	@FindBy(xpath = "//*[@id='img_2_i6rlbitx']/img")
	private WebElement pinterestIcon;
	
	
	
	public boolean facebookIconDisplayed() {
		return display(facebookIcon);
	}

	public boolean twiterIconDisplayed() {
		return display(twiterIcon);
	}

	public boolean pinterestIconDisplayed() {
		return display(pinterestIcon);
	}

	public TestBase facebookClicked() {
		click(facebookIcon);
		return this;
	}

	public TestBase twitterClicked() {
		click(twiterIcon);
		return this;
	} 

	public TestBase pinterestClicked() {
		click(pinterestIcon);
		return this;
	} 

	public String getUrl() {
		String url = driver.getCurrentUrl();
		return url;
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
