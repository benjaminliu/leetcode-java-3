package com.ben.leetcode.Q401_500;

public class _409_Longest_Palindrome {
    static class Solution {
        public int longestPalindrome(String s) {
            int[] arr = new int[52];
            for (char c : s.toCharArray()) {
                arr[c2i(c)]++;
            }

            boolean hasOdd = false;

            int count = 0;
            for (int i = 0; i < 52; i++) {
                if (arr[i] % 2 == 1) {
                    hasOdd = true;
                    count += arr[i] - 1;
                } else
                    count += arr[i];
            }
            if (hasOdd == true)
                return count + 1;
            return count;
        }

        private int c2i(char c) {
            if (c >= 'a' && c <= 'z') {
                return c - 'a';
            }

            return c - 'A' + 26;
        }
    }
}
