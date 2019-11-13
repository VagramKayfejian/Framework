package com.vagramkayfejian;

import org.openqa.selenium.WebDriver;

public class Browser {
	
	private static WebDriver driver = null;
	
	
	public static WebDriver getDriver() {
		return Browser.driver;
	}

	public static void setDriver(WebDriver d) {
		Browser.driver = d;
	}

}
