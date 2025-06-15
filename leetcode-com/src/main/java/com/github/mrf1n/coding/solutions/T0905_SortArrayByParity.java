package com.github.mrf1n.coding.solutions;

import java.util.Arrays;

public class T0905_SortArrayByParity {

    public static void main(String[] args) {
        int[] nums0 = new int[]{3,1,2,4};
        System.out.println(Arrays.toString(new T0905_SortArrayByParity().sortArrayByParity(nums0)));
        int[] nums1 = new int[]{0,2};
        System.out.println(Arrays.toString(new T0905_SortArrayByParity().sortArrayByParity(nums1)));
    }

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < nums.length && nums[l] % 2 == 0) {
                l++;
            }
            while (r >= 0 && nums[r] % 2 == 1) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] =  tmp;
            }
        }
        return nums;
    }
}
