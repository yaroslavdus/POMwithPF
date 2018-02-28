package com.qtpselenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pom.base.BasePage;
import com.qtpselenium.facebook.pom.util.FacebookConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{
	
	public LaunchPage(WebDriver driver, ExtentTest test) {
		super(driver	, test);

	}
	
	public LoginPage gotoLoginPage() { 
		
		test.log(LogStatus.INFO, "Opening the url: " + FacebookConstants.HOMEPAGE_URL);
		driver.get(FacebookConstants.HOMEPAGE_URL);
		test.log(LogStatus.PASS, "Url Oppened: " + FacebookConstants.HOMEPAGE_URL);
		LoginPage loginPage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

}
