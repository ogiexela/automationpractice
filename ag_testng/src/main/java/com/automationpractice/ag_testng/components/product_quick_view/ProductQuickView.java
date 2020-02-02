package com.automationpractice.ag_testng.components.product_quick_view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ag.framework.browser.Browser;

public class ProductQuickView {
	
	public static By QUICK_VIEW_FRAME_SELECTOR = By.cssSelector(".fancybox-iframe");
	
	private Browser browser;
	
	public ProductQuickView(Browser browser) {
		this.browser = browser;
	}
	
	public String getProductName() {
		WebElement productName = this.browser.getElement(By.cssSelector("[itemprop=\"name\"]"));
		return productName.getText();
	}
	
	public ProductQuickView selectSize(String sizeText) {
		Select sizeSelect = new Select(this.browser.getElement(By.id("group_1")));
		sizeSelect.selectByVisibleText(sizeText);
		return this;
	}
	
	public ProductQuickView addToCart() {
		WebElement addToCart = this.browser.getClickableElement(By.id("add_to_cart"));
		addToCart.click();
		return this;
	}
	

}
