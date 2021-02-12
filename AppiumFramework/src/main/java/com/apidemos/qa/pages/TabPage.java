package com.apidemos.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.apidemos.qa.base.BaseClass;

public class TabPage extends BaseClass{

	@FindBy(xpath = "//android.widget.TextView[@text='5. Scrollable']")
	WebElement scrollable;
	
	public TabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ScrollablePage clickOnScrollable() {
		scrollable.click();
		return new ScrollablePage();
		
	}
}
