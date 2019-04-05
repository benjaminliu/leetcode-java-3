package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/29.
 */
public class Q21_E_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q21_E_Merge_Two_Sorted_Lists q = new Q21_E_Merge_Two_Sorted_Lists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = q.mergeTwoLists(l1, l2);
        Utils.printListNode(listNode);
    }
}
