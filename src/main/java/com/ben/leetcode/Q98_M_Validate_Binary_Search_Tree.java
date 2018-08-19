package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ben on 2018/8/19.
 */
public class Q98_M_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean helper(TreeNode node, long max, long min) {
        if (node.val <= min || node.val >= max) return false;
        boolean ret = true;
        if (node.left != null)
            ret = node.val > node.left.val && helper(node.left, node.val, min);
        if (!ret) return ret;
        if (node.right != null)
            ret = node.val < node.right.val && helper(node.right, max, node.val);
        return ret;
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;

        Deque<Integer> values = new LinkedList<>();
        if (helper1(root, values) == false)
            return false;

        return true;
    }

    private boolean helper1(TreeNode root, Deque<Integer> values) {
        if (null == root)
            return true;

        if (root.left != null) {
            if (helper1(root.left, values) == false)
                return false;
        }


        if (!values.isEmpty() && root.val <= values.peekLast())
            return false;

        values.addLast(root.val);

        if (root.right != null) {
            if (helper1(root.right, values) == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q98_M_Validate_Binary_Search_Tree q = new Q98_M_Validate_Binary_Search_Tree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        boolean res = q.isValidBST(root);
        Utils.println(res);

        root = new TreeNode(1);
        // root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        res = q.isValidBST(root);
        Utils.println(res);
    }
}
