package exercises.seleniun.data_providers.dataprovider_from_file;

import org.testng.annotations.Test;

public class ParametrizedTests {

  @Test(dataProviderClass = DataProviders.class, dataProvider = "loadUserFromFile")
  public void test1(String user, String password) {
    System.out.println(user + ":" + password);
  }

}
