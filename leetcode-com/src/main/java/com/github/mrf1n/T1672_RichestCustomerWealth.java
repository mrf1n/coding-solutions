package com.github.mrf1n;

public class T1672_RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] accounts0 = new int[][]{{1, 2, 3}, {3, 2, 1}};
        System.out.println(new T1672_RichestCustomerWealth().maximumWealth(accounts0));
        int[][] accounts1 = new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(new T1672_RichestCustomerWealth().maximumWealth(accounts1));
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int current = 0;
            for (int i : account) {
                current += i;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
