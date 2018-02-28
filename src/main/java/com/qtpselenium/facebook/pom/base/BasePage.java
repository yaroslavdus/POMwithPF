package com.qtpselenium.facebook.pom.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pom.base.common.TopMenu;
import com.qtpselenium.facebook.pom.util.FacebookConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	
	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;
	
	public BasePage() {}
	
	public BasePage(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		menu = PageFactory.initElements(driver, TopMenu.class);
	}
	
	public String verifyTitle(String title) {
		test.log(LogStatus.INFO, "Verifying the title " + title);
		return "";
	}
	
	public String verifyText(String locator, String expText) {
		return "";
	}
	
	public boolean isElementPresent(String locator) {
		try{
			driver.findElement(By.xpath(locator));
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public TopMenu getMenu() {
		return menu;
	}
	
	public void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replaceAll(":",  "_").replace(" ", "_")+".png";
		String filePath = FacebookConstants.REPORTS_PATH+"screenShots/"+screenshotFile;
		//store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}
	

}
