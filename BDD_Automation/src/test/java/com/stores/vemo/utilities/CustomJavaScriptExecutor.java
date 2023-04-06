package com.stores.vemo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.time.Instant;

public class CustomJavaScriptExecutor {
	private static JavascriptExecutor jse;
	private static Object obj;
	private int Timeout;
	private Instant Start, Curr;

	public CustomJavaScriptExecutor(WebDriver driver) {
		Timeout = 60;
		jse = (JavascriptExecutor) driver;
	}

	public Object executeScript(String query) {

		obj = null;
		Start = Instant.now();
		Curr = Instant.now();
		if (query.contains("return")) {
			while (obj == null && Duration.between(Start, Curr).toSeconds() <= Timeout) {
				Curr = Instant.now();
				try {
					obj = jse.executeScript(query);
					Thread.sleep(1200);
				} catch (Exception e) {
				}

			}

		} else {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj = jse.executeScript(query);

		}

		return obj;
	}
}
