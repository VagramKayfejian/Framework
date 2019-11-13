package com.vagramkayfejian;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Framework {

	public static void setupAutomation(String is_remote, String browser) {
		
		if(browser.equals("chrome")) {
			if(is_remote.equals("false")) {

				System.setProperty("webdriver.chrome.driver", "chromedriver");   //you only need options if you were to use them ex: maximizing window, or open in oncog etc.
				Browser.setDriver(new ChromeDriver(new ChromeOptions()));
			}
			else
			{
				try {
				    Browser.setDriver(new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), new ChromeOptions()));
				}
				catch(MalformedURLException e) {
					System.err.println("URL is malformed. Cannot access server!");
				}
			}
		}
		else if(browser.equals("firefox")) {
			if(is_remote.equals("false")) {
				System.setProperty("webdriver.firefox.driver", "geckodriver");  //you only need options if you were to use them ex: maximizing window, or open in oncog etc.
				Browser.setDriver(new FirefoxDriver(new FirefoxOptions()));
			}
		}
		
		
		return;
	}
}
