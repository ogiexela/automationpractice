package com.automationpractice.ag_testng.pages.product_list_page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.ag_testng.pages.base_page.BasePage;

import ag.framework.browser.Browser;

public class ProductListPage extends BasePage {

	private By SEARCH_RESULTS_COUNTER_SELECTOR = By.cssSelector(".heading-counter");
	private By PRODUCT_LIST_ITEM_SELECTOR = By.cssSelector(".product-container");
	
	public ProductListPage(Browser browser) {
		super(browser);
	}
	
	public int getNumberOfSearchResults() {
		WebElement searchBox = this.getBrowser().getElement(SEARCH_RESULTS_COUNTER_SELECTOR);
		
		String fullText = searchBox.getText();
		String countAsString = fullText.split(" ", 2)[0];
		
		int count = Integer.parseInt(countAsString);
		
		return count;
	}
	
	public int getNumberOfProductResults() {
		WebElement searchBox = this.getBrowser().getElement(SEARCH_RESULTS_COUNTER_SELECTOR);
		
		String fullText = searchBox.getText();
		String countAsString = fullText.split(" ", 4)[2];
		
		int count = Integer.parseInt(countAsString);
		
		return count;
	}
	
	public ProductListItem getProductByName(String name) {
		List<WebElement> products = this.getBrowser().getElements(PRODUCT_LIST_ITEM_SELECTOR);
		
		ProductListItem foundProduct = products
			.stream()
			.map(element -> new ProductListItem(this.getBrowser(), element))
			.filter(product -> name.equals(product.getProductName()))
			.findFirst()
			.orElseGet(() -> null);
		
		return foundProduct;
		
	}
	
	public ProductListPage openProductQuickView(String productName) {
		getProductByName(productName).hoverOver();
		getProductByName(productName).openQuickView();
		return this;
	}
}
