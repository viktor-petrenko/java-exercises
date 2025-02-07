package exercises.implementing_annotations.ignore_in_browser;

import org.testng.annotations.Test;

import static tests.testng.tricky2.sample31.IgnoreInBrowser.Browser.CHROME;

public class SeleniumTest extends SeleniumFixture {

  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test

  @IgnoreInBrowser(CHROME)
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
