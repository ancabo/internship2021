package common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;



public class TestBase {
	public static WebDriver driver;
	

	@BeforeMethod(alwaysRun = true)
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
    	driver.get("https://ancabota09.wixsite.com/intern");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	@AfterTest(alwaysRun = true)
	public void quitDriver() {
		if (driver != null)
			driver.quit();
		}
	
	
	
	
	// Selenium Helpers
	
	public void navigateToURL(String url) {
		driver.get(url);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean checkTextOnPage(String textToCheck){
		return driver.getPageSource().contains(textToCheck);
	}
	
	public String getAttributeValue(WebElement element, String attribute){
		return element.getAttribute(attribute);
	}
	
	public void clear_SendKey(WebElement element, String txt) {
		element.clear();
		element.sendKeys(txt);
	}

	public void click(WebElement element) {
		element.click();
	}
	
	
	// DropDown select

	public void selectDropDownByVisibleText(WebElement element, String dropDownText) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(dropDownText);
	}

	public void selectDropDownByIndex(WebElement element, int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	public void selectDropDownByValue(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public String getDropDownFirstSelectedOption(WebElement element) {
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText();
	}
	
	
	//Wait methods
	//implicit wait
	public void inplicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public void waitPageLoad(int sec) {
		driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
	}
	
	
	//explicit wait
	public void waitElementIsVisible(WebElement element, int intervalToWait) {
		WebDriverWait wait = new WebDriverWait(driver, intervalToWait);		
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public WebElement waitElementIsClickable(int intervalToWait, By option){
		WebElement element = new WebDriverWait(driver, intervalToWait)
		        .until(ExpectedConditions.elementToBeClickable(option));
		
		return element;
	}
	
		
	//fluent wait	
	public WebElement fluentWaitElementPresentBy(int secTimeOut, int secSearchInterval, By option){ //By.xpath("//a/h3"))
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(secTimeOut))
				.pollingEvery(Duration.ofSeconds(secSearchInterval)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		
		WebElement fluentElement = wait.until(ExpectedConditions.presenceOfElementLocated(option));
		return fluentElement;		
	}
		
	public WebElement fluentWait(int secTimeOut, int secSearchInterval, final By option) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(secTimeOut))
				.pollingEvery(Duration.ofSeconds(secSearchInterval)).ignoring(NoSuchElementException.class);

		WebElement fluentElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(option);
			}
		});
		return fluentElement;
	}
	
}
