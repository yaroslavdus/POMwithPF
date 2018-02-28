package com.qtpselenium.facebook.pom.testCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.pom.pages.LandingPage;
import com.qtpselenium.facebook.pom.pages.LaunchPage;
import com.qtpselenium.facebook.pom.pages.LoginPage;
import com.qtpselenium.facebook.pom.pages.ProfilePage;
import com.qtpselenium.facebook.pom.testCases.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProfileTest extends BaseTest{

	@Test
	public void testProfile() {

		test = extent.startTest("Profile Test");
		test.log(LogStatus.INFO, "Starting Profile test");
		init("Chrome");
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.verifyTitle("Facebook");
		Object page = loginPage.doLogin("yaroslavdus@gmail.com", "Yardus79861530");

		if(page instanceof LoginPage)
			Assert.fail("Login failed");
		else if(page instanceof LandingPage)
			System.out.println("Login successfull");

		LandingPage landingPage = (LandingPage)page;
		ProfilePage profilePage = landingPage.gotoProfilePage();
		profilePage.verifyProfile();
		test.log(LogStatus.PASS, "Profile Test Passed");
		profilePage.takeScreenShot();
		
	}

	@AfterMethod
	public void shutDown() {
		
		if(extent!=null) {
			extent.endTest(test);
			extent.flush();
		}
		
//		driver.close();
	}

}
