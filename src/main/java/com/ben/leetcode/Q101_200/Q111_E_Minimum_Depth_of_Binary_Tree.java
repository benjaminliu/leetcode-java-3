package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/26.
 */
public class Q111_E_Minimum_Depth_of_Binary_Tree {
    int dep = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, 1);
        return dep;
    }

    private void helper(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            if (level < dep) {
                dep = level;
            }
            return;
        }
        if (root.left != null)
            helper(root.left, level + 1);

        if (root.right != null)
            helper(root.right, level + 1);
    }

    public static void main(String[] args) {
        Q111_E_Minimum_Depth_of_Binary_Tree q = new Q111_E_Minimum_Depth_of_Binary_Tree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int res = q.minDepth(root);
        Utils.println(res);
    }
}
