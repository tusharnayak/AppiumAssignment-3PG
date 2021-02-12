package com.apidemos.qa.specs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apidemos.qa.base.BaseClass;
import com.apidemos.qa.pages.HomePage;
import com.apidemos.qa.pages.ViewPage;

public class ScrollSpecs extends BaseClass{
	public HomePage homepage;
	public ViewPage viewPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void dragDrop() {
		viewPage=homepage.clickOnView();
		viewPage.scrollElement();	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
