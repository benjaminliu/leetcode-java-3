package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/1.
 */
public class Q33_M_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] < nums[mid]) {
                if (target == nums[left])
                    return left;
                if (target > nums[left] && target < nums[mid]) {
                    return binarySearch(nums, left, mid - 1, target);
                }
                left = mid + 1;
            } else {
                if (target == nums[right])
                    return right;

                if (target > nums[mid] && target < nums[left])
                    return binarySearch(nums, mid + 1, right, target);
                right = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        }
        return binarySearch(nums, mid + 1, right, target);
    }

    public static void main(String[] args) {
        Q33_M_Search_in_Rotated_Sorted_Array q = new Q33_M_Search_in_Rotated_Sorted_Array();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {3,1};
        //   int[] nums = {1};
        int res = q.search(nums, 1);
        Utils.print(res);
    }
}
