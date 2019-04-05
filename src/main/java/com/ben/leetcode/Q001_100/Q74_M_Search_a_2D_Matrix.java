package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/12.
 */
public class Q74_M_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        if (target < matrix[0][0])
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (target > matrix[m - 1][n - 1])
            return false;

        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / n;
            int midCol = mid % n;

            if (matrix[midRow][midCol] == target)
                return true;
            if (matrix[midRow][midCol] > target)
                right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Q74_M_Search_a_2D_Matrix q = new Q74_M_Search_a_2D_Matrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        boolean res = q.searchMatrix(matrix, 3);
        Utils.println(res);
        res = q.searchMatrix(matrix, 13);
        Utils.println(res);
    }
}
