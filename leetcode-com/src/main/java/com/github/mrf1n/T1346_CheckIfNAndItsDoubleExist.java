package com.github.mrf1n;

import java.util.HashSet;

public class T1346_CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        int[] nums0 = new int[]{10,2,5,3};
        System.out.println(new T1346_CheckIfNAndItsDoubleExist().checkIfExist(nums0));
        int[] nums1 = new int[]{3,1,7,11};
        System.out.println(new T1346_CheckIfNAndItsDoubleExist().checkIfExist(nums1));

    }

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(j * 2) || j % 2 == 0 && set.contains(j / 2)) {
                return true;
            }
            set.add(j);
        }
        return false;
    }
}
