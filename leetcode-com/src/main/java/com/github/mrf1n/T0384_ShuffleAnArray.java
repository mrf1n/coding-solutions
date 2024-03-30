package com.github.mrf1n;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class T0384_ShuffleAnArray {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        int[] shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));
    }

    static class Solution {
        private int[] array;
        private int[] original;

        private final Random rand = new Random();

        private List<Integer> getArrayCopy() {
            List<Integer> asList = new ArrayList<>();
            for (int item : array) {
                asList.add(item);
            }
            return asList;
        }

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        public int[] reset() {
            array = original;
            original = original.clone();
            return array;
        }

        public int[] shuffle() {
            List<Integer> aux = getArrayCopy();

            for (int i = 0; i < array.length; i++) {
                int removeIdx = rand.nextInt(aux.size());
                array[i] = aux.get(removeIdx);
                aux.remove(removeIdx);
            }

            return array;
        }
    }
}
