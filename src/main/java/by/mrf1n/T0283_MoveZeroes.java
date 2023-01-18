package by.mrf1n;

import java.util.Arrays;

public class T0283_MoveZeroes {
    public static void main(String[] args) {
        int[] test0 = new int[]{1, 2, 3, 12};
        moveZeroes(test0);
        System.out.println(Arrays.toString(test0));
        int[] test1 = new int[]{0, 1};
        moveZeroes(test1);
        System.out.println(Arrays.toString(test1));
        int[] test2 = new int[]{1, 0};
        moveZeroes(test2);
        System.out.println(Arrays.toString(test2));
        int[] test3 = new int[]{0, 0, 0, 1, 0, 0, 0, 2};
        moveZeroes(test3);
        System.out.println(Arrays.toString(test3));
    }

    public static void moveZeroes(int[] nums) {
        int pZero = 0;
        for (int i = 0; i < nums.length; i++) {
            while (pZero < nums.length && nums[pZero] != 0) {
                pZero++;
            }
            if (nums[i] != 0 && i > pZero) {
                nums[pZero] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
