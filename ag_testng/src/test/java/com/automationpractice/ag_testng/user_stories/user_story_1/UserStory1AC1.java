package com.automationpractice.ag_testng.user_stories.user_story_1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpractice.ag_testng.pages.index_page.IndexPage;
import com.automationpractice.ag_testng.pages.product_list_page.ProductListPage;

import ag.framework.browser.Browser;

public class UserStory1AC1 {

	private Browser browser;

	@BeforeClass
	public void setUp() {
		browser = new Browser("firefox", 30, 5);
		
		browser
		.maximizeWindow()
		.goTo("http://automationpractice.com");
	}

	@AfterClass
	public void tearDown() {
		browser.quit();
	}

	@Test(description = "As a user I would like to be able to search the catalog")
	public void search_for_a_product() {
		IndexPage indexPage = new IndexPage(browser);
		indexPage.searchFor("Faded Short Sleeve T-shirts");

		ProductListPage searchResultsPage = new ProductListPage(browser);
		int count = searchResultsPage.getNumberOfSearchResults();

		assertEquals(count, 2);
		
	}
	
}
