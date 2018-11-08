package com.lowesfoods.shop.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lowesfoods.shop.qa.base.Base;

public class RegistrationPage extends Base {
//Registration page/popup
	@FindBy(xpath = "//*[@id='nav-register']")
	WebElement loginRegisterbtn;

	@FindBy(xpath = "//*[@id=\"registration-register\"]")
	WebElement registrationbtn;

	@FindBy(xpath = "//*[@id=\"registration-email\"]")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"registration-password\"]")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"registration-password-confirm\"]")
	WebElement confirmpassword;

	@FindBy(xpath = "//*[@id=\"registration-telephone-mobile_phone_number\"]")
	WebElement mobileNumber;

	@FindBy(xpath = "//*[@id=\"registration-first-name\"]")

	WebElement firstname;

	@FindBy(xpath = "//*[@id=\"registration-last-name\"]")
	WebElement lastname;

	@FindBy(xpath = "//*[@id=\"registration-address1\"]")
	WebElement address;

	@FindBy(xpath = "//*[@id=\"registration-city\"]")
	WebElement city;

	@FindBy(xpath = "//*[@id=\"registration-postal-code\"]")
	WebElement zipcode;

	@FindBy(xpath = "//*[@id=\"registration-state\"]")
	WebElement state;

	public RegistrationPage() {
		PageFactory.initElements(driver, this); // current class object pointing to it

	}

	public void verifyRegistration(String eml, String pass, String cpassword, String mnumber, String fname,
			String lname, String add, String cty, String zip, String prvnce) {
		//used below forloop to avoid statleElementException
		for (int i = 0; i <= 2; i++)
			{

			try {

				loginRegisterbtn.click();

				break;

			}

			catch (Exception e) {

				e.getMessage();

			}
			registrationbtn.click();

			email.sendKeys(eml);
			password.sendKeys(pass);
			confirmpassword.sendKeys(cpassword);
			mobileNumber.sendKeys(mnumber);
			firstname.sendKeys(fname);
			lastname.sendKeys(lname);
			address.sendKeys(add);
			city.sendKeys(cty);
			zipcode.sendKeys(zip);
			state.sendKeys(prvnce);

		}

	}
}
