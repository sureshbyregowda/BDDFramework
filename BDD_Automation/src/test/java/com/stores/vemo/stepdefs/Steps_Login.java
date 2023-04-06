package com.stores.vemo.stepdefs;

import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

import com.stores.vemo.utilities.*;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.stores.vemo.hooks.*;
import com.stores.vemo.pages.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_Login {
	private static CustomDriver driver;
	private BaseEntityClass baseEntityClass;
	private static final Logger log = LogManager.getLogger(Steps_Login.class.getName());
	public Map<String, String> TestData;
	private DataContainer dataContainer;
	private Page_Login page_login;
	private hooks hooks;

	  
	public Steps_Login(DriverHelper driverHelper, DataContainer dataContainer)
	{
		baseEntityClass = new BaseEntityClass(driverHelper);
		hooks = new hooks(driverHelper, dataContainer);
		page_login = new Page_Login(driverHelper.driver);
		this.dataContainer = dataContainer;
	}	
	
	@Given("I am at Login page")
	public void i_am_at_login_page() {	
		page_login.navigateToLoginScreen();	
	}
	
	@When("I fill Email addrress with value {string}")
	public void i_fill_email_addrress_with_value(String email) {
		page_login.enterEmailAddress(email);
	}
	
	@When("I fill Password with value {string}")
	public void i_fill_password_with_value(String password) {
		page_login.enterPassword(password);
	}
	
	@When("I click on Login button")
	public void i_click_on_login_button() {
		page_login.clickLoginbutton();
	}
	
	@Then("I should be at the home page")
	public void i_should_be_at_the_home_page() {
		page_login.verifySuccessfullogin();
	}	  

}
