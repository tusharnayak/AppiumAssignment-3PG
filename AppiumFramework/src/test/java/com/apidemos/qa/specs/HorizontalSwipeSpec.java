package com.apidemos.qa.specs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apidemos.qa.base.BaseClass;
import com.apidemos.qa.pages.HomePage;
import com.apidemos.qa.pages.ScrollablePage;
import com.apidemos.qa.pages.TabPage;
import com.apidemos.qa.pages.ViewPage;

public class HorizontalSwipeSpec extends BaseClass {
	public HomePage homepage;
	public ViewPage viewPage;
	public TabPage tabPage;
	public ScrollablePage scrollable;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void horizontalSwipe() {
		viewPage=homepage.clickOnView();
		tabPage=viewPage.verticalSwipeDown();
		scrollable=tabPage.clickOnScrollable();
		scrollable.horizontalSwipe();
		
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
