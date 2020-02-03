package ag.framework.browser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

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
			this.driver = new ChromeDriver();
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
}
