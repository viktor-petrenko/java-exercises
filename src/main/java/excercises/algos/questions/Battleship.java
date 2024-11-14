package excercises.algos.questions;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Battleship {
    public static void main(String[] args) {
        int rows = 9;
        int columns = 7;
        int[][] matrix = new int[rows][columns];

        System.out.println(getHitProbability(rows, columns, matrix));
    }

    public static double getHitProbability(int R, int C, int[][] field) {
        for (int[] row : field)
            Arrays.fill(row, ThreadLocalRandom.current().nextInt(0, 2));

        System.out.println(Arrays.deepToString(field));

        double ships = 0;
        for (int[] row : field) {
            for (int cell : row) {  // Visit each cell in the row
                ships += cell; // Add the cell's value unconditionally
            }
        }
        return ships / (field.length * field[0].length);
    }
}
