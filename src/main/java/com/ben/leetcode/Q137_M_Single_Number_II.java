package com.ben.leetcode;

/**
 * Created by ben on 2018/9/3.
 */
public class Q137_M_Single_Number_II {
    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                if (((n >> i) & 1) == 1) {
                    sum++;
                }
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}
