package core.manager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import api.android.Android;
import core.ADB;
import core.MyLogger;
import core.constants.Arg;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverManager {
	private static String nodeJSExecutable= "C:/Program Files/nodejs/node.exe";
	private static String appiumJS="C:/Users/suraj/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
	private static DriverService service;
	private static HashMap<String, URL> hosts;
	private static String unlockPackage="io.appium.unlock";
	private static String deviceId;

	private static DesiredCapabilities getCaps(String deviceId)
	{
		MyLogger.logger.info("Creating driver caps for device:"+deviceId);
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("deviceName", deviceId);
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		MyLogger.logger.info("Returning the Capabilites for:"+deviceId);
		return caps;
	}

	private static URL host(String deviceId) throws MalformedURLException
	{
		if(hosts==null)
		{
			hosts= new HashMap<String,URL>();
			hosts.put(deviceId, new URL("http://127.0.0.1:4723/wd/hub"));

		}return hosts.get(deviceId);

	}

	private static ArrayList<String> getAvailableDevices()
	{
		MyLogger.logger.info("Checking for Available Devices");
		ArrayList<String> avaibleDevice=new ArrayList<String>();
		ArrayList<String> connectedDevices= ADB.getConnectedDevices();
		for(Object connectedDevice:connectedDevices)
		{
			String device=connectedDevice.toString();
			ArrayList<String> apps=new ADB(device).getInstallPackages();
			if(!apps.contains(unlockPackage)) avaibleDevice.add(device);
			else MyLogger.logger.info("Device:"+device+"has "+unlockPackage+".Assuming its under test");
		}
		if(avaibleDevice.size()==0) throw new RuntimeException("Not a single device is available for testing");
		return avaibleDevice;
	}


	public static void createDriver() throws MalformedURLException
	{
		ArrayList<String> devices=getAvailableDevices();
		for(String device:devices)
		{
			try
			{
				deviceId=device;
				createService().start();
				MyLogger.logger.info("Started Appium Service with Device: "+device);
				MyLogger.logger.info("Trying to create new Driver for device: "+device);
				Android.driver= new AndroidDriver<MobileElement>(host(device),getCaps(device));
				MyLogger.logger.debug("Android Driver Value:"+Android.driver);
				Android.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Android.adb= new ADB(device);
				MyLogger.logger.info("Created new Driver for device: "+device);
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
	}

	public static void killDriver()
	{
		if(Android.driver!=null)
		{
			MyLogger.logger.info("Killing Android Driver");
			Android.driver.quit();
			Android.adb.uninstallApp(unlockPackage);
			service.stop();

		}
		else MyLogger.logger.info("Android driver not initialized. Nothing to kill");

	}

	private static DriverService createService() throws NumberFormatException, MalformedURLException
	{
		MyLogger.logger.info("Starting Appium Service: ");
		service= new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodeJSExecutable))
				.withAppiumJS(new File(appiumJS))
				.withIPAddress(host(deviceId).toString().split(":")[1].replace("//", ""))
				.usingAnyFreePort()
				.withArgument(Arg.TIMEOUT,"120")
				.withArgument(Arg.LOG_LEVEL,"warn")
				.build();
		//usingPort(Integer.parseInt(host(deviceId).toString().split(":")[2].replace("/wd/hub","")))
		return service; 		

	}
	
	
	
	
}


