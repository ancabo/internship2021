package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.TestBase;

public class ChatPage extends TestBase{

	protected WebDriver driver;

	public ChatPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
	
	
	public void switchToChat() {
		waitForFrameAndSwitch(wixChat);
		//driver.switchTo().frame(wixChat);
	}

	public boolean chatBtnisDisplayed() {
		
		return display(minimizeChat);
	}

	public TestBase chatBtnClicked() {
		click(chatButton);
		return this;
	}

	public TestBase emojiBtnClicked() {
		waitElementIsClickable(5,emojiBtn);
		click(emojiBtn);
		return this;
	}

	public boolean emojiBtnDisplayed() {
		return display(emojiBtn);
	}

	public TestBase emojiClicked() {
		waitElementIsClickable(5,selectEmoji);
		click(selectEmoji);
		return this;
	}

	public boolean emojiDisplayed() {
		return display(selectEmoji);
	}

	public TestBase sendEmojiClicked() {
		waitElementIsClickable(5,sendBtn);
		click(sendBtn);
		return this;
	}

	public boolean expectedEmojiDisplayed() {
		return display(expectedEmoji);
	}

	public boolean formDisplayed() {
		return display(find);
	}

	public TestBase nameClicked() {
		click(name);
		return this;
	}

	public boolean nameDisplayed() {
		return display(name);
	}

	public TestBase nameSendDisplayed() {
		clear_SendKey(name, "Sorina Vancea");
		return this;
	}

	public void emailClicked() {
		waitElementIsClickable(5,email);
		email.click();
	}

	public boolean emailDisplayed() {
		return display(email);
	}

	public TestBase emailSendDisplayed() {
		clear_SendKey(email, "sorina.sorina61@yahoo.com");
		return this;
	}

	public TestBase messageClicked() {
		waitElementIsClickable(5,message);
		click(message);
		return this;
	}

	public boolean messageDisplayed() {
		return display(email);
	}

	public TestBase messageSendDisplayed() {
		clear_SendKey(message,"Buna ziua! Acesta este mesajul meu!");
		return this;
	}

	public TestBase submitClicked() {
		waitElementIsClickable(10,submit);
		click(submit);
		return this;
	}

	public boolean submitDisplayed() {
		return display(submitExpected);
	}

	public boolean attachmentDisplayed() {
		waitElementIsVisible(attach,5);
		return display(attach);
	}

	public TestBase addFileDisplayed() {
		clear_SendKey(file,"D:\\hey.png");
		return this;
	}
}
