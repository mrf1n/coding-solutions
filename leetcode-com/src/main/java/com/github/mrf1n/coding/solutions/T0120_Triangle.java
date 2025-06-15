package com.github.mrf1n.coding.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T0120_Triangle {
    public static void main(String[] args) {
        Integer[][] triInt0 = new Integer[][]{{-10}};
        List<List<Integer>> triangle0 = Arrays.stream(triInt0).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(new T0120_Triangle().minimumTotal(triangle0));

        Integer[][] triInt1 = new Integer[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangle1 = Arrays.stream(triInt1).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(new T0120_Triangle().minimumTotal(triangle1));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size() - 1; j++) {
                if (i > 0) {
                    int cur = triangle.get(i).get(j);
                    int curOne = triangle.get(i).get(j + 1);
                    triangle.get(i - 1).set(j, triangle.get(i - 1).get(j) + Math.min(cur, curOne));
                }
            }
        }
        return triangle.get(0).get(0);
    }
}
