package com.automationpractice.ag_testng.pages.account_creation_page;

public class AccountRegistrationInfo {
	private AccountRegistrationPersonalInfo personalInfo;
	private AccountRegistrationAddressInfo addressInfo;

	public AccountRegistrationPersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public AccountRegistrationInfo setPersonalInfo(AccountRegistrationPersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
		return this;
	}

	public AccountRegistrationAddressInfo getAddressInfo() {
		return addressInfo;
	}

	public AccountRegistrationInfo setAddressInfo(AccountRegistrationAddressInfo addressInfo) {
		this.addressInfo = addressInfo;
		return this;
	}
}
