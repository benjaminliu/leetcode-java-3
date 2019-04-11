package com.ben.leetcode.Q301_400;

import java.util.Stack;

public class _394_Decode_String {
    static class Solution {
        public String decodeString(String s) {
            String res = "";
            Stack<Integer> countStack = new Stack<>();
            Stack<String> resStack = new Stack<>();
            int idx = 0;
            int len = s.length();
            while (idx < len) {
                if (Character.isDigit(s.charAt(idx))) {
                    int count = 0;
                    while (Character.isDigit(s.charAt(idx))) {
                        count = count * 10 + (s.charAt(idx) - '0');
                        idx++;
                    }
                    countStack.push(count);
                } else if (s.charAt(idx) == '[') {
                    resStack.push(res);
                    res = "";
                    idx++;
                } else if (s.charAt(idx) == ']') {
                    StringBuilder sb = new StringBuilder(resStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        sb.append(res);
                    }
                    res = sb.toString();
                    idx++;
                } else {
                    res += s.charAt(idx);
                    idx++;
                }
            }
            return res;
        }
    }
}
