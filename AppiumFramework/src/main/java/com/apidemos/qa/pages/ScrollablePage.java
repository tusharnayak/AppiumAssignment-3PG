package com.apidemos.qa.pages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apidemos.qa.base.BaseClass;
import com.apidemos.qa.util.TestUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollablePage extends BaseClass {

	@FindBy(xpath = "//android.widget.TextView[@text='TAB 10']")
	WebElement tab25;

	@FindBy(xpath = "//android.widget.TextView[@text='TAB 1']")
	WebElement tab1;

	public ScrollablePage() {
		PageFactory.initElements(driver, this);
	}

	public void horizontalSwipe() {
		
		boolean flag = false;
		for (int i = 1; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				tab25.isDisplayed();
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				flag = true;
				break;
			} catch (Exception e) {
				Dimension dimension = driver.manage().window().getSize();
				int height = dimension.getHeight();
				int width = dimension.getWidth();
				
				int y=(int) (height*0.20);
				int startX=(int) (width*0.75);
				int endX=(int) (width*0.35);
				TouchAction touch = new TouchAction(driver).press(PointOption.point(startX, y))
						.waitAction(waitOptions(ofMillis(800))).moveTo(PointOption.point(endX, y)).release().perform();			}
		}

		for (int i = 1; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				tab1.isDisplayed();
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				flag = true;
				break;
			} catch (Exception e) {
				Dimension dimension = driver.manage().window().getSize();
				int height = dimension.getHeight();
				int width = dimension.getWidth();
				
				int y=(int) (height*0.20);
				int startX=(int) (width*0.75);
				int endX=(int) (width*0.35);
				TouchAction touch = new TouchAction(driver).press(PointOption.point(endX, y))
						.waitAction(waitOptions(ofMillis(800))).moveTo(PointOption.point(startX, y)).release().perform();			}
		}
		

	}
}
