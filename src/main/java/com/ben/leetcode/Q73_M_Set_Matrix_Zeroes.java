package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/12.
 */
public class Q73_M_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0)
            return;

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1)
                    continue;

                if (matrix[i][j] == 0)
                    zeroRowColumn(i, j, matrix, visited, m, n);
            }
        }
    }

    private void zeroRowColumn(int i, int j, int[][] matrix, int[][] visited, int m, int n) {
        for (int x = 0; x < m; x++) {
            if (matrix[x][j] != 0) {
                matrix[x][j] = 0;
                visited[x][j] = 1;
            }
        }

        for (int x = 0; x < n; x++) {
            if (matrix[i][x] != 0) {
                matrix[i][x] = 0;
                visited[i][x] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Q73_M_Set_Matrix_Zeroes q = new Q73_M_Set_Matrix_Zeroes();
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        q.setZeroes(matrix);
        Utils.printMatrix(matrix);
    }
}
