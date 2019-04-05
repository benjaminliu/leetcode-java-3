package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/31.
 */
public class Q130_M_Surrounded_Regions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;

        int row = board.length;
        int col = board[0].length;

        int[][] visited = new int[row][col];
        for (int j = 0; j < col; j++) {
            if (visited[0][j] > 0)
                continue;
            if (board[0][j] == 'O') {
                visited[0][j] = 2;
                helper(board, visited, 0, j, row, col);
            }
        }
        for (int j = 0; j < col; j++) {
            int x = row - 1;
            if (visited[x][j] > 0)
                continue;
            if (board[x][j] == 'O') {
                visited[x][j] = 2;
                helper(board, visited, x, j, row, col);
            }
        }

        for (int i = 0; i < row; i++) {
            if (visited[i][0] > 0)
                continue;
            if (board[i][0] == 'O') {
                visited[i][0] = 2;
                helper(board, visited, i, 0, row, col);
            }
        }

        for (int i = 0; i < row; i++) {
            int y = col - 1;
            if (visited[i][y] > 0)
                continue;
            if (board[i][y] == 'O') {
                visited[i][y] = 2;
                helper(board, visited, i, y, row, col);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 2) {

                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void helper(char[][] board, int[][] visited, int i, int j, int row, int col) {
        if (i > 0) {
            int x = i - 1;
            if (visited[x][j] > 0) {
                //visited
            } else {
                //note visited
                if (board[x][j] == 'O') {
                    visited[x][j] = 2;
                    helper(board, visited, x, j, row, col);
                } else {
                    visited[x][j] = 1;
                }
            }
        }
        if (i < row - 1) {
            int x = i + 1;
            if (visited[x][j] > 0) {
                //visited
            } else {
                //note visited
                if (board[x][j] == 'O') {
                    visited[x][j] = 2;
                    helper(board, visited, x, j, row, col);
                } else {
                    visited[x][j] = 1;
                }
            }
        }
        if (j > 0) {
            int y = j - 1;
            if (visited[i][y] > 0) {

            } else {
                if (board[i][y] == 'O') {
                    visited[i][y] = 2;
                    helper(board, visited, i, y, row, col);
                } else {
                    visited[i][y] = 1;
                }
            }
        }
        if (j < col - 1) {
            int y = j + 1;
            if (visited[i][y] > 0) {

            } else {
                if (board[i][y] == 'O') {
                    visited[i][y] = 2;
                    helper(board, visited, i, y, row, col);
                } else {
                    visited[i][y] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        Q130_M_Surrounded_Regions q = new Q130_M_Surrounded_Regions();
        q.solve(board);
        Utils.printMatrix(board);
    }
}
