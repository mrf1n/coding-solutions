package by.mrf1n;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T167_TwoSum2 {
    public static void main(String[] args) {
        int[] numbers0 = new int[]{2, 7, 11, 15};
        int target0 = 9;
        System.out.println(Arrays.toString(twoSum(numbers0, target0)));
    }

    public static int[] twoSumPrevious(int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer ind = indexMap.get(numbers[i]);
            if (ind != null && ind != i) {
                return new int[]{ind + 1, i + 1};
            }
            indexMap.put(target - numbers[i], i);
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] out = new int[]{-1, -1};
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                out[0] = l + 1;
                out[1] = r + 1;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return out;
    }
}
