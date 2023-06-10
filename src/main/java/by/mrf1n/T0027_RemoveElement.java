package by.mrf1n;

import java.util.Arrays;

public class T0027_RemoveElement {
    public static void main(String[] args) {
        int[] nums0 = new int[]{3,2,2,3};
        int val0 = 3;
        System.out.println(new T0027_RemoveElement().removeElement(nums0, val0));
        System.out.println(Arrays.toString(nums0));

        int[] nums1 = new int[]{0,1,2,2,3,0,4,2};
        int val1 = 2;
        System.out.println(new T0027_RemoveElement().removeElement(nums1, val1));
        System.out.println(Arrays.toString(nums1));

    }

    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
