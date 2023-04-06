package com.stores.vemo.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stores.vemo.utilities.CustomDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Page_Login {

	private CustomDriver driver;
	private static final Logger log = LogManager.getLogger(Page_Login.class.getName());

	public Page_Login(WebDriver driver) {
		this.driver = new CustomDriver(driver);
	}
	//Navigate to Login screen
	public void navigateToLoginScreen()
	{
		//Launch URL
		driver.getDriver().get("https://fego.vmos-demo.com/");
		//Clicks on Login link or button
		driver.findElement(By.xpath("//a[@data-test='header-profile-link']")).click();
		log.info("user navigated to login screen");
	}

	//Enter EmailAddress field
	public void enterEmailAddress(String emailAddress)
	{
		driver.findElement(By.id("email")).sendKeys(emailAddress);
		log.info("user entered email address successfully");
	}

	//Enter Password field
	public void enterPassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
		log.info("user entered password successfully");
	}

	//Clicks on Login button
	public void clickLoginbutton()
	{
		driver.findElement(By.xpath("//button[@data-test='auth-button']")).click();
		log.info("user clicks on login button");
	}      
	
	public void verifySuccessfullogin()
	{
		if(driver.findElement(By.xpath("//button[@data-test='rewards-btn']")).isDisplayed())
		{
			log.info("user is successfully able to login");					
		}
		else
		{
			log.error("User unable to login");
		}

	}   	

}




