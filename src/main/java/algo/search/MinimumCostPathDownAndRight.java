package algo.search;

import java.util.Arrays;

public class MinimumCostPathDownAndRight {

    /**
     * Given a matrix of integers matrix of size n*m, where each element matrix[i][j] represents the cost of passing from that cell,
     * create a function that returns the cost of the minimum cost path to go from the top left cell to the right bottom cell,
     * knowing that you can only move to the right or to the bottom.
     *
     * Example 1:
     * <p>
     * Input: matrix = [[3, 12, 4, 7, 10], [6, 8, 15, 11, 4], [19, 5, 14, 32, 21], [1, 20, 2, 9, 7]]
     * Output: 54
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a DP table to store the minimum path sum to each cell
        int[][] dp = new int[rows][cols];

        // Initialize the starting point
        dp[0][0] = grid[0][0];

        // The first column can only be reached from above, so each cell is the sum of itself and the cell above it
        for (int i = 1; i < rows; i++) {
            System.out.println("column '"+ dp[i - 1][0] + "'" + "+" +  "'" + grid[i][0] + "'");
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        System.out.println(Arrays.deepToString(dp) + "\n");

        // The first row can only be reached from the left, so each cell is the sum of itself and the cell to its left.
        for (int j = 1; j < cols; j++) {
            System.out.println("first row '"+ dp[0][j - 1] + "'" + "+" +  "'" + grid[0][j] + "'");
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
         System.out.println(Arrays.deepToString(dp) + "\n");

        // FilFor each cell (i, j), the value of dp[i][j] is the minimum of the path sum coming from the left (dp[i][j-1]) and the path sum coming from above (dp[i-1][j]),
        // plus the value of the current cell grid[i][j].
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                System.out.println("Left '"+ grid[i][j] + "'" + "+" +  "'" + "MIN BETWeEN " + dp[i - 1][j] + " and " +  dp[i][j - 1] + "'");
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(Arrays.deepToString(dp)  + "\n");

        // The last cell contains the minimum path sum to reach the bottom-right corner
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 12, 4, 7, 10}, {6, 8, 15, 1, 4}, {19, 5, 14, 32, 21}, {1, 20, 2, 9, 7}};

        int result = minPathSum(grid);
        System.out.println("Minimum Path Sum: " + result);
    }
}
