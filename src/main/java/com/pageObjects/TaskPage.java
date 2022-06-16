package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.actionDriver.Action;
import com.baseclass.configurebrowser.BaseClass;

public class TaskPage extends BaseClass
{
	
	By task=By.id("container_tasks");
	
	By addNew=By.className("addNewButton");
	
	By newCustomer=By.cssSelector("div.item.createNewCustomer");
	
	public TaskPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnTask() throws Exception
	{
		driver.findElement(task).click();
		Thread.sleep(2000);
//		String actualTitle=driver.getTitle();
//		String expectedTitle="actiTIME -  Task List";
//		Assert.assertEquals(actualTitle, expectedTitle);
	}
	public void clickAddNew()
	{
		driver.findElement(addNew).click();
	}
	public void clickNewCustomer()
	{
		driver.findElement(newCustomer).click();
	}
}
