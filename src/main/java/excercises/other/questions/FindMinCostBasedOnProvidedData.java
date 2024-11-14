package excercises.other.questions;

import java.util.*;

public class FindMinCostBasedOnProvidedData {

    public static long minCostQueue(int numProjects, List<Integer> projectId, List<Integer> bid) {
        // Map to store minimum bid for each project
        Map<Integer, PriorityQueue<Integer>> projectBids = new HashMap<>();

        // Populate the map with bids for each project
        for (int i = 0; i < projectId.size(); i++) {
            int project = projectId.get(i);
            int cost = bid.get(i);

            // Initialize priority queue if it doesn't exist for the project
            projectBids.computeIfAbsent(project, k -> new PriorityQueue<>()).add(cost);
        }

        long totalCost = 0;

        // Calculate the minimum cost for each project
        for (int i = 0; i < numProjects; i++) {
            // Check if there are any bids for this project
            if (!projectBids.containsKey(i)) {
                return -1; // Return -1 if any project has no bids
            }

            // Get the minimum bid for the current project
            totalCost += projectBids.get(i).poll();
        }

        return totalCost;
    }

    public static long minCostMaps(int numProjects, List<Integer> projectId, List<Integer> bid) {
        Map<Integer, List<Integer>> projectBids = new HashMap<>();

        for (int i = 0; i < projectId.size(); i++) {
            int project = projectId.get(i);
            int cost = bid.get(i);
            projectBids.computeIfAbsent(project, k -> new ArrayList<>()).add(cost);
        }

        long totalCost = 0;

        for (int i = 0; i < numProjects; i++) {
            if (!projectBids.containsKey(i)) {
                return -1;
            }

            // Find the minimum bid for this project
            totalCost += Collections.min(projectBids.get(i));
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int numProjects = 3;
        List<Integer> projectId = Arrays.asList(2, 0, 1, 2);
        List<Integer> bid = Arrays.asList(8, 7, 6, 9);

        System.out.println(minCostMaps(numProjects, projectId, bid)); // Expected output: 21
        System.out.println( minCostQueue(numProjects, projectId, bid)); // Expected output: 21
    }
}
