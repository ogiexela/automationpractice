package com.automationpractice.ag_testng.pages.address_page;

import com.automationpractice.ag_testng.pages.checkout_flow_page.CheckoutFlowPage;

import ag.framework.browser.Browser;

public class AddressPage extends CheckoutFlowPage {

	public AddressPage(Browser browser) {
		super(browser);
	}

	public AddressPage proceedToCheckout() {
		super.proceedToCheckout("processAddress");
		
		return this;
	}
}
