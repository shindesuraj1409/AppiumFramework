package tests;




import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.android.Android;
import api.apps.speedtest.Speedtest;
import core.manager.TestNGTestManager;

public class TestNGDemo extends TestNGTestManager
{
	private static Speedtest speedtest=Android.app.speedtest;
	
	@BeforeClass
	public static void beforeClass()
	{
		testInfo.suite("DemoTstNG");
		speedtest.open();
		
		
	}
	@Test
	public void testTestNG1()
	{
		testInfo.id("TestNG1").name("TestNG_Demo").suite("Demo");
		speedtest.menu.tapSpeedbutton();
		speedtest.home.tapGoButton();
		//Assert.assertTrue(speedtest.speedResultScreen.uiObjects.downloads.exists());
		Assert.assertTrue(speedtest.speedResultScreen.uiObjects.downloads.exists());
	}
	

}
