package com.ben.leetcode.Q301_400;

public class _389_Find_the_Difference {
    static class Solution {
        public char findTheDifference(String s, String t) {
            int[] map = new int[26];
            for (int i = 0, end = s.length(); i < end; i++) {
                char c = s.charAt(i);
                map[c - 'a']++;
            }

            for (int i = 0, end = t.length(); i < end; i++) {
                char c = t.charAt(i);
                int temp = c - 'a';
                map[temp]--;
                if (map[temp] < 0)
                    return c;
            }

            return t.charAt(t.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd","abcde"));
    }
}
