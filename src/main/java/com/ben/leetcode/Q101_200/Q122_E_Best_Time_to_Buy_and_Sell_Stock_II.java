package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/28.
 */
public class Q122_E_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int len = prices.length;
        int last = len - 1;
        int idx = 0;
        while (idx < last) {
            if (prices[idx] < prices[idx + 1])
                break;
            idx++;
        }
        if (idx == last)
            return 0;
        if (idx == 0)
            idx++;

        int profix = 0;
        int low = prices[idx - 1];

        while (idx < len) {
            if (prices[idx] >= prices[idx - 1]) {
            } else {
                profix += prices[idx - 1] - low;
                low = prices[idx];
            }
            idx++;
        }
        if (prices[len - 1] > low)
            profix += prices[len - 1] - low;
        return profix;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        Q122_E_Best_Time_to_Buy_and_Sell_Stock_II q = new Q122_E_Best_Time_to_Buy_and_Sell_Stock_II();
        int res = q.maxProfit(nums);
        Utils.println(res);

        int[] nums1 = {1, 2, 3, 4, 5};
        res = q.maxProfit(nums1);
        Utils.println(res);

        int[] nums2 = {7, 6, 4, 3, 1};
        res = q.maxProfit(nums2);
        Utils.println(res);
    }
}
