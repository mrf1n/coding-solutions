package com.github.mrf1n.coding.solutions;

import java.util.Arrays;

public class T1051_HeightChecker {

    public static void main(String[] args) {
        int[] nums0 = new int[]{1,1,4,2,1,3};
        System.out.println(new T1051_HeightChecker().heightChecker(nums0));
    }

    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);

        int number = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                number++;
            }
        }
        return number;
    }
}
