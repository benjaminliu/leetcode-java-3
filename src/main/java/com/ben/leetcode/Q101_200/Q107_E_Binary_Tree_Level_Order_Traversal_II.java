package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by ben on 2018/8/26.
 */
public class Q107_E_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                group.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            res.add(group);
        }

        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> parent = new LinkedList<>();
        Deque<TreeNode> child = new LinkedList<>();
        Deque<TreeNode> temp;
        List<Integer> group = new ArrayList<>();

        parent.add(root);
        while (!parent.isEmpty()) {
            TreeNode cur = parent.pollFirst();
            group.add(cur.val);
            if (cur.left != null)
                child.add(cur.left);
            if (cur.right != null)
                child.add(cur.right);

            if (parent.isEmpty()) {
                res.add(group);
                group = new ArrayList<>();
                temp = parent;
                parent = child;
                child = temp;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
