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

public class AppiumAndroid {
  
  private AppiumDriver driver;
  
  @Before
  public void setUp() throws Exception {
    // set up appium
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("platformVersion", "4.3");
    capabilities.setCapability("platformName", "Selendroid");
    capabilities.setCapability("deviceName", "Android");
    capabilities
        .setCapability("androidPackage", "com.ooyala.android.analytics");
    capabilities.setCapability("appActivity",
        "com.ooyala.android.analytics.LoginActivity");
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
        capabilities);
  }
  
  @Test
  public void firsttest() {
    WebElement HelloButton = driver.findElement(By.name("HLS Asset"));
    HelloButton.click();
    List<WebElement> allText = driver.findElements(By
        .className("android.widget.EditText"));
//    allText.get(0).sendKeys("");
    allText.get(0).sendKeys("Swap");
//    allText.get(1).sendKeys("");
    allText.get(1).sendKeys("swap@g.com");
    
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}