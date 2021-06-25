package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	protected WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//WebElements//
	
		@FindBy(xpath = "(//p[@class='ccDUc'])[4]") //  (//a[@data-testid=\"linkElement\"])[5] //
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
		
		@FindBy(xpath = "//*[@id=\"i01vcq-i6m1143v\"]/a")
		private WebElement fb;
		
		@FindBy(xpath = "//*[@id=\"i21ibq-i6m1143v\"]/a")
		private WebElement tw;
		
		@FindBy(xpath = "//*[@id=\"i3mls-i6m1143v\"]/a")
		private WebElement pint;
		
		@FindBy(xpath = "//*[@id=\"i0odz-i6rlbitx\"]/a")
		private WebElement fb2;
		
		@FindBy(xpath = "//*[@id=\"i220sc-i6rlbitx\"]/a")
		private WebElement tw2;
		
		@FindBy(xpath = "//*[@id=\"i3175p-i6rlbitx\"]/a")
		private WebElement pint2;
		
		@FindBy(xpath = "//*[@id=\"i6ku0wvj\"]/p/span")
		private WebElement addressTitle;
		
		@FindBy(xpath = "//*[@id=\"i71wvfxg\"]/p[1]")
		private WebElement address1;
		
		@FindBy(xpath = "//*[@id=\"i71wvfxg\"]/p[2]")
		private WebElement address2;
		
		@FindBy(xpath = "//*[@id=\"i6ku3n0i\"]/p/span")
		private WebElement contactTitle;
		
		@FindBy(xpath = "//*[@id=\"i71ww6nk\"]/p[1]")
		private WebElement contact1;
		
		@FindBy(xpath = "//*[@id=\"i71ww6nk\"]/p[2]")
		private WebElement contact2;
		
		@FindBy(xpath = "//*[@id=\"i6ktzy38\"]/p/span")
		private WebElement haTitle;
		
		@FindBy(xpath = "//*[@id=\"i71wwqnj\"]/p[1]")
		private WebElement ha1;
		
		@FindBy(xpath = "//*[@id=\"i71wwqnj\"]/p[2]")
		private WebElement ha2;
		
		@FindBy(xpath = "//*[@id=\"i6lux50r_0\"]/p/span")
		private WebElement payTitle;
		
		@FindBy(xpath = "//*[@id=\"i71uub1o\"]/div[1]")
		private WebElement payment;
		
		
		//Actions on WebElements//	
		
		public boolean contactButtonDisplayed() {
			return contactButton.isDisplayed();
		}
		
		public void clickContact() {
			contactButton.click();
		}
		
		public String getPageTitle() {
			return driver.getTitle();
		}
		
		public boolean contactUsDisplayed() {
			return contact.isDisplayed();
		}
		
		public String getContactUsText() {
			return contact.getText();
		}
		
		public boolean paragraphDisplayed() {
			return paragraph.isDisplayed();
		}
		
		public boolean talkToUsDisplayed() { 
			return talkToUs.isDisplayed();
		}
		
		public String getTalkToUsText() {
			return talkToUs.getText();
		}
		
		public boolean backgroundImgDisplayed() { 
			return backgroundImg.isDisplayed();
		}
		
		public void changeFrame() {
			driver.switchTo().frame(frame);
		}
		
		public boolean mapDisplayed() {
			return map.isDisplayed();
		}
		
		public boolean fullScreenBDisplayed() {
			return fullScreenB.isDisplayed();
		}
		
		public boolean nameDisplayed() {
			return name.isDisplayed();
		}
		
		public boolean emailDisplayed() {
			return email.isDisplayed();
		}
		
		public boolean phoneDisplayed() {
			return phone.isDisplayed();
		}
		
		public boolean messageDisplayed() {
			return message.isDisplayed();
		}
		
		public boolean submitBDisplayed() {
			return submitB.isDisplayed();
		}
		
		public void completeFields() {
			name.sendKeys("John");
			email.sendKeys("john@yahoo.com");
			phone.sendKeys("0753928713");
			message.sendKeys("Hello! Nice to meet you!");		
		}
		
		public void clickSubmit() {
			submitB.click();
		}
		
		public boolean verificationMsgDisplayed() {
			return verificationMsg.isDisplayed();
		}
		
		public boolean fbDisplayed() {
			return fb.isDisplayed();
		}
		
		public String getFbLink() {
			return fb.getAttribute("href");
		}
		
		public boolean twitterDisplayed() {
			return tw.isDisplayed();
		}
		
		public String getTwLink() {
			return tw.getAttribute("href");
		}
		
		public boolean pinterestDisplayed() {
			return pint.isDisplayed();
		}
		
		public String getPintLink() {
			return pint.getAttribute("href");
		}
		
		public boolean fb2Displayed() {
			return fb2.isDisplayed();
		}
		
		public String getFb2Link() {
			return fb2.getAttribute("href");
		}
		
		public boolean twitter2Displayed() {
			return tw2.isDisplayed();
		}
		
		public String getTw2Link() {
			return tw2.getAttribute("href");
		}
		
		public boolean pinterest2Displayed() {
			return pint2.isDisplayed();
		}
		
		public String getPint2Link() {
			return pint2.getAttribute("href");
		}
		
		public boolean addressTitleDisplayed() {
			return addressTitle.isDisplayed();
		}
		
		public String getAddressTitle() {
			return addressTitle.getText();
		}
		
		public boolean address1Displayed() {
			return address1.isDisplayed();
		}
		
		public String getAddress1Text() {
			return address1.getText();
		}
		
		public boolean address2Displayed() {
			return address2.isDisplayed();
		}
		
		public String getAddress2Text() {
			return address2.getText();
		}
		
		public boolean contactTitleDisplayed() {
			return contactTitle.isDisplayed();
		}
		
		public String getContactTitle() {
			return contactTitle.getText();
		}
		
		public boolean contact1Displayed() {
			return contact1.isDisplayed();
		}
		
		public String getContact1Text() {
			return contact1.getText();
		}
		
		public boolean contact2Displayed() {
			return contact2.isDisplayed();
		}
		
		public String getContact2Text() {
			return contact2.getText();
		}
		
		public boolean haTitleDisplayed() {
			return haTitle.isDisplayed();
		}
		
		public String getHaTitle() {
			return haTitle.getText();
		}
		
		public boolean ha1Displayed() {
			return ha1.isDisplayed();
		}
		
		public String getHa1Text() {
			return ha1.getText();
		}
		
		public boolean ha2Displayed() {
			return ha2.isDisplayed();
		}
		
		public String getHa2Text() {
			return ha2.getText();
		}
		
		public boolean payTitleDisplayed() {
			return payTitle.isDisplayed();
		}
		
		public String getPayTitle() {
			return payTitle.getText();
		}
		
		public boolean paymentDisplayed() {
			return payment.isDisplayed();
		}
}
