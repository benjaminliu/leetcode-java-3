package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/6.
 */
public class Q53_E_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = nums[0];
        int curSum = nums[0];
        for (int i = 1, end = nums.length; i < end; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            res = Math.max(res, curSum);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 0)
            return 0;
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid];
        int temp = mmax;
        for (int i = mid - 1; i >= left; i--) {
            temp += nums[i];
            mmax = Math.max(mmax, temp);
        }
        temp = mmax;
        for (int i = mid + 1; i <= right; i++) {
            temp += nums[i];
            mmax = Math.max(mmax, temp);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }

    public static void main(String[] args) {
        Q53_E_Maximum_Subarray q = new Q53_E_Maximum_Subarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = q.maxSubArray(nums);
        Utils.print(res);
    }
}
