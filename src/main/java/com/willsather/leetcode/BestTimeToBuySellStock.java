package com.willsather.leetcode;

public class BestTimeToBuySellStock {
    public static int solution(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // update buyPrice if current is lower
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            // update profit if new profit is higher
            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }
}