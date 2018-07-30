package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/30.
 */
public class Q27_E_Remove_Element {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int dup = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                dup++;
            } else {
                if (dup > 0) {
                    nums[i - dup] = nums[i];
                }
            }
        }
        return len - dup;
    }

    public static void main(String[] args) {
        Q27_E_Remove_Element q = new Q27_E_Remove_Element();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int res = q.removeElement(nums, 2);

        Utils.println(res);
        Utils.printArray(nums);
    }
}
