package exercises.implementing_annotations.needs_fresh_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.lang.reflect.Method;

public class SeleniumFixture {

  protected WebDriver driver;

  @BeforeClass
  public void startDriver() {
    config.LocalDesiredCapabilities localDesiredCapabilities = new config.LocalDesiredCapabilities();
    File chromeDriver = new File("src/test/resources/drivers/chromedriver.exe");
    System.setProperty(conf.TestProperties.CHROME_DRIVER, chromeDriver.getAbsolutePath());
                    /*try {
                        driver = new RemoteWebDriver(new URL("http://192.168.0.11:4444/wd/hub"), localDesiredCapabilities.chrome());
                        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }*/
    driver = new ChromeDriver(localDesiredCapabilities.chrome());
  }

  @BeforeMethod
  public void refreshDriver(Method m) {
      config.LocalDesiredCapabilities localDesiredCapabilities = new config.LocalDesiredCapabilities();
      System.out.println("Before method " + m.getName());
    if (m.getAnnotation(NeedsFreshDriver.class) != null) {
      System.out.println("Restarting the browser");
      driver.quit();
        driver = new ChromeDriver(localDesiredCapabilities.chrome());
    }
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    driver.quit();
  }
  
}
