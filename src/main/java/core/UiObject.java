package core;

import java.util.NoSuchElementException;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import api.android.Android;


public class UiObject {
	private String locator;
	public UiObject(String locator) {
		this.locator=locator;
		
	}
	
	private boolean isXpath()
	{
		return !locator.contains("UiSelector");
	}
	
	public boolean exists(){
		try
		{
			WebElement element;
			if(isXpath()) element=Android.driver.findElementByXPath(locator);
			else element=Android.driver.findElementByAndroidUIAutomator(locator);
			return element.isDisplayed();
		}catch (NoSuchElementException e) {
			return false;
		}
		
	
	}
	
	public boolean isChecked()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("checked").equals("true");
	}
	
	public boolean isCheckable()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("checkable").equals("true");
	}
	public boolean isClickable()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("clickable").equals("true");
	}
	
	public boolean isEnabled()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("enabled").equals("true");
	}
	public boolean isFocusable()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("focusable").equals("true");
	}
	public boolean isFocused()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("focused").equals("true");
	}
	public boolean isScrollable()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("Scroallble").equals("true");
	}
	public boolean isLongClickable()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("longClickable").equals("true");
	}
	public boolean isSelected()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("selected").equals("true");
	}
	
	public Point getLocation()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getLocation();
	}
	
	public String getText()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("name");
	}
	public String getResourceId()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("resourceid");
	}
	public String getClassName()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("classname");
	}
	public String getContentDesc()
	{
		WebElement element;
		if(isXpath()) element=Android.driver.findElementByXPath(locator);
		else element=Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("contentDesc");
	}
	
	public UiObject clearText()
	{
		
		if(isXpath()) Android.driver.findElementByXPath(locator).clear();
		else Android.driver.findElementByAndroidUIAutomator(locator).clear();  
		return this;
	}
	
	public UiObject typeText(String value)
	{
		
		if(isXpath()) Android.driver.findElementByXPath(locator).sendKeys(value);
		else Android.driver.findElementByAndroidUIAutomator(locator).sendKeys(value);  
		return this;
	}
	
	public UiObject tap()
	{
		
		if(isXpath()) Android.driver.findElementByXPath(locator).click();
		else Android.driver.findElementByAndroidUIAutomator(locator).click();  
		return this;
	}
	
	public UiObject scrollTo()
	{
		return this;
	}
	
	public UiObject waitToAppear(int seconds)
	{
		Timer timer= new Timer();
		timer.start();
		while(timer.expired(seconds)) if (exists()) break;
		if(timer.expired(seconds) && !exists()) throw new AssertionError("Element"+locator+" failed to appear within"+seconds+"seconds");
		return this;
	}
	
	public UiObject waitToDisappear(int seconds)
	{
		Timer timer= new Timer();
		timer.start();
		while(timer.expired(seconds)) if (!exists()) break;
		if(timer.expired(seconds) && exists()) throw new AssertionError("Element"+locator+" failed to disappear within"+seconds+"seconds");
		return this;
	}
	
}
