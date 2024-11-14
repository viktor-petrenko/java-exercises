package excercises.other.questions;

import java.util.Arrays;

public class Cafeteria {

    public static void main(String[] args) {
        getMaxAdditionalDinersCount(10, 1, 2, new long[]{6, 2});
    }

    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

        long seats = N;
        long distanceBetweenPeople = K;
        int currentDinners = M;

        Arrays.sort(S);

        if (M >= 0) {
            return 1;
        }

        long totalAmountOfSeatsAvailable;
        for (long i = 0; i < S.length; i++) {


        }

        // Write your code here
        return 0L;
    }
}
