package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
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
	
	@FindBy(xpath = "//iframe[@title='Wix Chat']")
	private WebElement frameChat; 
	
	@FindBy(xpath = "//div[@data-hook=\"chat-widget\"]")
	private WebElement chatB;
	
	@FindBy(xpath = "//textarea[@role=\"textbox\"]")
	private WebElement textare;
	
	@FindBy(xpath = "//span[@data-hook=\"indication-text\"]")
	private WebElement sent;
	
	@FindBy(xpath = "//div[@data-hook=\"chat-message\"]")
	private WebElement chatMsg;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submitChatB;
	
	@FindBy(xpath = "//div[@id=\"name-error\"]")
	private WebElement nameErr;
	
	@FindBy(xpath = "//div[@id=\"email-error\"]")
	private WebElement emailErr;
	
	@FindBy(xpath = "//input[@id=\"name\"]")
	private WebElement nameChat;
	
	@FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement emailChat;
	
	@FindBy(xpath = "//textarea[@id=\"message\"]")
	private WebElement messageChat;
	
	@FindBy(xpath = "//div[@data-hook=\"lcf-thank-you\"]")
	private WebElement thxMsg;
	
	@FindBy(xpath = "//button[@data-hook=\"attachment-button\"]")
	private WebElement attachmentB;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement attachment;
	
	@FindBy(xpath = "//button[@data-hook=\"emoji-keyboard\"]")
	private WebElement emojiB;
	
	@FindBy(xpath = "//div[@id=\"emojis-tab-content-0\"]")
	private WebElement emojiBox;
	
	@FindBy(xpath = "//button[@data-unicode=\"1f609\"]")
	private WebElement emoji;
	
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
	
	public void clickFullScreenB() {
		fullScreenB.click();
	}
	
	public void clickAndHoldMap() {
		Actions action = new Actions(driver);
        action.moveToElement(map);
        action.clickAndHold().perform();
        map.click();
	}
	
	public boolean mapTermsDisplayed() {
		return mapTerms.isDisplayed();
	}
	
	public String getMapTermsLink() {
		return mapTerms.getAttribute("href");
	}
	
	public boolean mapErrorDisplayed() {
		return mapError.isDisplayed();
	}
	
	public String getMapErrorLink() {
		return mapError.getAttribute("href");
	}
	
	public boolean nameDisplayed() {
		return name.isDisplayed();
	}
	
	public String getNameColour() {
		return name.getCssValue("background-color");
	}
	
	public boolean emailDisplayed() {
		return email.isDisplayed();
	}
	
	public String getEmailColour() {
		return email.getCssValue("background-color");
	}
	
	public String getEmailBorderColour() {
		return email.getCssValue("border-color");
	}
	
	public boolean phoneDisplayed() {
		return phone.isDisplayed();
	}
	
	public boolean messageDisplayed() {
		return message.isDisplayed();
	}
	
	public String getMessageColour() {
		return message.getCssValue("background-color");
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
	
	public void completeWrongEmail() {
		email.sendKeys("john");	
	}
	
	public void clickSubmit() {
		submitB.click();
	}
	
	public boolean verificationMsgDisplayed() {
		return verificationMsg.isDisplayed();
	}
	
	public void changeChatFrame() {
		driver.switchTo().frame(frameChat);
	}
	
	public boolean chatButtonDisplayed() {
		return chatB.isDisplayed();
	}
	
	public void clickChatB() {
		chatB.click();
	}
	
	public boolean textareDisplayed() {
		return textare.isDisplayed();
	}
	
	public void sendTextChat() {
		textare.sendKeys("Hey");  
    	textare.sendKeys(Keys.ENTER);
	}
	
	public String getSentMessage() {
		return sent.getText();
	}
	
	public boolean chatMsgDisplayed() {
		return chatMsg.isDisplayed();
	}
	
	public boolean submitChatBDisplayed() {
		return submitChatB.isDisplayed();
	}
	
	public void clickSubmitChatB() {
		submitChatB.click();
	}
	
	public boolean nameErrDisplayed() {
		return nameErr.isDisplayed();
	}
	
	public boolean emailErrDisplayed() {
		return emailErr.isDisplayed();
	}
	
	public boolean nameChatDisplayed() {
		return nameChat.isDisplayed();
	}
	
	public void completeName() {
		nameChat.sendKeys("Ion");
	}
	
	public boolean emailChatDisplayed() {
		return emailChat.isDisplayed();
	}
	
	public void completeWrongEmailChat() {
		emailChat.sendKeys("hey..."); 
	}
	
	public boolean messageChatDisplayed() {
		return messageChat.isDisplayed();
	}
	
	public void clickChatMessage() {
		messageChat.click();
	}
	
	public void completeChatMessage() {
		messageChat.sendKeys("Hello");
	}
	
	public boolean emailErrChatDisplayed() {
		return emailErr.isDisplayed();
	}
	
	public void clearEmail() {
		emailChat.click();
        emailChat.clear();
	}
	
	public void completeEmailChat() {
		emailChat.sendKeys("ion@yahoo.com"); 
	}
	
	public boolean thxMsgDisplayed() {
		return thxMsg.isDisplayed();
	}
	
	public boolean attachmentBDisplayed() {
		return attachmentB.isDisplayed();
	}
	
	public void sendAttachment() {
		attachment.sendKeys("D:\\hey.png");
	}
	
	public boolean emojiBDisplayed() {
		return emojiB.isDisplayed();
	}
	
	public void clickEmojiB() {
		emojiB.click();
	}
	
	public boolean emojiBoxDisplayed() {
		return emojiBox.isDisplayed();
	}
	
	public boolean emojiDisplayed() {
		return emoji.isDisplayed();
	}
	
	public void clickEmoji() {
		emoji.click();
	}
	
	public void enter() {
		textare.sendKeys(Keys.ENTER);    
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
