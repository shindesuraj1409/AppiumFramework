package api.apps.speedtest.menu;

import java.util.NoSuchElementException;

import core.MyLogger;

public class Menu {
	public MenuUiObjects uiObject= new MenuUiObjects();

	public void tapSpeedbutton()
	{
		try {
			MyLogger.logger.info("Tapping on Speed Menu button");
			uiObject.speed().tap();

		} catch(NoSuchElementException e) 
		{
			throw new AssertionError("Can't tap Speed button. Element absent or blocked");
		}
	}
	
	
	public void tapVpnbutton()
	{
		try {
			MyLogger.logger.info("Tapping on VPN Menu button");
			uiObject.vpn().tap();

		} catch(NoSuchElementException e) 
		{
			throw new AssertionError("Can't tap VPN button. Element absent or blocked");
		}
	}
	public void tapResultbutton()
	{
		try {
			MyLogger.logger.info("Tapping on Result Menu button");
			uiObject.results().tap();

		} catch(NoSuchElementException e) 
		{
			throw new AssertionError("Can't tap Results button. Element absent or blocked");
		}
	}
	public void tapToolsbutton()
	{
		try {
			MyLogger.logger.info("Tapping on Tools Menu button");
			uiObject.tools().tap();

		} catch(NoSuchElementException e) 
		{
			throw new AssertionError("Can't tap Tools button. Element absent or blocked");
		}
	}
	
	public void tapSettingbutton()
	{
		try {
			MyLogger.logger.info("Tapping on Settings Menu button");
			uiObject.tools().tap();

		} catch(NoSuchElementException e) 
		{
			throw new AssertionError("Can't tap Setting button. Element absent or blocked");
		}
	}

}
