package com.automationpractice.ag_testng.pages.account_creation_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.ag_testng.data_types.AccountRegistrationInfo;
import com.automationpractice.ag_testng.pages.base_page.BasePage;

import ag.framework.browser.Browser;

public class AccountCreationPage extends BasePage {

	public AccountCreationPage(Browser browser) {
		super(browser);
	}

	public AccountCreationPage setTitle(String title) {
		if (title == null) {
			return this;
		}

		switch (title.toLowerCase()) {
		case "mr.":
			WebElement gender1 = getClickableElement(By.cssSelector("#uniform-id_gender1"));
			gender1.click();
			break;
		case "mrs.":
			WebElement gender2 = getClickableElement(By.cssSelector("#uniform-id_gender2"));
			gender2.click();
			break;
		}
		return this;
	}

	public AccountCreationPage setCustomerFirstName(String value) {
		WebElement field = getClickableElement(By.cssSelector("#customer_firstname"));
		field.sendKeys(value);
		return this;
	}

	public AccountCreationPage setCustomerLastName(String value) {
		WebElement field = getClickableElement(By.cssSelector("#customer_lastname"));
		field.sendKeys(value);
		return this;
	}

	public AccountCreationPage setEmail(String value) {
		if (value == null) {
			return this;
		}

		WebElement field = getClickableElement(By.cssSelector("#email"));
		field.clear();
		field.sendKeys(value);
		return this;
	}

	public AccountCreationPage setPassword(String value) {
		WebElement field = getClickableElement(By.cssSelector("#passwd"));
		field.sendKeys(value);
		return this;
	}

	public AccountCreationPage setDOB_date(String value) {
		if (value == null) {
			return this;
		}

		Select field = new Select(getElement(By.id("days")));
		field.selectByValue(value);
		return this;
	}

	public AccountCreationPage setDOB_month(String value) {
		if (value == null) {
			return this;
		}

		Select field = new Select(getElement(By.id("months")));
		field.selectByValue(value);
		return this;
	}

	public AccountCreationPage setDOB_year(String value) {
		if (value == null) {
			return this;
		}

		Select field = new Select(getElement(By.id("years")));
		field.selectByValue(value);
		return this;
	}

	public AccountCreationPage setAddressFirstName(String value) {
		if (value == null) {
			return this;
		}

		WebElement field = getClickableElement(By.cssSelector("#firstname"));
		field.sendKeys(value);
		return this;
	}

	public AccountCreationPage setAddressLastName(String value) {
		if (value == null) {
			return this;
		}

		WebElement field = getClickableElement(By.cssSelector("#lastname"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressCompany(String value) {
		if (value == null) {
			return this;
		}

		WebElement field = getClickableElement(By.cssSelector("#company"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressLine1(String value) {
		WebElement field = getClickableElement(By.cssSelector("#address1"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressLine2(String value) {
		if (value == null) {
			return this;
		}
		
		WebElement field = getClickableElement(By.cssSelector("#address2"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressCity(String value) {
		WebElement field = getClickableElement(By.cssSelector("#city"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressState(String value) {
		Select state = new Select(getElement(By.id("id_state")));
		state.selectByVisibleText(value);
		return this;
	}
	
	public AccountCreationPage setAddressPostcode(String value) {
		WebElement field = getClickableElement(By.cssSelector("#postcode"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressCountry(String value) {
		Select state = new Select(getElement(By.id("id_country")));
		state.selectByVisibleText(value);
		return this;
	}
	
	public AccountCreationPage setAddressAdditionalInfo(String value) {
		if (value == null) {
			return this;
		}
		
		WebElement field = getClickableElement(By.cssSelector("#other"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressHomePhone(String value) {
		if (value == null) {
			return this;
		}
		
		WebElement field = getClickableElement(By.cssSelector("#phone"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressMobilePhone(String value) {
		WebElement field = getClickableElement(By.cssSelector("#phone_mobile"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage setAddressAlias(String value) {
		if (value == null) {
			return this;
		}
		
		WebElement field = getClickableElement(By.cssSelector("#alias"));
		field.sendKeys(value);
		return this;
	}
	
	public AccountCreationPage clickRegisterAccount() {
		WebElement submitAccount = getClickableElement(By.cssSelector("#submitAccount"));
		submitAccount.click();
		return this;
	}

	public AccountCreationPage registerAccount(AccountRegistrationInfo accountInfo) {

		setTitle(accountInfo.getPersonalInfo().getTitle());
		setCustomerFirstName(accountInfo.getPersonalInfo().getFirstname());
		setCustomerLastName(accountInfo.getPersonalInfo().getLastname());
		setEmail(accountInfo.getPersonalInfo().getEmail());
		setPassword(accountInfo.getPersonalInfo().getPassword());
		setDOB_date(accountInfo.getPersonalInfo().getDob_date());
		setDOB_month(accountInfo.getPersonalInfo().getDob_month());
		setDOB_year(accountInfo.getPersonalInfo().getDob_year());

		setAddressFirstName(accountInfo.getAddressInfo().getFirstname());
		setAddressLastName(accountInfo.getAddressInfo().getLastname());
		setAddressCompany(accountInfo.getAddressInfo().getCompany());
		setAddressLine1(accountInfo.getAddressInfo().getAddress_line1());
		setAddressLine2(accountInfo.getAddressInfo().getAddress_line2());
		setAddressCity(accountInfo.getAddressInfo().getAddress_city());
		setAddressState(accountInfo.getAddressInfo().getAddress_state());
		setAddressCountry(accountInfo.getAddressInfo().getAddress_country());
		setAddressPostcode(accountInfo.getAddressInfo().getAddress_postcode());
		setAddressAdditionalInfo(accountInfo.getAddressInfo().getAdditional_info());
		setAddressHomePhone(accountInfo.getAddressInfo().getHome_phone());
		setAddressMobilePhone(accountInfo.getAddressInfo().getMobile_phone());
		setAddressAlias(accountInfo.getAddressInfo().getAddress_alias());

		clickRegisterAccount();

		return this;
	}
}
