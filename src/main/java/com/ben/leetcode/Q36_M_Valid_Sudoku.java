package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/1.
 */
public class Q36_M_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] areas = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j])
                    continue;
                int value = board[i][j] - '1';
                if (rows[i][value] == true) {
                    return false;
                }
                if (cols[j][value] == true) {
                    return false;
                }
                //0,1,2
                //3,4,5
                //6,7,8
                int left = i / 3 * 3 + j / 3;
                if (areas[left][value] == true) {
                    return false;
                }
                rows[i][value] = true;
                cols[j][value] = true;
                areas[left][value] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];

        int[] area1 = new int[9];
        int[] area2 = new int[9];
        int[] area3 = new int[9];
        int[] area4 = new int[9];
        int[] area5 = new int[9];
        int[] area6 = new int[9];
        int[] area7 = new int[9];
        int[] area8 = new int[9];
        int[] area9 = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j])
                    continue;
                int value = board[i][j] - '1';
                if (rows[i][value] == 1) {
                    return false;
                }
                rows[i][value] = 1;
                if (cols[j][value] == 1) {
                    return false;
                }
                cols[j][value] = 1;
                if (i < 3) {
                    if (j < 3) {
                        if (area1[value] == 1) {
                            return false;
                        }
                        area1[value] = 1;
                    } else if (j < 6) {
                        if (area2[value] == 1) {
                            return false;
                        }
                        area2[value] = 1;
                    } else {
                        if (area3[value] == 1) {
                            return false;
                        }
                        area3[value] = 1;
                    }
                } else if (i < 6) {
                    if (j < 3) {
                        if (area4[value] == 1) {
                            return false;
                        }
                        area4[value] = 1;
                    } else if (j < 6) {
                        if (area5[value] == 1) {
                            return false;
                        }
                        area5[value] = 1;
                    } else {
                        if (area6[value] == 1) {
                            return false;
                        }
                        area6[value] = 1;
                    }
                } else {
                    if (j < 3) {
                        if (area7[value] == 1) {
                            return false;
                        }
                        area7[value] = 1;
                    } else if (j < 6) {
                        if (area8[value] == 1) {
                            return false;
                        }
                        area8[value] = 1;
                    } else {
                        if (area9[value] == 1) {
                            return false;
                        }
                        area9[value] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q36_M_Valid_Sudoku q = new Q36_M_Valid_Sudoku();
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        char[][] board = {
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        boolean res = q.isValidSudoku(board);
        Utils.print(res);
    }
}
