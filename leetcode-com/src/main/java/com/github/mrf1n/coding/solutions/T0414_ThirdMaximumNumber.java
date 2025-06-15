package com.github.mrf1n.coding.solutions;

public class T0414_ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] nums0 = new int[]{3,2,1};
        System.out.println(new T0414_ThirdMaximumNumber().thirdMax(nums0));
        int[] nums1 = new int[]{2,1};
        System.out.println(new T0414_ThirdMaximumNumber().thirdMax(nums1));
        int[] nums2 = new int[]{2,2,3,1};
        System.out.println(new T0414_ThirdMaximumNumber().thirdMax(nums2));
    }

    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for (int num: nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num < max1 && num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num < max2 && num > max3) {
                max3 = num;
            }
        }

        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }
}
