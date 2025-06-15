package com.github.mrf1n.coding.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T0350_IntersectionOfTwoArrays2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new T0350_IntersectionOfTwoArrays2().intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int num : nums1) {
            Integer count = store.get(num);
            store.put(num, count == null ? 1 : count + 1);
        }
        List<Integer> intersectionItems = new ArrayList<>();

        for (int num : nums2) {
            store.computeIfPresent(num, (key, oldValue) -> {
                intersectionItems.add(num);

                return oldValue == 1 ? null : oldValue - 1;
            });
        }
        int[] intersection = new int[intersectionItems.size()];
        for (int i = 0; i < intersectionItems.size(); i++) {
            intersection[i] = intersectionItems.get(i);
        }
        return intersection;
    }
}
