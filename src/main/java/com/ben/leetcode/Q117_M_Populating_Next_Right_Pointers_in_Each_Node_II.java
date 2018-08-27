package com.ben.leetcode;

import com.ben.leetcode.common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2018/8/27.
 */
public class Q117_M_Populating_Next_Right_Pointers_in_Each_Node_II {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode head = root;
        while (head != null) {
            TreeLinkNode cur = head;
            TreeLinkNode prev = null;
            head = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) head = cur.left;
                    if (prev != null) prev.next = cur.left;
                    prev = cur.left;
                }

                if (cur.right != null) {
                    if (head == null) head = cur.right;
                    if (prev != null) prev.next = cur.right;
                    prev = cur.right;
                }

                cur = cur.next;
            }
        }
    }

    public void connect1(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeLinkNode cur = queue.poll();
                if (i != len - 1)
                    cur.next = queue.peek();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
    }
}
