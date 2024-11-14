package typicode;

import com.fasterxml.jackson.databind.JsonNode;
import excercises.rest.typicode.clients.TypiCodeService;
import excercises.rest.typicode.clients.pojos.EntityInformation;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class HappyPathTestTypicode {
    @Test()
    public void TestGetUsers() {
        for (EntityInformation entity : TypiCodeService.getUsersPlain()) {
            System.out.println(entity.getName());
        }
    }

    @Test()
    public void TestGetUsersJson() {
        for (JsonNode node : TypiCodeService.getUsersJson()) {
            // Get the "name" field
            String name = node.get("name").asText();
            System.out.println("Name: " + name);
        }
    }

    @Test()
    public void TestRestAssured() {
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.JACKSON_2));

        Response response = given().baseUri("https://jsonplaceholder.typicode.com")
                .when().get("/users");
/**
 *     Given: Specifies the base URI, sets the header to accept JSON, and adds a query parameter userId.
 *     When: Defines the HTTP method as GET and the endpoint /users.
 *     Then: Asserts the expected status code (200) and checks that the response contains specific values for the name and email fields.
 */
        JsonPath jsonPath = response.jsonPath();

        List<String> names = jsonPath.getList("name");

        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }

}
