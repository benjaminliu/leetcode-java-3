package com.ben.leetcode;

import com.ben.leetcode.common.TreeLinkNode;
import com.ben.leetcode.util.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2018/8/27.
 */
public class Q116_M_Populating_Next_Right_Pointers_in_Each_Node {


    public void connect(TreeLinkNode root) {
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

    public static void main(String[] args) {
        Q116_M_Populating_Next_Right_Pointers_in_Each_Node q = new Q116_M_Populating_Next_Right_Pointers_in_Each_Node();
        TreeLinkNode t = new TreeLinkNode(1);
        t.left = new TreeLinkNode(2);
        t.left.left = new TreeLinkNode(4);
        t.left.right = new TreeLinkNode(5);
        t.right = new TreeLinkNode(3);
        t.right.left = new TreeLinkNode(6);
        t.right.right = new TreeLinkNode(7);

        q.connect(t);
        Utils.println();
    }
}
