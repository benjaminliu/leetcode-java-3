package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;
import com.ben.leetcode.util.Utils;

/**
 * Created by ben on 2018/8/8.
 */
public class Q61_M_Rotate_List {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
    
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast, slow;
        fast = dummy.next;
        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }

        k = k % len;
        if (k == 0)
            return head;

        fast = dummy.next;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        slow = dummy.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        Q61_M_Rotate_List q = new Q61_M_Rotate_List();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode res = q.rotateRight(head, 2);
        Utils.printListNode(res);
    }
}
