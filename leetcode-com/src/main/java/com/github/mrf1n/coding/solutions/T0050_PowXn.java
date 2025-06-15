package com.github.mrf1n.coding.solutions;

public class T0050_PowXn {

    public static void main(String[] args) {
        double[][] nums = new double[][] {
                {2.0, 10},
                {2.1, 3},
                {2.0, -2},
                {0.00001, 2147483647},
                {2.0, -2147483647}
        };
        for (double[] num : nums) {
            System.out.println(new T0050_PowXn().myPow(num[0], (int) num[1]));
        }

    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            n+=2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x, n - 1);
        }
    }
}
