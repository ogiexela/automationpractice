package com.automationpractice.ag_testng.components.shopping_cart_summary;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import ag.framework.browser.Browser;

public class ShoppingCartSummary {
	private Browser browser;

	public ShoppingCartSummary(Browser browser) {
		this.browser = browser;
	}

	public List<ShoppingCartSummaryItem> getItems() {
		return browser
				.getElements(By.cssSelector("#cart_summary .cart_item"))
				.stream()
				.map(element -> new ShoppingCartSummaryItem(element))
				.collect(Collectors.toList());
	}
}
