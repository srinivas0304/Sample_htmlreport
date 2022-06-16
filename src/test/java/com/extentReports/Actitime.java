package com.extentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.extentUtility.ExtentUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actitime 
{
	public static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	
	@Test
	public void login() throws Exception
	{
		ExtentUtility.setupExtent();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	@AfterTest
	public void closeB()
	{
		driver.quit();
	}
}
