package com.github.mrf1n;

public class T0136_SingleNumber {
    public static void main(String[] args) {
        int[] nums0 = new int[]{2,2,1};
        System.out.println(new T0136_SingleNumber().singleNumber(nums0));
        int[] nums1 = new int[]{4,2,1,1,2};
        System.out.println(new T0136_SingleNumber().singleNumber(nums1));
        int[] nums2 = new int[]{1};
        System.out.println(new T0136_SingleNumber().singleNumber(nums2));
    }

    public int singleNumber(int[] nums) {
        int out = 0;
        for (int num : nums) {
            out ^= num;
        }
        return out;
    }
}
