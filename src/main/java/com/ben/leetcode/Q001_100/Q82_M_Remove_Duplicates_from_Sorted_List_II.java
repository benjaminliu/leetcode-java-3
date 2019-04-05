package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/14.
 */
public class Q82_M_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                prev.next = cur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy.next;
        ListNode slow = fast;
        ListNode pre = dummy;

        while (fast.next != null) {
            if (fast.next.val == slow.val)
                fast = fast.next;
            else {
                if (fast != slow) {
                    pre.next = fast.next;
                } else {
                    pre.next = fast;
                    pre = pre.next;
                }
                fast = pre.next;
                slow = fast;
            }
        }

        if (fast != slow) {
            pre.next = fast.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Q82_M_Remove_Duplicates_from_Sorted_List_II q = new Q82_M_Remove_Duplicates_from_Sorted_List_II();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);

        ListNode res = q.deleteDuplicates(head);
        Utils.printListNode(res);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        res = q.deleteDuplicates(head);
        Utils.printListNode(res);
    }
}
