package com.sevenrmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	Properties properties=new Properties();
	@FindBy(xpath="//a[@class='d-block']")
	WebElement profileName;
	@FindBy(xpath="(//a[text()='More info '])[2]")
	WebElement adminUserInfo;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String getProfileName() {
		return profileName.getText();
	}
	public void clickOnAdminUserList() {
		adminUserInfo.click();
		System.out.println(adminUserInfo.getText());
	}
}
