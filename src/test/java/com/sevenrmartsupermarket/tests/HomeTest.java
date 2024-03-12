package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.Excel;

public class HomeTest extends Base{
	
	Excel excel=new Excel();
	LoginPage loginpage;
	HomePage homepage;
	@Test(groups = {"smoke","regression"})
	public void verifyAdminUsersInfo() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		homepage.clickOnAdminUserList();
	}
		
	}


