package com.apidemos.qa.specs;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apidemos.qa.base.BaseClass;
import com.apidemos.qa.pages.DragDropPage;
import com.apidemos.qa.pages.HomePage;
import com.apidemos.qa.pages.ViewPage;

public class DragAndDropSpec extends BaseClass{
	public HomePage homepage;
	public ViewPage viewPage;
	public DragDropPage dragDropPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void dragDrop() {
		Assert.assertEquals("API Demos", homepage.isApiDemosPresent());
		viewPage=homepage.clickOnView();
		dragDropPage=viewPage.clickOnDragDrop();
		dragDropPage.dragWithLongPress();
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
