package misc.meta;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Battleship {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        int[][] matrix = new int[rows][columns];

        System.out.println(getHitProbability(rows, columns, matrix));
    }

    public static double getHitProbability(int R, int C, int[][] G) {
        // Write any import statements here

        for (int[] row : G)
            Arrays.fill(row, ThreadLocalRandom.current().nextInt(0, 2));

        System.out.println(Arrays.deepToString(G));

        double ships = 0;
        for (int[] row : G) {
            for (int val : row) {  // Visit each cell in the row
                ships += val; // Add the cell's value unconditionally
            }
        }
        return ships / (G.length * G[0].length);
    }
}
