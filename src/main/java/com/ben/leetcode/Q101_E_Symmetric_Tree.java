package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;

/**
 * Created by ben on 2018/8/19.
 */
public class Q101_E_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left == null && right == null)
                return true;
            return false;
        }
        if (left.val != right.val)
            return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
