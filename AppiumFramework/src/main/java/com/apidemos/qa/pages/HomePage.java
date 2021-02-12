package com.apidemos.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apidemos.qa.base.BaseClass;


public class HomePage extends BaseClass{
	// page factory --object repository

	@FindBy(xpath = "//android.widget.TextView[@text='Preference']")
	WebElement dependency;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Views']")
	WebElement views;
	
	@FindBy(xpath = "//android.widget.TextView[@text='API Demos']")
	WebElement validation;


//initializing the page objects
	public HomePage()
	{
	    PageFactory.initElements(driver, this);
	}


	public PreferencePage clickOnPreference() throws InterruptedException
	{
	    dependency.click();
	    return new PreferencePage();
	    
	}
	
	public ViewPage clickOnView() {
		views.click();
		return new ViewPage();
	}
	
	public String isApiDemosPresent() {
		return validation.getText();
		
	}
}
