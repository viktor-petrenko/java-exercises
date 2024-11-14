package excercises.other;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson {
    public static void main(String args[]) throws IOException {
        CustomerDetails customerDetails = new CustomerDetails().setAge(11).setLastname("last Name").setName("first name");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("excercises/other/jackson"), customerDetails);
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerDetails);

        ObjectMapper reader = new ObjectMapper();
        CustomerDetails customerDetails1 = reader.readValue(new File("excercises/other/jackson"), CustomerDetails.class);

    }
}
