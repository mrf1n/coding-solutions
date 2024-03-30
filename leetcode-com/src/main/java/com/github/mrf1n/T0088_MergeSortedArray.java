package com.github.mrf1n;

import java.util.Arrays;

public class T0088_MergeSortedArray {

    public static void main(String[] args) {
        int[] nums01 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums02 = new int[]{2, 5, 6};
        new T0088_MergeSortedArray().merge(nums01, 3, nums02, 3);
        System.out.println(Arrays.toString(nums01));

        int[] nums11 = new int[]{1};
        int[] nums12 = new int[]{};
        new T0088_MergeSortedArray().merge(nums11, 1, nums12, 0);
        System.out.println(Arrays.toString(nums11));

        int[] nums21 = new int[]{0};
        int[] nums22 = new int[]{1};
        new T0088_MergeSortedArray().merge(nums21, 0, nums22, 1);
        System.out.println(Arrays.toString(nums21));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int lastI = m + n - 1;
        m--;
        n--;
        for (int i = lastI; i >= 0; i--) {
            if (n < 0) {
                break;
            } else if (m >= 0) {
                nums1[i] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            } else {
                nums1[i] = nums2[n--];
            }

        }

    }
}
