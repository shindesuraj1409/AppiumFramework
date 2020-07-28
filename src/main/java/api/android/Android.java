package api.android;

import api.apps.Apps;
import core.ADB;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Android {
	public static AndroidDriver<MobileElement> driver=null;
	public static ADB adb;
	public static Apps app= new Apps();

}
