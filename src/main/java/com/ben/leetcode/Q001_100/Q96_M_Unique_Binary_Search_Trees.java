package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/19.
 */
public class Q96_M_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Q96_M_Unique_Binary_Search_Trees q = new Q96_M_Unique_Binary_Search_Trees();
        int res = q.numTrees(3);
        Utils.println(res);
    }
}
