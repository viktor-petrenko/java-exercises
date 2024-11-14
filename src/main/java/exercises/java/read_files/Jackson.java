package exercises.java.read_files;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson {
    public static String JACKSON_FILEPATH = "java/exercises/java/read_files/jackson.json";

    public static void main(String args[]) throws IOException {
        CustomerDetails initialDetails = getCustomerDetails();

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(JACKSON_FILEPATH);
        objectMapper.writeValue(file, initialDetails);
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(initialDetails);

        ObjectMapper reader = new ObjectMapper();
        CustomerDetails fileData = reader.readValue(new File(JACKSON_FILEPATH), CustomerDetails.class);

        System.out.println(fileData);
    }

    private static CustomerDetails getCustomerDetails() {
        return new CustomerDetails().setAge(11).setLastname("last Name").setName("first name");
    }
}
