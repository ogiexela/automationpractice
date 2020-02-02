package com.automationpractice.ag_testng.pages.base_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.ag_testng.components.shopping_cart.ShoppingCart;

import ag.framework.browser.Browser;

public class BasePage {

	private Browser browser;
	private By SEARCH_BOX_SELECTOR = By.id("searchbox");
	
	public BasePage(Browser browser) {
		this.browser = browser;
	}
	
	public Browser getBrowser() {
		return this.browser;
	}
	
	public WebElement getElement(By selector) {
		return this.browser.getElement(selector);
	}
	
	public WebElement getClickableElement(By selector) {
		return this.browser.getClickableElement(selector);
	}
	
	public BasePage searchFor(String query) {
		WebElement searchBox = this.browser.getElement(SEARCH_BOX_SELECTOR);
		WebElement inputField = searchBox.findElement(By.id("search_query_top"));
		
		inputField.sendKeys(query);
		
		WebElement submitButton = searchBox.findElement(By.name("submit_search"));
		submitButton.click();
		
		return this;
	}
	
	public BasePage selectMenu(String item) {
		WebElement menu = this.browser.getClickableElement(By.cssSelector(".sf-menu" + " [title=\"" + item + "\"]"));
		
		menu.click();
		
		
		return this;
	}
	
	public BasePage openMenu(String item) {
		WebElement menu = this.browser.getClickableElement(By.cssSelector(".sf-menu" + " [title=\"" + item + "\"]"));
		
		this.browser
		.getActionBuilder()
		.moveToElement(menu)
		.build()
		.perform();
		
		
		return this;
	}
	
	public BasePage selectMenu(String item, String subItem) {
		
		this.openMenu(item);
		
		String subItemPath = ".sf-menu .submenu-container [title=\"" + subItem + "\"]";
	
		WebElement subMenu = this.browser.getClickableElement(By.cssSelector(subItemPath));
		subMenu.click();
		
		return this;
	}
	
	public ShoppingCart getShoppingCart() {
		return new ShoppingCart(this.browser);
	}
	
}
