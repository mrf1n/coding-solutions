package com.github.mrf1n;

public class T0326_PowerOfThree {

    public static void main(String[] args) {
        int n0 = 0;
        System.out.println(new T0326_PowerOfThree().isPowerOfThree(n0));
        int n1 = 1;
        System.out.println(new T0326_PowerOfThree().isPowerOfThree(n1));
        int n2 = 5;
        System.out.println(new T0326_PowerOfThree().isPowerOfThree(n2));
        int n3 = 1162261467;
        System.out.println(new T0326_PowerOfThree().isPowerOfThree(n3));
        int n4 = 1162261470;
        System.out.println(new T0326_PowerOfThree().isPowerOfThree(n4));
        int n5 = 2147483647;
        System.out.println(new T0326_PowerOfThree().isPowerOfThreeLC(n5));
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        int pow = 1;
        while (n >= pow && pow > 0) {
            if (pow == n) {
                return true;
            }
            pow *= 3;
        }
        return false;
    }

    public boolean isPowerOfThreeLC(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
