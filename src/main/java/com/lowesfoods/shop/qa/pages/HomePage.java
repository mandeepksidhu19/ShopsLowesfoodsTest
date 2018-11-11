package com.lowesfoods.shop.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lowesfoods.shop.qa.base.Base;

public class HomePage extends Base {
	// Home page of application
	@FindBy(xpath = "//button[@class='close']")
	WebElement closebtn;

	@FindBy(xpath = "//*[@id='nav-register']")
	WebElement loginRegisterbtn;

	@FindBy(xpath = "//*[@id='nav-main-shop-category-2723']")
	WebElement produceAndfloral;

	@FindBy(xpath = "//*[@id='nav-main-shop-category-2771']")
	WebElement deliAndbakery;

	@FindBy(xpath = "//*[@id=\"nav-main-shop-category-2874\"]")
	WebElement meatAndseafood;

	@FindBy(xpath = "//*[@id=\"nav-main-shop-category-3697\"]")
	WebElement bearAndwine;

	@FindBy(xpath = "//*[@id=\"nav-main-shop-category-2970\"]")
	WebElement dairyAndeggs;

	@FindBy(xpath = "//*[@id=\"nav-main-shop-category-3113\"]")
	WebElement kitchenAndpantery;

	public HomePage() { // now we have to initialize the elements with help of pagefactory, i will
						// create
		// constructor
		PageFactory.initElements(driver, this); // current class objector pointing to it

	}

	// to add items to the cart
	public void addItemsToCart() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver; // using JavascriptExecutor class to scroll down to the
																// page
		WebElement TopDeals = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div/h1/span")); // TopDeals
		// To avoid staleElementException
		for (int i = 0; i <= 2; i++) {
			try {
				js.executeScript("arguments[0].scrollIntoView();", TopDeals); // scrolling till TopDeals element visible
				break;
			} catch (Exception e) {

				e.getMessage();
			}
		}
		// Adding 1st element to the cart
		WebElement crownbrocli = driver.findElement(
				By.xpath("//*[@id=\"add-to-cart-button-cart-service-add-item-26487-homepage-collection\"]"));
		crownbrocli.click();

		Actions actions = new Actions(driver); // now use action class to move cursor to another element so that we can
												// add another element
		 // Adding 2nd Element to the cart
		WebElement apples = driver.findElement(
				By.xpath("//*[@id=\"add-to-cart-button-cart-service-add-item-25982-homepage-collection\"]"));
		actions.moveToElement(apples);
		apples.click();

		// Adding 3rd element to the cart
		WebElement tomatoes = driver.findElement(
				By.xpath("//*[@id=\"add-to-cart-button-cart-service-add-item-254884-homepage-collection\"]"));
		actions.moveToElement(tomatoes).click(); // Adding 3rd element to the cart


		// Adding 4rd element to the cart
		WebElement salmonFillet= driver.findElement(
				By.xpath("//*[@id=\"add-to-cart-button-cart-service-select-item-weight-22454-homepage-collection\"]"));
		actions.moveToElement(salmonFillet).click(); 
        Select salmonWeight = new Select(salmonFillet); //to choose particular weight use Select Class
		salmonWeight.selectByVisibleText("0.75 lbs"); 

		/*WebElement ChickenBreast = driver.findElement(
				By.xpath("//*[@id=\"add-to-cart-button-cart-service-add-item-265709-homepage-collection\"]"));
//("//*[@id=\"add-to-cart-button-cart-service-add-item-265709-homepage-collection\"]
		actions.moveToElement(ChickenBreast).click(); // Adding 4th element to the cart
*/
	}

	// To verify all links are working fine
	public static void veryifyCategoryLinksActive(String linkUrl) throws Exception {

		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage());
			}

			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {

				System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// To verify Produce and Floral category link clicks and load page properly
	public ProduceAndFloralPage clickOnProduceandFloralLink() {
		// Use for loop to make sure link got clicked
		for (int i = 0; i <= 2; i++) {
			try {
				produceAndfloral.click();
				break;
			} catch (Exception e) {

				e.getMessage();
			}
		}
		return new ProduceAndFloralPage();
	}

	// To verify Deli and Bakery category link clicks and load page properly.
	// like these we can write methods for all categories links and test. here I
	// have written methods only for 2 categories
	public DeliAndBakeryPage clickOnDeliAndBakeryLink() {
		for (int i = 0; i <= 2; i++) {
			try {
				deliAndbakery.click();
				
				break;
			} catch (Exception e) {

				e.getMessage();
			}
		}
		return new DeliAndBakeryPage();
	}

}
