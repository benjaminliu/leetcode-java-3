package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/29.
 */
public class Q24_M_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode left, mid, right;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        left = dummy;
        mid = head;
        right = head.next;
        while (true) {
            mid.next = right.next;
            right.next = mid;
            left.next = right;

            mid = left.next;
            right = mid.next;

            if (right.next == null || right.next.next == null)
                break;

            left = left.next.next;
            mid = mid.next.next;
            right = right.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q24_M_Swap_Nodes_in_Pairs q = new Q24_M_Swap_Nodes_in_Pairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode listNode = q.swapPairs(head);
        Utils.printListNode(listNode);
    }
}
