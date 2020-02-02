package com.automationpractice.ag_testng.components.shopping_cart_summary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartSummaryItem {
	private WebElement element;
	
	public ShoppingCartSummaryItem(WebElement element) {
		this.element = element;
	}
	
	public WebElement getDescriptionElement() {
		return this.element.findElement(By.cssSelector(".cart_description"));
	}

}
