package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/16.
 */
public class Q86_M_Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode bigger = dummy;
        while (bigger.next != null && bigger.next.val < x)
            bigger = bigger.next;
        if (bigger.next == null)
            return head;
        ListNode smaller = bigger.next;
        while (true) {
            while (smaller.next != null && smaller.next.val >= x) {
                smaller = smaller.next;
            }
            if (smaller.next == null)
                break;

            ListNode temp = smaller.next;
            smaller.next = temp.next;
            temp.next = bigger.next;
            bigger.next = temp;
            bigger = bigger.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q86_M_Partition_List q = new Q86_M_Partition_List();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        ListNode partition = q.partition(head, 2);
        Utils.printListNode(partition);
    }
}
