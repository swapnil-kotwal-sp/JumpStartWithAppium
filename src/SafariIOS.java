
import io.appium.java_client.AppiumDriver;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SafariIOS {
  
  private AppiumDriver driver;
  
  @Before
  public void setUp() throws Exception {
    // set up appium
    // File appDir = new File(System.getProperty("user.dir"),
    // "../../../apps/TestApp/build/Release-iphonesimulator");
    // File app = new File(appDir, "TestApp.app");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("platformVersion", "6.1.2");
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("deviceName", "iPad");
    capabilities.setCapability("browserName", "safari");
    // capabilities.setCapability("app", app.getAbsolutePath());
//    capabilities.setCapability("udid",
//        "bd417b870e006b8a7ea0c9e300f6ea5174c99795");
//    capabilities.setCapability("app", "com.vertis.iOS-Analytics-Generator");
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
        capabilities);
  }
  
  @Test
  public void example() throws Exception {
   driver.get("http://google.com");
  }
  
   @After
   public void tearDown() throws Exception {
//   driver.quit();
   }
}