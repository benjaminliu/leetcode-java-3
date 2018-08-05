package com.ben.leetcode.util;

import com.ben.leetcode.common.ListNode;

import java.util.List;

/**
 * Created by ben on 2018/7/28.
 */
public class Utils {

    public static <T> void print(T item) {
        if (item == null)
            return;
        System.out.print(item);
        System.out.print(" , ");
    }

    public static void printSpace() {
        System.out.print(" ");
    }

    public static void println() {
        System.out.println();
    }

    public static <T> void println(T item) {
        if (item == null)
            return;
        System.out.println(item);
    }

    public static void printArray(int[] array) {
        if (array == null)
            return;
        for (int i = 0, len = array.length; i < len; i++) {
            print(array[i]);
        }
        println();
    }

    public static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                print(matrix[i][j]);
                printSpace();
            }
            println();
        }
    }

    public static <T> void printList(List<T> list) {
        if (list == null)
            return;

        for (T item : list) {
            print(item);
        }
    }

    public static <T> void printListOfList(List<List<T>> list) {
        if (list == null)
            return;

        for (List<T> group : list) {
            printList(group);
            println();
        }
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            print(head.val);
            head = head.next;
        }
    }
}
