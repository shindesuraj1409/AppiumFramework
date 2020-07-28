package api.apps.speedtest.home;

import org.openqa.selenium.support.PageFactory;

import core.CommonAppiumTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePagePom extends CommonAppiumTest
{
	public HomePageUiPageObjects objects= new HomePageUiPageObjects();
	AndroidDriver<MobileElement> driver;
	public HomePagePom(AndroidDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), objects);
		
	}
	
	public void tapGoButton()
	{
		
		objects.goButton.click();
	}

}
