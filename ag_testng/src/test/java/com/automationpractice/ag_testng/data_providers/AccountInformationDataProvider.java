package com.automationpractice.ag_testng.data_providers;

import org.testng.annotations.DataProvider;

import com.automationpractice.ag_testng.data_types.AccountRegistrationAddressInfo;
import com.automationpractice.ag_testng.data_types.AccountRegistrationInfo;
import com.automationpractice.ag_testng.data_types.AccountRegistrationPersonalInfo;
import com.automationpractice.ag_testng.data_types.ProductInfo;

public class AccountInformationDataProvider {

	@DataProvider(name = "customerInfo1")
	public Object[][] customerInfo() {
				
		AccountRegistrationPersonalInfo personalInfo = new AccountRegistrationPersonalInfo();
		personalInfo
			.setFirstname("foo")
			.setLastname("bar")
			.setEmail("foo" + System.currentTimeMillis() + "@bar.com")
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
		
		ProductInfo productInfo = new ProductInfo();
		productInfo
			.setColor("Yellow")
			.setName("Printed Chiffon Dress")
			.setSize("M");
		
		return new Object[][]{
			{accountInfo, productInfo},
		};
	}
}
