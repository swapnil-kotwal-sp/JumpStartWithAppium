

import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {
  private AppiumDriver driver;

  @Before
  public void setUp() throws Exception {
    // set up appium
    DesiredCapabilities capabilities = DesiredCapabilities.android();
    capabilities.setCapability("deviceName", "Tablet S4");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability(CapabilityType.VERSION, "4.3");
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
    capabilities.setCapability("androidPackage", "com.android.chrome");
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
        capabilities);

  }

  @Test
  public void openBrowsers(){
	  driver.get("http://google.com");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("hello Appium");
	  driver.findElement(By.name("btnG")).click();
  }
  
  @After  
  public void tearDown() throws Exception {  
     driver.quit();  
  } 
  
  @Test
  public void OpenBrowser() throws InterruptedException {
    driver.get("http://shared.ooyala.com/RCTTestAssets/v3_basic/v3_p.html");
    WebElement video_p = driver.findElement(By.xpath("html/body/ol/li[1]/a"));
    video_p.click();
    pause(1000);
    isElementPresent("oo_start_button");
    WebElement play = driver.findElementByClassName("oo_start_button");
    play.click();
    System.out.println("Clicked");
    pause(1000);
    if (isElementPresent("oo_tap_panel") == true) {
      pause(1000);
      hover("//*[@class='oo_tap_panel']");
      WebElement pause = driver.findElement(By
          .xpath("//*[@class='oo_button oo_toolbar_item oo_pause']"));
      pause.click();
      hover("//*[@class='oo_tap_panel']");
      String CT = getTime("//*[@class='oo_label oo_currentTime']");
      System.out.print(CT);
      hover("//*[@class='oo_tap_panel']");
      WebElement play1 = driver.findElement(By
          .xpath("//*[@class = 'oo_button oo_toolbar_item oo_play']"));
      play1.click();
      String ET = getTime("//*[@class = 'oo_label oo_duration']");
      System.out.println(ET);

      do {
        hover("//*[@class='oo_tap_panel']");
        pause(4000);

      } while (compareStrings(CT, ET) != true);

    }
    WebElement replay = driver.findElement(By
        .xpath("//*[@class = 'oo_replay']"));
    replay.click();
    {
      System.out.println("Can not Replay!Some thing went wrong");
    }
  }

  /*
   * WebElement fullscreen = driver.findElement(By.xpath(
   * "//*[@class='oo_button oo_toolbar_item oo_fullscreen oo_fullscreen_on']"));
   * fullscreen.click(); hover("//*[@class='oo_tap_panel']"); WebElement
   * exit_fullscreen = driver.findElement(By.xpath(
   * "//*[@class='oo_button oo_toolbar_item oo_fullscreen oo_fullscreen_off']"
   * )); exit_fullscreen.click();
   */

  /*
   * @After public void CloseBrowser() throws InterruptedException {
   * driver.quit(); }
   */
  public boolean isElementPresent(String classname) {

    int count = driver.findElements(By.className(classname)).size();
    if (count != 0) {
      return true;
    } else {
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      return false;
    }
  }

  public boolean isElementPresentOne(String Xpath) {
    int count1 = driver.findElements(By.xpath(Xpath)).size();
    if (count1 != 0) {
      return true;
    } else {
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      return false;
    }
  }

  public void hover(String xpath) {
    Actions ac = new Actions(driver);
    WebElement we = driver.findElement(By.xpath(xpath));
    ac.moveToElement(we).perform();

  }

  public void pause(int miliseconds) throws InterruptedException {
    Thread.sleep(miliseconds);
  }

  public String getTime(String xpath) {

    String str = driver.findElement(By.xpath(xpath)).getText();
    // System.out.println(str);
    return str;
  }

  public boolean compareStrings(String one, String two) {

    if (one.equals("two")) {
      return true;

    } else {
      return false;
    }

  }
}