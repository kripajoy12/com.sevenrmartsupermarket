package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenShot {
static TakesScreenshot takesscreenshot;
	public  static  void takeScreenShot(WebDriver driver,String imageName) {
	 try {
		 String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		 takesscreenshot=(TakesScreenshot) driver;
		 File screenshot=takesscreenshot.getScreenshotAs(OutputType.FILE);//to capture screenshot
		String destination=Constants.SCREENSHOT_FILE_PATH+imageName+"_"+timeStamp+".png";
		File finalDestination=new File(destination);
		FileHandler.copy(screenshot,finalDestination);
				
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
