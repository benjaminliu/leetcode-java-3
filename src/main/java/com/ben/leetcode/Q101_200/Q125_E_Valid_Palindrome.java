package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/28.
 */
public class Q125_E_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right && alpha(s.charAt(left)) == -1) {
            left++;
        }
        if (left == right)
            return true;

        while (alpha(s.charAt(right)) == -1) {
            right--;
        }
        while (left < right) {
            if (alpha(s.charAt(left)) == -1) {
                left++;
            } else if (alpha(s.charAt(right)) == -1) {
                right--;
            } else if (alpha(s.charAt(left)) == alpha(s.charAt(right))) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    private int alpha(char c) {
        int i = c - '0';
        if (i >= 0 && i < 10)
            return i;
        i = c - 'a';
        if (i >= 0 && i < 27)
            return i + 10;
        i = c - 'A';
        if (i >= 0 && i < 27)
            return i + 10;
        return -1;
    }

    public static void main(String[] args) {
        Q125_E_Valid_Palindrome q = new Q125_E_Valid_Palindrome();
        boolean res = q.isPalindrome("A man, a plan, a canal: Panama");
        Utils.println(res);
        res = q.isPalindrome("race a car");
        Utils.println(res);
    }
}
