package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageProduct {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility=new GeneralUtility();
	@FindBy(xpath="//p[text()='Manage Product']")
	WebElement manageProductLink;
	@FindBy(xpath="//tbody//tr//td[1]")
	List<WebElement> productNameList;
	@FindBy(xpath="//h1[text()='Edit Product']")
	WebElement editText;
	public  ManageProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnManageProductLink() {
		manageProductLink.click();
	}
 public void editProduct(String product) {
	 pageutility=new PageUtility(driver);
		List<String> names=new ArrayList<String>();
		names= generalutility.get_TextOfElements(productNameList);
		System.out.println(names);
		int index=0;
		for(index=0;index<names.size();index++) {
			if(product.contains(names.get(index))) {
				index++;
				break;
			}
		}
		WebElement unlockButton=driver.findElement(By.xpath("//table//tbody//tr["+index+"]//td[9]//i[@class='fas fa-edit']"));
		System.out.println(unlockButton.getText());
		pageutility.srollAndClick(unlockButton);
		
		
 }
 public String getEditText() {
	return editText.getText();
 }
}
