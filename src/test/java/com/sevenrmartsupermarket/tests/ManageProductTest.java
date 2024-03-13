package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProduct;

public class ManageProductTest extends Base{
	LoginPage loginpage;
	ManageProduct manageproduct;
	
	@Test
	public void verifyEditProduct() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageproduct=new ManageProduct(driver);
		manageproduct.clickOnManageProductLink();
		manageproduct.editProduct("Pomogranate P1151");
		String actualEditText=manageproduct.getEditText();
		String expectedEditText="Edit Product";
		Assert.assertEquals(actualEditText,expectedEditText);
	}

}
