package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/9.
 */
public class Q63_M_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else
                break;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = 1;
            else
                break;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        if (m == 1 && n == 1) {
            return dp[0][0];
        }
        if (m == 1) {
            return dp[0][n - 1];
        }
        if (n == 1) {
            return dp[m - 1][0];
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Q63_M_Unique_Paths_II q = new Q63_M_Unique_Paths_II();
//        int[][] matrix = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
//        int[][] matrix = {
//                {0, 0}
//        };
        int[][] matrix = {
                {0},
                {0}
        };
        int res = q.uniquePathsWithObstacles(matrix);
        Utils.print(res);
    }
}
