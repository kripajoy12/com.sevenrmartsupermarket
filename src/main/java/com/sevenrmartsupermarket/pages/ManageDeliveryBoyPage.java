package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.Excel;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	PageUtility pageutility;
	@FindBy(xpath="//p[text()='Manage Delivery Boy']")
	WebElement manageDeliveryBoyOption;
	@FindBy(xpath="//a[contains(text(),'New')]")
	WebElement newButton;
	@FindBy(id=("name"))
	WebElement nameField;
	@FindBy(id=("email"))
	WebElement emailField;
	@FindBy(id=("phone"))
	WebElement phoneNumberField;
	@FindBy(id=("address"))
	WebElement addressField;
	@FindBy(id=("username"))
	WebElement UserNameField;
	@FindBy(id=("password"))
	WebElement passwordField;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement cancelButton;
	Excel excel=new Excel();
	
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageDeliveryBoyOption() {
		manageDeliveryBoyOption.click();
	}
	
	public void addNewDeliveryBoys() {
		newButton.click();
	}
	
	public void enterName(String name) {
		nameField.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPhoneNumber(String number) {
		phoneNumberField.sendKeys(number);
	}
	

	public void enterAddress(String address) {
		addressField.sendKeys(address);
	}

	public void enterUserName(String userName) {
		UserNameField.sendKeys(userName);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void addDeliveryBoyDetails(String name,String email,String phoneNumber,String address,String userName,String password) {
		enterName(name);
		enterEmail(email);
		enterPhoneNumber(phoneNumber);
		enterAddress(address);
		enterUserName(userName);
		enterPassword(password);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public void scrollDown() {
		pageutility=new PageUtility(driver);
		pageutility.srollAndClick(saveButton);
	}
	public void clickOnCancelButton() {
		cancelButton.click();
	}
	
}
