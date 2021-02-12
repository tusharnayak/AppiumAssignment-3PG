package com.apidemos.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.apidemos.qa.base.BaseClass;

public class WifiPage extends BaseClass{
	
	@FindBy(id = "android:id/checkbox")
	WebElement checkBox;
	
	@FindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	WebElement clickOnSetting;
	
	@FindBy(className = "android.widget.EditText")
	WebElement sendPassword;
	
	public WifiPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void wifiAction()  {
		checkBox.click();
		clickOnSetting.click();
		sendPassword.sendKeys("3pillar");
		
	}
	
}
