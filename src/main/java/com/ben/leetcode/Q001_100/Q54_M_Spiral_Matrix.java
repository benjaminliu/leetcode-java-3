package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/6.
 */
public class Q54_M_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int i = 0, j = 0;
        int direction = 0;
        int idx = 0;
        int len = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (idx < len) {
            int mod = direction % 4;
            if (mod == 0) {
                //go right;
                while (j <= right) {
                    res.add(matrix[i][j++]);
                    idx++;
                }
                top++;
                j--;
                i++;
            } else if (mod == 1) {
                //go down
                while (i <= down) {
                    res.add(matrix[i++][j]);
                    idx++;
                }
                right--;
                i--;
                j--;
            } else if (mod == 2) {
                //go left
                while (j >= left) {
                    res.add(matrix[i][j--]);
                    idx++;
                }
                down--;
                j++;
                i--;
            } else {
                //go up
                while (i >= top) {
                    res.add(matrix[i--][j]);
                    idx++;
                }
                left++;
                i++;
                j++;
            }
            direction++;
        }
        return res;
    }

    public static void main(String[] args) {
        Q54_M_Spiral_Matrix q = new Q54_M_Spiral_Matrix();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> res = q.spiralOrder(matrix);
        Utils.printList(res);
    }
}
