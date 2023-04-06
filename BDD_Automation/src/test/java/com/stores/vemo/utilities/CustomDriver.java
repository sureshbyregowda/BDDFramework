package com.stores.vemo.utilities;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomDriver {

	public WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	WebElement element;
	List<WebElement> elements;

	public CustomDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findElement(By obj) {
		element = driver.findElement(obj);
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}

	public List<WebElement> findElements(By obj) {
		elements = driver.findElements(obj);
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elements;
	}
	
	public void switchToAlertAccept() {
		driver.switchTo().alert().accept();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void scrollToElement(WebElement element) 
	{
		
		try
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void ExecuteScript(WebElement element) 
	{
		
		try
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		
	public void timeouts(int n) {
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
	}

	public void moveToElement(WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	
}
}

