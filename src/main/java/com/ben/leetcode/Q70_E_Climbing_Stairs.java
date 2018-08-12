package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/12.
 */
public class Q70_E_Climbing_Stairs {
    public int climbStairs(int n) {
        if (n < 2)
            return n;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Q70_E_Climbing_Stairs q = new Q70_E_Climbing_Stairs();
        int res = q.climbStairs(4);
        Utils.println(res);
    }
}
