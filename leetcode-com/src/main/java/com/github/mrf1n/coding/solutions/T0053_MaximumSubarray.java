package com.github.mrf1n.coding.solutions;

public class T0053_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums0 = new int[]{5, 4, -1, 7, 8};
        System.out.println(new T0053_MaximumSubarray().maxSubArray(nums0));
        int[] nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new T0053_MaximumSubarray().maxSubArray(nums1));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
