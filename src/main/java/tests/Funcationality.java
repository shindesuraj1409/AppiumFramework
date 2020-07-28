package tests;

import org.junit.Assert;
import org.junit.Test;

import api.android.Android;
import api.apps.speedtest.Speedtest;
import core.manager.TestManager;

public class Funcationality extends TestManager
{
	private static Speedtest speedtest=Android.app.speedtest;
	
	@Test
	public void test4()
	{
		testInfo.id("test4").name("3").suite("Funcationality");
		speedtest.menu.tapSpeedbutton();
		speedtest.home.tapGoButton();
		Assert.assertTrue(speedtest.speedResultScreen.uiObjects.downloads.exists());
	}

}
