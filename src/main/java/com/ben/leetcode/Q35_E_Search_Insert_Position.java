package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/1.
 */
public class Q35_E_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1) {
            if (target <= nums[0])
                return 0;
            return 1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Q35_E_Search_Insert_Position q = new Q35_E_Search_Insert_Position();
        int[] nums = {1, 3, 5, 6};
        int res = q.searchInsert(nums, 5);
        Utils.print(res);
        res = q.searchInsert(nums, 2);
        Utils.print(res);
        res = q.searchInsert(nums, 7);
        Utils.print(res);
        res = q.searchInsert(nums, 0);
        Utils.print(res);
    }
}
