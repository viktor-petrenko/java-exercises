package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import java.util.logging.Level;


public abstract class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class.getSimpleName());

    public static final String RESOURCES_FOLDER = "src/test/resources/";
    public static final String configFile = "src/test/resources/config/local.properties";

    public static WebDriverWait wait;
    public static Properties properties;

    public static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return properties.getProperty(propertyName);
        } else {
            System.getProperty(propertyName);
        }
        return propertyName;
    }

    public static String getBaseUrl() {
        return getProperty("url");
    }
}