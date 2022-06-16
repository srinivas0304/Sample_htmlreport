package com.extentReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleExtent 
{
	@Test
	public void demo()
	{
		ExtentReports extent =new ExtentReports();
		ExtentSparkReporter report=new ExtentSparkReporter("./SampleExtentReport/report.html");
		extent.attachReporter(report);
		ExtentTest test=extent.createTest("Test1");
		test.pass("pass");
		ExtentTest test1=extent.createTest("Test2");
		test1.log(Status.FAIL,"This is failed");
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		extent.flush();
	}
}
