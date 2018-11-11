package com.lowesfoods.shop.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lowesfoods.shop.qa.base.Base;
import com.lowesfoods.shop.qa.pages.DashBoardPage;
import com.lowesfoods.shop.qa.pages.HomePage;
import com.lowesfoods.shop.qa.pages.LoginPage;

public class LoginPageTest extends Base {
	//Login Page to give credentials to login 
	LoginPage loginPage;
	DashBoardPage dashooardPage;

	public LoginPageTest() {
		super(); // with this i am calling BaseClass constructor
	}

	@BeforeMethod
	public void setup() {
		initialization(); // called method from parent class
		loginPage = new LoginPage();

	}

	@Test()
	public void loginTest() {
		dashooardPage= loginPage.login("mandeepksidhu19@gmail.com", "12345321");
		driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);


	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
