package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/7.
 */
public class Q59_M_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {


        int[][] matrix = new int[n][n];
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int direction = 0;
        int cur = 1;
        int last = n * n;
        int i = 0;
        int j = 0;
        while (cur <= last) {
            if (direction == 0) {
                //go right
                while (j <= right) {
                    matrix[i][j] = cur++;
                    j++;
                }
                top++;
                i++;
                j--;
                direction = 1;
            } else if (direction == 1) {
                //go down
                while (i <= down) {
                    matrix[i][j] = cur++;
                    i++;
                }
                j--;
                i--;
                right--;
                direction = 2;
            } else if (direction == 2) {
                //go left
                while (j >= left) {
                    matrix[i][j] = cur++;
                    j--;
                }
                i--;
                j++;
                down--;
                direction = 3;
            } else {
                //go up
                while (i >= top) {
                    matrix[i][j] = cur++;
                    i--;
                }
                i++;
                j++;
                left++;
                direction = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Q59_M_Spiral_Matrix_II q = new Q59_M_Spiral_Matrix_II();
        int[][] res = q.generateMatrix(4);
        Utils.printMatrix(res);
    }
}
