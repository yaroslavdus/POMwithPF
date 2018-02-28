package com.qtpselenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pom.base.BasePage;
import com.qtpselenium.facebook.pom.util.FacebookConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends BasePage{
	
	@FindBy(id=FacebookConstants.LOGIN_USERNAME)
	public WebElement email;
	
	@FindBy(id=FacebookConstants.LOGIN_PASSWORD)
	public WebElement password;
	
	@FindBy(id=FacebookConstants.LOGIN_BUTTON)
	public WebElement loginbutton;
	
	public LoginPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public Object doLogin(String userName, String pass) {
		test.log(LogStatus.INFO, "Logging in with: " + userName + " " + pass);
		email.sendKeys(userName);
		password.sendKeys(pass);
		loginbutton.click();
		//logic to validate login
		boolean loginSuccess = true;
		if(loginSuccess) {
			test.log(LogStatus.INFO, "Login Success");
			LandingPage landingPage = new LandingPage(driver, test);
			PageFactory.initElements(driver, landingPage);
			return landingPage;
		}
		else {
			test.log(LogStatus.INFO, "Login Not Success");
			LoginPage loginPage = new LoginPage(driver, test);
			PageFactory.initElements(driver, loginPage);
			return loginPage;
		}
			
	}

}
