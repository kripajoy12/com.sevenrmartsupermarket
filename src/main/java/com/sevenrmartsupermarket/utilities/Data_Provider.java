package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class Data_Provider {
	Excel excel=new Excel();
	@DataProvider(name = "ExcelProvider")
	
	public Object[][] exceldata() {
		excel.setExcelFile(null, null);
		Object data[][]=excel.getMultidimentionalData(2, 2);
		return data;
	}

}
