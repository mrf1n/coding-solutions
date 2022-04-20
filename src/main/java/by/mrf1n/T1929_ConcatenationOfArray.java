package by.mrf1n;

import java.util.Arrays;

public class T1929_ConcatenationOfArray {

    public static void main(String[] args) {
        int[] nums0 = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(new T1929_ConcatenationOfArray().getConcatenation(nums0)));
    }

    public int[] getConcatenation(int[] nums) {
        int[] outNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            outNums[i] = nums[i];
            outNums[i + nums.length] = nums[i];
        }
        return outNums;
    }
}
