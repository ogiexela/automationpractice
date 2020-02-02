package com.automationpractice.ag_testng.components.shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ag.framework.browser.Browser;

public class ShoppingCart {

	public Browser browser;

	public ShoppingCart(Browser browser) {
		this.browser = browser;
	}

	public WebElement getShoppingCartQuantity() {
		return this.browser.getElement(By.cssSelector(".shopping_cart .ajax_cart_quantity"));
	}

	public String getShoppingCartQuantityValue() {
		return this.getShoppingCartQuantity().getText();
	}

	public ShoppingCart expand() {
		WebElement shoppingCart = this.browser
				.getClickableElement(By.cssSelector(".shopping_cart [title=\"View my shopping cart\"]"));

		this.browser.getActionBuilder().moveToElement(shoppingCart).build().perform();

		return this;
	}

	public ShoppingCart previewAndcheckout() {
		this.expand();
		
		WebElement checkout = this.browser.getClickableElement(By.cssSelector(".shopping_cart #button_order_cart"));

		checkout.click();
		return this;
	}
	
	public ShoppingCart checkout() {
		WebElement shoppingCart = this.browser
				.getClickableElement(By.cssSelector(".shopping_cart [title=\"View my shopping cart\"]"));

		shoppingCart.click();
		return this;
	}
}
