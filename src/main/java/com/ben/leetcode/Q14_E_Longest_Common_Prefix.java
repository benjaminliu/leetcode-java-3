package com.ben.leetcode;

/**
 * Created by ben on 2018/7/28.
 */
public class Q14_E_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (strs[i] == null || strs[i].length() == 0)
                return "";

            if (minLen > strs[i].length())
                minLen = strs[i].length();
        }
        int i = 0;
        outter:
        for (; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (c != strs[j].charAt(i)) {
                    break outter;
                }
            }
        }
        if (i == 0)
            return "";
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        Q14_E_Longest_Common_Prefix q = new Q14_E_Longest_Common_Prefix();
        String[] strs = {"flower", "flow", "flight"};
        String res = q.longestCommonPrefix(strs);
        System.out.println(res);
    }
}
