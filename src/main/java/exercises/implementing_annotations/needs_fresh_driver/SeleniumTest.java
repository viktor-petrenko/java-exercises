package exercises.implementing_annotations.needs_fresh_driver;

import org.testng.annotations.Test;

public class SeleniumTest extends SeleniumFixture {

  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test
  @NeedsFreshDriver
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
