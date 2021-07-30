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
	
	@FindBy(xpath = "//span[contains(text(),'BOOK ')]")
	private WebElement bookNowButtonText;
	
	//div/div/p[contains(text(),'More')]
	//span[contains(text(),'BOOK ')]
	
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
		return display(roomsButtonText);
	}
	
	public boolean contactButtonDisplayed() {
		return display(contactButtonText);
	}
	
	public boolean exploreButtonDisplayed() {
		return display(exploreButtonText);
	}
	
	public boolean homeButtonDisplayed() {
		return display(homeButtonText);
	}
	
	public boolean bookNowButtonDisplayed() {
		return display( bookNowButtonText);
	}
	
	public boolean bookNowButtonGoodDisplayed() {
		return display(bookNowButtonGood);
	}
	
	public String getTextHomeButton() {
		//System.out.println(homeButtonText.getText());
		return homeButton.getText();
	}
	
	public String getTextExploreButton() {
		return exploreButton.getText();
	}
	
	public String getTextRoomsButton() {
		return roomsButton.getText();
	}
	
	public String getTextContactButton() {
		return contactButton.getText();
	}
	
	public String getTextBookNowButton() {
		return bookNowButtonGood.getText();
	}
	
	public String getTextBookNowButtonGood() {
		return bookNowButtonGood.getText();
	}
}
