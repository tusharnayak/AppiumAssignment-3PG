
package com.apidemos.qa.specs;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apidemos.qa.base.BaseClass;
import com.apidemos.qa.pages.HomePage;
import com.apidemos.qa.pages.PreferencePage;
import com.apidemos.qa.pages.WifiPage;


public class BasicTestSpecs extends BaseClass {

	public HomePage homepage;
	public PreferencePage prefPage;
	public WifiPage wifiPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		
	}

	@Test
	public void clickOnPreference() throws InterruptedException {
		Assert.assertEquals("API Demos", homepage.isApiDemosPresent());
		prefPage = homepage.clickOnPreference();
		wifiPage=prefPage.clickOnPrefDep();
		wifiPage.wifiAction();
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
