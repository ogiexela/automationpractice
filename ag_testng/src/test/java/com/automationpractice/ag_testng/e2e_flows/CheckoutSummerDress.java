package com.automationpractice.ag_testng.e2e_flows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationpractice.ag_testng.components.cart_update_popup.CartUpdatePopup;
import com.automationpractice.ag_testng.components.product_quick_view.ProductQuickView;
import com.automationpractice.ag_testng.components.shopping_cart.ShoppingCart;
import com.automationpractice.ag_testng.components.shopping_cart_summary.ShoppingCartSummary;
import com.automationpractice.ag_testng.components.shopping_cart_summary.ShoppingCartSummaryItem;
import com.automationpractice.ag_testng.data_providers.AccountInformationDataProvider;
import com.automationpractice.ag_testng.data_types.AccountRegistrationInfo;
import com.automationpractice.ag_testng.data_types.ProductInfo;
import com.automationpractice.ag_testng.pages.account_creation_page.AccountCreationPage;
import com.automationpractice.ag_testng.pages.address_page.AddressPage;
import com.automationpractice.ag_testng.pages.index_page.IndexPage;
import com.automationpractice.ag_testng.pages.product_list_page.ProductListPage;
import com.automationpractice.ag_testng.pages.shipping_page.ShippingPage;
import com.automationpractice.ag_testng.pages.shopping_cart_summary_page.ShoppingCartSummaryPage;
import com.automationpractice.ag_testng.pages.signin_page.SigninPage;

import ag.base_test.BaseTest;

public class CheckoutSummerDress extends BaseTest {

	@Test(
			dataProvider = "customerInfo1",
			dataProviderClass = AccountInformationDataProvider.class,
			description = "As a new user I would like to checkout a summer dress."
	)
	public void e2e_flow_checkout_summer_dress(AccountRegistrationInfo accountInfo, ProductInfo productInfo) {
		
		String DRESS_NAME = productInfo.getName();
		String DRESS_SIZE = productInfo.getSize();
		String DRESS_COLOR = productInfo.getColor();
		String EMAIL = accountInfo.getPersonalInfo().getEmail();
		
		IndexPage indexPage = new IndexPage(browser());
		
		indexPage.selectMenu("Women", "Summer Dresses");

		ProductListPage productListPage = new ProductListPage(browser());
		
		assertions().shouldBeTrue(driver -> productListPage.getNumberOfProductResults() > 0);
		
		productListPage.openProductQuickView(DRESS_NAME);
		
		ProductQuickView productQuickView = productListPage.switchToProductQuickView();
		
		assertions().shouldBeTrue(driver -> DRESS_NAME.equals(productQuickView.getProductName()));
		
		productQuickView
			.selectSize(DRESS_SIZE)
			.addToCart();
		
		productListPage.switchToDefaultContent();
		
		CartUpdatePopup cartUpdatePopup = new CartUpdatePopup(browser());
		cartUpdatePopup.continueShopping();
		
		WebElement continueShoppingPopup = cartUpdatePopup.getCartUpdatePopup();
		
		assertions().shouldNotShow(continueShoppingPopup, "Cart update popup should disappear");
		
		ShoppingCart shoppingCart = productListPage.getShoppingCart();
		
		assertions().shouldHaveText(shoppingCart.getShoppingCartQuantity(), "1", "Shopping cart should have 1 item");
		
		shoppingCart.previewAndcheckout();
		
		ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(browser());
		shoppingCartSummaryPage.proceedToCheckout();
		
		SigninPage signinPage = new SigninPage(browser());
		signinPage.createAccount(EMAIL);
		
		AccountCreationPage accountCreationPage = new AccountCreationPage(browser());
		accountCreationPage.registerAccount(accountInfo);
		
		AddressPage addressPage = new AddressPage(browser());
		addressPage.proceedToCheckout();
		
		ShippingPage shippingPage = new ShippingPage(browser());
		shippingPage
			.agreeToTOS()
			.proceedToCheckout();
		
		ShoppingCartSummary shoppingCartSummary = shippingPage.getShoppingCartSummary();
		
		List<ShoppingCartSummaryItem> cartItems = shoppingCartSummary.getItems();
		ShoppingCartSummaryItem firstItem = cartItems.get(0);
		WebElement itemDescription = firstItem.getDescriptionElement();
		
		assertions().shouldHaveText(itemDescription, DRESS_NAME, "Product name should be '" + DRESS_NAME + "'");
		assertions().shouldHaveText(itemDescription, "SKU : demo_7", "Product SKU should be 'SKU : demo_7'");
		assertions().shouldHaveText(itemDescription, "Color : " + DRESS_COLOR, "Product color should be 'Color : " + DRESS_COLOR + "'");
		assertions().shouldHaveText(itemDescription, "Size : " +  DRESS_SIZE, "Product size should be 'Size : " + DRESS_SIZE + "'");
	}
}

