package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {

LoginPage loginpage;
HomePage homepage;

	@Test(groups = "smoke")
	public void verifyUserLogin() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login("admin","admin");
		String expectedProfileName="Admin";
		String actualProfileName=homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName,"profile names not match");
		
	}
	@Test(groups = {"smoke","regression"})
	public void verifyInvalidUserLogin() {
		loginpage=new LoginPage(driver);
		loginpage.enterUserName("admin");
		loginpage.enterPassword("ad");
		loginpage.clickOnSignInButton();
		loginpage.manageAlertMessage();
			
	}
	@Test(groups = "smoke")
	public void verifyRememberMeText() {
		loginpage=new LoginPage(driver);
		String actualText=loginpage.getTextOfRememberMe();
		Assert.assertEquals(actualText,"Remember Me","text matches");
	}
}
