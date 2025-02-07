package exercises.seleniun.data_providers.annotated_data_provider.csv;

import org.testng.annotations.Test;

public class SampleTest {

  @Test(enabled = false, dataProvider = "csvDataProvider", dataProviderClass = CsvDataProviders.class)
  @CsvDataSource("src/test/resources/user.data")
  public void testCsv(String par1, String par2) {
    System.out.println("Hello, " + par1 + "," + par2);
  }

  @Test(enabled = true, dataProvider = "lazyCsvDataProvider", dataProviderClass = CsvDataProviders.class)
  @CsvDataSource("src/test/resources/user.data")
  public void testLazyCsv(String par1, String par2) {
    System.out.println("Hello, " + par1 + "," + par2 );
  }



}
