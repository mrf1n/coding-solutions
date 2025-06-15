package com.github.mrf1n.coding.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1027_LongestArithmeticSubsequence {

    public static void main(String[] args) {
        int[] array0 = new int[]{3, 6, 9, 12};
        System.out.println(new T1027_LongestArithmeticSubsequence().longestArithSeqLength(array0));
        int[] array1 = new int[]{9, 4, 7, 2, 10};
        System.out.println(new T1027_LongestArithmeticSubsequence().longestArithSeqLength(array1));
        int[] array2 = new int[]{20, 1, 15, 3, 10, 5, 8};
        System.out.println(new T1027_LongestArithmeticSubsequence().longestArithSeqLength(array2));
        int[] array3 = new int[]{83, 20, 17, 43, 52, 78, 68, 45};
        System.out.println(new T1027_LongestArithmeticSubsequence().longestArithSeqLengthBest(array3));
    }

    public int longestArithSeqLength(int[] nums) {
        int longest = 0;
        List<Map<Integer, Integer>> dp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            dp.add(new HashMap<>());

            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp.get(i).put(diff, dp.get(j).getOrDefault(diff, 1) + 1);
                longest = Math.max(longest, dp.get(i).get(diff));
            }
        }

        return longest;
    }

    public int longestArithSeqLengthBest(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[][] dp = new int[n][1001];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[j] - nums[i] + 500;
                dp[i][diff] = dp[j][diff] + 1;
                max = Math.max(max, dp[i][diff]);
            }
        }
        return max + 1;
    }
}
