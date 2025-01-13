package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BestTimeToBuySellStockTest {

    @Test
    public void testExampleCase() {
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Buy at 1, sell at 6
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(5);
    }

    @Test
    public void testNoProfit() {
        int[] prices = {7, 6, 4, 3, 1};

        // No profit can be made
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(0);
    }

    @Test
    public void testIncreasingPrices() {
        int[] prices = {1, 2, 3, 4, 5};

        // Buy at 1, sell at 5
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(4);
    }

    @Test
    public void testSingleDay() {
        int[] prices = {5};

        // Only one price, no transaction possible
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(0);
    }

    @Test
    public void testTwoDaysProfit() {
        int[] prices = {1, 5};

        // Buy at 1, sell at 5
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(4);
    }

    @Test
    public void testTwoDaysNoProfit() {
        int[] prices = {5, 1};

        // Prices decrease, no profit
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(0);
    }

    @Test
    public void testRandomCase() {
        int[] prices = {3, 8, 1, 7, 4, 9};

        // Buy at 1, sell at 9
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(8);
    }

    @Test
    public void testLargeInput() {
        int[] prices = new int[100000];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = i + 1;
        }

        // Buy at 1, sell at 100000
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(99999);
    }

    @Test
    public void testEdgeCaseMinimumInput() {
        int[] prices = {1, 2};

        // Buy at 1, sell at 2
        assertThat(BestTimeToBuySellStock.solution(prices)).isEqualTo(1);
    }
}
