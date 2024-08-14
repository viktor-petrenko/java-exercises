package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
        Collections.sort(arr);

        long min = 0, max = 0;
        for (int i = 0; i < 4; i++) {
            min += arr.get(i);
            max += arr.get(arr.size() - 4 + i);
        }

        System.out.println(min + " " + max);
    }
}