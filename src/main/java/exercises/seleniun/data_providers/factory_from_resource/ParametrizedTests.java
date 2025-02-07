package exercises.seleniun.data_providers.factory_from_resource;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ParametrizedTests extends TestBase {
  
  @Factory
  public Object tf() {
    return new Object[]{
    };
  }

  public ParametrizedTests(String resource) {
    super(resource);
  }

  @Test(dataProvider = "loadUserFromResource")
  public void test1(String user, String password) {
    System.out.println(user + ":" + password);
  }

}
