package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.Excel;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base{
	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboypage;
	Excel excel=new Excel();
	GeneralUtility generalutility;
	
	@Test
	public void verifyNewDeliveryBoyAddition() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		
		managedeliveryboypage.clickOnManageDeliveryBoyOption();
		managedeliveryboypage.addNewDeliveryBoys();
		excel.setExcelFile("AddDeliveryBoy","Sheet1");
		String name=excel.getCellData(1, 0)+GeneralUtility.getRandomFirstName();
		System.out.println(name);
		String email=GeneralUtility.getRandomFirstName()+excel.getCellData(1, 1);
		System.out.println(email);
		String phoneNumber =excel.getCellData(1, 2);
		System.out.println(phoneNumber);
		String address =excel.getCellData(1, 3);
		System.out.println(address);
		String userName=excel.getCellData(1, 4)+GeneralUtility.getRandomFirstName();
		System.out.println(userName);
		String password =excel.getCellData(1, 5);
		System.out.println(password);
		managedeliveryboypage.scrollDown();
		managedeliveryboypage.addDeliveryBoyDetails(name, email, phoneNumber, address, userName, password);
		
		managedeliveryboypage.clickOnSaveButton();
		//System.out.println(GeneralUtility.getRandomFirstName());
	}
	
}
