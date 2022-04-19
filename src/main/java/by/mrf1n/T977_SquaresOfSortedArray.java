package by.mrf1n;

import java.util.Arrays;

public class T977_SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] test0 = new int[]{-4, -1, 0, 3, 10};
        int[] test1 = new int[]{-7, -3, 2, 3, 11};
        int[] test2 = new int[]{1};
        int[] test3 = new int[]{-5, -3, -2, -1};
        int[] test4 = new int[]{-1, 2, 2};
        System.out.println(Arrays.toString(sortedSquaresBest(test0)));
        System.out.println(Arrays.toString(sortedSquaresBest(test1)));
        System.out.println(Arrays.toString(sortedSquaresBest(test2)));
        System.out.println(Arrays.toString(sortedSquaresBest(test3)));
        System.out.println(Arrays.toString(sortedSquaresBest(test4)));
    }

    public static int[] sortedSquaresIncorrect(int[] nums) {
        int[] outNums = new int[nums.length];
        int m = 0, l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                l = r = i;
                break;
            }
        }
        while (l >= 0 && r < nums.length) {
            if (l == r) {
                outNums[m++] = nums[l] * nums[l];
                l--;
                r++;
            }
            if (r < nums.length && Math.abs(nums[r]) < Math.abs(nums[l])) {
                outNums[m++] = nums[r] * nums[r];
                r++;
            } else if (l >= 0) {
                outNums[m++] = nums[l] * nums[l];
                l--;
            }
            if (l >= 0 && Math.abs(nums[r]) > Math.abs(nums[l])) {
                outNums[m++] = nums[l] * nums[l];
                l--;
            } else if (r < nums.length) {
                outNums[m++] = nums[r] * nums[r];
                r++;
            }
        }
        return outNums;
    }

    public static int[] sortedSquares(int[] nums) {
        int[] outNums = new int[nums.length];
        int m = 0, l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            l = r = i;
            if (nums[i] >= 0) {
                if (l > 0 && nums[l - 1] < nums[l]) {
                    l = l - 1;
                }
                break;
            }
        }
        while (l >= 0 || r < nums.length) {
            if (l == r) {
                outNums[m++] = nums[l] * nums[l];
                l--;
                r++;
            } else if (l >= 0 && r < nums.length) {
                if (Math.abs(nums[r]) < Math.abs(nums[l])) {
                    outNums[m++] = nums[r] * nums[r];
                    r++;
                } else {
                    outNums[m++] = nums[l] * nums[l];
                    l--;
                }
            } else if (l >= 0) {
                outNums[m++] = nums[l] * nums[l];
                l--;
            } else {
                outNums[m++] = nums[r] * nums[r];
                r++;
            }
        }
        return outNums;
    }

    public static int[] sortedSquaresBest(int[] nums) {
        int l = 0, r = nums.length - 1, k = r;
        int[] outNums = new int[nums.length];

        while (l <= r) {
            int powL = nums[l] * nums[l];
            int powR = nums[r] * nums[r];
            if (powR > powL) {
                outNums[k--] = powR;
                r--;
            } else {
                outNums[k--] = powL;
                l++;
            }
        }
        return outNums;
    }
}
