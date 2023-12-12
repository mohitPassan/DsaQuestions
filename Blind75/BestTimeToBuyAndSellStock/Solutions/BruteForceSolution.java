// Time limit exceeded

package Blind75.BestTimeToBuyAndSellStock.Solutions;

public class BruteForceSolution implements ISolution {
    @Override
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    continue;
                }

                int currentProfit = prices[j] - prices[i];
                if (currentProfit > profit) {
                    profit = currentProfit;
                }
            }
        }

        return profit;
    }
}
