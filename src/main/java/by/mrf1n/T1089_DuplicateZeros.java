package by.mrf1n;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class T1089_DuplicateZeros {

    public static void main(String[] args) {
        int[] arr0 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        new T1089_DuplicateZeros().duplicateZeros(arr0);
        System.out.println(Arrays.toString(arr0));

        arr0 = new int[]{1, 0, 0, 2, 3, 0, 5, 4};
        new T1089_DuplicateZeros().duplicateZeros(arr0);
        System.out.println(Arrays.toString(arr0));

        arr0 = new int[]{1, 5, 2, 0, 6, 8, 0, 6, 0};
        new T1089_DuplicateZeros().duplicateZeros(arr0);
        System.out.println(Arrays.toString(arr0));

        arr0 = new int[]{0, 1, 7, 6, 0, 2, 0, 7};
        new T1089_DuplicateZeros().duplicateZeros(arr0);
        System.out.println(Arrays.toString(arr0));

        arr0 = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
        new T1089_DuplicateZeros().duplicateZeros(arr0);
        System.out.println(Arrays.toString(arr0));

        arr0 = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
        new T1089_DuplicateZeros().duplicateZerosQueues(arr0);
        System.out.println(Arrays.toString(arr0));
    }

    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int lIndex;
        for (lIndex = 0; lIndex < arr.length - zeros; lIndex++) {
            if (arr[lIndex] == 0) {
                zeros++;
            }
        }

        boolean halfZero = zeros > 0 && lIndex == arr.length - zeros;
        for (int i = lIndex, j = arr.length - 1; i >= 0 && zeros > 0; i--) {
            arr[j--] = arr[i];
            if (arr[i] == 0 && halfZero) {
                halfZero = false;
            } else if (arr[i] == 0) {
                arr[j--] = arr[i];
            }
        }
    }

    public void duplicateZerosQueues(int[] arr) {
        Queue<Integer> queueNums = new ArrayDeque<>();
        Queue<Integer> queueMulti = new ArrayDeque<>();
        int curNum = -1;
        int curMulti = 0;
        for (int i = 0; i < arr.length; i++) {
            queueNums.add(arr[i]);
            if (arr[i] == 0) {
                queueMulti.add(2);
            } else {
                queueMulti.add(1);
            }

            if (curMulti == 0 && !queueNums.isEmpty() && !queueMulti.isEmpty()) {
                curNum = queueNums.poll();
                curMulti = queueMulti.poll();
            }

            arr[i] = curNum;
            curMulti--;
        }
    }
}
