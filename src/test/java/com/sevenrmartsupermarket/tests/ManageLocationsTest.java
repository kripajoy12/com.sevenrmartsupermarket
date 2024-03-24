package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageLocationsPage;
import com.sevenrmartsupermarket.utilities.Data_Provider;
import com.sevenrmartsupermarket.utilities.ExcelUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationsTest extends Base {
	LoginPage loginpage;
	ManageLocationsPage managelocationspage;
	PageUtility pageutility;
	SoftAssert softassert = new SoftAssert();

	@Test(dataProvider = "ExcelProvider", dataProviderClass = Data_Provider.class)
	public void verifyAddingNewLocation(String location, String deliveryCharge) {
		loginpage = new LoginPage(driver);
		managelocationspage = new ManageLocationsPage(driver);
		pageutility = new PageUtility(driver);
		loginpage.login();
		managelocationspage.clickOnMangeLocationsLink();
		managelocationspage.clickOnNewLink();
		managelocationspage.selectCountry(1);
		managelocationspage.selectState(6);
		managelocationspage.addLocation(location, deliveryCharge);
		managelocationspage.clickOnSaveButton();
		String actualText = managelocationspage.manageAlertMessage();
		String expectedText = "Alert!";
		softassert.assertEquals(actualText, expectedText);
	}

}
