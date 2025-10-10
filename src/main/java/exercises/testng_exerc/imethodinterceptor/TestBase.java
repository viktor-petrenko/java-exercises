package exercises.testng_exerc.imethodinterceptor;

public class TestBase implements HasPriority {

  private int p;

  @Override
  public int getPriority() {
    return p;
  }

  @Override
  public void setPriority(int p) {
    this.p = p;
  }

}
