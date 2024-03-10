package misc.hired;

import java.util.*;
/*
suppose you are given a list of integers prices that represents the proce of google's stock over time. prieces[i] is the price of the stock on day i. You must buy the stock once and then later sell it. You are not allowed to sell before you buy.

Write function that returns an integer which is maximum profit you can make from buying the stock and then later selling it. If the list is empty return 0.

Example input :
 prices = [6,0,-1,10]
prices: [350, 300, 494, 316, 86, -457, -431, 0, 126, -395, 22, 205, 83, 182, -285, 81, -407, 340, -331, -374, 351, -436, -186, -152, 471, -491, 34, 134, -300, -268, 500, 220, 121, -154, 298, -438, 484, 285, 484, -352, -183, 188, 68, -441, -346, 481, 13, -43]
Example output : 11
Explanation :  11 is the maximum profit you can make buying the stock when it's -1 and selling it when it's 10

public static long solution(long[] prices) {
}
 */
class Job {
    int start;
    int end;
    int load;

    Job(long[] arr) throws IllegalArgumentException {
        if (arr.length != 3 || arr[0] < 0 || arr[1] <= arr[0] || arr[2] < 0) {
            throw new IllegalArgumentException("Invalid job data");
        }
        this.start = (int) arr[0];
        this.end = (int) arr[1];
        this.load = (int) arr[2];
    }
}

class Solution {
    public static long solution(long[][] jobValues) {
        try {
            Job[] jobs = Arrays.stream(jobValues)
                    .map(Job::new)
                    .toArray(Job[]::new);

            int maxEndTime = Arrays.stream(jobs)
                    .mapToInt(job -> job.end)
                    .max()
                    .orElse(0);

            if (maxEndTime == 0) {
                return -1; // Indicates invalid input or no jobs
            }

            int[] cpuTimeline = new int[maxEndTime + 1];
            Arrays.fill(cpuTimeline, 0);

            for (Job job : jobs) {
                for (int i = job.start; i < job.end; i++) {
                    cpuTimeline[i] += job.load;
                }
            }

            return Arrays.stream(cpuTimeline)
                    .max()
                    .orElse(0);
        } catch (IllegalArgumentException e) {
            return -1; // Return -1 to indicate invalid input
        }
    }
}