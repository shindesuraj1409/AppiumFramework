package core.manager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import core.MyLogger;
import core.TestInfo;

public class TestNGTestManager implements ITestListener
{
	public static TestInfo testInfo= new TestInfo();
	
	@BeforeTest
	public void before()
	{
		testInfo.reset();
		
	}
	
	public void onTestFailure(ITestResult Result) 					
    {		
		MyLogger.logger.info("Test Failed");
		TestInfo.printResults();
    }	
	
	public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }
	
	public void onTestSuccess(ITestResult Result)					
    {		
		MyLogger.logger.info("Test Passed");
		TestInfo.printResults();					
    }

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	

}
