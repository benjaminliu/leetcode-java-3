package com.ben.leetcode;

/**
 * Created by ben on 2018/5/19.
 */
public class M_5_LongestPalindromicSubstring {
    private int max;
    private int lower;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        int len = s.length();

        for (int i = 0; i < len; i++) {
            eventPalindrom(s, i, len);

            oddPalindrom(s, i, len);
        }
        return s.substring(lower, lower + max);
    }

    private void oddPalindrom(String s, int i, int len) {
        int left = i;
        int right = i + 1;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int temp = right - left - 1;
        if (temp > max) {
            max = temp;
            lower = left + 1;
        }
    }

    private void eventPalindrom(String s, int i, int len) {
        int left = i - 1;
        int right = i + 1;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int temp = right - left - 1;
        if (temp > max) {
            max = temp;
            lower = left + 1;
        }
    }
}
