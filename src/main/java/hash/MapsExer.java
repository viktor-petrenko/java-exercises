package hash;

import java.util.HashMap;
import java.util.Map;

public class MapsExer {
    // NOT SYNCRONIZED
    public static void main(String[] args) {
        // NOT SORTED, if sorting needed use TreeMap
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Adam");
        map.put(2, "Kevin");
        map.put(3, "Ana");
        map.put(4, "Lucy");
        map.put(null, "This is null");

        // removing non-existing data dont cause issues.
        map.remove(99);

        // We can retrieve items based on keys 0(1) if no collisions
        // NULL KEYS
        System.out.println("key which is not preset : " + map.get(70));
        System.out.println("null : " + map.get(null) + "\n");

        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
