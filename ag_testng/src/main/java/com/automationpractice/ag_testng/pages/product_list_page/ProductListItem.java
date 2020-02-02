package com.automationpractice.ag_testng.pages.product_list_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ag.framework.browser.Browser;

public class ProductListItem {

	private WebElement productItem;
	private Browser browser;
	private By QUICK_VIEW_SELECTOR = By.cssSelector(".quick-view span");
	private By PRODUCT_NAME_SELECTOR = By.cssSelector(".product-name");
	
	public ProductListItem(Browser browser, WebElement item) {
		this.browser = browser;
		this.productItem = item;
	}
	
	public String getProductName() {
		WebElement name = productItem.findElement(PRODUCT_NAME_SELECTOR);
		
		return name.getText();
	}
	
	public ProductListItem hoverOver() {
		this.browser
		.getActionBuilder()
		.moveToElement(this.productItem)
		.build()
		.perform();
		
		return this;
	}
	
	public ProductListItem openQuickView() {
		this.hoverOver();
		
		WebElement quickView = productItem.findElement(QUICK_VIEW_SELECTOR);
		
		this.browser.getWait().until(ExpectedConditions.visibilityOf(quickView));
		
		quickView.click();
		
		return this;
	}
}
