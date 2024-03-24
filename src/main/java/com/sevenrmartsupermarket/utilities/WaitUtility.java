package com.sevenrmartsupermarket.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	WebDriverWait wait;
	public WaitUtility(WebDriver driver) {
		this.driver=driver;
		
	}
	public void waitForClickable(WebElement element,long time) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForVisibiityOfElement(WebElement element,long time) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForInvisibilityOfElement(WebElement element, long time) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitForTextToBePresentInElement(WebElement element, String text, long time) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void waitForAllElementsToBePresent(List<WebElement> elements, long time) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

}
