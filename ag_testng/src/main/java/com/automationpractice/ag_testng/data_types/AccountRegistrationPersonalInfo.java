package com.automationpractice.ag_testng.data_types;

public class AccountRegistrationPersonalInfo {

	private String title;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String dob_date;
	private String dob_month;
	private String dob_year;

	public String getTitle() {
		return title;
	}

	public AccountRegistrationPersonalInfo setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public AccountRegistrationPersonalInfo setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public AccountRegistrationPersonalInfo setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public AccountRegistrationPersonalInfo setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public AccountRegistrationPersonalInfo setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getDob_date() {
		return dob_date;
	}

	public AccountRegistrationPersonalInfo setDob_date(String dob_date) {
		this.dob_date = dob_date;
		return this;
	}

	public String getDob_month() {
		return dob_month;
	}

	public AccountRegistrationPersonalInfo setDob_month(String dob_month) {
		this.dob_month = dob_month;
		return this;
	}

	public String getDob_year() {
		return dob_year;
	}

	public AccountRegistrationPersonalInfo setDob_year(String dob_year) {
		this.dob_year = dob_year;
		return this;
	}
}
