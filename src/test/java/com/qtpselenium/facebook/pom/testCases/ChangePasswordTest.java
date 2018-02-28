package com.qtpselenium.facebook.pom.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.pom.testCases.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class ChangePasswordTest extends BaseTest{
	
	@Test
	public void changePasswordTest()	{
		test = extent.startTest("Login Test");
		test.log(LogStatus.INFO, "Starting login test");
		//
		test.log(LogStatus.FAIL, "Test Faild");
		
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
