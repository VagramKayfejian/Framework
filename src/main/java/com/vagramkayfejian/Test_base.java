package com.vagramkayfejian;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;



public class Test_base {

	
	
	@Parameters({"is_remote","browser"})
	@BeforeMethod
	public void beforeMethod(String is_remote, String browser) { 
		Framework.setupAutomation(is_remote, browser);		
		Browser.getDriver().get("https://www.toofab.com");  
	}
	
	@AfterMethod
	public void afterMethod() {
		
		Browser.getDriver().quit();
		Browser.setDriver(null);
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		
	}
	
	@AfterSuite
	public void afterSuite() {
		
	}
}
