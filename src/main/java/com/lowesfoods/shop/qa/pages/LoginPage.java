package com.lowesfoods.shop.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lowesfoods.shop.qa.base.Base;

public class LoginPage extends Base {
//Login page to give credentials for login
	
	// define first object repository or page factory of loginpage
	// ObjectRepository or PageFactory

	@FindBy(xpath = "//*[@id='nav-register']")
	WebElement loginRegisterbtn;
	
	@FindBy(name = "username")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@id ='login-submit']")
	WebElement loginbtn;

	// Initializing the Page Objects:
	public LoginPage() { // initializing page elements using PageFactory class inside the constructor of
							// LoginPage
		PageFactory.initElements(driver, this); // current class object pointing to it

	}

	// Actions:
	
	public DashBoardPage login(String em, String pwd) {
//for loop used to handle StaleElementException
		for (int i = 0; i <= 2; i++)

		{

			try {

				loginRegisterbtn.click();

				break;

			}

			catch (Exception e) {

				e.getMessage();

			}

		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		email.sendKeys(em);
		password.sendKeys(pwd);
		loginbtn.click();

		return new DashBoardPage(); //returning object of landing homepage

	}

}
