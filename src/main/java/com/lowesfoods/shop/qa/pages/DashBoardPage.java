package com.lowesfoods.shop.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lowesfoods.shop.qa.base.Base;

public class DashBoardPage extends Base {
	//DashBoard page: landing page after successful login 
	@FindBy(xpath= "//*[@id='nav-user']")
    WebElement userbtn;
	
	@FindBy(id = "nav-user-main-account-profile")
	WebElement profile;

	@FindBy(id = "profileDeliveryAddressFirstName")
	WebElement name;

	@FindBy(id = "profileDeliveryAddressLastName")
	WebElement lastname;

	@FindBy(id = "profileDeliveryAddressAddress1")
	WebElement streetaddress1;

	@FindBy(id = "profileDeliveryAddressAddress2")
	WebElement streetaddress2;

	@FindBy(id = "profileDeliveryAddressCity")
	WebElement city;

	@FindBy(id = "profileDeliveryAddressProvince")
	WebElement province;

	@FindBy(xpath = "//*[@id=\"profileDeliveryPostalCode\"]")
	WebElement zipcode;
	public DashBoardPage() { // now we have to initialize the elements with help of pagefactory, i will create
		// constructor
		PageFactory.initElements(driver, this); // current class objector pointing to it

	}

	
	
	
	public void clickOnProfile() {
		//here forLoop to avoid staleElementException
		for(int i=0;i<=2;i++)
			 
		{
		 
		  try{
			  
			  userbtn.click();
		 
		    break;
		 
		}
		 
		catch(Exception e)
		{
		 
		e.getMessage();
		 
		}
		 
		}
		profile.click(); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  //to scroll down the page till DeliveryAddress text visible
		WebElement DeliveryAddress = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/form/div[3]/h2/span"));
		js.executeScript("arguments[0].scrollIntoView();", DeliveryAddress);
		
	}
	
public String validateName() {
		
		return name.getAttribute("value");
	}
	
	public String validateLastName() {
		
		return lastname.getAttribute("value");
		
	}
	public  String validateAddress() {
		return streetaddress1.getAttribute("value");
		
	}
	
	public String validateCity() {
		return city.getAttribute("value");
	}
	
	public String validateProvince() {
		return province.getAttribute("value");
	}
	
	public CharSequence validateZipcode() {
		return zipcode.getAttribute("value");
		
	}
	
}
