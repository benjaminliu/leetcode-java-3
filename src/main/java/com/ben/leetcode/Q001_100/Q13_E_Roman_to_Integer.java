package com.ben.leetcode;

/**
 * Created by ben on 2018/7/28.
 */
public class Q13_E_Roman_to_Integer {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int idx = 0;
        int res = 0;

        while (idx < len && s.charAt(idx) == 'M') {
            res += 1000;
            idx++;
        }

        if (idx < len - 1 && s.charAt(idx) == 'C' && s.charAt(idx + 1) == 'M') {
            res += 900;
            idx += 2;
        }

        if (idx < len && s.charAt(idx) == 'D') {
            res += 500;
            idx++;
        }

        if (idx < len - 1 && s.charAt(idx) == 'C' && s.charAt(idx + 1) == 'D') {
            res += 400;
            idx += 2;
        }

        while (idx < len && s.charAt(idx) == 'C') {
            res += 100;
            idx++;
        }

        if (idx < len - 1 && s.charAt(idx) == 'X' && s.charAt(idx + 1) == 'C') {
            res += 90;
            idx += 2;
        }

        if (idx < len && s.charAt(idx) == 'L') {
            res += 50;
            idx++;
        }

        if (idx < len - 1 && s.charAt(idx) == 'X' && s.charAt(idx + 1) == 'L') {
            res += 40;
            idx += 2;
        }

        while (idx < len && s.charAt(idx) == 'X') {
            res += 10;
            idx++;
        }

        if (idx < len - 1 && s.charAt(idx) == 'I' && s.charAt(idx + 1) == 'X') {
            res += 9;
            idx += 2;
        }

        if (idx < len && s.charAt(idx) == 'V') {
            res += 5;
            idx++;
        }

        if (idx < len - 1 && s.charAt(idx) == 'I' && s.charAt(idx + 1) == 'V') {
            res += 4;
            idx += 2;
        }

        while (idx < len && s.charAt(idx) == 'I') {
            res += 1;
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
        Q13_E_Roman_to_Integer q = new Q13_E_Roman_to_Integer();
        int res = q.romanToInt("LVIII");
        System.out.println(res);
    }
}
