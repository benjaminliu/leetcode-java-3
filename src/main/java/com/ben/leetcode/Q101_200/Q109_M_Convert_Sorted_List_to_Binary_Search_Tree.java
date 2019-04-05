package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.common.TreeNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/26.
 */
public class Q109_M_Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode fast = head;
        ListNode slow = head;
        ListNode last = slow;
        while (fast.next != null && fast.next.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        last.next = null;
        TreeNode root = new TreeNode(slow.val);
        if (head != slow)
            root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);
        return root;
    }


    public static void main(String[] args) {
        Q109_M_Convert_Sorted_List_to_Binary_Search_Tree q = new Q109_M_Convert_Sorted_List_to_Binary_Search_Tree();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode res = q.sortedListToBST(head);
        Utils.printTreeNode(res);

        head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        res = q.sortedListToBST(head);
        Utils.printTreeNode(res);
    }
}
