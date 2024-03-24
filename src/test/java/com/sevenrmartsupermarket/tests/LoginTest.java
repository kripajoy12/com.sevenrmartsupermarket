package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.Data_Provider;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	

	@Test(groups = "smoke")
	public void verifyUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homepage.getLoginUserName();
		Assert.assertEquals(actualProfileName, expectedProfileName, "profile names not match");

	}

	@Test
	public void verifyInvalidUserLogin() {

		loginpage = new LoginPage(driver);
		loginpage.enterUserName("admin");
		loginpage.enterPassword("ad");
		loginpage.clickOnSignInButton();
		String actualText = loginpage.manageAlertMessage();
		String expectedText = "Alert!";
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(groups = "smoke")
	public void verifyRememberMeText() {
		loginpage = new LoginPage(driver);
		String actualText = loginpage.getTextOfRememberMe();
		Assert.assertEquals(actualText, "Remember Me", "text matches");
	}

	@Test(groups = { "smoke", "regression" })
	public void verifyRememberMeCheckBoxIsSelected() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnRememberMeCheckBox();
		Assert.assertTrue(loginpage.selectRememberMeCheckBox());
	}

}
