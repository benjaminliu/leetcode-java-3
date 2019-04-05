package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/30.
 */
public class Q28_E_Implement_strSt {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;

        if (haystack == null || haystack.length() == 0)
            return -1;

        int len = haystack.length();
        int lenNeedle = needle.length();
        long targetSum = calcSum(needle, 0, lenNeedle);

        for (int i = 0, end = len - lenNeedle; i <= end; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                long sum = calcSum(haystack, i, i + lenNeedle);
                if (sum == targetSum) {
                    if (compareString(haystack, i, len, needle, 0, lenNeedle, lenNeedle))
                        return i;
                }
            }
        }
        return -1;
    }

    private boolean compareString(String leftStr, int leftStart, int leftLen, String rightStr, int rightStart, int rightLen, int compareLen) {
        for (int i = 0; i < compareLen; i++) {
            int left = leftStart + i;
            int right = rightStart + i;
            if (leftStr.charAt(left) != rightStr.charAt(right))
                return false;
        }
        return true;
    }

    private long calcSum(String str, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res += str.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Q28_E_Implement_strSt q = new Q28_E_Implement_strSt();
        int res = q.strStr("babbbbbabb", "bbab");
        Utils.print(res);
    }
}
