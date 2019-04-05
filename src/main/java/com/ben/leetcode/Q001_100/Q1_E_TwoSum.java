package com.ben.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2018/5/19.
 */
public class Q1_E_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (null == nums || nums.length < 2)
            return res;

        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++)
            map.put(nums[i], i);

        for (int i = 0; i < len; i++) {
            int sub = target - nums[i];
            Integer idx = map.get(sub);
            if (null != idx) {
                if (idx == i)
                    continue;
                return new int[]{i, idx};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        Q1_E_TwoSum twoSum = new Q1_E_TwoSum();
        int[] res = twoSum.twoSum(arr, 6);
        System.out.println(Arrays.toString(res));
    }


    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2)
            return res;


        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
            if (min > nums[i])
                min = nums[i];
        }

        int[] index = new int[max - min + 1];
        int other = 0;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (index[other - min] > 0) {
                res[0] = index[other - min] - 1;
                res[1] = i;
                return res;
            }
            index[nums[i] - min] = i + 1;
        }
        return res;
    }
}
