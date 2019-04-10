package com.ben.leetcode.Q301_400;

public class _393_UTF_8_Validation {
    static class Solution {
        public boolean validUtf8(int[] data) {
            int bitCount = 0;
            for (int n : data) {
                if (n >= 192) {
                    if (bitCount != 0)
                        return false;
                    if (n > 247)
                        return false;
                    else if (n >= 240)
                        bitCount = 3;
                    else if (n >= 224)
                        bitCount = 2;
                    else
                        bitCount = 1;
                } else if (n >= 128) {
                    bitCount--;
                    if (bitCount < 0)
                        return false;
                } else if (bitCount > 0) {
                    return false;
                }
            }
            return bitCount == 0;
        }
    }
}
