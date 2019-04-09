package com.ben.leetcode.Q301_400;

public class _390_Elimination_Game {
    static class Solution {
        public int lastRemaining(int n) {
            boolean fromLeft = true;
            int remaining = n;
            int step = 1;
            int head = 1;
            while (remaining > 1) {
                if (fromLeft || remaining % 2 == 1) {
                    head = head + step;
                }

                remaining = remaining / 2;
                step = step * 2;
                fromLeft = !fromLeft;
            }
            return head;
        }
    }
}
