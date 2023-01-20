package by.mrf1n;

import by.mrf1n.common.TreeNode;

public class T0108_ConvertSortedArrayToBinarySearch {

    public static void main(String[] args) {
        int[] nums0 = new int[]{1, 3};
        System.out.println(new T0108_ConvertSortedArrayToBinarySearch().sortedArrayToBST(nums0));
        int[] nums1 = new int[]{-10, -3, 0, 5, 9};
        System.out.println(new T0108_ConvertSortedArrayToBinarySearch().sortedArrayToBST(nums1));
        int[] nums2 = new int[]{-10, -3, 0, 1, 2, 3, 4, 5, 9};
        System.out.println(new T0108_ConvertSortedArrayToBinarySearch().sortedArrayToBST(nums2));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        if (r - l == 1) {
            return new TreeNode(nums[l], null, new TreeNode(nums[r]));
        }
        return new TreeNode(nums[(l + r) / 2], sortedArrayToBST(nums, l, (l + r) / 2 - 1), sortedArrayToBST(nums, (l + r) / 2 + 1, r));
    }
}
