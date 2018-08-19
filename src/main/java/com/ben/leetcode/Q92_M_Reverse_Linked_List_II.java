package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/18.
 */
public class Q92_M_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;

        ListNode pre, last, next, cur;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        cur = dummy;
        int idx = 1;
        while (idx < m) {
            cur = cur.next;
            idx++;
        }
        pre = cur;
        last = pre;
        cur = cur.next;
        while (idx < n) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
            idx++;
        }
        pre.next.next = cur.next;
        pre.next = cur;
        cur.next = last;

        return dummy.next;
    }

    public static void main(String[] args) {
        Q92_M_Reverse_Linked_List_II q = new Q92_M_Reverse_Linked_List_II();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = q.reverseBetween(head, 1, 3);
        Utils.printListNode(res);

        head = new ListNode(1);
        res = q.reverseBetween(head, 1, 1);
        Utils.printListNode(res);
    }
}
