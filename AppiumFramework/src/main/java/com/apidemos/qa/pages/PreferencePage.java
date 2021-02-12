package com.apidemos.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apidemos.qa.base.BaseClass;


public class PreferencePage extends BaseClass{
	
	@FindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']") 
	WebElement clickPrefDependency;
	
	public PreferencePage() {
		PageFactory.initElements(driver, this);
	}
	
	public WifiPage clickOnPrefDep() {
		System.out.println("before click");
		clickPrefDependency.click();
		System.out.println("after click");
		return new WifiPage();
	}

}
