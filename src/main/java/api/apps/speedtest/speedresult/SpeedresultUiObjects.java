package api.apps.speedtest.speedresult;

import core.UiObject;
import core.UiSelector;

public class SpeedresultUiObjects {
	public static UiObject downloads, uploads,ping, jitter, loss, testAgain, rate1, rate2, rate3, rate4, rate5, worse, asepected,better, serviceProvider, closebutton; 

	public UiObject downloads()
	{
		if(downloads==null) downloads=new UiSelector().resourceid("org.zwanoo.android.speedtest:id/txt_test_result_value").makeUiObject();
		return downloads;
	}
}
