# Problem statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return _the maximum profit you can achieve from this transaction_. If you cannot achieve any profit, return `0`.

**Example 1:**

**Input:** prices = \[7,1,5,3,6,4]
**Output:** 5
**Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

**Example 2:**

**Input:** prices = \[7,6,4,3,1]
**Output:** 0
**Explanation:** In this case, no transactions are done and the max profit = 0.

**Constraints:**

- `1 <= prices.length <= 105`
- `0 <= prices[i] <= 104`

# Brute force

Just run two nested loops and find the profit for each iteration and keep storing the maximum profit.

Time complexity: `O(n^2)`

*Time limit exceeded*
## Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=0; i<prices.length; i++) {
            int current = prices[i];

            for(int j=i+1; j<prices.length; j++) {
                if(prices[j] < prices[i]) {
                    continue;
                }

                int currentProfit = prices[j] - prices[i];
                if(currentProfit > profit) {
                    profit = currentProfit;
                }
            }
        }

        return profit;
    }
}
```

# Optimised solution

The intuition behind the solution is that at `ith` day the maximum profit would have been if we bought at the day when the price was minimum. So the minimum element in the range `0 to i-1`.

What we do is that keep a track of the minimum element till now and find the profit. If this profit is greater than the maximum profit, we store the current value.

Time complexity: `O(n)`

## Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] < minimum) {
                minimum = prices[i];
            }

            int profit = prices[i] - minimum;

            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
```

# Building more intuition

Suppose there are 4 variables, `buyPrice`, `sellPrice`, `profit`, `maxProfit`.

On day 1, we buy and sell at the same price, so `buyPrice = sellPrice` and `profit = maxProfit = 0`.

On next iterations:

- If we see that the current price is less than the `buyPrice`, so we make the current price the buy price. Also, we cannot sell in the past, so the sell price will also become the current price. Then, we calculate the profit and check if it should replace max profit or not.
- If we see that the current price is more than the `sellPrice`, we simply replace sell price with the current. Then, we calculate the profit and check if it should replace max profit or not.

In the end, we return the maximum profit.

## Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int sellPrice = prices[0];
        int profit = 0;
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
                sellPrice = prices[i];
            }

            if(prices[i] > sellPrice) {
                sellPrice = prices[i];
            }

            profit = sellPrice - buyPrice;

            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
```
