package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationsPage {
	WebDriver driver;
	Properties properties = new Properties();
	PageUtility pageutility;
	@FindBy(xpath = "//p[text()='Manage Location']")
	private WebElement manageLocationsLink;
	@FindBy(xpath = "//a[contains(text(),'New')]")
	private WebElement newLInk;
	@FindBy(xpath = "//select[@id='country_id']")
	private WebElement countryField;
	@FindBy(xpath = "//select[@id='st_id']")
	private WebElement stateField;
	@FindBy(xpath = "//input[@id='location']")
	private WebElement locationField;
	@FindBy(xpath = "//input[@id='delivery']")
	private WebElement deliveryChargeField;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public ManageLocationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);// initialisation
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void clickOnMangeLocationsLink() {
		manageLocationsLink.click();
	}

	public void clickOnNewLink() {
		newLInk.click();
	}
	public void selectCountry(int index) {
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(countryField,index);
	}
	public void selectState(int index) {
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(stateField,index);
	}

	public void enterLocation(String location) {
		locationField.sendKeys(location);

	}

	public void enterDeliveryCharge(String deliveryCharge) {
		deliveryChargeField.sendKeys(deliveryCharge);

	}

	public void clickOnSaveButton() {
		pageutility = new PageUtility(driver);
		pageutility.jsClick(saveButton);
	}

	public void addLocation(String location, String deliveryCharge) {
		enterLocation(location);
		enterDeliveryCharge(deliveryCharge);

	}

	public String manageAlertMessage() {

		return alertMessage.getText();

	}
}
