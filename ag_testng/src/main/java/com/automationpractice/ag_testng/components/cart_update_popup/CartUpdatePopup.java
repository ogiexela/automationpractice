package com.automationpractice.ag_testng.components.cart_update_popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ag.framework.browser.Browser;

public class CartUpdatePopup {
	private Browser browser;
	private String LAYER_CART_LOCATOR = "#layer_cart";
	
	public CartUpdatePopup(Browser browser) {
		this.browser = browser;
	}
	
	public CartUpdatePopup continueShopping() {
		WebElement continueShopping = getContinueShoppingButton();
		continueShopping.click();
		return this;
	}
	
	public WebElement getCartUpdatePopup() {
		return this.browser.getElement(By.cssSelector(LAYER_CART_LOCATOR));
	}
	
	public WebElement getContinueShoppingButton() {
		return this.browser.getClickableElement(By.cssSelector(LAYER_CART_LOCATOR + " [title=\"Continue shopping\"]"));
	}

}
