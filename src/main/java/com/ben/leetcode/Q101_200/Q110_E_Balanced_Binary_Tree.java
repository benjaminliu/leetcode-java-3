package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/26.
 */
public class Q110_E_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = helper(root.left, 1);
        if (left == -1)
            return false;
        int right = helper(root.right, 1);
        if (right == -1)
            return false;

        return Math.abs(left - right) < 2;
    }

    private int helper(TreeNode node, int depth) {
        if (node == null)
            return depth;
        int left = helper(node.left, depth + 1);
        if (left == -1)
            return -1;
        int right = helper(node.right, depth + 1);
        if (right == -1)
            return -1;

        int diff = Math.abs(left - right);
        if (diff > 1)
            return -1;
        return Math.max(right, left);
    }

    public static void main(String[] args) {
        Q110_E_Balanced_Binary_Tree q = new Q110_E_Balanced_Binary_Tree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean balanced = q.isBalanced(root);
        Utils.println(balanced);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.right = new TreeNode(2);

        balanced =  q.isBalanced(root);
        Utils.println(balanced);
    }
}
