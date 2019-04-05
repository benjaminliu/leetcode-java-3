package com.ben.leetcode;

import com.ben.leetcode.common.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2018/9/3.
 */
public class Q138_M_Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        Map<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        RandomListNode newHead = new RandomListNode(cur.label);
        RandomListNode newCur = newHead;
        map.put(newCur.label, newCur);

        while (cur.next != null) {
            RandomListNode temp = new RandomListNode(cur.next.label);
            newCur.next = temp;
            cur = cur.next;
            newCur = newCur.next;
            map.put(newCur.label, newCur);
        }

        newCur = newHead;
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                RandomListNode temp = map.get(cur.random.label);
                newCur.random = temp;
            }
            newCur = newCur.next;
            cur = cur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Q138_M_Copy_List_with_Random_Pointer q = new Q138_M_Copy_List_with_Random_Pointer();
        RandomListNode head = new RandomListNode(-1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        RandomListNode res = q.copyRandomList(head);
    }
}
