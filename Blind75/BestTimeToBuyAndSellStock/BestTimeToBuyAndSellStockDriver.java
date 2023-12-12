package Blind75.BestTimeToBuyAndSellStock;

import Blind75.BestTimeToBuyAndSellStock.Solutions.BruteForceSolution;
import Blind75.BestTimeToBuyAndSellStock.Solutions.ISolution;
import Blind75.BestTimeToBuyAndSellStock.Solutions.OptimisedSolution1;
import Blind75.BestTimeToBuyAndSellStock.Solutions.OptimisedSolution2;

class TestCase {
    public int[] prices;

    public TestCase(int[] prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int price : prices) {
            sb.append(price + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class BestTimeToBuyAndSellStockDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new int[] { 7, 1, 5, 3, 6, 4 }),
                new TestCase(new int[] { 7, 6, 4, 3, 1 }),
                new TestCase(new int[] { 7, 8, 5, 3, 6, 4, 1 })
        };

        ISolution[] solutions = new ISolution[] {
                new BruteForceSolution(),
                new OptimisedSolution1(),
                new OptimisedSolution2()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.maxProfit(testCase.prices);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}
