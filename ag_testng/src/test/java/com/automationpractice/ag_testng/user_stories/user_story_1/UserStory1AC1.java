package com.automationpractice.ag_testng.user_stories.user_story_1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.ag_testng.base_test.BaseTest;
import com.automationpractice.ag_testng.pages.index_page.IndexPage;
import com.automationpractice.ag_testng.pages.product_list_page.ProductListPage;

public class UserStory1AC1 extends BaseTest {

	@Test(description = "As a user I would like to be able to search the catalog")
	@Parameters({"productname", "expectedCount"})
	public void search_for_a_product(
			@Optional("Faded Short Sleeve T-shirts") String productName,
			@Optional("1") int expectedCount
	) {
		IndexPage indexPage = new IndexPage(browser());
		indexPage.searchFor(productName);

		ProductListPage searchResultsPage = new ProductListPage(browser());
		int count = searchResultsPage.getNumberOfSearchResults();

		assertEquals(count, expectedCount);
		
	}
	
}
