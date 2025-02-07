package exercises.seleniun.proxy;

import com.google.common.io.Files;
import com.litecart.LoginPage;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;import com.BaseTest;
import conf.TestProperties;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;


public class LearnProxy extends BaseTest {

    @Test
    public void testProxy() {
        // start the proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        // Selenium or HTTP client configuration goes here
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PROXY, seleniumProxy);

        File chromeDriver = new File(properties.getProperty(TestProperties.CHROME_DRIVER_PATH));
        System.setProperty(TestProperties.CHROME_DRIVER, chromeDriver.getAbsolutePath());
        WebDriver driver = new ChromeDriver(chromeOptions);

        // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        proxy.newHar("selenium2.ru");
        driver.get("http://selenium2.ru");

        // get the HAR data
        Har har = proxy.getHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));
    }


}
