package exercises.seleniun.video_screenshot;

import com.LocalDesiredCapabilities;
import conf.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

@Listeners(VideoListener.class)
public class MyTest {

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
  
  @Test
  public void test1() {
    driver.get("http://www.seleniumhq.org/");
  }

  @Test
  public void test2() {
    driver.get("http://selenium2.ru/");
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    driver.quit();
  }
  
}
