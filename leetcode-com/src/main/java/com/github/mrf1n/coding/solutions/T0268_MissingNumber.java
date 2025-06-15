package com.github.mrf1n.coding.solutions;

public class T0268_MissingNumber {

    public static void main(String[] args) {
        int[] nums0 = new int[]{3, 0, 1};
        System.out.println(new T0268_MissingNumber().missingNumber(nums0));
        int[] nums1 = new int[]{0, 1};
        System.out.println(new T0268_MissingNumber().missingNumber(nums1));
        int[] nums2 = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(new T0268_MissingNumber().missingNumber(nums2));
    }

    public int missingNumber(int[] nums) {
        int out = 0;
        out ^= nums.length;
        for (int i = 0; i < nums.length; i++) {
            out ^= nums[i];
            out ^= i;
        }
        return out;
    }
}
