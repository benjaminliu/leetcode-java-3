package com.ben.leetcode.Q301_400;

public class _396_Rotate_Function {
    static class Solution {
        public int maxRotateFunction(int[] A) {
            int allSum = 0;
            int len = A.length;
            int f = 0;
            for (int i = 0; i < len; i++) {
                f += i * A[i];
                allSum += A[i];
            }
            int max = f;
            for (int i = len - 1; i > 0; i--) {
                f = f + allSum - len * A[i];
                max = Math.max(f, max);
            }
            return max;
        }
    }
}
