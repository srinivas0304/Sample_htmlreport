package testNGListenerConcept;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Customlistener.class)
public class ScreenshotTest extends BaseClass_Listerns
{
	
	@BeforeMethod
	public void setup()
	{
		launchBrowser();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void test1()
	{
		String s=driver.getTitle();
		System.out.println(s);
		
		String s1="Google";
		Assert.assertEquals(s, s1);
	}

	
	@Test
	public void test2()
	{
		String s=driver.getTitle();
		System.out.println(s);
		
		String s1="Googleq";
		Assert.assertEquals(s, s1);
	}

}
