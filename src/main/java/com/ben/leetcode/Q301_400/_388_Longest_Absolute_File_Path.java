package com.ben.leetcode.Q301_400;

import java.util.ArrayList;
import java.util.List;

public class _388_Longest_Absolute_File_Path {
    static class Solution {
        public int lengthLongestPath(String input) {
            if (input.length() == 0)
                return 0;

            String[] paths = input.split("\n");
            int[] dp = new int[paths.length + 1];
            int maxLen = 0;
            for (String s : paths) {
                int level = s.lastIndexOf("\t") + 1;
                int curLen = dp[level + 1] = dp[level] + s.length() - level + 1;
                if (s.contains("."))
                    maxLen = Math.max(maxLen, curLen - 1);
            }
            return maxLen;
        }
    }
}
