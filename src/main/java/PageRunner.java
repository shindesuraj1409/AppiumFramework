import java.net.MalformedURLException;

import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;

import api.android.Android;
import core.MyLogger;
import core.manager.AppiumDriverManager;
import core.manager.DriverManager;
import tests.TestPrimer;

public class PageRunner {

	public static void main(String[] args) throws MalformedURLException
	{

		MyLogger.logger.setLevel(Level.INFO);

	try
		{
			Android.app.speedtest.open();
			Android.app.speedtest.homePome.tapGoButton();
			//JUnitCore.runClasses(TestPrimer.class);
			//JUnitCore.main("tests.TesstPrimer");

		}finally
		{
			AppiumDriverManager.killDriver();
		}
	}

}
