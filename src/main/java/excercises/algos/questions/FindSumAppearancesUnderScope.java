package excercises.algos.questions;

import java.io.*;
import java.util.*;

public class FindSumAppearancesUnderScope {

    /* A friend of Jamie has gifted a collection of recipes, and Jamie is excited to cook them all as quickly as possible.
    The duration of the recipes is given in an array durations[n], the number of recipes, and each recipe's duration is between 1.01 and 3.00 hours (up to two decimal places).
    Every day, Jamie wants to spend no more than 3.00 hours cooking and to complete the recipes in the minimum number of days.
    If a recipe is started, Jamie completes the recipe on the same day. Find the minimum number of days needed to cook all the recipes.

Example:
n = 5
durations = [1.90, 1.04, 1.25, 2.5, 1.75]

Considering 1-based indexing, Jamie can cook the recipes in a minimum of 3 days as:
Day 1: first and second recipe: 1.90 + 1.04 = 2.94 ≤ 3.00
Day 2: fourth recipe: 2.5 ≤ 3.00
Day 3: third and fifth recipes: 1.25 + 1.75 = 3.00 ≤ 3.00

Function Description
1 ≤ n ≤ 1000
1.01 ≤ durations[i] ≤ 3.00

durations[] size n = 5
1.90
1.04
1.25
2.5
1.75

Sample Output
3

Explanation
Jamie can cook all the recipes in 3 days as follows:

    Day 1: first and second recipe: 1.90 + 1.04 = 2.94 ≤ 3.00
    Day 2: fourth recipe: 2.5 ≤ 3.00
    Day 3: third and fifth recipes: 1.25 + 1.75 = 3.00 ≤ 3.00

Sample Case 1
durations[] size n = 4
1.01
1.01
1.91
1.4

Sample Output
3

Explanation
Jamie can cook all the recipes in 3 days as follows:

    Day 1: first and second recipe: 1.01 + 1.01 = 2.02 ≤ 3.00
    Day 2: third recipe: 1.91 ≤ 3.00
    Day 3: fourth recipe: 1.4 ≤ 3.00
    * */
    public static final float MAX_SCOPE = 3.00f;

    public static void main(String[] args) throws IOException {
        List<Float> amounts = Arrays.asList(
                2.99f, 2.98f, 2.97f, 2.95f, 2.93f, 2.93f, 2.93f, 2.93f, 2.93f, 2.92f, 2.89f, 2.89f, 2.89f, 2.88f, 2.85f,
                2.83f, 2.81f, 2.77f, 2.77f, 2.77f, 2.76f, 2.73f, 2.71f, 2.69f, 2.67f, 2.67f, 2.67f, 2.65f, 2.63f, 2.63f,
                2.61f, 2.61f, 2.61f, 2.60f, 2.57f, 2.57f, 2.56f, 2.53f, 2.53f, 2.53f, 2.53f, 2.51f, 2.49f, 2.48f, 2.48f,
                2.47f, 2.47f, 2.47f, 2.45f, 2.45f, 2.45f, 2.45f, 2.43f, 2.40f, 2.39f, 2.37f, 2.36f, 2.36f, 2.34f, 2.33f,
                2.29f, 2.29f, 2.29f, 2.29f, 2.29f, 2.29f, 2.25f, 2.25f, 2.25f, 2.25f, 2.23f, 2.21f, 2.20f, 2.19f, 2.19f,
                2.17f, 2.17f, 2.15f, 2.15f, 2.15f, 2.14f, 2.14f, 2.13f, 2.12f, 2.12f, 2.11f, 2.07f, 2.05f, 2.05f, 2.05f,
                2.05f, 2.05f, 2.05f, 2.03f, 2.02f, 2.02f, 2.00f, 1.99f, 1.98f, 1.98f, 1.97f, 1.96f, 1.95f, 1.94f, 1.94f,
                1.93f, 1.93f, 1.92f, 1.89f, 1.89f, 1.89f, 1.89f, 1.89f, 1.87f, 1.86f, 1.86f, 1.83f, 1.82f, 1.82f, 1.81f,
                1.77f, 1.77f, 1.76f, 1.75f, 1.73f, 1.73f, 1.72f, 1.71f, 1.69f, 1.69f, 1.68f, 1.68f, 1.66f, 1.65f, 1.65f,
                1.63f, 1.63f, 1.61f, 1.59f, 1.57f, 1.57f, 1.56f, 1.55f, 1.53f, 1.52f, 1.50f, 1.50f, 1.49f, 1.49f, 1.49f,
                1.47f, 1.47f, 1.46f, 1.46f, 1.45f, 1.45f, 1.44f, 1.43f, 1.42f, 1.41f, 1.41f, 1.41f, 1.40f, 1.39f, 1.38f,
                1.37f, 1.37f, 1.37f, 1.35f, 1.35f, 1.35f, 1.33f, 1.33f, 1.32f, 1.32f, 1.31f, 1.31f, 1.31f, 1.28f, 1.27f,
                1.27f, 1.25f, 1.23f, 1.21f, 1.21f, 1.20f, 1.19f, 1.17f, 1.17f, 1.14f, 1.12f, 1.12f, 1.11f, 1.11f, 1.10f,
                1.09f, 1.09f, 1.09f, 1.05f, 1.01f
        );
        //  System.out.println(FindSumAppearancesUnderScope.findTotalAmountOfSumsUnderMaxScope(amounts, MAX_SCOPE));
        // System.out.println(FindSumAppearancesUnderScope.findTotalAmountOfSumsUnderMaxScope2(amounts, MAX_SCOPE));
        System.out.println(FindSumAppearancesUnderScope.findTotalAmountOfSumsUnderMaxScope3(amounts, MAX_SCOPE));
    }

    public static int findTotalAmountOfSumsUnderMaxScope(List<Float> numbers, float maxScope) {
        int appearances = 0;
        List<Float> tempNumbers = new ArrayList<>();

        for (float number : numbers) {
            boolean added = false;

            for (int i = 0; i < tempNumbers.size(); i++) {
                float currentTempNumber = tempNumbers.get(i);
                float sum = tempNumbers.get(i) + number;
                if (sum <= maxScope) {
                    System.out.println("Setting sum of '" + tempNumbers.get(i) + " + " + number + " = " + sum + "'" + " instead of '" + tempNumbers.get(i) + "'");
                    tempNumbers.set(i, sum);
                    added = true;
                    break;
                }
            }

            if (!added) {
                tempNumbers.add(number);
                appearances++;
            }
        }

        return appearances;
    }

    public static int findTotalAmountOfSumsUnderMaxScope2(List<Float> numbers, float maxScope) {
        int appearances = 0;
        PriorityQueue<Float> pq = new PriorityQueue<>();

        for (float number : numbers) {
            if (!pq.isEmpty() && pq.peek() + number <= maxScope) {
                float smallestSum = pq.poll();
                pq.add(smallestSum + number);
                System.out.println("Setting sum of '" + smallestSum + " + " + number + " = " + (smallestSum + number) + "'" + " instead of '" + smallestSum + "'");
            } else {
                pq.add(number);
                appearances++;
            }
        }

        return appearances;
    }

    public static int findTotalAmountOfSumsUnderMaxScope3(List<Float> numbers, float maxScope) {
        List<Float> durationList = new ArrayList<>(numbers);
        Collections.sort(durationList, Collections.reverseOrder()); //  This step ensures that we try to fit the longest movies first.

        int days = 0;
        while (!durationList.isEmpty()) { // We use a greedy algorithm to fill each day up to the limit of 3.0 hours, removing movies as they are assigned to a day.
            days++;
            float currentDay = 0.0f;
            Iterator<Float> iterator = durationList.iterator();

            // Use a greedy approach to fill the current day
            while (iterator.hasNext()) {
                float duration = iterator.next();
                if (currentDay + duration <= maxScope) {
                    currentDay += duration;
                    iterator.remove();
                }
            }
        }

        return days;
    }

}


