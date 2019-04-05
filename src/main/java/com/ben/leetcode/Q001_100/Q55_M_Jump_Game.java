package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/6.
 */
public class Q55_M_Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        if (nums.length == 1)
            return true;

        if (nums[0] == 0)
            return false;

        int len = nums.length - 1;
        int maxStep = nums[0];
        for (int i = 1; i < len; i++) {
            maxStep = Math.max(maxStep - 1, nums[i]);
            if (maxStep == 0)
                return false;
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        Q55_M_Jump_Game q = new Q55_M_Jump_Game();
//        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {0};
        boolean res = q.canJump(nums);
        Utils.print(res);
    }
}
