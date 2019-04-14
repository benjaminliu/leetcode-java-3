package com.ben.leetcode.Q401_500;

public class _402_Remove_K_Digits {
    static class Solution {
        public String removeKdigits(String num, int k) {
            int digits = num.length() - k;
            char[] stack = new char[num.length()];
            int top = 0;

            // k keeps track of how many characters we can remove
            // if the previous character in stk is larger than the current one
            // then removing it will get a smaller number
            // but we can only do so when k is larger than 0
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                while (top > 0 && stack[top - 1] > c && k > 0) {
                    top--;
                    k--;
                }
                stack[top] = c;
                top++;
            }

            // find the index of first non-zero digit
            int idx = 0;
            while (idx < digits && stack[idx] == '0')
                idx++;
            return idx == digits ? "0" : new String(stack, idx, digits - idx);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219",3));
    }
}
