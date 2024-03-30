package com.github.mrf1n;

import java.util.Arrays;

public class T0066_PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{4, 3, 2, 1, 9};
        System.out.println(Arrays.toString(new T0066_PlusOne().plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int plusNumber = 1;
        int i = digits.length - 1;
        while (plusNumber > 0 && i >= 0) {
            int digitsSum = digits[i] + plusNumber;
            if (digitsSum > 9) {
                digits[i] = digitsSum % 10;
                plusNumber = digitsSum / 10;
            } else {
                digits[i] = digitsSum;
                plusNumber = 0;
            }
            i--;
        }
        if (plusNumber > 0) {
            int[] oldDigits = digits;
            digits = new int[oldDigits.length + 1];
            digits[0] = plusNumber;
            for (i = 1; i < digits.length; i++) {
                digits[i] = oldDigits[i - 1];
            }
        }
        return digits;
    }
}
