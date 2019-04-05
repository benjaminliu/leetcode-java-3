package com.ben.leetcode;

/**
 * Created by ben on 2018/8/28.
 */
public class Q121_E_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int low = prices[0];
        int profit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] < low) {
                low = prices[i];
            } else {
                int diff = prices[i] - low;
                if (diff > profit)
                    profit = diff;
            }
        }
        return profit;
    }
}
