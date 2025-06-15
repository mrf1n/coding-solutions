package com.github.mrf1n.coding.solutions;

public class T0122_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new T0122_BestTimeToBuyAndSellStock2().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
