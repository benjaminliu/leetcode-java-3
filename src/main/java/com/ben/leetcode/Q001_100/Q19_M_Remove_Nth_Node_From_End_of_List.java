package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/7/29.
 */
public class Q19_M_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode cur = dummy;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if (fast == null)
            return dummy.next;

        while (fast.next != null) {
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Q19_M_Remove_Nth_Node_From_End_of_List q = new Q19_M_Remove_Nth_Node_From_End_of_List();
        ListNode listNode = q.removeNthFromEnd(head, 2);
        Utils.printListNode(listNode);
    }
}
