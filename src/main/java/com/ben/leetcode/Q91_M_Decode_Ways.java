package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/18.
 */
public class Q91_M_Decode_Ways {

    public int numDecodings(String s) {
        if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Q91_M_Decode_Ways q = new Q91_M_Decode_Ways();
        int res = q.numDecodings("100");
        Utils.println(res);
        res = q.numDecodings("12");
        Utils.println(res);
        res = q.numDecodings("0");
        Utils.println(res);
        res = q.numDecodings("100");
        Utils.println(res);
        res = q.numDecodings("00");
        Utils.println(res);
        res = q.numDecodings("01");
        Utils.println(res);
    }
}
