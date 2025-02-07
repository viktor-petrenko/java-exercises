package exercises.testng.iannotationtransformer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWithBug {

  @Test
  @Bug(1)
  public void testSomething() {
    Assert.assertEquals(2 * 2, 5);
  }
  
}
