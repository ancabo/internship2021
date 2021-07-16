package common;

import java.lang.reflect.Method;
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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class TestBase {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		//setup report
		htmlReporter = new ExtentHtmlReporter("./InternshipReport.html");
		htmlReporter.config().setDocumentTitle("Internship Test Automation Report");
		htmlReporter.config().setReportName("Internship Test Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeMethod(alwaysRun = true)
	public void setUpBeforeMethod(Method method) {
		//setup driver
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ancabota09.wixsite.com/intern");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//setup report
		test = extent.createTest(method.getName());
	}


	@AfterTest(alwaysRun = true)
	public void quitDriver() {
		if (driver != null)
			driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("FAILED: " + result.getName());
			System.out.println(result.getThrowable().toString());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.RED));
		}
		else if (result.getStatus() == ITestResult.SKIP){
			System.out.println("SKIPPED");       
			test.log(Status.SKIP, MarkupHelper.createLabel("Skipped", ExtentColor.ORANGE));
		}		
		else{
			System.out.println("PASSED: " + result.getName());
			test.log(Status.PASS, MarkupHelper.createLabel("Passed", ExtentColor.GREEN));
		}	        
		extent.flush();
	}



	// Selenium Helpers

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public boolean display(WebElement element) {
		return element.isDisplayed();
	}

	public String getText(WebElement element) {
		return element.getText();
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

	//	public WebDriver switchToFrame(WebElement element) {
	//		return driver.switchTo().frame(element);
	//	}

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
	public void implicitWait(int sec) {
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

	public WebElement waitElementIsClickable(int intervalToWait, WebElement emojiBtn){
		WebElement element = new WebDriverWait(driver, intervalToWait)
				.until(ExpectedConditions.elementToBeClickable(emojiBtn));

		return element;
	}

	public void waitForFrameAndSwitch(WebElement wixChat) {
		WebDriverWait wait = new WebDriverWait(driver, 400);		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(wixChat));
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



	// Extent Reports Helper
	public void logReport(String logType, String logDetails) {

		switch (logType) {
		case "Pass":
			test.log(Status.PASS, logDetails);
			break;
		case "Fail":
			test.log(Status.FAIL, logDetails);
			break;
		case "Info":
			test.log(Status.INFO, logDetails);
			break;
		}	
	}

}
