package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/30.
 */
public class Q129_M_Sum_Root_to_Leaf_Numbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int no) {
        no = no * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += no;
            return;
        }
        if (root.left != null)
            helper(root.left, no);
        if (root.right != null)
            helper(root.right, no);
    }

    public static void main(String[] args) {
        Q129_M_Sum_Root_to_Leaf_Numbers q = new Q129_M_Sum_Root_to_Leaf_Numbers();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);

        int res = q.sumNumbers(root);
        Utils.println(res);
    }
}
