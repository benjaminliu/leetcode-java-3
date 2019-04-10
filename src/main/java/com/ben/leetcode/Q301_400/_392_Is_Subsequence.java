package com.ben.leetcode.Q301_400;

public class _392_Is_Subsequence {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0)
                return true;

            int indexS = 0;
            int indexT = 0;
            while (indexT < t.length()) {
                if (t.charAt(indexT) == s.charAt(indexS)) {
                    indexS++;
                    if (indexS == s.length())
                        return true;
                }
                indexT++;
            }
            return false;
        }

        public boolean isSubsequence1(String s, String t) {
            int idx = -1;
            for (char c : s.toCharArray()) {
                idx = t.indexOf(c, idx + 1);

                if (idx == -1) {
                    return false;
                }
            }
            return true;
        }
    }
}
