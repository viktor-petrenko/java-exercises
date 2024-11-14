package excercises.algos.questions;

import java.util.Random;

public class MinMaxMatrix {

    public static void main(String[] args) {
        int rows = 5; // number of rows
        int columns = 5; // number of columns
        int[][] array = new int[rows][columns];

        Random random = new Random();

        // Fill the array with random integers between -10 and 10
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = random.nextInt(21) - 10; // Random integer from -10 to 10
            }
        }

        System.out.println(maxMatrixSum(array));
    }

    static int maxMatrixSum(int[][] matrix){
        int sum = 0, negativeCount = 0, min = 1_000_000_000;
        for(int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[row].length; column++){
                int num = matrix[row][column];
                 sum += Math.abs(num);
                if(num < 0) {
                    negativeCount++;
                }
                min = Math.min(min, Math.abs(num));
            }
        }
        if(negativeCount % 2 == 0){
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
}
