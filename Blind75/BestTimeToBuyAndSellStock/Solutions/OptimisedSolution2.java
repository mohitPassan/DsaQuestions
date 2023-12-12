package Blind75.BestTimeToBuyAndSellStock.Solutions;

public class OptimisedSolution2 implements ISolution {
    @Override
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int sellPrice = prices[0];
        int profit = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
                sellPrice = prices[i];
            }

            if (prices[i] > sellPrice) {
                sellPrice = prices[i];
            }

            profit = sellPrice - buyPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
