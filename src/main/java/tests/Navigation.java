package tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import api.android.Android;
import api.apps.speedtest.Speedtest;
import core.manager.TestManager;


public class Navigation extends TestManager
{
	private static Speedtest speedtest=Android.app.speedtest;
	
	@BeforeClass
	public static void beforeClass()
	{
		testInfo.suite("Navigation");
		speedtest.open();
		
		
	}
	
	@Test
	public void test1()
	{
		testInfo.id("test1").name("Verify that Home Activity has all Elements");
		Assert.assertTrue(speedtest.home.uiObjects.goButton().exists());
		Assert.assertTrue(speedtest.home.uiObjects.multiConnection().exists());
		Assert.assertTrue(speedtest.home.uiObjects.server().exists());
		Assert.assertTrue(speedtest.home.uiObjects.singleConnection().exists());
	}
	
	@Test
	public void test2()
	{
		testInfo.id("test2").name("Verify that Home Activity has all Elements 2");
		Assert.assertTrue(speedtest.home.uiObjects.goButton().exists());
		Assert.assertTrue(speedtest.home.uiObjects.multiConnection().exists());
		Assert.assertTrue(speedtest.home.uiObjects.server().exists());
		Assert.assertTrue(speedtest.home.uiObjects.singleConnection().exists());
	}
	
	@Test
	public void test3()
	{
		testInfo.id("test3").name("Verify that Home Activity has all Elements 3");
		Assert.assertTrue(speedtest.home.uiObjects.goButton().exists());
		Assert.assertTrue(speedtest.home.uiObjects.multiConnection().exists());
		Assert.assertTrue(speedtest.home.uiObjects.server().exists());
		Assert.assertTrue(speedtest.home.uiObjects.singleConnection().exists());
		
		
	}
	

}
