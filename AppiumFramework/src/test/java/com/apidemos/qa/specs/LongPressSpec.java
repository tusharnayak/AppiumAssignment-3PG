package com.apidemos.qa.specs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.apidemos.qa.base.BaseClass;
import com.apidemos.qa.pages.ExpandableListPage;
import com.apidemos.qa.pages.HomePage;
import com.apidemos.qa.pages.PeopleNamesPage;
import com.apidemos.qa.pages.ViewPage;

public class LongPressSpec extends BaseClass{

	public HomePage homepage;
	public ViewPage viewPage;
	public ExpandableListPage expandableListPage;
	public PeopleNamesPage peopleNamesPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void longPressAction() {
		viewPage=homepage.clickOnView();
		expandableListPage=viewPage.clickOnExpandableList();
		peopleNamesPage=expandableListPage.clickOncustomerAdapter();
		peopleNamesPage.longPressOnPeopleNames();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
