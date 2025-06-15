package com.github.mrf1n.coding.solutions;

public class T0070_ClimbingStairs {

    public static void main(String[] args) {
        int n0 = 0, n1 = 1, n2 = 2, n3 = 3, n4 = 4;
        System.out.println(new T0070_ClimbingStairs().climbStairs(n0));
        System.out.println(new T0070_ClimbingStairs().climbStairs(n1));
        System.out.println(new T0070_ClimbingStairs().climbStairs(n2));
        System.out.println(new T0070_ClimbingStairs().climbStairs(n3));
        System.out.println(new T0070_ClimbingStairs().climbStairs(n4));
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }
}
