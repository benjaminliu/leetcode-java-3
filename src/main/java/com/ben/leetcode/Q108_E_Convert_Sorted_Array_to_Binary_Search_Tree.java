package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;

/**
 * Created by ben on 2018/8/26.
 */
public class Q108_E_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        int right = nums.length - 1;
        TreeNode root = helper(nums, 0, right);
        return root;
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
