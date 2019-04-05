package com.ben.leetcode;

import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

import java.util.*;

/**
 * Created by ben on 2018/8/25.
 */
public class Q103_M_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> child = new LinkedList<>();
        Deque<TreeNode> parent = new LinkedList<>();
        Deque<TreeNode> temp;

        parent.add(root);
        TreeNode cur;
        boolean isEven = false;
        List<Integer> group = new ArrayList<>();
        while (!parent.isEmpty()) {
            cur = parent.pollFirst();
            group.add(cur.val);
            if (cur.left != null) {
                child.addLast(cur.left);
            }
            if (cur.right != null) {
                child.addLast(cur.right);
            }
            if (parent.isEmpty()) {
                temp = parent;
                parent = child;
                child = temp;
                if (isEven)
                    Collections.reverse(group);

                res.add(group);
                group = new ArrayList<>();
                isEven = !isEven;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Q103_M_Binary_Tree_Zigzag_Level_Order_Traversal q = new Q103_M_Binary_Tree_Zigzag_Level_Order_Traversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = q.zigzagLevelOrder(root);
        Utils.printListOfList(lists);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        lists = q.zigzagLevelOrder(root);
        Utils.printListOfList(lists);
    }
}
