package com.ben.leetcode;

import com.ben.leetcode.common.ListNode;

/**
 * Created by ben on 2018/8/16.
 */
public class Q83_E_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }
}
