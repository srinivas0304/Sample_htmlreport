package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.configurebrowser.BaseClass;
import com.extentUtility.ExtentUtility;
import com.pageObjects.LoginPage;
import com.pageObjects.TaskPage;

public class TaskPageTest extends BaseClass
{
	LoginPage loginPage;
	TaskPage taskPage;
	
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
	public void taskTest() throws Exception
	{
		ExtentUtility.setupExtent();
		loginPage=new LoginPage(driver);
		loginPage.loginTo(obj.getProperty("username"), obj.getProperty("password"));
		taskPage=new TaskPage(driver);
		taskPage.clickOnTask();
		taskPage.clickAddNew();
		taskPage.clickNewCustomer();
	}
}
