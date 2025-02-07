package exercises.seleniun.assertions;


import org.openqa.selenium.WebDriver;

public class SeleniumTestBase{

    private final WebDriver driver;

    public SeleniumTestBase(WebDriver driver) {
        super();
        this.driver = driver;
    }
}
