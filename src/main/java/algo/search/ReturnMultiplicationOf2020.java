package algo.search;

import java.util.Arrays;
import java.util.List;

public class ReturnMultiplicationOf2020 {
    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        System.out.println(find2020sum(numbersList));
    }

    // let numbersArray = [1721, 979, 366, 299, 675, 1456];
    public static Integer find2020sum(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            for (int n = 0; i < list.size(); i++) {
                System.out.println("inner loop i '" + list.get(i) + "'");
                System.out.println("inner loop n '" + list.get(n) + "'");
                int multiplication  = list.get(n) * list.get(i);

                if (list.get(n) + list.get(i) == 2020) {
                    System.out.println("Result " + " " + list.get(n) + " + " + list.get(i) + "=" + list.get(n) + list.get(i));
                    System.out.println("Result " + " " + list.get(n) + " * " + list.get(i) + "=" + multiplication);
                    return multiplication;
                }
            }
        }
        return null;
    }
}