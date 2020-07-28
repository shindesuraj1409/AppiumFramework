package api.apps.speedtest.menu;

import core.UiObject;
import core.UiSelector;

public class MenuUiObjects {

	private static UiObject 
	speed,
	vpn,
	results,
	tools,
	settings;
	
	public UiObject speed()
	{
		if(speed==null) speed= new UiSelector().resourceid("org.zwanoo.android.speedtest:id/tab_internet").makeUiObject();
		return speed;
	}
	
	public UiObject vpn()
	{
		if(speed==null) vpn= new UiSelector().resourceid("org.zwanoo.android.speedtest:id/tab_vpn").makeUiObject();
		return vpn;
	}
	public UiObject results()
	{
		if(speed==null) results= new UiSelector().resourceid("org.zwanoo.android.speedtest:id/tab_results").makeUiObject();
		return results;
	}
	public UiObject tools()
	{
		if(speed==null) tools= new UiSelector().resourceid("org.zwanoo.android.speedtest:id/tab_tools").makeUiObject();
		return tools;
	}
	

	public UiObject settings()
	{
		if(speed==null) settings= new UiSelector().resourceid("org.zwanoo.android.speedtest:id/tab_settings").makeUiObject();
		return settings;
	}
	
}
