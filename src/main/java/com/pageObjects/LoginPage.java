package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.actionDriver.Action;
import com.baseclass.configurebrowser.BaseClass;

public class LoginPage extends BaseClass
{
	
	public static WebDriver driver;
	
	By username=By.id("username");
	
	By password=By.name("pwd");
	
	By loginBtn=By.xpath("//div[text()='Login ']");

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public void loginTo(String uname, String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
}
