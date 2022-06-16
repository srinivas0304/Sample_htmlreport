package extentReport_letskodeit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleLoginTest 
{
	private WebDriver driver;
	private String baseUrl;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass()
	{
		baseUrl="https://demo.actitime.com/login.do";
		extent=new ExtentReports();
		File path = new File("report.html");
		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./HtmlReport/report.html");
		extent.attachReporter(sparkReport);
		test=extent.createTest("Verify Welcome Text");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		test.log(Status.INFO, "Browser started");
		
		driver.manage().window().maximize();
		test.log(Status.INFO, "Browser maximized");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(Status.INFO, "Browser opened");
	}
	
	@Test
	public void login()
	{
		String actual=driver.getTitle();
		String expected="actiTIME - Login";
		Assert.assertEquals(expected, actual);
		test.log(Status.INFO, "Title verified");
		
		//********************Login Test*************
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		test.log(Status.INFO, "clicks on username and typing username");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		test.log(Status.INFO, "clicks on password and typing password");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		test.log(Status.INFO, "clicks on login button");
		
		test.log(Status.INFO, "successfully logged in");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		extent.flush();
	}
}
