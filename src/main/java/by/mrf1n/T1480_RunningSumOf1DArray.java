package by.mrf1n;

import java.util.Arrays;

public class T1480_RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] nums0 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(new T1480_RunningSumOf1DArray().runningSum(nums0)));
        int[] nums1 = new int[]{1,1,1,1,1};
        System.out.println(Arrays.toString(new T1480_RunningSumOf1DArray().runningSum(nums1)));
        int[] nums2 = new int[]{3,1,2,10,1};
        System.out.println(Arrays.toString(new T1480_RunningSumOf1DArray().runningSum(nums2)));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
