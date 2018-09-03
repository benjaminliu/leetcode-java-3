package com.ben.leetcode;

/**
 * Created by ben on 2018/9/3.
 */
public class Q136_M_Single_Number {
    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;

        int temp = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            temp ^= nums[i];
        }
        return temp;
    }
}
