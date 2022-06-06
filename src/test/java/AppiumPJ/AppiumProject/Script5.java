package AppiumPJ.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Script5 
{
	RemoteWebDriver driver;
	
	  @Test
	  public void KhanAcademy_Explore_Science() throws InterruptedException
	  {
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("Search tab")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Science\")")).click();
		Thread.sleep(3000);
		  
		Dimension d= driver.manage().window().getSize();
		int width=d.width;
		int height=d.height;
		int x1=width/2;
		int y1=(int) (height * 0.8);
		int x2=width/2;
		int y2=(int) (height * 0.4);

		while(driver.findElements(AppiumBy.androidUIAutomator("UiSelector().text(\"Class 12 Biology (India)\")")).size()==0) 
		{
			driver.executeScript("mobile:shell", ImmutableMap.of("command","input swipe "+x1+" "+y1+" "+x2+" "+y2));
			Thread.sleep(3000);
		}
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Class 12 Biology (India)\")")).click();
		Thread.sleep(3000);
		
		
		//check whether page is displayed
		String expected = "Reproduction";
		String actual = driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Reproduction\")")).getText();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
		Thread.sleep(3000);  
		
		//click Home
		driver.findElement(AppiumBy.accessibilityId("Explore tab")).click();
		Thread.sleep(4000);
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
