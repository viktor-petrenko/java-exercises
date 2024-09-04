package algo.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;// Dijkstra's algorithm to find minimum cost path with all four directions allowed

public class MinimumCostPathAllDirections {

    public static int minCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Define the possible directions (up, down, left, right)
        int[] rowDirections = {-1, 1, 0, 0};
        int[] colDirections = {0, 0, -1, 1};

        // Priority Queue for Dijkstra's Algorithm
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.cost));

        // 2D array to store the minimum cost to reach each cell
        int[][] minCost = new int[n][m];

        // Initialize the cost array with infinity (as we want to minimize)
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start from the top-left corner (0, 0)
        minCost[0][0] = grid[0][0];
        pq.add(new Cell(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int currentRow = current.row;
            int currentCol = current.col;
            int currentCost = current.cost;

            // If we reach the bottom-right corner, return the cost
            if (currentRow == n - 1 && currentCol == m - 1) {
                return currentCost;
            }

            // Explore the neighbors (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + rowDirections[i];
                int newCol = currentCol + colDirections[i];

                System.out.println(newRow);
                System.out.println(newCol);

                // Ensure the new cell is within the bounds of the grid
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    System.out.println(grid[newRow][newCol]);
                    int newCost = currentCost + grid[newRow][newCol];

                    // If we find a cheaper path to the neighbor, update the cost and add to the priority queue
                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        pq.add(new Cell(newRow, newCol, newCost));
                    }
                }
            }
        }
        // If we cannot reach the bottom-right corner, return -1 (shouldn't happen with valid input)
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{31, 100, 65, 12, 18}, {10, 13, 47, 157, 6}, {100, 113, 174, 11, 33}, {88, 124, 41, 20, 140}, {99, 32, 111, 41, 20}};
        System.out.println("Initial grid" + Arrays.deepToString(grid));
        int result = minCostPath(grid);
        System.out.println("The minimum cost to reach the bottom-right corner is: " + result);
    }

    static class Cell {
        int row, col, cost;

        public Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

}