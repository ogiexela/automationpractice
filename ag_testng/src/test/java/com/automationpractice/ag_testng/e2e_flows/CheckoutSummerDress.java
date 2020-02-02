package com.automationpractice.ag_testng.e2e_flows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpractice.ag_testng.components.cart_update_popup.CartUpdatePopup;
import com.automationpractice.ag_testng.components.product_quick_view.ProductQuickView;
import com.automationpractice.ag_testng.components.shopping_cart.ShoppingCart;
import com.automationpractice.ag_testng.components.shopping_cart_summary.ShoppingCartSummary;
import com.automationpractice.ag_testng.components.shopping_cart_summary.ShoppingCartSummaryItem;
import com.automationpractice.ag_testng.pages.account_creation_page.AccountCreationPage;
import com.automationpractice.ag_testng.pages.account_creation_page.AccountRegistrationAddressInfo;
import com.automationpractice.ag_testng.pages.account_creation_page.AccountRegistrationInfo;
import com.automationpractice.ag_testng.pages.account_creation_page.AccountRegistrationPersonalInfo;
import com.automationpractice.ag_testng.pages.address_page.AddressPage;
import com.automationpractice.ag_testng.pages.index_page.IndexPage;
import com.automationpractice.ag_testng.pages.product_list_page.ProductListPage;
import com.automationpractice.ag_testng.pages.shipping_page.ShippingPage;
import com.automationpractice.ag_testng.pages.shopping_cart_summary_page.ShoppingCartSummaryPage;
import com.automationpractice.ag_testng.pages.signin_page.SigninPage;

import ag.framework.assertions.Assertions;
import ag.framework.browser.Browser;

public class CheckoutSummerDress {

	private Browser browser;
	private Assertions assertions;

	@BeforeClass
	public void setUp() {
		browser = new Browser("firefox", 30, 3);
		assertions = new Assertions(browser.getWait());
		
		browser
		.maximizeWindow()
		.goTo("http://automationpractice.com");
	}

	@AfterClass
	public void tearDown() {
		browser.quit();
	}

	@Test(description = "As a new user I would like to checkout a summer dress.")
	public void e2e_flow_checkout_summer_dress() {
		String DRESS_NAME = "Printed Chiffon Dress";
		String DRESS_SIZE = "M";
		String DRESS_COLOR = "Yellow";
		String FIRST_NAME = "foo";
		String LAST_NAME = "bar";
		String EMAIL = FIRST_NAME + System.currentTimeMillis() + "@bar.com"; 
				
		AccountRegistrationPersonalInfo personalInfo = new AccountRegistrationPersonalInfo();
		personalInfo
			.setFirstname(FIRST_NAME)
			.setLastname(LAST_NAME)
			.setDob_date("1")
			.setDob_month("1")
			.setDob_year("1999")
			.setPassword("12345");
		
		AccountRegistrationAddressInfo addressInfo = new AccountRegistrationAddressInfo();
		addressInfo
			.setAddress_line1("123 fake street")
			.setAddress_city("Bigcity")
			.setAddress_state("Ohio")
			.setAddress_postcode("43001")
			.setAddress_country("United States")
			.setMobile_phone("1234567890");
		
		AccountRegistrationInfo accountInfo = new AccountRegistrationInfo();
		accountInfo
			.setAddressInfo(addressInfo)
			.setPersonalInfo(personalInfo);
		
		IndexPage indexPage = new IndexPage(browser);
		
		indexPage.selectMenu("Women", "Summer Dresses");

		ProductListPage productListPage = new ProductListPage(browser);
		
		assertions.shouldBeTrue(driver -> productListPage.getNumberOfProductResults() > 0);
		
		productListPage.openProductQuickView(DRESS_NAME);
		
		browser.switchToFrame(ProductQuickView.QUICK_VIEW_FRAME_SELECTOR);
		
		ProductQuickView productQuickView = new ProductQuickView(browser);
		
		assertions.shouldBeTrue(driver -> DRESS_NAME.equals(productQuickView.getProductName()));
		
		productQuickView
			.selectSize(DRESS_SIZE)
			.addToCart();
		
		browser.switchToDefaultContent();
		
		CartUpdatePopup cartUpdatePopup = new CartUpdatePopup(browser);
		cartUpdatePopup.continueShopping();
		
		WebElement continueShoppingPopup = cartUpdatePopup.getCartUpdatePopup();
		
		assertions.shouldNotShow(continueShoppingPopup, "Cart update popup should disappear");
		
		ShoppingCart shoppingCart = productListPage.getShoppingCart();
		
		assertions.shouldHaveText(shoppingCart.getShoppingCartQuantity(), "1", "Shopping cart should have 1 item");
		
		shoppingCart.previewAndcheckout();
		
		
		
		ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(browser);
		shoppingCartSummaryPage.proceedToCheckout();
		
		
		SigninPage signinPage = new SigninPage(browser);
		signinPage.createAccount(EMAIL);
		
		AccountCreationPage accountCreationPage = new AccountCreationPage(browser);
		accountCreationPage.registerAccount(accountInfo);
		
		AddressPage addressPage = new AddressPage(browser);
		addressPage.proceedToCheckout();
		
		ShippingPage shippingPage = new ShippingPage(browser);
		shippingPage
			.agreeToTOS()
			.proceedToCheckout();
		
		ShoppingCartSummary shoppingCartSummary = shippingPage.getShoppingCartSummary();
		
		List<ShoppingCartSummaryItem> cartItems = shoppingCartSummary.getItems();
		ShoppingCartSummaryItem firstItem = cartItems.get(0);
		WebElement itemDescription = firstItem.getDescriptionElement();
		
		assertions.shouldHaveText(itemDescription, DRESS_NAME, "Product name should be '" + DRESS_NAME + "'");
		assertions.shouldHaveText(itemDescription, "SKU : demo_7", "Product SKU should be 'SKU : demo_7'");
		assertions.shouldHaveText(itemDescription, "Color : " + DRESS_COLOR, "Product color should be 'Color : " + DRESS_COLOR + "'");
		assertions.shouldHaveText(itemDescription, "Size : " +  DRESS_SIZE, "Product size should be 'Size : " + DRESS_SIZE + "'");
	}
}

