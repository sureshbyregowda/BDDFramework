package com.stores.vemo.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.stores.vemo.utilities.*;

public class Page_Account_Registration {

	private static CustomDriver driver;
	private static final Logger log = LogManager.getLogger(Page_Account_Registration.class.getName());
	private String jsq;
	private CustomJavaScriptExecutor jse;

	public Page_Account_Registration(WebDriver driver) {
		this.driver = new CustomDriver(driver);
		this.jse = new CustomJavaScriptExecutor(driver);
	}
	
	//Navigate to Create Account Registration Screen
	public void navigateToRegistrationPage()
	{
		//Launch URL
		driver.getDriver().get("https://fego.vmos-demo.com/");
		
		//Clicks on Login link or button
		driver.findElement(By.xpath("//a[@data-test='header-profile-link']")).click();
		
		//Clicks on Create Account tab
		driver.findElement(By.xpath("//li[@data-test='auth-tab-register']")).click();		
		
	}
	
	//Enter all registration fields
	public void enterAllregistrationfields(String name,String email,String code,String phoneNumber,String day,String month,String year,String password)
	{
		//Enter Name
		driver.findElement(By.id("firstName")).sendKeys(name);
		//Enter Email address
		driver.findElement(By.id("email")).sendKeys(email);
		//Select Country code
		driver.findElement(By.xpath("//img[@class='eu7emln0 css-1r94pm6 e971uut0']")).click();
		
		//jsq = "return document.querySelector('*[class=\"css-h0jes7 eu7emln4\"]')";
		//WebElement scountry = (WebElement) jse.executeScript(jsq);
		//scountry.click();		
		
		List<WebElement> phoneLists= driver.findElements(By.xpath("//li[@class='css-xdtyhh eu7emln2']"));
		
		for(int index=0; index<phoneLists.size(); index++)
		{
			if(phoneLists.get(index).getText().equalsIgnoreCase(code.strip()))
			{
				phoneLists.get(index).click();
				System.out.println("Country code  "+code+"   selected successfully");
				break;
			}			
		}
		
		//Enter phone number
		driver.findElement(By.xpath("//input[@data-test='phone-number-field']")).click();
		driver.findElement(By.xpath("//input[@data-test='phone-number-field']")).sendKeys(phoneNumber);
		
		//Select Date of birth - Day		
		WebElement sDayWebElement = driver.findElement(By.xpath("//div[@class='css-vabva8 e8h9qit3'][1]/select[@class='css-19g9shq e8h9qit2']"));		
		Select sDayObj = new Select(sDayWebElement);
		sDayObj.selectByValue(day);
		
		//Select Date of birth - Month		
		WebElement sMonthWebElement = driver.findElement(By.xpath("//div[@class='css-vabva8 e8h9qit3'][2]/select[@class='css-19g9shq e8h9qit2']"));		
		Select sMonthObj = new Select(sMonthWebElement);
		sMonthObj.selectByValue("5");	
		
		//Select Date of birth - Year		
		WebElement sYearWebElement = driver.findElement(By.xpath("//div[@class='css-vabva8 e8h9qit3'][3]/select[@class='css-19g9shq e8h9qit2']"));		
		Select sYearObj = new Select(sYearWebElement);
		sYearObj.selectByValue(year.toString());			
		
		//Enter Password
		driver.findElement(By.id("password")).sendKeys(password.strip());
		
		//Accept Terms & Conditions
		driver.findElement(By.xpath("//div[@class='css-q1j3qv e379e0i4']")).click();
		
		//Click on Create Account button
		driver.findElement(By.xpath("//button[@data-test='auth-button']")).click();
		
		//Verify Account details by entering verification code
		//Example for verification code
		/*String firstDigitfromVerificationCode = "6";
		String secondDigitfromVerificationCode = "4";
		String thirdDigitfromVerificationCode = "3";
		String fourthDigitfromVerificationCode = "2";
		
		driver.findElement(By.id("input-code-0")).sendKeys(firstDigitfromVerificationCode);
		driver.findElement(By.id("input-code-1")).sendKeys(secondDigitfromVerificationCode);
		driver.findElement(By.id("input-code-2")).sendKeys(thirdDigitfromVerificationCode);
		driver.findElement(By.id("input-code-3")).sendKeys(fourthDigitfromVerificationCode);
		*/
		
		//Click on Verify button
		driver.findElement(By.xpath("//button[@data-test='verify-button']")).click();
	}
}




