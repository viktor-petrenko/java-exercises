package exercises.seleniun.data_providers.factory_from_resource;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBase {

    private String resource;

    protected TestBase(String resource) {
        this.resource = resource;
    }

    @DataProvider
    public Iterator<Object[]> loadUserFromResource() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(TestBase.class.getResourceAsStream(resource)));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }

}
