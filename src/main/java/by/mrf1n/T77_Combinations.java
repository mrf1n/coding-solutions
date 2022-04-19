package by.mrf1n;

import java.util.ArrayList;
import java.util.List;

public class T77_Combinations {
    public static void main(String[] args) {
        int n0 = 4, k0 = 2;
        System.out.println(new T77_Combinations().combine(n0, k0));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> out = new ArrayList<>();
        backtracking(new ArrayList<>(), 1, n, k, out);
        return out;
    }

    public void backtracking(List<Integer> tmp, int begin, int n, int k, List<List<Integer>> out) {
        if (k == 0) {
            out.add(new ArrayList<>(tmp));
        }
        for (int i = begin; i <= n; i++) {
            tmp.add(i);
            backtracking(tmp, i + 1, n, k - 1, out);
            tmp.remove(tmp.size() - 1);
        }
    }
}
