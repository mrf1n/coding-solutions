package com.github.mrf1n;

public class T0007_RevertInteger {
    public static void main(String[] args) {
        int test0 = 1;
        int test1 = -100;
        int test2 = 1255221;
        int test3 = -1534236469;
        System.out.println(new T0007_RevertInteger().reverse(test0));
        System.out.println(new T0007_RevertInteger().reverse(test1));
        System.out.println(new T0007_RevertInteger().reverse(test2));
        System.out.println(new T0007_RevertInteger().reverse(test3));
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}
