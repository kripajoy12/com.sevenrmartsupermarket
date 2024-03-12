package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility=new GeneralUtility();
	Properties properties=new Properties();
	@FindBy(xpath="//p[text()='Admin Users']")
	WebElement adminUserLink;
	@FindBy(xpath="//a[contains(text(),'New')]")
	WebElement newButton;
	@FindBy(xpath="//input[@id='username']")
	WebElement userNameField;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath="//select[@name='user_type']")
	WebElement selectDropDown;
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	@FindBy(xpath="//h5[contains(text(),'Alert!')]")
	WebElement alertMessage;
	@FindBy(xpath="//a[contains(text(),'Search')]")
	WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")
	WebElement searchUserName;
	String userName;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchFieldButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement searchFieldUserName;
	@FindBy(xpath="//table//tbody/tr//td[1]")
	List<WebElement> userNameList;
	public  AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		try {
			FileInputStream fi=new FileInputStream(Constants.ADMIN_FILE_PATH);//initialisation
			properties.load(fi);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public void clickonAdminUser() {
		adminUserLink.click();
	}
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
		
	}
	public void selectFromDropDownList(WebElement selectDropDown,int index) {
		 pageutility=new PageUtility(driver);
		 pageutility.select_ByIndex(selectDropDown,index);
	}
	public void clickOnSaveButton() {
		saveButton.click();
		
	}
	public void adminUserCreation() {
		userName=properties.getProperty("userName")+GeneralUtility.getRandomFirstName();
		enterUserName(userName);
		String password=properties.getProperty("password");
		enterPassword(password);
		String index=properties.getProperty("index");
		int ind=Integer.parseInt(index);
		selectFromDropDownList(selectDropDown,ind);
		clickOnSaveButton();
		
	}
	public void adminUserCreation(String userName,String password,int index) {
		enterUserName(userName);
		enterPassword(password);
		selectFromDropDownList(selectDropDown, index);
		clickOnSaveButton();
	}
	public String getAlertMessage() {
		return alertMessage.getText();
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void enterSearchUserName() {
		
		 searchUserName.sendKeys(userName);
		 
		
	}
	public void clickOnSearchFieldButton() {
		searchFieldButton.click();
	}
	public String getAdminUserText() {
		return searchFieldUserName.getText();
	}
	public String getSearchUserNameText() {
		return userName;
	}
	
	public void deactivateUser(String person) {
		pageutility=new PageUtility(driver);
		List<String> names=new ArrayList<String>();
		names= generalutility.get_TextOfElements(userNameList);
		int index=0;
		for(index=0;index<names.size();index++) {
			if(person.equals(names.get(index))) {
				index++;
				break;
			}
		}
		WebElement unlockButton=driver.findElement(By.xpath("//table//tbody/tr[\"+index+\"]//td[5]/a[1]"));
		System.out.println(unlockButton.getText());
		pageutility.srollAndClick(unlockButton);
		
	}
}
