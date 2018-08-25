package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ben on 2018/8/19.
 */
public class Q102_M_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> parent = new LinkedList<>();
        Deque<TreeNode> child = new LinkedList<>();
        Deque<TreeNode> temp;
        TreeNode cur;
        List<Integer> group = new ArrayList<>();
        parent.add(root);
        while (!parent.isEmpty()) {
            cur = parent.pollFirst();
            group.add(cur.val);
            if (cur.left != null)
                child.addLast(cur.left);

            if (cur.right != null)
                child.addLast(cur.right);

            if (parent.isEmpty()) {
                temp = parent;
                parent = child;
                child = temp;
                res.add(group);
                group = new ArrayList<>();
            }
        }
        return res;
    }
}
