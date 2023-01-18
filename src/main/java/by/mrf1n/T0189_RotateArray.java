package by.mrf1n;

import java.util.Arrays;

public class T0189_RotateArray {
    public static void main(String[] args) {
        int[] nums0 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k0 = 3;
        rotateAsymmetry(nums0, k0);
        System.out.println(Arrays.toString(nums0));
        int[] nums1 = new int[]{-1, -100, 3, 99};
        int k1 = 2;
        rotateTwoFor(nums1, k1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = new int[]{-1, -100, 3, 99};
        int k2 = 2;
        rotateBest(nums2, k2);
        System.out.println(Arrays.toString(nums1));
    }

    public static void rotateAsymmetry(int[] nums, int k) {
        k %= nums.length;
        int p = 0, prev = nums[nums.length - k];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[p];
            nums[p] = prev;
            prev = tmp;
            p = (p + k) % nums.length;
        }
    }

    public static void rotateTwoFor(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        for (int i = 0; i < k; i++) {
            int p = 0, prev = nums[length - 1];
            for (int j = 0; j < length; j++) {
                int tmp = nums[p];
                nums[p] = prev;
                prev = tmp;
                p = (p + 1) % length;
            }
        }
    }

    public static void rotateBest(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) return;
        k %= length;
        if (k == 0) return;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
