package com.github.mrf1n;

public class T0941_ValidMountainArray {

    public static void main(String[] args) {
        int[] arr0 = new int[]{2, 1};
        System.out.println(new T0941_ValidMountainArray().validMountainArray(arr0));
        int[] arr1 = new int[]{3,5,5};
        System.out.println(new T0941_ValidMountainArray().validMountainArray(arr1));
        int[] arr2 = new int[]{0,3,2,1};
        System.out.println(new T0941_ValidMountainArray().validMountainArray(arr2));
        int[] arr3 = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println(new T0941_ValidMountainArray().validMountainArray(arr3));
        int[] arr4 = new int[]{0,1,2,1,2};
        System.out.println(new T0941_ValidMountainArray().validMountainArray(arr4));
        int[] arr5 = new int[]{1,1,1,1,1,1,1,2,1};
        System.out.println(new T0941_ValidMountainArray().validMountainArray(arr5));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        boolean decreasing = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i] && decreasing || arr[i - 1] >= arr[i] && !decreasing) {
                return false;
            }
            if (i < arr.length - 1 && arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                decreasing = true;
            }

        }
        return decreasing;
    }
}
