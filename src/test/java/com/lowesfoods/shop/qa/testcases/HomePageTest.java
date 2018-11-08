package com.lowesfoods.shop.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lowesfoods.shop.qa.base.Base;
import com.lowesfoods.shop.qa.pages.HomePage;
import com.lowesfoods.shop.qa.pages.LoginPage;

public class HomePageTest extends Base {
	private static final boolean True = false;
	// First or Home page of application
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated --independent to each other
	// before each test cases --launch the browser and login
	// @test --execute test case
	// after each test case --close the browser
	@BeforeMethod
	public void setup() {
		initialization(); // called method from parent class
		homePage = new HomePage();

	}

	@Test(priority=1)
	// adding four items into the cart
	public void verifyItemsinCart() throws InterruptedException {
		homePage.addItemsToCart();
	}

	@Test(priority=4)
	// verifying all links working fine and loading pages correctly.
	public void veryifyCategoryLinks() throws Exception {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are" + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			homePage.veryifyCategoryLinksActive(url);
		}

	}

	@Test(priority=2)
	// verify Produce and Floral link works and loads page properly
	public void verifyProduceAndFloralLink() {
		homePage.clickOnProduceandFloralLink();
		System.out.println(driver.getTitle());

	}

	
	@Test(priority=3)
	// verify Deli and Bakery link works and load page correctly
    public void verifyDeliAndBakeryLink() {
		homePage.clickOnDeliAndBakeryLink();
		System.out.println(driver.getTitle());

	}
	
	//like above 2 tests we can write validate all the categories links are clicking and loading pages correctly
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
