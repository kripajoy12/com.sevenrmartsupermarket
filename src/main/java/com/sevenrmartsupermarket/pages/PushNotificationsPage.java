package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationsPage {
	WebDriver driver;
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushNotification;
	@FindBy(xpath="//input[@id='title']")
	WebElement titleField;
	@FindBy(xpath="//input[@id='description']")
	WebElement descriptionField; 
	@FindBy(xpath="//button[@name='create']")
	WebElement sendButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	@FindBy(xpath="//a[text()='Reset']")
	WebElement resetButton;
	public PushNotificationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnPushNotification() {
		pushNotification.click();
	}
	public void enterTitle(String title) {
		titleField.sendKeys(title);
	}
	public void enterDescription(String description) {
		descriptionField.sendKeys(description);
	}
	public void clickOnSendButton() {
		sendButton.click();
	}
	public String getSuccessMessage() {
		return successMessage.getText();
		
	}
	public String getTextOfResetButton() {
		return  resetButton.getText();
	}
}
