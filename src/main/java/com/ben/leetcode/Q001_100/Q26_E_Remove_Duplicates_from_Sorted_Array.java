package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/29.
 */
public class Q26_E_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        if (nums.length == 1)
            return 1;

        int dupCount = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                dupCount++;
                continue;
            }

            if (dupCount != 0) {
                nums[i - dupCount] = nums[i];
            }
        }
        return len - dupCount;
    }

    public static void main(String[] args) {
        Q26_E_Remove_Duplicates_from_Sorted_Array q = new Q26_E_Remove_Duplicates_from_Sorted_Array();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = q.removeDuplicates(nums);
        Utils.println(i);
        Utils.printArray(nums);
    }
}
