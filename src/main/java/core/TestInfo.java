package core;

public class TestInfo {

	private static String TimeStamp,
	Suite,
	ID,
	Name,
	Notes,
	Expected,
	Actual,
	Version;
	
	public void reset()
	{
		TimeStamp=null;
		Suite=null;
		ID=null;
		Name=null;
		Notes=null;
		Expected=null;
		Actual=null;
		Version=null;

		
	}


	public TestInfo timeStamp(String value)
	{
		TimeStamp=value;
		return this;
	}

	public TestInfo suite(String value)
	{
		Suite=value;
		return this;
	}
	public TestInfo id(String value)
	{
		ID=value;
		return this;
	}
	public TestInfo name(String value)
	{
		Name=value;
		return this;
	}
	public TestInfo notes(String value)
	{
		Notes=value;
		return this;
	}
	public TestInfo expected(String value)
	{
		Expected=value;
		return this;
	}
	public TestInfo version(String value)
	{
		Version=value;
		return this;
	}
	public TestInfo actual(String value)
	{
		Actual=value;
		return this;
	}

	public static String timeStamp()
	{
		return TimeStamp;
	}


	public static String sutie()
	{
		return Suite;
	}
	public static String id()
	{
		return ID;
	}
	public static String name()
	{
		return Name;
	}
	public static String notes()
	{
		return Notes;
	}
	public static String expected()
	{
		return Expected;
	}

	public static String actual()
	{
		return Actual;
	}
	public static String version()
	{
		return Version;
	}
	
	public static void printResults()
	{
		MyLogger.logger.info("Test ID:"+ID);
		MyLogger.logger.info("Test Name:"+Name);
		MyLogger.logger.info("Test Suite:"+Suite);
	}

}