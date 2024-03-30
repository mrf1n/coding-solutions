package com.github.mrf1n;

public class T1295_FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] arr0 = new int[]{12,345,2,6,7896};
        System.out.println(new T1295_FindNumbersWithEvenNumberOfDigits().findNumbers(arr0));
        int[] arr1 = new int[]{555,901,482,1771};
        System.out.println(new T1295_FindNumbersWithEvenNumberOfDigits().findNumbers(arr1));
    }

    public int findNumbers(int[] nums) {
        int even = 0;
        for (int num : nums) {
            even += isEvenDigitsNumber(num) ? 1 : 0;
        }
        return even;
    }

    private boolean isEvenDigitsNumber(int num) {
        int digitsNumber = 0;
        while (num > 0) {
            num = num / 10;
            digitsNumber++;
        }
        return digitsNumber % 2 == 0;
    }
}
