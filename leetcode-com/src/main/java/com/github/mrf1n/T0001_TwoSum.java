package com.github.mrf1n;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T0001_TwoSum {
    public static void main(String[] args) {
        int[] nums0 = new int[]{2,7,11,15};
        int target0 = 9;
        System.out.println(Arrays.toString(new T0001_TwoSum().twoSum(nums0, target0)));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer fp = map.get(nums[i]);
            if (fp != null && fp != i) {
                return new int[]{fp, i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
