package algo.search;

import java.util.Arrays;

public class FindUniqueElement {
    public static int findUnique(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1; // Divide the search space into two halves by finding the middle index “mid”.

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is even or odd
            if (mid % 2 == 1) {
                mid--;
            }

            // If the pair matches, move to the right half
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // Otherwise, move to the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 4, 2, 3, 4, 0};
        int unique = findUnique(nums);
        System.out.println("The unique element is: " + unique); // Output: The unique element is: 5
    }
}
