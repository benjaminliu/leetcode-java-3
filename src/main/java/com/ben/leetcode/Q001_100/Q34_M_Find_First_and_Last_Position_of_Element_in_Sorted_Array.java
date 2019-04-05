package com.ben.leetcode;

import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/1.
 */
public class Q34_M_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        if (nums.length == 1) {
            if (nums[0] == target)
                return new int[]{0, 0};
            return new int[]{-1, -1};
        }
        if (nums[0] > target)
            return new int[]{-1, -1};

        int right = nums.length - 1;
        if (nums[right] < target)
            return new int[]{-1, -1};

        int start;
        int end;

        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                start = findLeft(nums, left, mid - 1, target);
                end = findRight(nums, mid + 1, right, target);
                if (start == -1 && end == -1)
                    return new int[]{mid, mid};
                else if (start == -1)
                    return new int[]{mid, end};
                else if (end == -1)
                    return new int[]{start, mid};
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }

    private int findRight(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == right)
                    return right;
                if (nums[mid + 1] != target)
                    return mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findLeft(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == left)
                    return left;
                if (nums[mid - 1] != target)
                    return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q34_M_Find_First_and_Last_Position_of_Element_in_Sorted_Array q = new Q34_M_Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int[] nums = {0, 0, 0, 0, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 8, 9, 9, 10, 10, 11, 11};
//        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 9};
//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = q.searchRange(nums, 0);
        Utils.printArray(res);
    }
}
