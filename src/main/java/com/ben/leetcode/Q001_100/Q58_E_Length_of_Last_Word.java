package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/7.
 */
public class Q58_E_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0)
            return 0;
        int idx = s.length() - 1;

        //begin space
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }
        if (idx == -1)
            return 0;

        if (idx == 0)
            return 1;

        int lastChar = idx;

        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
        }

        return lastChar - idx;
    }

    public static void main(String[] args) {
        Q58_E_Length_of_Last_Word q = new Q58_E_Length_of_Last_Word();
        int res = q.lengthOfLastWord("day");
        Utils.print(res);

    }
}
