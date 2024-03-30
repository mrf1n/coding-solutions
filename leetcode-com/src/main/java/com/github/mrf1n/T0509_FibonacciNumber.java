package com.github.mrf1n;

import java.util.HashMap;
import java.util.Map;

public class T0509_FibonacciNumber {

    public static void main(String[] args) {
        int[] ns = new int[]{0, 1, 2, 3, 4, 10, 30};
        for (int n : ns) {
            System.out.println(new T0509_FibonacciNumber().fib(n));
        }
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result;

        if (n < 2) {
            result = n;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }

        cache.put(n, result);
        return result;
    }
}
