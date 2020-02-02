package com.automationpractice.ag_testng.pages.checkout_flow_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.ag_testng.components.shopping_cart_summary.ShoppingCartSummary;
import com.automationpractice.ag_testng.pages.base_page.BasePage;

import ag.framework.browser.Browser;

public class CheckoutFlowPage extends BasePage{

	public CheckoutFlowPage(Browser browser) {
		super(browser);
	}

	public ShoppingCartSummary getShoppingCartSummary() {
		return new ShoppingCartSummary(this.getBrowser());
	}
	
	protected CheckoutFlowPage proceedToCheckout(String buttonName) {
		WebElement processCarrier = getClickableElement(By.cssSelector(".cart_navigation [name=\""+ buttonName +"\"]"));
		processCarrier.click();
		
		return this;
	}
}
