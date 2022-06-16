package testNGListenerConcept;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Listerns
{
	public static WebDriver driver;
	
	public void launchBrowser()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("https://google.com");
	}
	
	public void failedTest(String testMethodName) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/addla/Maven_Project/ExtentReports_Maven/ListernersShop/screenshots/"+testMethodName+"_"+".jpg"));
	}
}
