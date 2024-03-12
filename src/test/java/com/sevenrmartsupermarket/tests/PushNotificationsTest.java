package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationsPage;
import com.sevenrmartsupermarket.utilities.Excel;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class PushNotificationsTest extends Base {
	LoginPage loginpage;
	PushNotificationsPage pushnotificationspage;
	Excel excel=new Excel();
	
	@Test
	public void verifyPushNotificationMessage() {
		loginpage=new LoginPage(driver);
		pushnotificationspage=new PushNotificationsPage(driver);
		loginpage.login();
		pushnotificationspage.clickOnPushNotification();
		excel.setExcelFile("PushNotificationsData","Sheet1");
		String title=excel.getCellData(0, 0);
		System.out.println(title);
		String description=excel.getCellData(0, 1);
		System.out.println(description);
		pushnotificationspage.enterTitle(title);
		pushnotificationspage.enterDescription(description);
		pushnotificationspage.clickOnSendButton();
		//ScreenShot.takeScreenShot(driver,"kripa");
	}
	@Test
	public void verifySuccessMessage() {
	loginpage=new LoginPage(driver);
	pushnotificationspage=new PushNotificationsPage(driver);
	loginpage.login();
	pushnotificationspage.clickOnPushNotification();
	excel.setExcelFile("PushNotificationsData","Sheet1");
	String title=excel.getCellData(0, 0);
	System.out.println(title);
	String description=excel.getCellData(0, 1);
	System.out.println(description);
	pushnotificationspage.enterTitle(title);
	pushnotificationspage.enterDescription(description);
	pushnotificationspage.clickOnSendButton();	
	System.out.println(pushnotificationspage.getSuccessMessage());

}
	@Test
	public void verifyResetButtonText() {
		loginpage=new LoginPage(driver);
		pushnotificationspage=new PushNotificationsPage(driver);
		loginpage.login();
		pushnotificationspage.clickOnPushNotification();
		String actualText=pushnotificationspage.getTextOfResetButton();
		String expectedText="Rese";
		Assert.assertEquals(actualText,expectedText);
	}
}