package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageSliderPage;

public class ManageSliderTest extends Base{
	LoginPage loginpage;
	ManageSliderPage managesliderpage;
	@Test
	public void verifyAddSlider() {
		loginpage=new LoginPage(driver);
		managesliderpage=new ManageSliderPage(driver);
		loginpage.login();
		managesliderpage.clickOnManageSliderLink();
		managesliderpage.clickOnNewButton();
		managesliderpage.addSlider("www.abc.com");
		 String actualAlertText=managesliderpage.getAlertMessage();
		 String expectedAlertText="Alert!";
		 Assert.assertEquals(actualAlertText, expectedAlertText);
	}
	

}
