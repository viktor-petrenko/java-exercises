package exercises.seleniun.data_providers.annotated_data_provider.list_array;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SampleTest {

    @SuppressWarnings("unused")
    public static String[] sampleArray = new String[]{"aaa", "bbb", "ccc"};

    @SuppressWarnings("unused")
    public static List<String> sampleList = new ArrayList<String>() {{
        add("aaaaaa");
        add("bbbbb");
        add("ccc");
    }};

    @Test(enabled = false, dataProvider = "arrayDataProvider", dataProviderClass = SingleParameterDataProviders.class)
    @SingleParameterDataSource("sampleArray")
    public void testArray(String param) {
        System.out.println("Hello, " + param);
    }

    @Test(enabled = true, dataProvider = "listDataProvider", dataProviderClass = SingleParameterDataProviders.class)
    @SingleParameterDataSource("sampleList")
    public void testList(String param) {
        System.out.println("Hello, " + param);
    }

}
