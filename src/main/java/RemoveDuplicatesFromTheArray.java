import java.util.*;

public class RemoveDuplicatesFromTheArray {
    public static void main(String[] args) {

        Integer[] arrayStorage = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 77, 77, 88, 99, 10, 11};
        justUsingList(arrayStorage);

        HashSet<Integer> setStorage = new HashSet<>(Arrays.asList(arrayStorage));

        for (Integer setItem : setStorage) {
            if (setItem % 2 == 0) {
                System.out.println(true + " item '" + setStorage);
            } else {
                System.out.println(false + " item '" + setStorage);
            }
        }

        System.out.println(setStorage);
    }

    private static void justUsingList(Integer[] arrayStorage) {
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
        System.out.println(noDuplicates);
    }
}
