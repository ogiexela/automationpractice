package com.automationpractice.ag_testng.pages.shopping_cart_summary_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.ag_testng.pages.base_page.BasePage;

import ag.framework.browser.Browser;

public class ShoppingCartSummaryPage extends BasePage {

	public ShoppingCartSummaryPage(Browser browser) {
		super(browser);
	}

	public ShoppingCartSummaryPage proceedToCheckout() {
		WebElement proceedToCheckout = this.getBrowser()
				.getClickableElement(By.cssSelector(".cart_navigation [title=\"Proceed to checkout\"]"));
		proceedToCheckout.click();
		return this;
	}

}
