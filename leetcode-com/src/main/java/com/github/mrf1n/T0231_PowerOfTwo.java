package com.github.mrf1n;

public class T0231_PowerOfTwo {
    public static void main(String[] args) {
        int[] nums0 = new int[]{-16, -15, 0, 1, 2, 3, 4, 5, 6, 16, 32, 129};
        for (int num : nums0) {
            System.out.println(num);
            System.out.println(new T0231_PowerOfTwo().isPowerOfTwoPrevious(num));
            System.out.println(new T0231_PowerOfTwo().isPowerOfTwo(num));
        }
    }

    public boolean isPowerOfTwoPrevious(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 2) {
            if ((n & 1) == 1) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
