package core.manager;

import java.io.IOException;
import java.util.Scanner;

public class ServerManager {
	private static String OS;
	private static String ANDROID_HOME;


	public static String getAndroidHome()
	{
		if(ANDROID_HOME==null)
		{
			ANDROID_HOME=System.getenv("ANDROID_HOME");
			if(ANDROID_HOME==null) throw new RuntimeException("Failed to Find Android Home. Make Sure the enviornment variable is set");
		}
		return ANDROID_HOME;

	}
	public static String getOS()
	{
		if(OS==null) OS=System.getenv("os.name");
		return OS;
	}
	public static boolean isWindows()
	{
		return getOS().startsWith("Windows");
	}

	public static boolean isMac()
	{
		return getOS().startsWith("Mac");
	}

	public static String runCommand(String command)
	{
		String output=null;
		try{
			Scanner scanner= new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
			if(scanner.hasNext()) output=scanner.next();
		}catch (IOException e) 
		{
			throw new RuntimeException(e.getMessage());// TODO: handle exception
		}
		
		return output;
	}


}
