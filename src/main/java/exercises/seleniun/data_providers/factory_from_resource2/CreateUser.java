package exercises.seleniun.data_providers.factory_from_resource2;

import org.testng.annotations.Test;

public class CreateUser {

  private String user;
  private String password;
  
  public CreateUser(String user, String password) {
    this.user = user;
    this.password = password;
  }

  @Test
  public void testCreateUser() {
    System.out.println("testCreateUser " + user + ":" + password);
  }

}
