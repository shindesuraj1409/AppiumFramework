package core;


import java.util.ArrayList;
import java.util.Arrays;



import core.manager.ServerManager;

public class ADB 
{
	private String ID;
	public ADB(String deviceiD)
	{
		ID=deviceiD;
	}


	public static String command(String command)
	{
		MyLogger.logger.debug("Formatting ADB Command:"+command);
		if(command.startsWith("adb")) command =command.replace("adb", ServerManager.getAndroidHome()+"/platform-tools/adb");
		else throw new RuntimeException("This method is designed to run ADB commands only");
		MyLogger.logger.debug("Formatted ADB Command:"+command);
		String output=ServerManager.runCommand(command);
		MyLogger.logger.debug("Output of ADB Command:"+output);
		if(output==null) return "";
		else return output.trim();
	}

	public static void killServer()
	{
		command("adb kill-server");
	}

	public static void startSever()
	{
		command("adb start-server");
	}

	public static ArrayList<String> getConnectedDevices()
	{
		ArrayList<String> devices= new ArrayList<String>();
		String output=command("adb devices");
		for(String line: output.split("\n"))
		{
			line=line.trim();
			if(line.endsWith("device")) devices.add(line.replace("device","").trim());
		}
		return devices;
	}


	public String getForGroundActivity()
	{
		return command("adb -s "+ID+" shell dumpsys windows windows | grep mCurrenFocus");
	}

	public String getAndroidVersionAsString()
	{
		String output=command("adb -s "+ID+" shell getprop ro.build.version.release ");
		if(output.length()==3) output+=".0";
		return output;
	}

	public int getAndroidVersion()
	{
		return Integer.getInteger(getAndroidVersionAsString().replaceAll("\\.",""));
	}

	public ArrayList<String> getInstallPackages()
	{
		ArrayList<String> packages=new ArrayList<String>();
		String[] output=command("adb -s "+ID+" shell pm list packages").split("\n");
		for(String packageId: output)
		{
			packages.add(packageId.replace("package", "").trim());
		}
		return packages;
	}

	public void openAppActivity(String packageid, String appActivity)
	{
		command("adb -s "+ID+" shell am start -c api.android.intent.category.Launcher -a api.android.intent.action.Main -n "+packageid+"/"+appActivity);
	}

	public void clearAppData(String packageid)
	{
		command("adb -s "+ID+" shell pm clear "+packageid);
	}
	public void forceStopApp(String packageid)
	{
		command("adb -s "+ID+" shell am force-stop "+packageid);
	}

	public void apkInstall(String apkPath)
	{
		command("adb -s "+ID+" install "+apkPath);
	}

	public void uninstallApp(String packageId)
	{
		command("adb -s "+ID+" uninstall "+packageId);
	}

	public void clearLogBuffer()
	{
		command("adb -s "+ID+" shell -c");
	}

	public void pushFile(String source ,String target)
	{
		command("adb -s "+ID+" push "+source+" "+target);
	}

	public void pullFile(String source, String target)
	{
		command("adb -s "+ID+" pull "+source+" "+target);
	}

	public void deletFile(String target)
	{
		command("adb -s "+ID+" shell rm "+target);
	}

	public void moveFile(String source, String target)
	{
		command("adb -s "+ID+" push "+source+" "+target);
	}

	public void takeScreenshot(String target)
	{
		command("adb -s "+ID+" shell screencap "+target);
	}

	public void rebootDevice()
	{
		command("adb -s "+ID+" reboot");
	}

	public String getDeviceModel()
	{
		return command("adb -s "+ID+" shell getprop ro.product.model");
	}

	public String getDeviceSerialNumber()
	{
		return command("adb -s "+ID+" shell getprop ro.product.serial");
	}

	public String getDeviceCarrier()
	{
		return command("adb -s "+ID+" shell getprop gsm.operator.alpha");
	}

	public ArrayList<String> getLogcatProcess()
	{
		String[] output=command("adb -s "+ID+" shell top -n 1 |grep -i 'logcat'").split("\n");
		ArrayList<String> process= new ArrayList<String>();
		for(String line:output)
		{
			process.add(line.split(" ")[0]);
			process.removeAll(Arrays.asList("",null));
		}
		return process;
	}

	
	

}
