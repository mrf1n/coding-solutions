package com.github.mrf1n.coding.solutions;

import java.util.ArrayList;
import java.util.List;

public class T0448_FindNumbersDisappearedInArray {

    public static void main(String[] args) {
        int[] nums0 = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(new T0448_FindNumbersDisappearedInArray().findDisappearedNumbers(nums0));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num: nums) {
            int index = Math.abs(num);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
