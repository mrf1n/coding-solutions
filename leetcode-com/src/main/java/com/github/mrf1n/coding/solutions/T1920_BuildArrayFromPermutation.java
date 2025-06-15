package com.github.mrf1n.coding.solutions;

import java.util.Arrays;

public class T1920_BuildArrayFromPermutation {

    public static void main(String[] args) {
        int[] nums0 = new int[]{0,2,1,5,3,4};
        System.out.println(Arrays.toString(new T1920_BuildArrayFromPermutation().buildArray(nums0)));
    }

    public int[] buildArray(int[] nums) {
        int[] outNums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            outNums[i] = nums[nums[i]];
        }
        return outNums;
    }
}
