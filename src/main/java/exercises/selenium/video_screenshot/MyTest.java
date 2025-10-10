package exercises.selenium.video_screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

@Listeners(VideoListener.class)
public class MyTest {

  protected WebDriver driver;

  @BeforeClass
  public void startDriver() {
    File chromeDriver = new File("src/test/resources/drivers/chromedriver.exe");
    System.setProperty(conf.TestProperties.CHROME_DRIVER, chromeDriver.getAbsolutePath());
                    /*try {
                        driver = new RemoteWebDriver(new URL("http://192.168.0.11:4444/wd/hub"), localDesiredCapabilities.chrome());
                        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }*/

    driver = new ChromeDriver();
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
