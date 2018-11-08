package com.lowesfoods.shop.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lowesfoods.shop.qa.base.Base;
import com.lowesfoods.shop.qa.pages.LoginPage;
import com.lowesfoods.shop.qa.pages.RegistrationPage;

public class RegistrationTest extends Base {
	//Registration page/ popup
	RegistrationPage registrationpage;
	public RegistrationTest() {
		super(); // with this i am calling TestBaseClass s constructor
	}

	@BeforeMethod
	public void setup() {
		initialization(); // called method from parent class
		RegistrationPage registrationpage = new RegistrationPage();

	}
	
	
	@Test
	public void verifyRegistration() {
		registrationpage.verifyRegistration("mandeepksidhu19@@gmail.com","12345321", "12345321","1234512345","MANDEEP", "SIDHU", "4200 Genesee Street", "Buffalo", "14225", "New York");
	}
}
