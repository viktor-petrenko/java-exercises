package exercises.selenium.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SeleniumAssertionsTest extends SeleniumTestBase {

    public SeleniumAssertionsTest(WebDriver driver) {
        super(driver);
    }

    @Test
  public void testAssertion() {
    SeleniumAssertion check = new SeleniumAssertion(getDriver());
      getDriver().get("http://selenium2.ru/");
    check.assertPresentElementLocated(By.id("header1"));
    check.assertDisplayed(getDriver().findElement(By.id("header")));
  }

}
