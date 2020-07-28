package api.apps.speedtest.home;

import core.UiObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;

public class HomePageUiPageObjects 
{
	@AndroidFindBy(id="org.zwanoo.android.speedtest:id/go_button")
	@iOSBy(id="org.zwanoo.android.speedtest:id/go_button")
	public MobileElement goButton;

}
