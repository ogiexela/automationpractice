package ag.testng;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ag.base_test.BaseTest;
import ag.framework.browser.Browser;

public class ScreenshotListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult result) {

		Object currentClass = result.getInstance();
		Browser browser = ((BaseTest) currentClass).browser();

		String methodName = result.getName();

		browser.takeScreenshot(methodName);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

		Object currentClass = result.getInstance();
		Browser browser = ((BaseTest) currentClass).browser();

		String methodName = result.getName();

		browser.takeScreenshot(methodName);
	}
}