package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.TestBase;

public class MenuPage extends TestBase {

	protected WebDriver driver;

	public MenuPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a/div/div/p[contains(text(),'HOME')]")
	private WebElement homeButtonText;
	
	@FindBy(xpath = "//a/div/div/p[contains(text(),'EXPLORE')]")
	private WebElement exploreButtonText;
	
	@FindBy(xpath = "//a/div/div/p[contains(text(),'ROOMS')]")
	private WebElement roomsButtonText;
	
	@FindBy(xpath = "//a/div/div/p[contains(text(),'CONTACT')]")
	private WebElement contactButtonText;
	
	@FindBy(xpath = "//div/div/p[contains(text(),'More')]")
	private WebElement bookNowButtonText;
	
	@FindBy(xpath = "(//p[@class='ccDUc'])[1]") // //p[@id='i6kl732v0label']
	private WebElement homeButton;
	
	@FindBy(xpath = "(//p[@class='ccDUc'])[2]")
	private WebElement exploreButton;
	
	@FindBy(xpath = "(//p[@class='ccDUc'])[3]")
	private WebElement roomsButton;
	
	@FindBy(xpath = "(//p[@class='ccDUc'])[4]")
	private WebElement contactButton;
	
	@FindBy(xpath = "(//p[@class='ccDUc'])[5]")
	private WebElement bookNowButton;
	
	@FindBy(xpath = "//span[@class='nr31w']")
	private WebElement bookNowButtonGood;
	
	
	@FindBy(xpath = "//p/span[@class = 'color_15']")
	private List<WebElement> generalInfoTitles;
	

	public List<WebElement> homeMenuTitles() {
		List<WebElement> titles = driver.findElements(By.xpath("//p[@class='ccDUc']"));
		return titles;
	}
	
	public List<WebElement> getHomeMenuTitles() {
		List<WebElement> titles = homeMenuTitles();
		return titles;
	}
	
	public ArrayList<String> getHomeMenuTitlesText() {
		List<WebElement> titles = homeMenuTitles();
		ArrayList<String> listofTitlesLink = new ArrayList<String>();
		for(WebElement title : titles) {
			//if(title.isDisplayed()) 
				listofTitlesLink.add(getText(title));	
		}
		return listofTitlesLink;
	}
	
	public boolean roomsButtonDisplayed() {
		return display(roomsButton);
	}
	
	public boolean contactButtonDisplayed() {
		return display(contactButton);
	}
	
	public boolean exploreButtonDisplayed() {
		return display(exploreButton);
	}
	
	public boolean homeButtonDisplayed() {
		return display(homeButton);
	}
	
	public boolean bookNowButtonDisplayed() {
		return display(bookNowButton);
	}
	
	public boolean bookNowButtonGoodDisplayed() {
		return display(bookNowButtonGood);
	}
	
	public String getTextHomeButton() {
		//System.out.println(homeButtonText.getText());
		return homeButtonText.getText();
	}
	
	public String getTextExploreButton() {
		return exploreButtonText.getText();
	}
	
	public String getTextRoomsButton() {
		return roomsButtonText.getText();
	}
	
	public String getTextContactButton() {
		return contactButtonText.getText();
	}
	
	public String getTextBookNowButton() {
		return bookNowButtonText.getText();
	}
	
	public String getTextBookNowButtonGood() {
		return bookNowButtonGood.getText();
	}
}
