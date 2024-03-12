package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties=new Properties();
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement loginButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath="//label[contains(text(),'Remember Me')]")
	WebElement  rememberMeCheckBox;
public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		try {
			FileInputStream fi=new FileInputStream(Constants.CONFIG_FILE_PATH);//initialisation
			properties.load(fi);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
		
	}
	
	public void clickOnSignInButton() {
		loginButton.click();
	}
	
	public void login(String userName,String password) {//for invalid cases
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
	public void login() {
		String userName=properties.getProperty("userName");
		String password=properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
	public String manageAlertMessage() {
		
	return alertMessage.getText();
	
		
	}
	public String getTextOfRememberMe() {
	return rememberMeCheckBox.getText();
		
	}
	
}
