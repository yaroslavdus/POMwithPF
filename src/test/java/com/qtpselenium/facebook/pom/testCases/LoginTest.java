package com.qtpselenium.facebook.pom.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.pom.pages.LaunchPage;
import com.qtpselenium.facebook.pom.pages.LoginPage;
import com.qtpselenium.facebook.pom.testCases.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{
	
	@Test
	public void doLogin() {
		
		test = extent.startTest("Login Test");
		test.log(LogStatus.INFO, "Starting login test");
		test.log(LogStatus.INFO, "Opening brower");
		init("Chrome");
		
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(LogStatus.INFO, "Logging in");
		loginPage.doLogin("yaroslavdus@gmail.com", "Yardus79861530");
		test.log(LogStatus.PASS, "Login Test Passed");
	}
	
	@AfterMethod
	public void shutDown() {
		
		if(extent!=null) {
			extent.endTest(test);
			extent.flush();
		}		
		driver.close();
	}

}
