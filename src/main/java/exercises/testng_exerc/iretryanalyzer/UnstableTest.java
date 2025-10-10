package exercises.testng_exerc.iretryanalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnstableTest {
  
  private static int attempt = 1;
  
  @Test(retryAnalyzer = RunUntilSuccess.class)
  public void randomlyFailingTest() {
    if (attempt == 3) {
      attempt = 1;

    } else {
      Assert.fail("Failed on " + (attempt++) + " attempt");
    }
  }

}
