package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2018/8/19.
 */
public class Q94_M_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Q94_M_Binary_Tree_Inorder_Traversal q = new Q94_M_Binary_Tree_Inorder_Traversal();
        List<Integer> res = q.inorderTraversal(root);
        Utils.printList(res);
    }
}
