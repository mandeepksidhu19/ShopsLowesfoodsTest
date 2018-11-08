package com.lowesfoods.shop.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

	//  initialization method:
	public static void initialization() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MANDEEP KAUR\\eclipse-workspace\\ShopLowesfoodsTest\\src\\main\\resources\\chromedriver.exe");  //give path to the chromedriver file
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://shop.lowesfoods.com/");
		driver.findElement(By.xpath("//button[@class='close']")).click(); //close the pop-up 

	}

}
