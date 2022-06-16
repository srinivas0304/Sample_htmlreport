package com.baseclass.configurebrowser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.actionDriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static Properties obj;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfig()
	{
		try
		{
			obj=new Properties();
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			obj.load(fs);
		}
		catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		
	}
	public void launchBrowser()
	{
		String browserName=obj.getProperty("browser");
		
		if(browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Action.imlicitWait(driver, 10);
		driver.get(obj.getProperty("url"));
	}
	
	
}
