package excercises.other.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateListWithBiggestNumberBasedOnStatePassed {

    public static List<Integer> generateListBasedOnParameters(int[] arr, String state, int m) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        char[] stateArr = state.toCharArray();

        for (int op = 0; op < m; op++) {
            // Find the largest available element
            int maxElement = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int i = 0; i < n; i++) {
                if (stateArr[i] == '1' && arr[i] > maxElement) {
                    maxElement = arr[i];
                    maxIndex = i;
                }
            }

            // Add the largest element to the result
            result.add(maxElement);

            // Update the state to make more elements available
            char[] newStateArr = Arrays.copyOf(stateArr, n);
            for (int i = 1; i < n; i++) {
                if (stateArr[i] == '0' && stateArr[i - 1] == '1') {
                    newStateArr[i] = '1';
                }
            }
            stateArr = newStateArr;  // Update state to reflect the new availability
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 7, 6};
        String state = "0101";
        int m = 3;

        List<Integer> result = generateListBasedOnParameters(arr, state, m);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
