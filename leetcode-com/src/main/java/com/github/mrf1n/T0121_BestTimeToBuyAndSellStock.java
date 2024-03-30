package com.github.mrf1n;

public class T0121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices0 = new int[]{7,1,5,3,6,4};
        System.out.println(new T0121_BestTimeToBuyAndSellStock().maxProfit(prices0));
        int[] prices1 = new int[]{7,6,4,3,1};
        System.out.println(new T0121_BestTimeToBuyAndSellStock().maxProfitBruteForce(prices1));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfitBruteForce(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
