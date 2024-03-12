package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageSliderPage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newButton;
	@FindBy(xpath = "//p[text()='Manage Slider']")
	WebElement manageSliderLink;
	@FindBy(xpath = "//input[@id='link']")
	WebElement linkField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//h5[contains(text(),'Alert!')]")
	WebElement alertMessage;

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageSliderLink() {
		manageSliderLink.click();
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void enterLink(String link) {
		linkField.sendKeys(link);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void addSlider(String link) {
		enterLink(link);
		clickOnSaveButton();
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}
}
