
import java.net.MalformedURLException;

import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;

import core.MyLogger;

import core.manager.DriverManager;
import tests.TestPrimer;




public class Runner {

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		MyLogger.logger.setLevel(Level.INFO);
		
		try
		{
			
			DriverManager.createDriver();
			JUnitCore.runClasses(TestPrimer.class);
			//JUnitCore.main("tests.TesstPrimer");
			
			
		 

		}finally
		{
			DriverManager.killDriver();
		}
	}

}
