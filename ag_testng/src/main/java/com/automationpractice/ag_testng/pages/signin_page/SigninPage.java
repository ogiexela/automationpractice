package com.automationpractice.ag_testng.pages.signin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.ag_testng.pages.base_page.BasePage;

import ag.framework.browser.Browser;

public class SigninPage extends BasePage {

	public SigninPage(Browser browser) {
		super(browser);
	}
	
	public SigninPage createAccount(String email) {
		enterNewAccountEmail(email);
		clickCreateNewAccount();
		
		return this;
	}
	
	public SigninPage enterNewAccountEmail(String email) {
		WebElement emailField = getClickableElement(By.cssSelector("#email_create"));
		emailField.sendKeys(email);
		
		return this;
	}
	
	public SigninPage clickCreateNewAccount() {
		WebElement createEmail = getClickableElement(By.cssSelector("#SubmitCreate"));
		createEmail.click();
		return this;
	}

}
