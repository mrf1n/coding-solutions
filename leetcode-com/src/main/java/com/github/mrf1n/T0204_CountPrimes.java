package com.github.mrf1n;

public class T0204_CountPrimes {
    public static void main(String[] args) {
        System.out.println(new T0204_CountPrimes().countPrimes(50));
    }

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = n - 2;
        boolean[] prime = new boolean[n];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p < n; p++) {
            if (prime[p]) {
                for (int i = p * p; i < n; i += p) {
                    if (prime[i]) {
                        count--;
                    }
                    prime[i] = false;
                }
            }
        }

        return count;
    }
}
