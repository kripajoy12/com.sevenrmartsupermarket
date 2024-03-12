package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
public WebDriver driver;
Properties properties=new Properties();

public  Base() {
	try {
		FileInputStream fi=new FileInputStream(Constants.CONFIG_FILE_PATH);//initialisation
		properties.load(fi);
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
}
/**Initializing driver**/
public void initialize(String browser,String url) {//launch browser
	
	if(browser.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equals("Edge")){
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else if(browser.equals("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}

	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICT_WAIT));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
}
@Parameters("browser")
@BeforeMethod(enabled=false)

	public void launchBrowser(String browser) {
		
		String url=properties.getProperty("url");
		initialize(browser,url);//give that data to initialize
}
@BeforeMethod(enabled=true,alwaysRun=true)
public void launchBrowser() {
	String browser=properties.getProperty("browser");//get data from config 
	String url=properties.getProperty("url");
	initialize(browser,url);//give that data to initialize
}
@AfterMethod
public void terminateSession(ITestResult itestresult) {
	
	if(itestresult.getStatus()==ITestResult.FAILURE) {
		ScreenShot.takeScreenShot(driver,itestresult.getName());
	}
	driver.quit();
}
}
