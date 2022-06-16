package com.extentUtility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtility 
{
	public static void setupExtent() throws Exception
	{

		ExtentReports extent = new ExtentReports();
		File path = new File("ActiTimeTask.html");
		// ExtentSparkReporter sparkReport=new ExtentSparkReporter(path);
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("./SparkReports/ActiTimeTask.html");
		extent.attachReporter(sparkReport);
		ExtentTest test = extent.createTest("Test 1", "Taking the screenshot");
		test.info("This is info msg");
//		test.addScreenCaptureFromPath(path);

		extent.flush();

		// Desktop.getDesktop().browse(new File("ActiTimeTask.html").toURI());
	}
}
