package excercises.other;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromTheArray {
    public static void main(String[] args) {

        Integer[] arrayStorage = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 77, 77, 88, 99, 10, 11};
        System.out.println("justUsingList " + justUsingList(arrayStorage));
        System.out.println("usingHashSet " + usingHashSet(arrayStorage).stream().sorted().toList());
        System.out.println("using arrays " + Arrays.toString(usingArrays(arrayStorage)));
        System.out.println("Using distinct with Streams: " + usingDistinctWithStreams(arrayStorage));
        System.out.println("Using TreeSet: " + new TreeSet<>(Arrays.asList(arrayStorage)));
        System.out.println("Using stream toMap : " + Arrays.stream(arrayStorage).collect(Collectors.toMap(key -> key, value -> true, (oldValue, newValue) -> oldValue)).keySet().stream().sorted().collect(Collectors.toList()));
    }

    private static List<Integer> usingDistinctWithStreams(Integer[] arrayStorage) {
        List<Integer> distinctList = Arrays.stream(arrayStorage).distinct().sorted().collect(Collectors.toList());
        return distinctList;
    }

    private static Integer[] usingArrays(Integer[] arrayStorage) {
        int uniqueIndex = 0;

        for (int i = 1; i < arrayStorage.length; i++) {
            if (!Objects.equals(arrayStorage[i], arrayStorage[uniqueIndex])) {
                uniqueIndex++;
                arrayStorage[uniqueIndex] = arrayStorage[i];
            }
        }

        return Arrays.copyOf(arrayStorage, uniqueIndex + 1);
    }

    private static HashSet<Integer> usingHashSet(Integer[] arrayStorage) {
        HashSet<Integer> setStorage = new HashSet<>(Arrays.asList(arrayStorage));

        for (Integer setItem : setStorage) {
            if (setItem % 2 == 0) {
                System.out.println(true + " item '" + setItem);
            } else {
                System.out.println(false + " item '" + setItem);
            }
        }

        return setStorage;
    }

    private static ArrayList<Integer> justUsingList(Integer[] arrayStorage) {
        List<Integer> listStorage = Arrays.stream(arrayStorage).toList().stream().sorted().toList();

        ArrayList<Integer> noDuplicates = new ArrayList<>();

        for (int i = 0; i < listStorage.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(true + " item '" + listStorage.get(i));
            } else {
                System.out.println(false + " item '" + listStorage.get(i));
            }
            if (!noDuplicates.contains(listStorage.get(i))) {
                noDuplicates.add(listStorage.get(i));
            }
        }
        return noDuplicates;
    }
}
