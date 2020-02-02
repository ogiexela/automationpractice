package ag.framework.assertions;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import static org.testng.Assert.assertEquals;

public class Assertions {
	
	private Wait<WebDriver> wait;
	
	public Assertions(Wait<WebDriver> wait) {
		this.wait = wait;
	}
	
	public void shouldBeTrue(Function<WebDriver, Boolean> conditionalFunction, String failMessage) {
		Boolean isTrue = this.wait.until(conditionalFunction);
		assertEquals(true, isTrue.booleanValue(), failMessage);
	}
	
	public void shouldBeTrue(Function<WebDriver, Boolean> conditionalFunction) {
		Boolean isTrue = this.wait.until(conditionalFunction);
		assertEquals(true, isTrue.booleanValue());
	}
	
	public void shouldHaveText(WebElement element, String text, String failMessage) {
		Boolean isTrue = this.wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		assertEquals(true, isTrue.booleanValue(), failMessage);
	}
	
	public void textMustBe(By selector, String text, String failMessage) {
		Boolean isTrue = this.wait.until(ExpectedConditions.textToBe(selector, text));
		assertEquals(true, isTrue.booleanValue(), failMessage);
	}
	
	public void textMustBe(WebElement element, String text, String failMessage) {
		Boolean isTrue = this.wait.until(driver -> text.equals(element.getText()));
		assertEquals(true, isTrue.booleanValue(), failMessage);
	}
	
	public void shouldNotShow(WebElement element, String failMessage) {
		Boolean isTrue = this.wait.until(ExpectedConditions.invisibilityOf(element));
		assertEquals(true, isTrue.booleanValue(), failMessage);
	}

}
