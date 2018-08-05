package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/5.
 */
public class Q48_M_Rotate_Image {


    public void rotate(int[][] matrix) {
        if (matrix.length < 2)
            return;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Q48_M_Rotate_Image q = new Q48_M_Rotate_Image();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        q.rotate(matrix);

        Utils.printMatrix(matrix);
    }
}
