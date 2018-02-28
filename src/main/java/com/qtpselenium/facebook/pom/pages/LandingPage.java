package com.qtpselenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pom.base.BasePage;
import com.qtpselenium.facebook.pom.util.FacebookConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPage extends BasePage{
	
	@FindBy(xpath=FacebookConstants.PROFILE_BUTTON)
	public WebElement profile;
	
	public LandingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public ProfilePage gotoProfilePage() {
		test.log(LogStatus.INFO, "Going to profile page");
		profile.click();
		ProfilePage profilePage = new ProfilePage(driver, test);
		PageFactory.initElements(driver, profilePage);
		return profilePage;
	}
}
