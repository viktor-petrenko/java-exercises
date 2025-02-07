package exercises.hamcrest;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SoftHamcrestTest {
  
  @Test
  public void testHardAssert() {
    assertThat("Three", 2 * 2, is(3));
    assertThat("Five", 2 * 2, is(5));
  }

  @Test
  public void testSoftAssert() {
    SoftHamcrestAssert h = new SoftHamcrestAssert();
    h.assertThat("Three", 2 * 2, is(3));
    h.assertThat("Five", 2 * 2, is(5));
    h.assertAll();
  }
}
