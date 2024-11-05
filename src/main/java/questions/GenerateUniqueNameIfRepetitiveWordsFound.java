 package questions;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerateUniqueNameIfRepetitiveWordsFound {

    public static void main(String[] args) {
        System.out.println(deviceNamesSystem(Arrays.asList("switch", "tv", "switch", "tv", "switch")));
    }

    public static List<String> deviceNamesSystem(List<String> devicenames) {
        HashMap<String, Integer> nameStorage = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        for (String name : devicenames) {
            if (!nameStorage.containsKey(name)) {
                resultList.add(name);
                nameStorage.put(name, 1);
            } else {
                int suffix = nameStorage.get(name);
                while (nameStorage.containsKey(name + suffix)) {
                    suffix++;
                }
                String uniqueName = name + suffix;
                resultList.add(uniqueName);
                nameStorage.put(name, suffix + 1);
                nameStorage.put(uniqueName, 1);
            }
        }

        return resultList;
    }
}
