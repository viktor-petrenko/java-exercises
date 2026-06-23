package leetcode;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
       // copyAndSort(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
       // copyAndSort(new int[]{1}, 1, new int[]{}, 0);
       // copyAndSort(new int[]{0}, 0, new int[]{1}, 1);
       // copyAndSort(new int[]{2, 0}, 1, new int[]{1}, 1);
       // copyAndSort(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);

        twoPointersAplusB(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        twoPointersAplusB(new int[]{1}, 1, new int[]{}, 0);
        twoPointersAplusB(new int[]{0}, 0, new int[]{1}, 1);
        twoPointersAplusB(new int[]{2, 0}, 1, new int[]{1}, 1);
        twoPointersAplusB(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }


    public static void copyAndSort(int[] nums1, int m, int[] nums2, int n) {
        if (n > 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
        }
        Arrays.sort(nums1);
        System.out.println("nums1 = " + Arrays.toString(nums1) + ", m = " + m + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
        System.out.println("nums1 = " + Arrays.toString(nums1));
    }

    public static void twoPointersAplusB(int[] nums1, int m, int[] nums2, int n) {
        int realValueNums1 = m - 1;        // last real value in nums1
        int realValueNums2 = n - 1;        // last value in nums2
        int lastFreePosition = m + n - 1;    // last free position in nums1

        System.out.println("realValueNums1 = " + realValueNums1);
        System.out.println("realValueNums2 = " + realValueNums2);
        System.out.println("lastFreePosition = " + lastFreePosition);

        while(realValueNums2 >= 0) {
            if(realValueNums1 >= 0 && nums1[realValueNums1] > nums2[realValueNums2] ){
                nums1[lastFreePosition] = nums1[realValueNums1];
                realValueNums1--;
            } else {
                nums1[lastFreePosition] = nums2[realValueNums2];
                realValueNums2--;
            }
            lastFreePosition--;
        }

        System.out.println("nums1 = " + Arrays.toString(nums1));
    }



}