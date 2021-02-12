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

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ViewPage extends BaseClass {

	@FindBy(xpath = "//android.widget.TextView[@text='Tabs']")
	WebElement clickOnTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
	WebElement dragDrop;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
	WebElement expandableList;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Animation']")
	WebElement animationList;

	public ViewPage() {
		PageFactory.initElements(driver, this);
	}

	public TabPage verticalSwipeDown() {
		for (int i = 0; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				clickOnTab.click();
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				break;
			} catch (Exception e) {
				Dimension dimension = driver.manage().window().getSize();
				int height = dimension.getHeight();
				int width = dimension.getWidth();

				int x = width / 2;
				int startY = (int) (height * 0.95);
				int endY = (int) (height * 0.30);
				TouchAction touch = new TouchAction(driver).press(PointOption.point(x, startY))
						.waitAction(waitOptions(ofMillis(800))).moveTo(PointOption.point(x, endY)).release().perform();
			}
		}
		return new TabPage();

	}

	public void verticalSwipeUpward() {
		boolean flag = false;
		driver.navigate().back();
		for (int i = 0; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				animationList.isDisplayed();
				flag = true;
				break;
			} catch (Exception e) {
				Dimension dimension = driver.manage().window().getSize();
				int height = dimension.getHeight();
				int width = dimension.getWidth();

				int x = width / 2;
				int startY = (int) (height * 0.95);
				int endY = (int) (height * 0.30);
				TouchAction touch = new TouchAction(driver).press(PointOption.point(x, endY))
						.waitAction(waitOptions(ofMillis(800))).moveTo(PointOption.point(x, startY)).release().perform();
						
			}
		}
	}
	
	public DragDropPage clickOnDragDrop() {
		dragDrop.click();
		return new DragDropPage();
	}
	public ExpandableListPage clickOnExpandableList() {
		expandableList.click();
		return new ExpandableListPage();
		
	}
	public void scrollElement() {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}
}
