package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.TestBase;

public class ContactPage extends TestBase{
	
	protected WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElements//
		
	@FindBy(xpath = "(//p[@class='ccDUc'])[4]") //  (//a[@data-testid=\"linkElement\"])[5]
	private WebElement contactButton;
	
	@FindBy(id = "i6ly3ckd")
	private WebElement contact;
	
	@FindBy(id = "i6ly3ckc_0")
	private WebElement paragraph;
	
	@FindBy(xpath = "//*[@id=\"i6ly3cka\"]/h3/font")
	private WebElement talkToUs;
	
	@FindBy(xpath = "//div[@id='bgMedia_mediajg145x8s7']")
	private WebElement backgroundImg;
	
	@FindBy(xpath = "//iframe[@title='Google Maps']")
	private WebElement frame;
	
	@FindBy(xpath = "//*[@id=\"map_canvas\"]")
	private WebElement map;
	
	@FindBy(xpath = "//button[@title='Toggle fullscreen view']")
	private WebElement fullScreenB;
	
	@FindBy(xpath = "//a[contains(text(), 'Terms of Use')]")
	private WebElement mapTerms;
	
	@FindBy(xpath = "//a[contains(text(), 'Report a map error')]")
	private WebElement mapError;
	
	@FindBy(xpath = "//*[@id=\"input_comp-jxbsa1e9\"]")
	private WebElement name;
	
	@FindBy(xpath = "//*[@id=\"input_comp-jxbsa1em\"]")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"input_comp-jxbsa1ev\"]")
	private WebElement phone;
	
	@FindBy(xpath = "//*[@id=\"textarea_comp-jxbsa1f7\"]")
	private WebElement message;
	
	@FindBy(xpath = "//*[@id=\"comp-jxbsa1fi\"]/button")
	private WebElement submitB;
	
	@FindBy(xpath = "//p[@class=\"tMcTE\"]")
	private WebElement verificationMsg;
	
	@FindBy(xpath = "//*[@id=\"i0odz-i6rlbitx\"]/a")
	private WebElement fb;
	
	@FindBy(xpath = "//*[@id=\"i220sc-i6rlbitx\"]/a")
	private WebElement tw;
	
	@FindBy(xpath = "//*[@id=\"i3175p-i6rlbitx\"]/a")
	private WebElement pint;
	
	
	//Actions on WebElements//	
	
	public boolean contactButtonDisplayed() {
		return display(contactButton);
	}
	
	public void clickContact() {
		click(contactButton);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean contactUsDisplayed() {
		return display(contact);
	}
	
	public String getContactUsText() {
		return contact.getText();
	}
	
	public boolean paragraphDisplayed() {
		return display(paragraph);
	}
	
	public boolean talkToUsDisplayed() { 
		return display(talkToUs);
	}
	
	public String getTalkToUsText() {
		return talkToUs.getText();
	}
	
	public boolean backgroundImgDisplayed() { 
		return display(backgroundImg);
	}
	
	public void changeFrame() {
		driver.switchTo().frame(frame);
	}
	
	public boolean mapDisplayed() {
		return display(map);
	}
	
	public boolean fullScreenBDisplayed() {
		return display(fullScreenB);
	}
	
	public void clickFullScreenB() {
		click(fullScreenB);
	}
	
	public void clickAndHoldMap() {
		Actions action = new Actions(driver);
        action.moveToElement(map);
        action.clickAndHold().perform();
        click(map);
	}
	
	public boolean mapTermsDisplayed() {
		return display(mapTerms);
	}
	
	public String getMapTermsLink() {
		return getAttributeValue(mapTerms, "href");
	}
	
	public boolean mapErrorDisplayed() {
		return display(mapError);
	}
	
	public String getMapErrorLink() {
		return getAttributeValue(mapError, "href");
	}
	
	public boolean nameDisplayed() {
		return display(name);
	}
	
	public String getNameColour() {
		return name.getCssValue("background-color");
	}
	
	public boolean emailDisplayed() {
		return display(email);
	}
	
	public String getEmailColour() {
		return email.getCssValue("background-color");
	}
	
	public String getEmailBorderColour() {
		return email.getCssValue("border-color");
	}
	
	public boolean phoneDisplayed() {
		return display(phone);
	}
	
	public boolean messageDisplayed() {
		return display(message);
	}
	
	public String getMessageColour() {
		return message.getCssValue("background-color");
	}
	
	public boolean submitBDisplayed() {
		return display(submitB);
	}
	
	public void completeFields() {
		name.sendKeys("John");
		email.sendKeys("john@yahoo.com");
		phone.sendKeys("0753928713");
		message.sendKeys("Hello! Nice to meet you!");		
	}
	
	public void completeWrongEmail() {
		email.sendKeys("john");	
	}
	
	public void clickSubmit() {
		click(submitB);
	}
	
	public boolean verificationMsgDisplayed() {
		return display(verificationMsg);
	}
	
	public boolean fbDisplayed() {
		return display(fb);
	}
	
	public String getFbLink() {
		return getAttributeValue(fb, "href");
	}
	
	public boolean twitterDisplayed() {
		return display(tw);
	}
	
	public String getTwLink() {
		return getAttributeValue(tw, "href");
	}
	
	public boolean pinterestDisplayed() {
		return display(pint);
	}
	
	public String getPintLink() {
		return getAttributeValue(pint, "href");
	}

}
