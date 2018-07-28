package com.ben.leetcode;

/**
 * Created by ben on 2018/5/20.
 */
public class Q8_M_StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        boolean isPositive = true;
        long res = 0;
        int idx = 0;
        int len = str.length();

        //remove leading space
        while (idx < len && str.charAt(idx) == ' ')
            idx++;

        //empty string
        if (idx == len)
            return 0;

        char firstChar = str.charAt(idx);
        if (firstChar == '-') {
            isPositive = false;
            idx++;
        } else if (firstChar == '+') {
            idx++;
        } else if (firstChar < '0' || firstChar > '9')
            return 0;

        //only a -
        if (idx == len)
            return 0;

        //remove leading zero
        while (idx < len && str.charAt(idx) == '0')
            idx++;

        if (idx == len)
            return 0;

        int len1 = 0;
        char currentChar = str.charAt(idx);
        while (currentChar >= '0' && currentChar <= '9') {
            res = res * 10 + currentChar - '0';
            idx++;
            len1++;
            if (len1 > 11)
                break;
            if (idx == len) {
                break;
            }
            currentChar = str.charAt(idx);
        }

        if (isPositive == true) {
            if (res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int) res;
        }

        res = res * -1;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) res;
    }

    public static void main(String[] args) {
        String s = "42";
        Q8_M_StringToInteger q = new Q8_M_StringToInteger();
        int i = q.myAtoi(s);
        System.out.print(i);
    }
}
