package exercises.algos.questions;

import java.util.*;

/*
 Write a function to return the string that appears the maximum number of times.
- Assume only one string will have max count.
Input: ["owl", "eagle", "eagle", "hummingbird", "hummingbird", "eagle", "hummingbird"]
Output: should return "eagle" and "hummingbird". Return all strings with max count.
 */


public class NewtonCompany {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("owl", "eagle", "eagle", "hummingbird", "hummingbird", "eagle", "hummingbird");
        System.out.println(getMaxAmountOfWordAppearence(words));
    }

    public static List<String> getMaxAmountOfWordAppearence(List<String> list) {
        //add check for empty List
        HashMap<String, Integer> containerStorage = new HashMap<String, Integer>();
        for (String word : list) {
            //if empty values fouds remove
            // add modifying data to upper/lowercase
            if (containerStorage.containsKey(word)) {
                containerStorage.put(word, containerStorage.get(word) + 1);
            } else {
                containerStorage.put(word, 1);
            }
        }

        int maxAppearences = 0;
        List<String> expected = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : containerStorage.entrySet()) {
            if (entry.getValue() > maxAppearences) {
                maxAppearences = entry.getValue();
            }
        }

        for (Map.Entry<String, Integer> innerSet : containerStorage.entrySet()) {
            if (innerSet.getValue() == maxAppearences) {
                expected.add(innerSet.getKey());
                System.out.print("\ninnerSet max " + innerSet.getKey());
            }
        }

        return expected;
    }
}
