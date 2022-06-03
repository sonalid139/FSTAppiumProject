package AppiumPJ.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Script7 
{
	RemoteWebDriver driver;
	
	  @Test
	  public void KhanAcademy_Explore_Economy() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  driver.findElement(AppiumBy.accessibilityId("Search tab")).click();
		  Thread.sleep(3000);
		  driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Life skills\")")).click();
		  Thread.sleep(3000);
		  
		  //while(driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Camp Khan\")")).isDisplayed())
			  
		  driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Camp Khan\")")).click();
		  Thread.sleep(8000);
		  //check whether page is displayed
		  String expected = "Interest and debt";
		  String actual = driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Interest and debt\")")).getText();
		  System.out.println(actual);
		  Assert.assertEquals(expected, actual);
		  
		  //click Home
		  driver.findElement(AppiumBy.accessibilityId("Explore tab")).click();
		  Thread.sleep(5000);
	  }
	  
	  @BeforeClass
	  public void LaunchBrowser() throws InterruptedException, MalformedURLException 
	  {
		  DesiredCapabilities capability = new DesiredCapabilities();
		  capability.setCapability("deviceName", "emulator-5554");
		  capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
		  capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
		  driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		  Thread.sleep(3000);	  
	  }

	  @AfterClass
	  public void CloseBrowser()
	  {
		  driver.quit();
	  }  
}
