package com.ben.leetcode;

import com.ben.leetcode.common.LinkListUtil;
import com.ben.leetcode.common.ListNode;

/**
 * Created by ben on 2018/5/19.
 */
public class Q2_M_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1)
            return l2;
        if (null == l2)
            return l1;

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int increase = 0;
        while (true) {
            int sum = l1.val + l2.val + increase;
            increase = sum / 10;
            sum = sum % 10;
            cur.val = sum;
            l1 = l1.next;
            l2 = l2.next;

            if (l1 != null && l2 != null) {
                cur.next = new ListNode(-1);
                cur = cur.next;
            } else {
                break;
            }
        }

        if (l1 == null) {
            if (l2 != null) {
                if (increase == 0) {
                    cur.next = l2;
                } else {
                    while (l2 != null) {
                        int sum = l2.val + increase;
                        increase = sum / 10;
                        sum = sum % 10;
                        cur.next = new ListNode(sum);
                        cur = cur.next;
                        l2 = l2.next;
                    }
                }
            }
        } else if (l2 == null) {
            if (l1 != null) {
                if (increase == 0) {
                    cur.next = l1;
                } else {
                    while (l1 != null) {
                        int sum = l1.val + increase;
                        increase = sum / 10;
                        sum = sum % 10;
                        cur.next = new ListNode(sum);
                        cur = cur.next;
                        l1 = l1.next;
                    }
                }
            }
        }

        if (increase != 0) {
            cur.next = new ListNode(increase);
        }

        return head;
    }

    public static void main(String[] args) {
        Q2_M_AddTwoNumbers q = new Q2_M_AddTwoNumbers();
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode head = q.addTwoNumbers(new ListNode(1), l2);
        LinkListUtil.print(head);
    }
}
