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

public class DashBoardPageTest extends Base {
	private static final boolean False = false;
	// Landing page after successful login
	LoginPage loginPage;
	HomePage homePage;
	DashBoardPage dashboardPage;

	public DashBoardPageTest() {
		super();
	}

	// test cases should be separated --independent with each other
	// @test --execute test case
	// after each test case --close the browser
	@BeforeMethod
	public void setup() {
		initialization(); // called method from parent class
		loginPage = new LoginPage();
		homePage = new HomePage();
		dashboardPage = new DashBoardPage();
	}

	@Test  // validation of Address in profile
	public void validateProfileAddress() {
		dashboardPage = loginPage.login("mandeepksidhu19@gmail.com", "12345321");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		dashboardPage.clickOnProfile();
		String nm = dashboardPage.validateName();
		Assert.assertEquals(nm, "MANDEEP");

		String lnm = dashboardPage.validateLastName();
		Assert.assertEquals(lnm, "SIDHU");

		Assert.assertEquals(dashboardPage.validateAddress(), "4200 Genesee Street");

		Assert.assertEquals(dashboardPage.validateCity(), "Buffalo");

		Assert.assertEquals(dashboardPage.validateZipcode(), "14225");

		Assert.assertEquals(dashboardPage.validateProvince(), "string:NY");

	}
	

	//@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
