package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/13.
 */
public class Q79_M_Word_Search {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;

        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = 1;
                    if (dfs(board, visited, m - 1, n - 1, i, j, word, 1, word.length()))
                        return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int[][] visited, int m, int n, int i, int j, String word, int idx, int length) {
        if (idx == length)
            return true;

        int temp;
        if (i > 0) {
            temp = i - 1;
            if (visited[temp][j] == 0 && board[temp][j] == word.charAt(idx)) {
                visited[temp][j] = 1;
                if (dfs(board, visited, m, n, temp, j, word, idx + 1, length))
                    return true;
                visited[temp][j] = 0;
            }
        }
        if (i < m) {
            temp = i + 1;
            if (visited[temp][j] == 0 && board[temp][j] == word.charAt(idx)) {
                visited[temp][j] = 1;
                if (dfs(board, visited, m, n, temp, j, word, idx + 1, length))
                    return true;
                visited[temp][j] = 0;
            }
        }
        if (j > 0) {
            temp = j - 1;

            if (visited[i][temp] == 0 && board[i][temp] == word.charAt(idx)) {
                visited[i][temp] = 1;
                if (dfs(board, visited, m, n, i, temp, word, idx + 1, length))
                    return true;
                visited[i][temp] = 0;
            }
        }
        if (j < n) {
            temp = j + 1;

            if (visited[i][temp] == 0 && board[i][temp] == word.charAt(idx)) {
                visited[i][temp] = 1;
                if (dfs(board, visited, m, n, i, temp, word, idx + 1, length))
                    return true;
                visited[i][temp] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q79_M_Word_Search q = new Q79_M_Word_Search();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean res = q.exist(board, "ABCCED");
        Utils.println(res);
        res = q.exist(board, "SEE");
        Utils.println(res);
        res = q.exist(board, "ABCB");
        Utils.println(res);
    }
}
