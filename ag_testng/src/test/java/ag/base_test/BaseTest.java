package ag.base_test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ag.framework.assertions.Assertions;
import ag.framework.browser.Browser;
import ag.testng.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class BaseTest {
	private Browser browser;
	private Assertions assertions;

	@BeforeClass
	@Parameters({"browserName", "timeout", "pollInterval", "pageURL"})
	public void setUp(
			@Optional("chrome") String browsername,
			@Optional("30") int timeout,
			@Optional("3") int pollInterval,
			@Optional("http://automationpractice.com") String pageURL
	) {
		browser = new Browser(browsername, timeout, pollInterval);
		assertions = new Assertions(browser.getWait());
		
		browser
		.maximizeWindow()
		.goTo(pageURL);
	}

	@AfterClass
	public void tearDown() {
		browser.quit();
	}
	
	public Browser browser() {
		return this.browser;
	}
	
	public Assertions assertions() {
		return this.assertions;
	}
}
