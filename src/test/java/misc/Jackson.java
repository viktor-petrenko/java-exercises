package misc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class Jackson {
    public static void main(String args[]) throws IOException {
        CustomerDetails customerDetails = new CustomerDetails().setAge(11).setLastname("last Name").setName("first name");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("jackson"), customerDetails);
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerDetails);

        ObjectMapper reader = new ObjectMapper();
        CustomerDetails customerDetails1 = reader.readValue(new File("jackson"), CustomerDetails.class);

    }
}
