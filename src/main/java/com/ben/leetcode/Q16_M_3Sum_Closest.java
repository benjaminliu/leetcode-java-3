package com.ben.leetcode;

import java.util.Arrays;

/**
 * Created by ben on 2018/7/28.
 */
public class Q16_M_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);

        int res = target;
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int aid = target - nums[i];
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == aid)
                    return target;

                // a + b + c - temp = target
                // a + b - temp = target - c
                // a + b - temp = aid;
                //sum - temp = aid;
                int temp = sum - aid;
                if (temp < 0) {
                    //left side is smaller then right side
                    int temp1 = temp * -1;
                    if (diff > temp1) {
                        diff = temp1;
                        res = target + temp;
                    }
                    j++;
                } else {
                    //left side is bigger then right side
                    if (diff > temp) {
                        diff = temp;
                        res = target + temp;
                    }
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q16_M_3Sum_Closest q = new Q16_M_3Sum_Closest();
        int[] nums = {-1, 2, 1, -4};
//        int[] nums = {0,2,1,-3};
        int res = q.threeSumClosest(nums, 1);
        System.out.println(res);
    }
}
