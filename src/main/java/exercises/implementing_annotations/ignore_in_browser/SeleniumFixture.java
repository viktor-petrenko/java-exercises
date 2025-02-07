package exercises.implementing_annotations.ignore_in_browser;

import com.LocalDesiredCapabilities;
import conf.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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
  public void ignoreInBrowser(Method m) {
    IgnoreInBrowser ignore = m.getAnnotation(IgnoreInBrowser.class);
    if (ignore != null) {
      String browser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
      IgnoreInBrowser.Browser [] ignoredBrowsers = ignore.value();
      for (IgnoreInBrowser.Browser  ignoredBrowser : ignoredBrowsers) {
        if (ignoredBrowser.name().toLowerCase().equals(browser)) {
          throw new SkipException("Ignored in browser " + browser);
        }
      }
    }
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    driver.quit();
  }
  
}
