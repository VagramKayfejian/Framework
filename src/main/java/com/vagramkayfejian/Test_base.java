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

	public static WebDriver driver = null;
	
	@Parameters({"is_remote","browser"})
	@BeforeMethod
	public void beforeMethod(String is_remote, String browser) { 
	
		
		if(browser.equals("chrome")) {
			if(is_remote.equals("false")) {

				System.setProperty("webdriver.chrome.driver", "chromedriver");   //you only need options if you were to use them ex: maximizing window, or open in oncog etc.
				Test_base.driver = new ChromeDriver(new ChromeOptions());
			}
			else
			{
				try {
				    Test_base.driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), new ChromeOptions());
				}
				catch(MalformedURLException e) {
					System.err.println("URL is malformed. Cannot access server!");
				}
			}
		}
		else if(browser.equals("firefox")) {
			if(is_remote.equals("false")) {
				System.setProperty("webdriver.firefox.driver", "geckodriver");  //you only need options if you were to use them ex: maximizing window, or open in oncog etc.
				Test_base.driver = new FirefoxDriver(new FirefoxOptions());
			}
		}
		  
	}
	
	@AfterMethod
	public void afterMethod() {
		
		Test_base.driver.quit();
		Test_base.driver = null;
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		
	}
	
	@AfterSuite
	public void afterSuite() {
		
	}
}
