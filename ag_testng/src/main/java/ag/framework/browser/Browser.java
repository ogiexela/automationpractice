package ag.framework.browser;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	private WebDriver driver;

	private Wait<WebDriver> wait;

	public Browser(String type, int timeout, int polling) {
		switch (type.toLowerCase()) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			
			chromeOptions.addArguments("--headless");
			
			this.driver = new ChromeDriver(chromeOptions);
			break;
		case "chrome-headless":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.addArguments("--headless", "--window-size=1920,1080");
			
			this.driver = new ChromeDriver(chromeOptions);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			this.driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Unknown browser type: " + type);
		}

		if (this.driver != null) {
			this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(polling)).ignoring(NoSuchElementException.class);
		}
	}

	public Browser maximizeWindow() {
		this.driver.manage().window().maximize();

		return this;
	}

	public Wait<WebDriver> getWait() {

		return this.wait;
	}

	public void goTo(String url) {
		this.driver.get(url);
	}

	public void quit() {
		this.driver.quit();
	}

	public String getTitle() {
		return this.driver.getTitle();
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	public WebElement getElement(By selector) {
		WebElement element = wait.until(driver -> driver.findElement(selector));
		return element;
	}

	public List<WebElement> getElements(By selector) {
		List<WebElement> elements = wait.until(driver -> driver.findElements(selector));

		return elements;
	}

	public WebElement getClickableElement(By selector) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}

	public Actions getActionBuilder() {
		return new Actions(driver);
	}

	public Browser switchToDefaultContent() {
		this.driver.switchTo().defaultContent();
		return this;
	}

	public Browser switchToFrame(By frameSelector) {
		this.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSelector));

		return this;
	}

	public Browser takeScreenshot(String name) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/target/surefire-reports";
			File destFile = new File((String) reportDirectory + "/screenshots/" + name + "_"
					+ formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return this;
	}
}
