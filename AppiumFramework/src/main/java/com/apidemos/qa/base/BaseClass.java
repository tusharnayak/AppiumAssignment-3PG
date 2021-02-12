package com.apidemos.qa.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.apidemos.qa.util.TestUtil;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static AndroidDriver<AndroidElement> driver;
	public static Properties prop;

	public void initialization() {

		try {
			prop = new Properties();
			File f = new File("src/test/resources/apps");
			File fs = new File(f, "ApiDemos.apk");

			String PLATFORM_NAME = prop.getProperty("android.platform");
			String PLATFORM_VERSION = prop.getProperty("android.platform.version");
			String DEVICE_NAME = prop.getProperty("android.device.name");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME); 
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION); 
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			URL url;
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<AndroidElement>(url, cap);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")")).click();

		} catch (IOException exp) {
			System.out.println("Reason is :" + exp.getCause());
			System.out.println("Message is :" + exp.getMessage());
			exp.printStackTrace();
		}
	}
}
