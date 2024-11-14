package excercises.algos.questions;


import java.util.*;

public class FindAmountOfSumsWhichAreDividablePowerOfThree {

    public static long searchForPairs(List<Integer> price) {
        // Precompute all powers of 3 up to 10^10 and store in a HashSet
        Set<Long> powersOfThree = new HashSet<>();
        long power = 1;
        while (power <= 1e10) {
            powersOfThree.add(power);
            power *= 3;
        }

        long count = 0;
        int n = price.size();

        // Iterate over all pairs (i, j) with i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = (long) price.get(i) + price.get(j);
                // Check if sum is a power of three by looking it up in the HashSet
                if (powersOfThree.contains(sum)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long searchForPairs2(List<Integer> price) {
        // The largest power of three that fits within our range
        final long maxPowerOfThree = 1162261467;

        long count = 0;
        int n = price.size();

        // Iterate over all pairs (i, j) with i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = (long) price.get(i) + price.get(j);
                // Check if the sum is a power of three
                if (sum > 0 && maxPowerOfThree % sum == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(searchForPairs2(Arrays.asList(1,2,5,6,7))); // Output: 3
         System.out.println(searchForPairs(Arrays.asList(1,2,5,6,7))); // Output: 5
    }
}
