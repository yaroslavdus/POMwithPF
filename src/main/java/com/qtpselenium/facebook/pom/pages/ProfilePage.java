package com.qtpselenium.facebook.pom.pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qtpselenium.facebook.pom.base.BasePage;
import com.qtpselenium.facebook.pom.util.FacebookConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public void verifyProfile() {
		test.log(LogStatus.INFO, "Verifying Profile");
	}

	public void takeScreenShot() {	

//		Date d = new Date();
//		String screenshotFile = d.toString().replaceAll(":",  "_").replace(" ", "_")+".png";
//		String filePath = FacebookConstants.REPORTS_PATH+"screenShots/"+screenshotFile;
//		//store screenshot in that file
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//		try {
//			FileUtils.copyFile(scrFile, new File(filePath));
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	
	}
}
