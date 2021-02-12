package com.apidemos.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apidemos.qa.base.BaseClass;

public class ExpandableListPage extends BaseClass{
	
	@FindBy(xpath = "//android.widget.TextView[@text='1. Custom Adapter']")
	WebElement customerAdapter;
	
	
	public ExpandableListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public PeopleNamesPage clickOncustomerAdapter() {
		customerAdapter.click();
		return new PeopleNamesPage();
	}
	

}
