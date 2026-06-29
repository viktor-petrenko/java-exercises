package leetcode;

public class RemoveElementFromArray27 {
    public static void main(String[] args) {
        removeElement(new int[]{0, 3,2,2,3}, 3);
    }


    public static int removeElement(int[] nums, int val) {
//     nums = Arrays.stream(nums).filter(i -> i != val).toArray();

        //    return nums.length;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;

//        int[] nums2 = Arrays.stream(nums).parallel().filter(i -> i != val).toArray();
//        System.out.println(Arrays.toString(nums2));
//        int length = nums2.length;
//        System.out.println(length);
//        return length;
    }

}