package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;

/**
 * Created by ben on 2018/8/25.
 */
public class Q104_E_Maximum_Depth_of_Binary_Tree {
    private int dep;

    public int maxDepth(TreeNode root) {
        helper(root, 1);
        return dep;
    }

    private void helper(TreeNode root, int level) {
        if (root == null)
            return;

        if (level > dep)
            dep = level;
        level++;
        helper(root.left, level);
        helper(root.right, level);
    }

}
