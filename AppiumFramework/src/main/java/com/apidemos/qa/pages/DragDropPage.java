package com.apidemos.qa.pages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.apidemos.qa.base.BaseClass;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DragDropPage extends BaseClass{
	
	@FindBy(id="io.appium.android.apis:id/drag_dot_1")
	WebElement longPressSource;
	
	@FindBy(id="io.appium.android.apis:id/drag_dot_2")
	WebElement longPressDestination;
	
	public DragDropPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void dragWithLongPress() {
		TouchAction touch=new TouchAction(driver);
		touch.longPress(longPressOptions().withElement(element(longPressSource))).moveTo(element(longPressDestination)).release().perform();
	}

}
