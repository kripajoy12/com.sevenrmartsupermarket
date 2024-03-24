package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelUtility;

public class HomeTest extends Base {

	ExcelUtility excel = new ExcelUtility();
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups = { "smoke", "regression" })
	public void verifyLoginUserName() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String actualName = homepage.getLoginUserName();
		String expectedName = "Admin";
		Assert.assertEquals(actualName, expectedName, "Names are same");

	}

}
