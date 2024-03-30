package com.github.mrf1n;

public class T0074_Search2DMatrix {
    public static void main(String[] args) {
        int[][] mat0 = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target0 = 10;
        System.out.println(new T0074_Search2DMatrix().searchMatrix(mat0, target0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            if(i+1 == matrix.length || (i+1 < matrix.length && target < matrix[i+1][0]))  {
                for(int j = 0; j < matrix[i].length; j++){
                    if( matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
