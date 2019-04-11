package com.ben.leetcode.Q301_400;

public class _395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    static class Solution {
        public int longestSubstring(String s, int k) {
            if (s == null || s.length() == 0)
                return 0;
            int[] chars = new int[26];
            for (int i = 0; i < s.length(); i++)
                chars[s.charAt(i) - 'a']++;

            boolean flag = true;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < k && chars[i] > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true)
                return s.length();

            int res = 0;
            int start = 0, cur = 0;
            while (cur < s.length()) {
                if (chars[s.charAt(cur) - 'a'] < k) {
                    res = Math.max(res, longestSubstring(s.substring(start, cur), k));
                    start = cur + 1;
                }
                cur++;
            }
            res = Math.max(res, longestSubstring(s.substring(start), k));
            return res;
        }
    }
}
