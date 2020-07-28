package api.apps.speedtest.home;

import java.util.NoSuchElementException;

import api.android.Android;
import api.apps.speedtest.speedresult.SpeedResultScreen;
import api.interfaces.Activity;
import core.MyLogger;

public class Home implements Activity 
{
	public HomeUiObjects uiObjects= new HomeUiObjects();

	public SpeedResultScreen tapGoButton()
	{
		try {
			MyLogger.logger.info("Tapping Go Button on HomeScreen");
			uiObjects.goButton().tap().waitToDisappear(120);
			return Android.app.speedtest.speedResultScreen;

		} catch (NoSuchElementException e) {
			throw new AssertionError("Can't tap Go button. Element absent or blocked");
		}
	}
	public void tapMultiButton()
	{
		try {
			MyLogger.logger.info("Tapping Mutli Button on HomeScreen");
			uiObjects.multiConnection().tap();

		} catch (NoSuchElementException e) {
			throw new AssertionError("Can't tap Multi button. Element absent or blocked");
		}
	}

	public void tapSingleButton()
	{
		try {
			MyLogger.logger.info("Tapping Single Button on HomeScreen");
			uiObjects.singleConnection().tap();

		} catch (NoSuchElementException e) {
			throw new AssertionError("Can't tap Single button. Element absent or blocked");
		}
	}

	public void tapServer()
	{
		try {
			MyLogger.logger.info("Tapping Server Button on HomeScreen");
			uiObjects.server().tap();

		} catch (NoSuchElementException e) {
			throw new AssertionError("Can't tap Server button. Element absent or blocked");
		}
	}

	public void tapServerName()
	{
		try {
			MyLogger.logger.info("Tapping ServerName displayed on HomeScreen");
			uiObjects.servertitle().tap();

		} catch (NoSuchElementException e) {
			throw new AssertionError("Can't tap ServerName title. Element absent or blocked");
		}
	}
	
	public Home waitToLoad() {
		try {
			MyLogger.logger.info("Waiting for HomeActivity");
			uiObjects.goButton().waitToAppear(10);
			return Android.app.speedtest.home;
		} catch (AssertionError e) 
		{
			throw new AssertionError("HomeScreen Activiyt failed to load");
		}
	}


}
