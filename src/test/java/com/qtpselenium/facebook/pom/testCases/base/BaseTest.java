package com.qtpselenium.facebook.pom.testCases.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qtpselenium.facebook.pom.util.ExtentManager;
import com.qtpselenium.facebook.pom.util.FacebookConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public WebDriver driver;
	
	public void init(String browserType) {
		
		test.log(LogStatus.INFO, "Opening browser: " + browserType);
		if(browserType.equalsIgnoreCase("Mozilla"))
			driver = new FirefoxDriver();
		else if(browserType.equalsIgnoreCase("Chrome")) {
			//disable native browser notifications
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + FacebookConstants.CHROME_DRIVER_EXE);
			driver = new ChromeDriver(options);
		}
		
		test.log(LogStatus.INFO, "Opened browser succsessfully: " + browserType);

	}
	

}
