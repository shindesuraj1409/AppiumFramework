package core.manager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import core.MyLogger;
import core.Retry;
import core.TestInfo;

public class TestManager 
{
	public static TestInfo testInfo= new TestInfo();
	@Rule
	public Retry retry= new Retry(3);
	
	@Before
	public void before()
	{
		testInfo.reset();
		
	}
	
	@Rule
	public TestRule listen= new TestWatcher() {
		@Override
		public void failed(Throwable t, Description description)
		{
			MyLogger.logger.info("Test Failed");
			TestInfo.printResults();
		}
		
		@Override
		public void succeeded(Description description)
		{
			MyLogger.logger.info("Test Passed");
			TestInfo.printResults();
		}
		
	};

}
