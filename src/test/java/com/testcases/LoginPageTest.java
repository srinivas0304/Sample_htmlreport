package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.configurebrowser.BaseClass;
import com.extentUtility.ExtentUtility;
import com.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass
{
	LoginPage loginPage;
	
	@BeforeMethod
	public void setupBrowser()
	{
		launchBrowser();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void loginTest() throws Exception
	{
		ExtentUtility.setupExtent();
		loginPage=new LoginPage(driver);
		loginPage.loginTo(obj.getProperty("username"), obj.getProperty("password"));		
	}
}
