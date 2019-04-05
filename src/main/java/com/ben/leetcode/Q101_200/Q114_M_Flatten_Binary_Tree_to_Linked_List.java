package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2018/8/26.
 */
public class Q114_M_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        helper(root, queue);
        TreeNode last = queue.poll();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            last.left = null;
            last.right = cur;
            last = cur;
        }
    }

    private void helper(TreeNode root, Queue<TreeNode> queue) {
        queue.offer(root);
        if (root.left != null)
            helper(root.left, queue);
        if (root.right != null)
            helper(root.right, queue);
    }

    public static void main(String[] args) {
        Q114_M_Flatten_Binary_Tree_to_Linked_List q = new Q114_M_Flatten_Binary_Tree_to_Linked_List();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        q.flatten(root);

        printRight(root);
    }

    private static void printRight(TreeNode root) {
        while (root!= null){
            Utils.print(root.val);
            root = root.right;
        }
    }
}
