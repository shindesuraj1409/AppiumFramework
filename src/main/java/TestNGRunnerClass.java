import java.net.MalformedURLException;

import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import org.testng.TestNG;

import core.MyLogger;
import core.manager.DriverManager;
import tests.TEstNGTestPrimer;


public class TestNGRunnerClass 
{

	public static void main(String[] args) throws MalformedURLException
	{
		MyLogger.logger.setLevel(Level.INFO);
		try
		{
			
			DriverManager.createDriver();
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { tests.TestNGDemo.class });
			testSuite.addListener(new TEstNGTestPrimer());
			testSuite.run();
		 

		}finally
		{
			DriverManager.killDriver();
		}
	}
}
