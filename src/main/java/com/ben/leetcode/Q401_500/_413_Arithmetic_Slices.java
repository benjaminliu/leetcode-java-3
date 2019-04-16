package com.ben.leetcode.Q401_500;

public class _413_Arithmetic_Slices {
    static class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int cur = 0;
            int sum = 0;
            for (int i = 2; i < A.length; i++) {
                if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                    cur++;
                    sum += cur;
                } else
                    cur = 0;
            }
            return sum;
        }
    }
}
