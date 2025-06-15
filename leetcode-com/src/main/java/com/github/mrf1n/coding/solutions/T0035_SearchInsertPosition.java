package com.github.mrf1n.coding.solutions;

public class T0035_SearchInsertPosition {
    public static void main(String[] args) {
        int[] testA0 = new int[]{1, 3, 5, 6};
        int testT0 = 7;
        System.out.println(new T0035_SearchInsertPosition().searchInsert(testA0, testT0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
