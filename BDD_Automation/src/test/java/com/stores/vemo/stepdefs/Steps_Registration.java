package com.stores.vemo.stepdefs;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.stores.vemo.hooks.hooks;
import com.stores.vemo.pages.Page_Account_Registration;
import com.stores.vemo.pages.Page_Login;
import com.stores.vemo.utilities.BaseEntityClass;
import com.stores.vemo.utilities.CustomDriver;
import com.stores.vemo.utilities.DataContainer;
import com.stores.vemo.utilities.DriverHelper;
import com.stores.vemo.utilities.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps_Registration {
	private CustomDriver driver;
	private BaseEntityClass baseEntityClass;
	private static final Logger log = LogManager.getLogger(Steps_Registration.class.getName());
	public Map<String, String> TestData;
	private DataContainer dataContainer;
	private Page_Account_Registration page_account_registration;
	private hooks hooks;	

	public Steps_Registration(DriverHelper driverHelper, DataContainer dataContainer)
	{
		baseEntityClass = new BaseEntityClass(driverHelper);
		hooks = new hooks(driverHelper, dataContainer);
		page_account_registration = new Page_Account_Registration(driverHelper.driver);
		this.dataContainer = dataContainer;
	}

	@Given("User is on the Registration page")
	public void user_is_on_the_registration_page() {		
		page_account_registration.navigateToRegistrationPage();
	}

	@When("User enters all required registration details")
	public void user_enters_all_required_registration_fields(DataTable usercredentials) {

		List<List<String>> regdetails = usercredentials.asLists(String.class);

		//Read all registration details from the Data Table
		String name = regdetails.get(1).get(0);   		//Name	
		String email = regdetails.get(1).get(1);  		//Email Address	
		String code = regdetails.get(1).get(2);   		//Country code
		String phoneNumber = regdetails.get(1).get(3);  //Phone Number	
		String day = regdetails.get(1).get(4);  		//Day
		String month = regdetails.get(1).get(5);   		//Month	
		String year = regdetails.get(1).get(6);  		//Year	
		String password = regdetails.get(1).get(7);     //password

		page_account_registration.enterAllregistrationfields(name,email,code,phoneNumber,day,month,year,password);
	}

	@Then("a fego vemos account is created")
	public void a_fego_vemos_account_is_created() {
		
	}


}
