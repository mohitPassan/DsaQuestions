package Blind75.BestTimeToBuyAndSellStock.Solutions;

public class OptimisedSolution1 implements ISolution {
    @Override
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minimum) {
                minimum = prices[i];
            }

            int profit = prices[i] - minimum;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
