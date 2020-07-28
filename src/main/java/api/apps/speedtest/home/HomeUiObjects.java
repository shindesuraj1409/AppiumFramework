package api.apps.speedtest.home;

import core.UiObject;
import core.UiSelector;

public class HomeUiObjects {
	
	private static UiObject goButton,multiConnection,singleConnection,server, servertitle;
	
	public UiObject goButton()
	{
		if(goButton==null) goButton=new UiSelector().resourceid("org.zwanoo.android.speedtest:id/go_button").makeUiObject();
		return goButton;
	}
	
	public UiObject multiConnection()
	{
		if(goButton==null) multiConnection=new UiSelector().resourceid("org.zwanoo.android.speedtest:id/host_assembly_connections_multi_button").makeUiObject();
		return multiConnection;
	}
	public UiObject singleConnection()
	{
		if(singleConnection==null) singleConnection=new UiSelector().resourceid("org.zwanoo.android.speedtest:id/host_assembly_connections_single_button").makeUiObject();
		return singleConnection;
	}
	public UiObject server()
	{
		if(server==null) server=new UiSelector().resourceid("org.zwanoo.android.speedtest:id/host_assembly_server_item_touch_target").makeUiObject();
		return server;
	}
	
	public UiObject servertitle()
	{
		if(servertitle==null) servertitle=new UiSelector().resourceid("org.zwanoo.android.speedtest:id/server_item_subtitle_text_view").makeUiObject();
		return servertitle;
	}

}
