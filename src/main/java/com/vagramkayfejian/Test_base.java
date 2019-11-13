package com.vagramkayfejian;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;



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