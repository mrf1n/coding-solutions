package by.mrf1n;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class T46_Permutations {
    public static void main(String[] args) {
        int[] nums0 = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(new T46_Permutations().permute(nums0));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtracking(0, list, out);
        return out;
    }

    public void backtracking(int begin, List<Integer> tmp, List<List<Integer>> out) {
        if (begin >= tmp.size()) {
            out.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = begin; i < tmp.size(); i++) {
            Collections.swap(tmp, i, begin);
            backtracking(begin + 1, tmp, out);
            Collections.swap(tmp, i, begin);
        }
    }
}
