package pages;

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
}
