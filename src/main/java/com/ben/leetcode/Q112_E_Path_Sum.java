package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/26.
 */
public class Q112_E_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return helper(root, root.val, sum);
    }

    private boolean helper(TreeNode root, int temp, int sum) {
        if (root.left == null && root.right == null) {
            if (temp == sum)
                return true;
            return false;
        }
        if (root.left != null) {
            boolean result = helper(root.left, temp + root.left.val, sum);
            if (result)
                return true;
        }
        if (root.right != null) {
            boolean result = helper(root.right, temp + root.right.val, sum);
            if (result)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Q112_E_Path_Sum q = new Q112_E_Path_Sum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        boolean res = q.hasPathSum(root, 22);
        Utils.println(res);
    }
}
