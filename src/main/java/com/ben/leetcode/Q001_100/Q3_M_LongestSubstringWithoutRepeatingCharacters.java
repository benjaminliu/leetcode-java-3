package com.ben.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2018/5/19.
 */
public class Q3_M_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        Map<Character, Integer> map = new HashMap<>();
        int lastIdx = 0;
        int maxLen = 0;
        int len = s.length();
        int i = 0;
        for (; i < len; i++) {
            char c = s.charAt(i);
            Integer idx = map.get(c);
            if (null == idx) {
            } else {
                if (idx < lastIdx) {
                } else {
                    int temp = i - lastIdx;
                    if (temp > maxLen) {
                        maxLen = temp;
                    }
                    lastIdx = idx + 1;
                }
            }
            map.put(c, i);
        }
        int temp = i - lastIdx;
        if (temp > maxLen) {
            maxLen = temp;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Q3_M_LongestSubstringWithoutRepeatingCharacters q = new Q3_M_LongestSubstringWithoutRepeatingCharacters();
        int res = q.lengthOfLongestSubstring(s);

        System.out.print(res);
    }
}
