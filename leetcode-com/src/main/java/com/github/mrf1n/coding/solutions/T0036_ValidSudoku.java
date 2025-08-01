package com.github.mrf1n.coding.solutions;

import java.util.HashSet;
import java.util.Set;

public class T0036_ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                  {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new T0036_ValidSudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i)
                            || !seen.add(number + " in column " + j)
                            || !seen.add(number + " in block [" + i / 3 + "" + j / 3 + "]")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
