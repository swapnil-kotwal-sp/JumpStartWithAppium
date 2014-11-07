import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumIOS {
  
  private AppiumDriver driver;
  
  @Before
  public void setUp() throws Exception {
    // set up appium
    // File appDir = new File(System.getProperty("user.dir"),
    // "../../../apps/TestApp/build/Release-iphonesimulator");
    // File app = new File(appDir, "TestApp.app");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("platformVersion", "6.1.3");
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("deviceName", "iPad");
    // capabilities.setCapability("app", app.getAbsolutePath());
    capabilities.setCapability("udid",
        "9da5df57b9755f3ab210299d6d3740e5b3545a6f");
    capabilities.setCapability("app", "com.vertis.iOS-Analytics-Generator");
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
        capabilities);
  }
  
  @Test
  public void example() throws Exception {
    // trigger computation by using the button
    WebElement button = driver.findElementByClassName("UIAButton");
    button.click();
    // is sum equal ?
    WebElement texts = driver.findElementByClassName("UIAStaticText");
  }
  
   @After
   public void tearDown() throws Exception {
   driver.quit();
   }
}