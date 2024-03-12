package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String get_Attribute(WebElement element,String attribute) {
		return element.getAttribute(attribute);
		
	}
	public List<String> get_TextOfElements(List<WebElement> elements){
		List<String> data=new ArrayList<String>();
		for(WebElement element : elements)
		{ 
			data.add(element.getText());
		}
		return data;
	}
	public String get_CssValue(WebElement element,String property) {
		return element.getCssValue(property);
	}
public static String getRandomFirstName() {
	Faker faker=new Faker();
	return faker.name().firstName();
}
}
