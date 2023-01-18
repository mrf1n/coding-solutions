package by.mrf1n;

public class T0198_HouseRobber {
    public static void main(String[] args) {
        int[] nums0 = new int[]{1, 2, 3, 1};
        System.out.println(new T0198_HouseRobber().rob(nums0));
        int[] nums1 = new int[]{2, 7, 9, 3, 1};
        System.out.println(new T0198_HouseRobber().rob(nums1));
        int[] nums2 = new int[]{};
        System.out.println(new T0198_HouseRobber().rob(nums2));
        int[] nums3 = new int[]{2, 1, 1, 2};
        System.out.println(new T0198_HouseRobber().rob(nums3));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(i - 3 < 0 ? 0 : nums[i - 3], i - 2 < 0 ? 0 : nums[i - 2]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
