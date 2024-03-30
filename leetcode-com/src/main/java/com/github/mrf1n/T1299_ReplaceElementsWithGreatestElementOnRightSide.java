package com.github.mrf1n;

import java.util.Arrays;

public class T1299_ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        int[] arr0 = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(
                Arrays.toString(
                        new T1299_ReplaceElementsWithGreatestElementOnRightSide().replaceElements(arr0)));
    }

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }
}
