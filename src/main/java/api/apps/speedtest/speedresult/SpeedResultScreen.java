package api.apps.speedtest.speedresult;

import java.util.NoSuchElementException;


import core.MyLogger;

public class SpeedResultScreen {
	public SpeedresultUiObjects uiObjects= new SpeedresultUiObjects();
	
	public String getdownloadSpeed()
	{
		try {
			MyLogger.logger.info("Getting Download Speed");
			uiObjects.downloads().getText();
			return uiObjects.downloads().getText();

		} catch (NoSuchElementException e) {
			throw new AssertionError("Can't tap Go button. Element absent or blocked");
		}
	}

}
