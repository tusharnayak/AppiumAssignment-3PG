package com.apidemos.qa.pages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apidemos.qa.base.BaseClass;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PeopleNamesPage extends BaseClass{

	
	
	@FindBy(xpath = "//android.widget.TextView[@text='People Names']")
	WebElement peopleNamesLongPress;
	
	public PeopleNamesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void longPressOnPeopleNames() {
		System.out.println("before TA");
		TouchAction touch=new TouchAction(driver);
		System.out.println("after TA");
		touch.longPress(longPressOptions().withElement(element(peopleNamesLongPress)).withDuration(ofSeconds(2))).release().perform();
		System.out.println("after longPress action");

	}
}
