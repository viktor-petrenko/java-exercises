package exercises.algos.questions.hired;

import java.util.Arrays;

/*
We've provided a program that was designed to accomplish the following task, but doesn't work properly . Your task is to fix the bugs in this program so the tests pass.
Given a series of CPU jobs over a period of time, each containing a [{start}, {end}, {load}] , calculate the highest CPU load at a single point in time.

CPU load is calculated as the sum of the load of each concurrent job happening at any point in time.
Note: If any job contains invalid data, the entire program should return

Example :
Jobs : [[1, 5, 3], [2, 5, 4], [7, 9, 6]]
Result : 7 (3+4 at times 2-5)
from functools import reduce
import typing


import java.util.*;

class Job {
    int start;
    int end;
    int load;

    Job(long[] arr) {
        this.start = (int)arr[0];
        this.end = (int)arr[1];
        this.load = (int)arr[2];
    }
}

class Solution {
    public static long solution(long[][] jobValues) {
        Job[] jobs = new Job[jobValues.length];
        for (int i = 0; i < jobValues.length; i++) {
            long[] jobValue = jobValues[i];
            jobs[i] = new Job(jobValue);
        }

        int timelineSize = jobs.length;

        int[] cpuTimeline = new int[timelineSize];
        Arrays.fill(cpuTimeline, 0);
        for (Job job: jobs) {
            for (int i = job.start; i < job.end; i++) {
                cpuTimeline[i] = job.load;
            }
        }

        return Arrays.stream(cpuTimeline).reduce(0, (currentMax, next) -> Math.max(currentMax, next));
    }
}
 */
public class Task2 {

    public static void main(String[] args) {
        // Test cases
        long[][] jobValues1 = {{6, 7, 10}, {2, 4, 11}, {8, 12, 15}};
        System.out.println(solution(jobValues1)); // Expected output: 15

        long[][] jobValues2 = {{1, 5, 3}, {2, 5, 4}, {7, 9, 6}};
        System.out.println(solution(jobValues2)); // Expected output: 7

        long[][] jobValues3 = {{0, 1}, {2, 4, 11}};
        System.out.println(solution(jobValues3)); // Expected output: -1 (Invalid input)
    }

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




