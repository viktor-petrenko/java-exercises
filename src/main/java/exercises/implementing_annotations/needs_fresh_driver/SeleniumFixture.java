package exercises.implementing_annotations.needs_fresh_driver;

import com.LocalDesiredCapabilities;
import conf.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.io.File;
import java.lang.reflect.Method;

public class SeleniumFixture {

  protected WebDriver driver;

  @BeforeClass
  public void startDriver() {
    LocalDesiredCapabilities localDesiredCapabilities = new LocalDesiredCapabilities();
    File chromeDriver = new File("src/test/resources/drivers/chromedriver.exe");
    System.setProperty(TestProperties.CHROME_DRIVER, chromeDriver.getAbsolutePath());
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
    System.out.println("Before method " + m.getName());
    if (m.getAnnotation(NeedsFreshDriver.class) != null) {
      System.out.println("Restarting the browser");
      driver.quit();
      driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
    }
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    driver.quit();
  }
  
}
