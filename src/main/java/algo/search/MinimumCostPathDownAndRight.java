package algo.search;

import java.util.Arrays;

public class MinimumCostPathDownAndRight {

    /**
     * Given a matrix of integers matrix of size n*m, where each element matrix[i][j]
     * represents the cost of passing from that cell,
     * create a function that returns the cost of the minimum cost path to go
     * from the top left cell to the right bottom cell,
     * knowing that you can only move to the right or to the bottom.
     *
     * Example 1:
     * <p>
     * Input: matrix = [[3, 12, 4, 7, 10], [6, 8, 15, 11, 4], [19, 5, 14, 32, 21], [1, 20, 2, 9, 7]]
     * Output: 54
     *
     * @param originalGrid 2D integer matrix
     * @return Minimum path sum from top-left to bottom-right
     */
    public static int minPathSum(int[][] originalGrid) {
        int maxRows = originalGrid.length;
        int maxCollms = originalGrid[0].length;

        // Create a DP table to store the minimum path sum to each cell
        int[][] tempArray = new int[maxRows][maxCollms];

        // Initialize the starting point
        tempArray[0][0] = originalGrid[0][0];
        System.out.println("Initialized starting point tempArray[0][0] = " + tempArray[0][0]);

        // Initialize the first column (can only be reached from the top)
        for (int i = 1; i < maxRows; i++) {
            System.out.println("Adding top value for column: tempArray[" + i + "][0] = tempArray[" + (i - 1) + "][0] + originalGrid[" + i + "][0]");
            tempArray[i][0] = tempArray[i - 1][0] + originalGrid[i][0];
            System.out.println("Result: tempArray[" + i + "][0] = " + tempArray[i][0]);
        }
        System.out.println("DP after filling the first column:\n" + Arrays.deepToString(tempArray) + "\n");

        // Initialize the first row (can only be reached from the left)
        for (int j = 1; j < maxCollms; j++) {
            System.out.println("Adding left value for row: tempArray[0][" + j + "] = tempArray[0][" + (j - 1) + "] + originalGrid[0][" + j + "]");
            tempArray[0][j] = tempArray[0][j - 1] + originalGrid[0][j];
            System.out.println("Result: tempArray[0][" + j + "] = " + tempArray[0][j]);
        }
        System.out.println("DP after filling the first row:\n" + Arrays.deepToString(tempArray) + "\n");

        // Fill the rest of the DP table
        for (int rowIndex = 1; rowIndex < maxRows; rowIndex++) {
            for (int columnIndex = 1; columnIndex < maxCollms; columnIndex++) {
                System.out.println("At cell (" + rowIndex + "," + columnIndex + "), originalGrid value: " + originalGrid[rowIndex][columnIndex]);
                System.out.println("Minimum between coming down (" + tempArray[rowIndex - 1][columnIndex] + ") and coming to the right (" + tempArray[rowIndex][columnIndex - 1] + ")");
                System.out.println(" Choosing min beetween '" + tempArray[rowIndex - 1][columnIndex] + "' and '" + tempArray[rowIndex][columnIndex - 1] + "', chose '" + Math.min(tempArray[rowIndex - 1][columnIndex], tempArray[rowIndex][columnIndex - 1]) + "'");
                System.out.println("OrignalGridValue " + originalGrid[rowIndex][columnIndex]);
                tempArray[rowIndex][columnIndex] = originalGrid[rowIndex][columnIndex] + Math.min(tempArray[rowIndex - 1][columnIndex], tempArray[rowIndex][columnIndex - 1]);
                System.out.println("Updated cost at cell (" + rowIndex + "," + columnIndex + "): " + tempArray[rowIndex][columnIndex]);
            }
            System.out.println(Arrays.deepToString(tempArray));
        }

        System.out.println("Final DP Table:\n" + Arrays.deepToString(tempArray) + "\n");

        // The last cell contains the minimum path sum to reach the bottom-right corner
        return tempArray[maxRows - 1][maxCollms - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3, 12, 4, 7, 10},
                {6, 8, 15, 1, 4},
                {19, 5, 14, 32, 21},
                {1, 20, 2, 9, 7}};

        System.out.println("Initial Grid:\n" + Arrays.deepToString(grid) + "\n");
        int result = minPathSum(grid);
        System.out.println("Minimum Path Sum: " + result);
    }

    static class Cell {
        int row, col, cost;

        public Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Cell{" + "row=" + row + ", col=" + col + ", cost=" + cost + '}';
        }
    }
}
