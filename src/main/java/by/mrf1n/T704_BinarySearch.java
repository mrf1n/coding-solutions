package by.mrf1n;

public class T704_BinarySearch {
    public static void main(String[] args) {
        int[] nums0 = new int[]{-1, 0, 3, 5, 9, 12};
        int target0 = 9;
        System.out.println(search(nums0, target0));
        int[] nums1 = new int[]{-1, 0, 3, 5, 9, 12};
        int target1 = 0;
        System.out.println(search(nums1, target1));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length, m = (l + r) / 2;
        while (true) {
            if (nums[m] == target) {
                return m;
            } else if (l == m || r == m) {
                return -1;
            } else if (nums[m] > target) {
                r = m;
                m = (l + r) / 2;
            } else if (nums[m] < target) {
                l = m;
                m = (l + r) / 2;
            }
        }
    }
}
