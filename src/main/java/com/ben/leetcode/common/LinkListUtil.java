package com.ben.leetcode.common;

/**
 * Created by ben on 2018/5/19.
 */
public class LinkListUtil {

    public static void print(ListNode root) {
        while (root != null) {
            System.out.print(root.val);
            root = root.next;
            if (root == null) {
                return;
            }
            System.out.print("->");
        }
    }
}
