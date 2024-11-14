package exercises.algos.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


// Dijkstra's algorithm to find minimum cost path with all four directions allowed
public class MinimumCostPathAllDirections {

    public static int minCostPath(int[][] originalGrid) {
        int maximumRowsLength = originalGrid.length;
        int maximumCollumnsLength = originalGrid[0].length;

        // Define the possible directions (up, down, left, right)
        int[] rowDirections = {-1, 1, 0, 0}; // {-1, 1, 0, 0} (up, down, stay on the same row for left/right).
        int[] colDirections = {0, 0, -1, 1}; // {0, 0, -1, 1} (stay on the same column for up/down, left, right)
        String[] directionNames = {"Up", "Down", "Left", "Right"}; // Corresponding direction names

       /*
       The comparator Comparator.comparingInt(cell -> cell.cost) orders Cell objects by their cost field in ascending order.
       This means cells with lower cost values will be considered as having higher priority (closer to the front of the queue).
       Specifically:
            When you enqueue (add) a Cell object to the PriorityQueue, the queue internally arranges the elements in such a way that the Cell with the lowest cost is always at the front of the queue.
            When you dequeue (remove) an element from the queue, the PriorityQueue will remove the Cell with the smallest cost first.*/
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.cost));

        // 2D array to store the minimum cost to reach each cell
        int[][] tempArray = new int[maximumRowsLength][maximumCollumnsLength];

        // Initialize the cost array with infinity (as we want to minimize)
        for (int[] row : tempArray) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start from the top-left corner (0, 0)
        tempArray[0][0] = originalGrid[0][0];
        pq.add(new Cell(0, 0, originalGrid[0][0]));
        System.out.println(Arrays.deepToString(tempArray));
        System.out.println(pq.toString());

        while (!pq.isEmpty()) {
            Cell firstCell = pq.poll();
            int currentRow = firstCell.row;
            int currentCol = firstCell.col;
            int currentCost = firstCell.cost;

            // If we reach the bottom-right corner, return the cost
            if (currentRow == maximumRowsLength - 1 && currentCol == maximumCollumnsLength - 1) {
                return currentCost;
            }

            // Explore the neighbors (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                //{-1, 1, 0, 0}
                //{0, 0, -1, 1}
                int newRow = currentRow + rowDirections[i];
                int newCol = currentCol + colDirections[i];

                // Ensure the new cell is within the bounds of the originalGrid
                if (newRow >= 0 && newRow < maximumRowsLength && newCol >= 0 && newCol < maximumCollumnsLength) {
                    int newCost = currentCost + originalGrid[newRow][newCol];

                    // If we find a cheaper path to the neighbor, update the cost and add to the priority queue
                    if (newCost < tempArray[newRow][newCol]) {
                        // System.out.println("newCost : " + newCost + " < MinCost : " + tempArray[newRow][newCol]);
                        tempArray[newRow][newCol] = newCost;
                        System.out.println("Looking to move " + directionNames[i] + " to Cell[" + newRow + "][" + newCol + "] with value " + originalGrid[newRow][newCol] + ", total cost: " + newCost);

                        //System.out.println("Adding to the queue : " + new Cell(newRow, newCol, newCost) + " to " + Arrays.deepToString(tempArray));
                        pq.add(new Cell(newRow, newCol, newCost));
                        // System.out.println("Smallest in the queue '" + pq.peek() + "'");
                        //System.out.println("currentCost '" + currentCost  + "' + " + "newCost '"  + originalGrid[newRow][newCol] + "'");
                    }
                }
            }
        }
        // If we cannot reach the bottom-right corner, return -1 (shouldn't happen with valid input)
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}};
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Cell{");
            sb.append("row=").append(row);
            sb.append(", col=").append(col);
            sb.append(", cost=").append(cost);
            sb.append('}');
            return sb.toString();
        }
    }

}