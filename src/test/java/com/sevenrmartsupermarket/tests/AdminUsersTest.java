package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUsersTest extends Base{	
	LoginPage loginpage;
	AdminUsersPage adminuserpage;
	 @Test
public void verifyAddingNewAdminUser() {
		 loginpage=new LoginPage(driver);
		 adminuserpage=new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserpage.clickonAdminUser();
		 adminuserpage.clickOnNewButton();
		 adminuserpage.adminUserCreation();
		 String actualAlertText=adminuserpage.getAlertMessage();
		 String expectedAlertText="Alert!";
		 Assert.assertEquals(actualAlertText, expectedAlertText);
		 
	 }
	 @Test
	 public void verifyAlertForAddingAlreadyExistingUserName() {
		 loginpage=new LoginPage(driver);
		 adminuserpage=new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserpage.clickonAdminUser();
		 adminuserpage.clickOnNewButton();
		 adminuserpage.adminUserCreation("admin","admin",2);
		 String actualAlertText=adminuserpage.getAlertMessage();
		 String expectedAlertText="Alert!";
		 Assert.assertEquals(actualAlertText, expectedAlertText);
	 }
	 @Test
	 public void verifySearchFunctionality() {
		 loginpage=new LoginPage(driver);
		 adminuserpage=new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserpage.clickonAdminUser();
		 adminuserpage.clickOnNewButton();
		 adminuserpage.adminUserCreation();
		 adminuserpage.clickOnSearchButton();
		 adminuserpage.enterSearchUserName();
		 adminuserpage.clickOnSearchFieldButton();
		String actualText=adminuserpage.getAdminUserText();
		String expectedText=adminuserpage.getSearchUserNameText();
		Assert.assertEquals(actualText, expectedText,"User not exist");
		
	 }
	 @Test
	 public void verifyNames() {
		 loginpage=new LoginPage(driver);
		 adminuserpage=new AdminUsersPage(driver);
		 loginpage.login();
		 adminuserpage.clickonAdminUser();
		 adminuserpage.deactivateUser("Kory");
		 String actualAlertText=adminuserpage.getAlertMessage();
		 String expectedAlertText="Alert!";
		 Assert.assertEquals(actualAlertText, expectedAlertText);
	 }
	 
	 
}
