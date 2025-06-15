package com.github.mrf1n.coding.solutions;

import java.util.HashSet;
import java.util.Set;

public class T0217_ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,4,1,2,4,2};
        System.out.println(new T0217_ContainsDuplicate().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            if (uniques.contains(num)) {
                return true;
            }
            uniques.add(num);
        }
        return false;
    }
}
