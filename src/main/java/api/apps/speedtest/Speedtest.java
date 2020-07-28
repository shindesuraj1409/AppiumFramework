package api.apps.speedtest;

import api.android.Android;
import api.apps.speedtest.home.Home;
import api.apps.speedtest.home.HomePagePom;
import api.apps.speedtest.menu.Menu;
import api.apps.speedtest.results.ResultScreen;
import api.apps.speedtest.settings.SettingScreeen;
import api.apps.speedtest.speed.SpeedScreen;
import api.apps.speedtest.speedresult.SpeedResultScreen;
import api.apps.speedtest.tools.ToolsScreen;
import api.apps.speedtest.vpn.VpnScreen;
import api.interfaces.Application;
import core.manager.AppiumDriverManager;


public class Speedtest implements Application
{

	public AppiumDriverManager driverManager= new AppiumDriverManager();
	public HomePagePom homePome= new HomePagePom(driverManager.getAppiumDriver());
	public Menu menu= new Menu();
	public Home home=new Home();
	public SpeedScreen speedScreen= new SpeedScreen();
	public SpeedResultScreen speedResultScreen= new SpeedResultScreen();
	public ToolsScreen toolsScreen= new ToolsScreen();
	public VpnScreen vpnscreen= new VpnScreen();
	public ResultScreen resultScreen= new ResultScreen();
	public SettingScreeen settingScreen= new SettingScreeen();

	
	public void forceStop() {
		Android.adb.forceStopApp(packageId());
	}

	
	public void clearData() {
		Android.adb.clearAppData(packageId());
		
	}

	
	public Object open() {
		Android.adb.openAppActivity(packageId(), activityId());
		// TODO Auto-generated method stub
		return null;
	}

	
	public String packageId() {
		// TODO Auto-generated method stub
		return "org.zwanoo.android.speedtest";
	}


	public String activityId() {
		// TODO Auto-generated method stub
		return "com.ookla.mobile4.screens.main.MainViewActivity";
	}

	

}
