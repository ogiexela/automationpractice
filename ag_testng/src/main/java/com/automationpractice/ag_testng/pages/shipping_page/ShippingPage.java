package com.automationpractice.ag_testng.pages.shipping_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.ag_testng.pages.checkout_flow_page.CheckoutFlowPage;

import ag.framework.browser.Browser;

public class ShippingPage extends CheckoutFlowPage {

	public ShippingPage(Browser browser) {
		super(browser);
	}

	public ShippingPage agreeToTOS() {
		WebElement agreeTOS = getClickableElement(By.cssSelector("#uniform-cgv"));
		agreeTOS.click();
		
		return this;
	}
	
	public ShippingPage proceedToCheckout() {
		super.proceedToCheckout("processCarrier");
		
		return this;
	}
	
}