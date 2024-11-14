package excercises.algos.questions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 */


public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        miniMaxSum(arr);

    }

    public static void miniMaxSum(List<Integer> arr) {
        cleverWay(arr);
        straighforwardWay(arr);
        geniusWay(arr);
    }

    private static void geniusWay(List<Integer> arr) {
        long totalSum = 0;
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        // Calculate total sum and find min and max elements in a single loop
        for (int num : arr) {
            totalSum += num;
            if (num < minElement) minElement = num;
            if (num > maxElement) maxElement = num;
        }

        long minSum = totalSum - maxElement; // Excluding the maximum element
        long maxSum = totalSum - minElement; // Excluding the minimum element

        System.out.println(minSum + " " + maxSum);
    }

    private static void straighforwardWay(List<Integer> arr) {
        Collections.sort(arr);
        Integer minSum = 0;
        Integer maxSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + " in the list " + arr.get(i));
            Integer sum = 0;
            //go left
            for (int l = i - 1; l >= 0; l--) {
                sum += arr.get(l);
                System.out.println("going left " + arr.get(l));
            }
            //go right
            for (int r = i + 1; r < arr.size(); r++) {
                sum += arr.get(r);
                System.out.println("going right " + arr.get(r));
            }

            System.out.println("Sum at the '" + i + " is '" + sum);

            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < maxSum) {
                minSum = sum;
            }
        }

        System.out.println(minSum + " " + maxSum);
    }

    private static void cleverWay(List<Integer> arr) {
        Collections.sort(arr);

        long min = 0, max = 0;
        for (int i = 0; i < 4; i++) {
            min += arr.get(i);
            max += arr.get(arr.size() - 4 + i);
        }

        System.out.println(min + " " + max);
    }


}
