package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class Data_Provider {
	ExcelUtility excel=new ExcelUtility();
	@DataProvider(name = "ExcelProvider")
	
	public Object[][] exceldata() {
		excel.setExcelFile("LocationsData","Sheet1");
		Object data[][]=excel.getMultidimentionalData(2, 2);
		return data;
	}

}
