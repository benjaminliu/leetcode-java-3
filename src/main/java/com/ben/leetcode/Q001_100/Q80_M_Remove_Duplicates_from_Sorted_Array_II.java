package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/13.
 */
public class Q80_M_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;

        int len = nums.length;
        int dup = 0;
        int duplicate = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                dup++;
                if (dup > 1) {
                    duplicate++;
                    continue;
                }
            } else {
                dup = 0;
            }

            nums[i - duplicate] = nums[i];
        }
        return len - duplicate;
    }

    public static void main(String[] args) {
        Q80_M_Remove_Duplicates_from_Sorted_Array_II q = new Q80_M_Remove_Duplicates_from_Sorted_Array_II();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int res = q.removeDuplicates(nums);
        Utils.println(res);
        int[] nums1 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        res = q.removeDuplicates(nums1);
        Utils.println(res);
    }
}
