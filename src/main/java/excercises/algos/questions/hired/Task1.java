package excercises.algos.questions.hired;

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

class Task1 {

    public static void main(String[] args) {
        long[] prices = {6, 0, -1, 10};
        System.out.println(solution(prices));
    }

    public static long solution(long[] prices) {
        if (prices == null || prices.length == 0) {
            return 0; // If the list is empty, return 0 as specified.
        }

        long minPrice = Long.MAX_VALUE; // Initialize minPrice to the maximum value possible.
        long maxProfit = 0; // Initialize maxProfit to 0.

        for (int i = 0; i < prices.length; i++) {
            // If the current price is less than minPrice, update minPrice.
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // If the profit from selling at the current price is greater than maxProfit, update it.
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }


}