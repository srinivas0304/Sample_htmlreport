package com.extentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.extentUtility.*;

public class DemoReport 
{
	public static WebDriver driver;
	@Test
	public void sample() throws Exception
	{
//		ExtentReports extent=new ExtentReports();
//		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./SparkReports/report.html");
//		extent.attachReporter(sparkReport);
		ExtentUtility.setupExtent();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		//String path=takingScreenShot("Google.jpg");
	}
//	public static String takingScreenShot(String filename) throws IOException 
//	{
//		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File destiFile = new File(".\\Screenshots\\"+filename);
//		FileUtils.copyFile(srcFile,destiFile );
//		return destiFile.getAbsolutePath();
//	}
}
