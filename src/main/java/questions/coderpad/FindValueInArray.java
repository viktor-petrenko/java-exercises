package questions.coderpad;

import java.util.Arrays;

class findValueInArray {

    static boolean exists(int[] ints, int k) {
        // Using Arrays.binarySearch to perform binary search
        int result = Arrays.binarySearch(ints, k);

        // Arrays.binarySearch returns index of the search key, if it is contained in the array; 
        // otherwise, it returns (-(insertion point) - 1). If result is non-negative, the element exists.
        return result >= 0;
    }

    public static void main(String[] args) {
        // Test cases
        int[] ints = {-9, 14, 37, 102};
        System.out.println("102 exists: " + exists(ints, 102)); // Should return true
        System.out.println("36 exists: " + exists(ints, 36)); // Should return false

        // Edge case: Empty array
        int[] empty = {};
        System.out.println("5 exists in empty: " + exists(empty, 5)); // Should return false

        // Large array test
        int[] largeArray = new int[1000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2; // Populate with even numbers only
        }
        System.out.println("999999 exists: " + exists(largeArray, 999999)); // Should return false
        System.out.println("100000 exists: " + exists(largeArray, 100000)); // Should return true
    }
}