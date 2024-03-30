package com.github.mrf1n;

public class T0461_HammingDistance {

    public static void main(String[] args) {
        int x0 = 1, y0 = 4;
        System.out.println(new T0461_HammingDistance().hammingDistance(x0, y0));
        int x1 = 1, y1 = 3;
        System.out.println(new T0461_HammingDistance().hammingDistance(x1, y1));
        int x2 = 1, y2 = 8;
        System.out.println(new T0461_HammingDistance().hammingDistance(x2, y2));
    }

    public int hammingDistance(int x, int y) {
        int weight = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                weight++;
            }
            x >>>=1;
            y >>>=1;
        }
        return weight;
    }
}
